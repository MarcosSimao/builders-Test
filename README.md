# builders-Test
Teste Builders api REST Crud

## Construído com

* 	[Maven](https://maven.apache.org/) - Gerenciador de Dependências
* 	[JDK 11](http://www.oracle.com/technetwork/java/javase/downloads/jdk11-downloads-2133151.html) - Java™ Platform, Standard Edition Development Kit - Versão 11
* 	[Spring Boot](https://spring.io/projects/spring-boot) - Framework utilizado facilitar e agilizar as Aplicações Springs
* 	[MongoDb](https://www.mongodb.com/try)- Bancos de Dados orientados a Documentos utilizam o conceito de dados e documentos autocontidos e auto descritivos.
* 	[git](https://git-scm.com/) - Sistema de Controle de Versões, Open-Source
api REST

## Ferramenta Externa Usada

* [Postman](https://www.getpostman.com/) - Ambiente de Desenvolvimento de Testes e Documentação

## O problema

Desenvolva um projeto Java com Spring Boot (utilizando qualquer modulo que achar necessário), que possua uma api REST com CRUD de Cliente (id, nome, cpf, dataNascimento). O CRUD deve possuir uma api de GET, POST, DELETE, PATCH e PUT.

 A api de GET deve aceitar query strings para pesquisar os clientes por CPF e nome. Também é necessário que nessa api os clientes voltem paginados e que possua um campo por cliente com a idade calculado dele considerando a data de nascimento.
 
## Solução

Aqui eu irei mostrar todo o processo de teste feito pelo postman:

o primeiro e o GET , nele ha  4 maneiras  para acessa-lo...  A primeira  e com o metodo findAll que esta incluindo dentro do mesmo a paginacao.
Nele lista todos que estao cadastrado no banco... para acessa-lo colocamos esta url:

```
GET http://localhost:8080/clientes
```
esse o resultado:

```
[
    {
        "id": "5f580a6fa4742943b47c87d2",
        "nome": "Januario ferreira",
        "cpf": "345.784.093.23",
        "dataNascimento": "22/10/1990",
        "idade": 29
    },
    {
        "id": "5f580a6fa4742943b47c87d1",
        "nome": "Leticia afrodite",
        "cpf": "983.345.456.11",
        "dataNascimento": "23/11/2001",
        "idade": 18
    },
    {
        "id": "5f580a6fa4742943b47c87d0",
        "nome": "Lucas almeida",
        "cpf": "234.123.093.33",
        "dataNascimento": "01/12/1999",
        "idade": 20
    },
    {
        "id": "5f580a6fa4742943b47c87cf",
        "nome": "Marcos alecrim",
        "cpf": "123.345.093.23",
        "dataNascimento": "12/02/1993",
        "idade": 27
    }
]
```


