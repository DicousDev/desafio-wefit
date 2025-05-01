# Wefit - Desafio técnico

## Requisitos

- Java 17
- Git
- Maven 3.6.3
- Docker 20.10+

## Arquitetura

A arquitetura em camadas foi e é decidida e reajustada com base no aumento da complexidade do projeto ao longo do tempo de desenvolvimento.
No momento, a arquitetura apresenta como as principais camadas: controller, service, repository, model. 
Podemos também, encontrar testes unitários e testes de integração o que é crucial para mantermos a qualidade das entregas.

## Padrões

O projeto segue boas práticas de clean code, single responsability principle (SRP) e aplica os conceitos de domain driven design (DDD). 

## Tecnologias

- Spring boot 3.4.5
- Spring Data Jpa
- Lombok
- Flyway migration
- Testcontainers
- PostgreSQL
- Documentação Swagger

## Executando localmente

- Certifique-se que seu Docker esteja aberto
- Abra a pasta raiz do projeto
- Execute o seguinte comando para subir a aplicação completa (API e database)

```shell
docker-compose up -d
```

- O projeto tem documentação swagger, então podemos acessar API acessando pelo navegador http://localhost:8080/swagger-ui/index.html#/

## Spoiler para próximas versões

Desenvolvimento de consultas pelo CEP para agilizar preenchimento dos endereços nos formulários.  

## Cadastro de pessoa física ou juridíca

```curl
POST http://localhost:8080/pessoas

{
  "tipoPessoa": "PESSOA_FISICA", // podendo ser "PESSOA_FISICA" ou "PESSOA_JURIDICA"
  "cnpj": null,
  "cpf": "07879120009",
  "nome": "João Victor",
  "celular": "7924349579",
  "telefone": "7924349579",
  "email": "joaoficticio@gmail.com",
  "endereco": {
    "cep": "18052370",
    "logradouro": "Rua Francelino Romão",
    "numero": "100",
    "complemento": "Apartamento",
    "cidade": "Sorocaba",
    "bairro": "Vila Rica",
    "estado": "SP"
  }
}
```