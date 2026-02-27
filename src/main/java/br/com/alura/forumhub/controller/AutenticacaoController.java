package br.com.alura.forumhub.controller;

import br.com.alura.forumhub.infra.security.DadosJWT;
import br.com.alura.forumhub.infra.security.TokenService;
import br.com.alura.forumhub.login.DadosAutenticacao;
import br.com.alura.forumhub.login.Login;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {

    //spring que injeta o parametro
    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    //esta recebendo informações (no caso o login)
    @PostMapping
    public ResponseEntity efetuarLogin(@RequestBody @Valid DadosAutenticacao dados){
        var authenticationToken = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());
        var authentication = manager.authenticate(authenticationToken);

        var tokenJWT = tokenService.gerarToken((Login) authentication.getPrincipal());
        return ResponseEntity.ok(new DadosJWT(tokenJWT));
    }
}
