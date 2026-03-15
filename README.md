# Farm Check - Sistema de Gestão de Medicamentos em Farmácias Públicas

Sistema para verificação de disponibilidade de medicamentos em farmácias públicas
---

## Objetivo do Projeto

O Farm Check permite que pacientes consultem a disponibilidade de medicamentos em farmacias publicas. Quando um medicamento nao esta disponivel

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
| Campo          | Tipo          | Preço                              |
|----------------|---------------|------------------------------------|
| id             | int           | Identificador unico (sequence)     |
| nome           | String        | Nome do medicamento                |
| descricao      | String        | Principio ativo                    |
| preco          | String        | valor do medicamento               |
| fornecedor     | String        | Laboratorio fabricante             |


## ✨ Nova Funcionalidades

- [🔧 TODO] **Cadastro/Autenticação** de usuários com perfis e permissões.  
- [🔧 TODO] **Relatórios de controle com status de todos medicamento** exportáveis (PDF/CSV).
