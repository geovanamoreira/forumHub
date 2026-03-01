🚀 FórumHub API
# 🚀 FórumHub API

![Java](https://img.shields.io/badge/Java-21-orange)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-4.x-brightgreen)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-Database-blue)
![JWT](https://img.shields.io/badge/Auth-JWT-black)
![Maven](https://img.shields.io/badge/Build-Maven-red)
![Status](https://img.shields.io/badge/Status-Concluído-success)
![License](https://img.shields.io/badge/License-Educacional-lightgrey)

API REST desenvolvida como parte do desafio **FórumHub** da Alura.

O projeto simula um sistema de fórum onde usuários podem criar, listar, atualizar e excluir tópicos, utilizando autenticação com JWT e boas práticas com Spring Boot 4.

---

## 📌 Tecnologias Utilizadas

- ☕ Java 21
- 🌱 Spring Boot 4
- 🔐 Spring Security
- 🛢️ Spring Data JPA
- 🗄️ PostgreSQL
- 🔑 JWT (Auth0)
- 📦 Maven
- 📄 Swagger / OpenAPI

---

## 🏗️ Arquitetura

O projeto foi estruturado seguindo o padrão em camadas:

controller → Endpoints da API
service → Regras de negócio
repository → Comunicação com banco
domain → Entidades JPA
infra → Segurança e configurações


---

## 🔐 Segurança

A autenticação é realizada via **JWT (JSON Web Token)**.

### Fluxo:

1. Usuário faz login em `/login`
2. API retorna um token JWT
3. Cliente envia no header:

Authorization: Bearer SEU_TOKEN

- Senhas criptografadas com BCrypt
- API Stateless
- Filtro de autenticação personalizado
- SecurityFilterChain configurado manualmente

---

## 📚 Funcionalidades

### 👤 Usuários
- Cadastro
- Login autenticado

### 📝 Tópicos
- Criar tópico
- Listar todos
- Buscar por ID
- Atualizar
- Exclusão lógica (Soft Delete)

---

## 🗄️ Banco de Dados

Banco utilizado: PostgreSQL

---

🧠 Conceitos Aplicados

REST API

DTO Pattern

Bean Validation

Relacionamentos JPA

Autenticação Stateless

JWT

Tratamento Global de Exceções

Soft Delete

Clean Code

---

👩‍💻 Desenvolvido por

Geovana Moreira de Oliveira

Projeto desenvolvido como parte do programa Alura.

---

📄 Licença

Uso educacional.
