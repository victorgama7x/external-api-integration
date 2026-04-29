# Integração com API externa

### Objetivo

Desenvolvimento de uma aplicação integrada a uma API externa para coleta e processamento de notícias sobre tecnologia, utilizando o Spring WebFlux como cliente HTTP. O projeto teve como objetivo a prática de consumo de APIs externas e manipulação de dados retornados.

## Tecnologias utilizadas

-**_Linguagem:_** Java 21.

- **_Frameworks e Dependências_**
  - **_Backend:_** Spring Boot 3.5.11, Spring Web, Spring DevTools e Spring WebFlux.

## Pré-requisitos

- [Docker](https://docs.docker.com/desktop/)
- [GIT](https://git-scm.com/)

## Como Executar

1. Acesse o site [NewsApi](https://newsapi.org/) e gere sua API KEY.

2. clone o projeto e acesse a pasta:

   ```bash
   git clone https://github.com/external-api-integration/
   cd external-api-integration
   ```

3. Crie o arquivo .env e cole sua API KEY:

   ```bash
   Example: API_KEY=your-api-key
   ```

4. Rode o projeto:
   ```bash
   Docker Compose up -d
   ```

## Como utilizar

- Faça um **GET** na rota `localhost:8080/api/v1/news`.

  ```bash
  Example:
      curl -X GET http://localhost:8080/api/v1/news \
      -H "Accept: application/json"
  ```

- Essa é a resposta esperada:

  ```bash
  Example:
   {
      [
         {
            "description": "A spate of attacks against civilians and military bases in Colombia's southwestern region has raised security concerns as the country heads to a May presidential election.",
            "publishedAt": "2026-04-28T07:38:58Z",
            "title": "Violence escalates in Colombia with dozens of attacks before presidential vote - NPR",
            "url": "https://www.npr.org/2026/04/28/nx-s1-5802273/violence-colombia-before-presidential-vote"
        },
        {
            "description": "The \"Daily Show\" host scolded a key Trump insider over this moment.",
            "publishedAt": "2026-04-28T06:33:56Z",
            "title": "Jon Stewart Reveals The Most Awkward 'True Colors' Moment Of WHCD Shooting - HuffPost",
            "url": "https://www.huffpost.com/entry/jon-stewart-rfk-jr-whcd_n_69f02368e4b0983c970e70aa"
        },
        {
            "description": "Google is developing a new Proactive Assistance feature for Gemini to delivers timely, context-aware suggestions even before you ask.",
            "publishedAt": "2026-04-28T04:49:59Z",
            "title": "Here's your first look at Google's upcoming 'Proactive Assistance' feature for Gemini - Android Authority",
            "url": "https://www.androidauthority.com/google-gemini-proactive-assistance-3661314/"
        }
    ],
    "status": "ok",
    "totalResults": 33
  }
  ```

  ## Arquitetura da solução

O projeto segue a arquitetura em camadas do Spring, separando responsabilidades em camadas distintas: Controller, Service, Config, Client e DTO. Cada camada possui funções específicas, garantindo clareza, manutenibilidade e facilidade de escalabilidade, além de promover separação de preocupações e reuso de código.

### Estrutura de diretórios

- **controller/**

  Camada responsável por receber e gerenciar as requisições HTTP, chamando os serviços adequados e retornando as respostas ao cliente.

- **service/**

  Contém a lógica de negócio do sistema, coordenando operações entre os repositórios e preparando os dados para a camada de apresentação.

- **client/**

  Responsável pela comunicação com APIs externas, realizando requisições HTTP por meio do WebClient (do Spring WebFlux) e tratando as respostas dessas integrações.

- **config/**

  Contém as configurações da aplicação, como definição de beans, configuração do WebClient, timeouts, interceptors e demais customizações necessárias para o funcionamento da aplicação.

- **dto/**

  Objetos de transferência de dados usados para transportar informações entre camadas, isolando a representação interna das entidades.
