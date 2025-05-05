
# DummyJSON Client - Java 17 e Spring Boot 3.2.5

## Descrição do Projeto

Este projeto é um microsserviço Java que interage com a API pública [DummyJSON](https://dummyjson.com/docs/products) para realizar operações de busca de produtos. O projeto foi atualizado para utilizar Java 17 e Spring Boot 3.2.5, garantindo compatibilidade com as versões mais recentes e melhores práticas de desenvolvimento.

## Objetivo do Desafio

O desafio consistiu em migrar o projeto de Java 8 e Spring Boot 2.6.x para Java 17 e Spring Boot 3.2.5. Durante a migração, foram realizadas diversas melhorias e ajustes para garantir a funcionalidade e modernização do código.

## Funcionalidades

- **Consulta de Produtos**: Realiza chamadas para a API do DummyJSON para buscar informações sobre produtos.
- **Integração com `WebClient`**: Substituição do `RestTemplate` por `WebClient` para chamadas HTTP reativas.
- **Validação de Dados**: Validação de dados de entrada usando Bean Validation (`jakarta.validation`).
- **Gestão de Dependências**: Configurado para utilizar injeção de dependências com `@Autowired` e `@Bean`.
- **Testes de Integração**: Testes utilizando `@SpringBootTest` para garantir a integração entre os componentes.
- **Endpoint de Saúde**: Adicionado o endpoint `/health` para verificar a saúde do microsserviço.

## Estrutura do Projeto

```bash
dummyjson-client
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com.example.dummyjsonclient
│   │   │       ├── DummyJsonClientApplication.java
│   │   │       ├── config
│   │   │       │   └── WebClientConfig.java
│   │   │       ├── controller
│   │   │       │   ├── ProductController.java
│   │   │       │   └── HealthController.java
│   │   │       ├── dto
│   │   │       │   └── Product.java
│   │   │       ├── service
│   │   │       │   └── ProductService.java
│   │   └── resources
│   │       └── application.yaml
│   └── test
│       ├── java
│       │   └── com.example.dummyjsonclient
│       │       ├── config
│       │       │   └── WebClientConfigTest.java
│       │       └── controller
│       │       │   ├── ProductControllerTest.java
│       │       │   └── HealthControllerTest.java
│       │       ├── dto
│       │       │   └── ProductTest.java
│       │       └── service
│       │           └── ProductServiceTest.java
│       └── resources
└── pom.xml
```

## Passos para Executar o Projeto

### Pré-requisitos

- **Java 17**
- **Maven 3.8.x**

### Executar a Aplicação

1. Clone o repositório:

    ```bash
    git clone https://github.com/WendellTufano/code-challenge-migration.git
    cd dummyjson-client
    ```

2. Compile e execute o projeto:

    ```bash
    mvn clean install
    mvn spring-boot:run
    ```

3. Acesse o serviço:

    O serviço estará disponível em `http://localhost:8080`.

### Executar Testes

Para executar os testes de integração:

```bash
mvn clean test
```

## Requisitos de Entrega

1. Atualizar o `pom.xml` para usar Java 17+ e Spring Boot 3.2.5.
2. Substituir `RestTemplate` por `WebClient` ou `Openfeign`.
3. Substituir os testes unitários feitos com `JUnit 4` e `Mockito` por testes de integração utilizando `@SpringBootTest`.
4. Refatorar qualquer código depreciado ou incompatível.
5. Garantir que todos os testes ainda passam após a migração.
6. Deixar a URL da API dummyjson parametrizada por ambiente no projeto.
7. Adicionar no projeto um novo path `/health` que retorna a saude do microsserviço.

## Validação Sobre o Challenge

- O projeto deve estar funcionando em Java 17 e Spring Boot 3.2.5.
- Todos os testes devem passar sem falhas.
- O código deve estar limpo, organizado e devidamente documentado.

## Extras

- Entregar o projeto em container será um diferencial.
- Fica a critério do desenvolvedor inserir ou remover dependencias do projeto para garantir o objetivo do challenge.

## Modificações Realizadas

### Atualização de Versões

- **Java**: Atualizado de Java 8 para Java 17.
- **Spring Boot**: Atualizado de 2.6.x para 3.2.5.
- **Dependências**: Atualizadas para versões compatíveis com Java 17 e Spring Boot 3.2.5.

### Substituição de Tecnologias

- **`RestTemplate`**: Substituído por `OpenFeign` para chamadas HTTP declarativas.
- **`javax.validation`**: Substituído por `jakarta.validation` devido à mudança de namespace no Spring Boot 3.

### Refatoração de Testes

- **JUnit 4**: Substituído por JUnit 5.
- **Mockito**: Ajustado para funcionar com as novas versões.
- **Testes de Integração**: Implementados utilizando `@SpringBootTest` com `TestRestTemplate` e `FeignClient`.

### Novas Funcionalidades

- **Endpoint `/health`**: Adicionado para verificar a saúde do microsserviço.
- **Configuração Parametrizada**: A URL da API DummyJSON foi parametrizada no arquivo `application.yaml` para suportar múltiplos ambientes.

### Melhorias Gerais

- **Cobertura de Testes**: Aumentada para atender aos requisitos do Sonar.
- **Código Depreciado**: Removido e substituído por alternativas modernas.
- **Documentação**: Atualizada para refletir as mudanças realizadas.

## Requisitos de Validação# code-challenge-migration
