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
O segundo GET e pesquisado pelo id do cliente ... e segue esta url:


```
http://localhost:8080/clientes/5f580a6fa4742943b47c87d2
```
Resultado:

```
{
    "id": "5f580a6fa4742943b47c87d2",
    "nome": "Januario ferreira",
    "cpf": "345.784.093.23",
    "dataNascimento": "22/10/1990",
    "idade": 29
}
```
O terceiro GET e pesquisado pelo cpf do cliente, e segue esta url:


```
http://localhost:8080/clientes/cpf/234.123.093.33
```
Resultado:

```
{
    "id": "5f580a6fa4742943b47c87d0",
    "nome": "Lucas almeida",
    "cpf": "234.123.093.33",
    "dataNascimento": "01/12/1999",
    "idade": 20
}
```

O Quarto GET e pesquisado pelo nome do cliente , e segue esta url:

```
http://localhost:8080/clientes/nome/Marcos alecrim
```
Resultado:


```
{
    "id": "5f580a6fa4742943b47c87cf",
    "nome": "Marcos alecrim",
    "cpf": "123.345.093.23",
    "dataNascimento": "12/02/1993",
    "idade": 27
}
```
o segundo verbo e o POST  para acessado segue este modelo de url:

```
 POST  http://localhost:8080/clientes
```
No POST segue as seguintes variaveis criada na classe CLiente:nome,cpf,dataNascimento. o id e gerado pelo proprio banco , e idade e criada apartir da datanascimento
pelo metodo na classe DTO cliente... se vc olhar esse modelo vai perceber que idade nao esta inserida no banco de dados , ela e um metodo chamado pelo verbo GET...
 e segue nesse Resultado:
 
 ```
 {
        
        "nome": "Laiane Silva ",
        "cpf": "800.784.093.23",
        "dataNascimento": "14/01/1991"
    }
```
Caso  o cpf ja estiver cadastrado , e restornado o erro :

 ```
{
    "timeStamp": 1599609852160,
    "status": 401,
    "error": "acesso invalido!!",
    "message": "cpf ja Cadastrado !!!",
    "path": "/clientes"
}
```
caso nao esteja cadastrado o resultado segue com 200 de sucesso !!!
 e mais um cliente e colocado na lista :
 
 ````
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
 

````
O proximo verbo e o PUT... nele podemos atulizar um objeto por indicacao do id , e segue neste modelo:

````
PUT http://localhost:8080/clientes/5f581b74a4742943b47c87d3
````
Pegamos o id de laiane e alteramos o nome dela para Lorena... Caso o cpf seja mudado segue o mesmo metodo do post , restorna o erro 401
e o modelo de atualizacao segue neste padrao:

````
{
        
        "nome": "Lorena Silva ",
        "cpf": "800.784.093.23",
        "dataNascimento": "14/01/1991"
    }

````
e se listarmos novamente veras que Laiane agora se chama Lorena...

````
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

````
e o Proximo verbo e o DELETE ... ele recebe o id do cliente e assim o mesmo e exluido do sistema ...
segue esta url:

````
DELETE http://localhost:8080/clientes/5f581b74a4742943b47c87d3

````
Agora se listarmos novamente , veras que Lorena nao se encontra mais  entre os cadastrados..

````
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

````
Caso nao encontre o cpf , nome e id sera retornado esse erro:

````
{
    "timeStamp": 1599611064332,
    "status": 404,
    "error": "nao Encontrado!!",
    "message": "Objeto não encontrado",
    "path": "/clientes/hyyyy"
}

````

Esses testes foram realizados no servidor Local ...
caso queira testar e so baixa-lo...!!!!


 
 






