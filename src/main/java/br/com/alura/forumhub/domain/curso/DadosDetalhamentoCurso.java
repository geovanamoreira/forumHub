package br.com.alura.forumhub.domain.curso;

public record DadosDetalhamentoCurso(
        String nome,
        String categoria
) {
    public DadosDetalhamentoCurso(Curso curso) {
        this(curso.getNome(), curso.getCategoria());
    }
}
