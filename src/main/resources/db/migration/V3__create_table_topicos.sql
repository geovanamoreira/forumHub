create table topicos(
    id SERIAL PRIMARY KEY,
    titulo varchar(100) not null unique,
    mensagem varchar(600) not null unique,
    dataCriacao TIMESTAMP not null,
    status varchar(100) not null,

    usuario_id INTEGER not null,
    curso_id INTEGER not null,

    constraint fk_topicos_usuario_id foreign key(usuario_id) references usuarios(id),
    constraint fk_topicos_curso_id foreign key(curso_id) references cursos(id)
);