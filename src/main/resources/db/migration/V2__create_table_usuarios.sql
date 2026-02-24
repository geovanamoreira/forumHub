create table usuarios(
    id SERIAL PRIMARY KEY,
    nome varchar(100) not null,
    email varchar(100) not null unique,
    senha varchar(100) not null
);