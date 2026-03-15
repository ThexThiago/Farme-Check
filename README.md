# FarmaCheck - API de Gestao de Medicamentos em Farmacias Publicas

Sistema para verificacao de disponibilidade de medicamentos em farmacias publicas
---

## Objetivo do Projeto

O FarmaCheck permite que pacientes consultem a disponibilidade de medicamentos em farmacias publicas. Quando um medicamento nao esta disponivel

Principais funcionalidades:
- Cadastro e gerenciamento de medicamentos (administrador)
- Consulta disponivilidade de medicamentos (usuario)

---

## Arquitetura Geral

```
Cliente (Browser / HTTP)
        |
        v
Spring Boot API (Java 21) -- porta 8080
        |
        +---> H2 (dados)
```

---

## Tecnologias Utilizadas

- **Java 21**
- **Spring Boot 3.5.7**
- **Spring Data JPA / Hibernate**
- **Spring Security + JWT** (auth0 java-jwt)
- **H2** (banco de dados)
---

## Modelo de Dados (Entidades)

### Usuario
| Campo         | Tipo          | Descricao                          |
|---------------|---------------|------------------------------------|
| id            | int           | Identificador unico (sequence)     |
| nome          | String        | Nome do usuario                    |
| email         | String        | Email (unico)                      |
| senha         | String        | Senha aberta                       |


### Medicamento
| Campo          | Tipo          | Descricao                          |
|----------------|---------------|------------------------------------|
| id             | int           | Identificador unico (sequence)     |
| nome           | String        | Nome do medicamento                |
| descricao      | String        | Principio ativo                    |
| preco          | String        | Descrição                          |
| fornecedor     | String        | Laboratorio fabricante             |
