package br.com.alura.forumhub.domain.topico;

import br.com.alura.forumhub.domain.curso.Curso;
import br.com.alura.forumhub.domain.usuario.Usuario;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "topicos")
@Entity(name = "Topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    private String mensagem;

    private LocalDateTime dataCriacao;

    private String status;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario autor;

    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;

    private Boolean ativo;

    public Topico(DadosCadastroTopico dados, Usuario usuario, Curso curso) {
        this.titulo = dados.titulo();
        this.mensagem = dados.mensagem();
        this.status = dados.status();
        this.dataCriacao = LocalDateTime.now();
        this.autor = usuario;
        this.curso = curso;
    }

    public void atualizarInformacoes(@Valid DadosAtualizacaoTopico dados) {
        if (dados.titulo() != null){
            this.titulo = dados.titulo();
        }

        if (dados.mensagem() != null){
            this.mensagem = dados.mensagem();
        }

        if (dados.status() != null){
            this.status = dados.status();
        }

    }


    public void excluir() {
        this.ativo = false;
    }
}
