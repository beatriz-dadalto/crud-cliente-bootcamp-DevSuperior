▶ CRUD completo de web services REST para acessar um recurso de clientes

# Desafio: CRUD completo de clientes

Desenvolver um projeto Spring Boot 2.3.x contendo um CRUD completo de web services REST para acessar um recurso de clientes, contendo as cinco operações básicas aprendidas no capítulo:

- Busca paginada de recursos
- Busca de recurso por id
- Inserir novo recurso
- Atualizar recurso
- Deletar recurso


# Requisições no Postman

**Buscar paginada de clientes**

```
GET /clients?page=0&linesPerPage=12&direction=ASC&orderBy=name
```

**Buscar de cliente por id**

```
GET /clients/1
```

**Inserção de novo cliente**

```
POST /clients
{
  "name": "Maria Silva",
  "cpf": "12345678901",
  "income": 6500.0,
  "birthDate": "1994-07-20T10:30:00Z",
  "children": 2
}
```

**Atualização de cliente**

```
PUT /clients/1
{
  "name": "Maria Silva",
  "cpf": "12345678901",
  "income": 6500.0,
  "birthDate": "1994-07-20T10:30:00Z",
  "children": 2
}
```

**Deleção de cliente**

```
DELETE /clients/1
```

**Requisitos:**

- Ambiente de testes configurado acessando o banco de dados **H2**;
- **Maven** como gerenciador de dependência;
- **Java 11** como linguagem.

# Resultado final no banco H2

<img src="https://raw.githubusercontent.com/biacoelho/crud-cliente-bootcamp-DevSuperior/master/img-h2.png" alt="" width="700">
