package br.com.alura.forumhub.controller;

import br.com.alura.forumhub.domain.curso.CursoRepository;
import br.com.alura.forumhub.domain.topico.*;
import br.com.alura.forumhub.domain.usuario.UsuarioRepository;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("topicos")
@SecurityRequirement(name = "bearer-key")
public class TopicoController {

    @Autowired
    private TopicoRepository repository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private CursoRepository cursoRepository;

    //CADASTRO
    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroTopico dados, UriComponentsBuilder uriComponentsBuilder){
        var usuario = usuarioRepository.getReferenceById(dados.idUsuario());
        var curso = cursoRepository.getReferenceById(dados.idCurso());

        var topico = new Topico(dados, usuario, curso);
        repository.save(topico);
        System.out.println(topico.getId());

        var uri = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoTopico(topico));
    }

    //LISTAGEM
    @GetMapping
    public ResponseEntity <Page<DadosListagemTopicos>> listarTopicos(@PageableDefault(size = 10, sort = {"titulo"}) Pageable paginacao){

        var page = repository.findAll(paginacao).map(DadosListagemTopicos::new);
        return ResponseEntity.ok(page);
    }

    //DETALHAR PELO ID
    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id){
        var topicovazio = repository.findById(id);

        if(topicovazio.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        var topico = topicovazio.get();
        return ResponseEntity.ok(new DadosDetalhamentoTopico(topico));
    }

    //ATUALIZAR
    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoTopico dados){
        var topico = repository.getReferenceById(dados.id());
        topico.atualizarInformacoes(dados);

        return ResponseEntity.ok(new DadosAtualizacaoTopico(topico));
    }

    //DELETAR
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletar(@PathVariable Long id){
        var topicovazio = repository.findById(id);

        if(topicovazio.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
