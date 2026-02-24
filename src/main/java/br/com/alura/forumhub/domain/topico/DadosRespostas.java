package br.com.alura.forumhub.domain.topico;

import java.time.LocalDateTime;

public record DadosRespostas(
        Long id,
        String mensagem,
        String topico,
        LocalDateTime dataDePublicacao,
        Long idUsuario,
        String solucao
) {
}
