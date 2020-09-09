# builders-Test
Teste Builders api REST Crud

## Construído com

* 	[Maven](https://maven.apache.org/) - Gerenciador de Dependências
* 	[JDK 11](http://www.oracle.com/technetwork/java/javase/downloads/jdk11-downloads-2133151.html) - Java™️ Platform, Standard Edition Development Kit - Versão 11
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

O primeiro é o GET, nele há 4 maneiras para acessá-lo...  A primeira é com o método findAll que está incluído dentro do mesmo... tudo paginado.
Nele lista todos que estão cadastrados no banco... para acessa-lo colocamos esta url:


GET http://localhost:8080/clientes

Esse é o resultado:


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

O segundo GET é pesquisado pelo id do cliente ... e segue esta url:



http://localhost:8080/clientes/5f580a6fa4742943b47c87d2

Resultado:


{
    "id": "5f580a6fa4742943b47c87d2",
    "nome": "Januario ferreira",
    "cpf": "345.784.093.23",
    "dataNascimento": "22/10/1990",
    "idade": 29
}

O terceiro GET é pesquisado pelo cpf do cliente, e segue esta url:



http://localhost:8080/clientes/cpf/234.123.093.33

Resultado:


{
    "id": "5f580a6fa4742943b47c87d0",
    "nome": "Lucas almeida",
    "cpf": "234.123.093.33",
    "dataNascimento": "01/12/1999",
    "idade": 20
}


O Quarto GET é pesquisado pelo nome do cliente , e segue esta url:


http://localhost:8080/clientes/nome/Marcos alecrim

Resultado:



{
    "id": "5f580a6fa4742943b47c87cf",
    "nome": "Marcos alecrim",
    "cpf": "123.345.093.23",
    "dataNascimento": "12/02/1993",
    "idade": 27
}

O segundo verbo é o POST,  para acessá-lo segue este modelo de url:


 POST  http://localhost:8080/clientes

No POST segue as seguintes variáveis criada na classe Cliente: nome, cpf, dataNascimento. O id é gerado pelo próprio banco, e idade é criada a partir da data de nascimento pelo método na classe DTO cliente... Se você olhar esse modelo vai perceber que idade não está inserida no banco de dados, ela é um método chamado pelo verbo GET...
 E segue neste Resultado:
 
 
 {
        
        "nome": "Laiane Silva ",
        "cpf": "800.784.093.23",
        "dataNascimento": "14/01/1991"
    }

Caso o cpf já esteja cadastrado, é retornado o erro :

 
{
    "timeStamp": 1599609852160,
    "status": 401,
    "error": "acesso invalido!!",
    "message": "cpf ja Cadastrado !!!",
    "path": "/clientes"
}

Caso não esteja cadastrado, o resultado segue com 200 de sucesso !!!
 E mais um cliente é colocado na lista:
 
 `
 [
    {
        "id": "5f581b74a4742943b47c87d3",
        "nome": "Laiane Silva ",
        "cpf": "800.784.093.23",
        "dataNascimento": "14/01/1991",
        "idade": 29
    },
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
 

`
O próximo verbo é o PUT... nele podemos atualizar um objeto por indicação do id , e segue neste modelo:

`
PUT http://localhost:8080/clientes/5f581b74a4742943b47c87d3
`
Pegamos o id de Laiane e alteramos o nome dela para Lorena... Caso o cpf seja mudado segue o mesmo método do post, retorna o erro 401
E o modelo para atualizar segue neste padrão:

`
{
        
        "nome": "Lorena Silva ",
        "cpf": "800.784.093.23",
        "dataNascimento": "14/01/1991"
    }

`
E se listarmos novamente, podemos observar que Laiane, agora, se chama Lorena...

`
[
    {
        "id": "5f581b74a4742943b47c87d3",
        "nome": "Lorena Silva ",
        "cpf": "800.784.093.23",
        "dataNascimento": "14/01/1991",
        "idade": 29
    },
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

`
E o Próximo verbo é o DELETE ... ele recebe o id do cliente e assim o mesmo é excluído do sistema ...
Segue esta url:

`
DELETE http://localhost:8080/clientes/5f581b74a4742943b47c87d3

`
Agora se listarmos novamente, é perceptível que Lorena não se encontra mais entre os cadastrados.

`
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

`
Caso não encontre o cpf, nome e id, será retornado esse erro:

`
{
    "timeStamp": 1599611064332,
    "status": 404,
    "error": "nao Encontrado!!",
    "message": "Objeto não encontrado",
    "path": "/clientes/hyyyy"
}

`

Esses testes foram realizados no servidor Local ...
caso queira testar é só baixá-lo...!!!!
