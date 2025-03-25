# Controle de Estacionamento API

## Visão Geral

O Controle de Estacionamento é um sistema desenvolvido em Java com Spring Boot que permite o gerenciamento de vagas de estacionamento. A API possibilita o cadastro, atualização, consulta e exclusão de registros de vagas, contendo dados de veículos, apartamentos e responsáveis.

O objetivo principal é oferecer uma interface REST para controle e administração eficiente das vagas de estacionamento em condomínios ou estabelecimentos, utilizando um banco de dados relacional PostgreSQL.

---

## Tecnologias Utilizadas

### Back-end

- **Java 17** - Linguagem principal da aplicação.
- **Spring Boot 3.2.3** - Framework principal.
- **Spring Web** - Para criação de endpoints RESTful.
- **Spring Data JPA** - Para persistência de dados com Hibernate.
- **Springdoc OpenAPI** - Documentação da API via Swagger.

### Banco de Dados

- **PostgreSQL** - Banco de dados relacional utilizado na aplicação.

### Ferramentas e Gerenciamento

- **Maven** - Gerenciador de dependências e build.
- **Postman** - Para testes de endpoints.
- **Swagger UI** - Documentação interativa da API.
- **cURL** - Testes via terminal.

---

## Competências e Habilidades Utilizadas

### Linguagem e Frameworks

- Java com boas práticas e organização de código.
- Spring Boot para APIs REST.
- JPA/Hibernate com validações de entidade.
- Uso de DTOs para encapsulamento de dados.
- Arquitetura em camadas (Controller, Service, Repository, Entity, DTO).

### Banco de Dados

- Modelagem de tabelas com JPA.
- Integração com PostgreSQL via Spring Data.
- Operações CRUD com segurança e validações.
- Uso de anotações como `@NotBlank`, `@Id`, `@GeneratedValue`.

### Ferramentas de Build e Execução

- Execução com `mvn clean install` e `mvn spring-boot:run`.
- Leitura segura de configurações com `.env`.

---

## Como Configurar e Executar o Projeto

### 1. Clonar o Repositório

```bash
cd C:\caminho\para\salvar\projeto
git clone https://github.com/seu-usuario/controle-estacionamento.git
cd controle-estacionamento
```

### 2. Abrir no IntelliJ IDEA

- Vá em **File > Open** e selecione a pasta do projeto.
- Verifique se o **Java SDK 17** está corretamente configurado.
- Aguarde o download automático das dependências via Maven.

### 3. Configurar o Banco de Dados

- Crie o banco de dados:

```sql
CREATE DATABASE controle_estacionamento;
```


### 4. Compilar e Executar

```bash
mvn clean install
mvn spring-boot:run
```

A aplicação será iniciada em:  
[http://localhost:8082](http://localhost:8082)

---

## Como Testar a API

### Via Postman

- Exemplo de requisição GET:

```
GET http://localhost:8082/v1/1
```

### Via Swagger UI

- Acesse:  
[http://localhost:8082/swagger-ui.html](http://localhost:8082/swagger-ui.html)

### Via cURL

```bash
curl -X GET http://localhost:8082/v1/1
```

---

## Estrutura do Projeto

```
src
└── main
    ├── java
    │   └── br.wesley.controle_estacionamento
    │       ├── controller       → Exposição de endpoints REST
    │       ├── dto              → Transferência de dados (DTOs)
    │       ├── entity           → Entidades JPA
    │       ├── repository       → Acesso a dados com Spring Data JPA
    │       ├── services         → Regras de negócio
    │       └── config           → (opcional) Configurações gerais
    └── resources
        ├── application.properties
        └── .env
```

---

## Considerações Finais

Esse projeto é uma API REST organizada, modular e escalável, pensada para controle de vagas em ambientes residenciais ou corporativos.

Além de seguir boas práticas, como uso de DTOs, validações com Bean Validation, e arquitetura em camadas, também permite fácil manutenção e expansão.

---

## Autor

**Wesley Martins Rosa**  
📧 Email: wesleymrosa@gmail.com  
🔗 LinkedIn: [linkedin.com/in/wesley-martins-rosa-5118aa15a](https://www.linkedin.com/in/wesley-martins-rosa-5118aa15a)
