# Projeto Yessr

O **Yessr** é uma aplicação de Gerenciamento de Relacionamento com Clientes (CRM) que utiliza tecnologias modernas para
oferecer uma solução eficiente e escalável.

## Tecnologias Utilizadas

- **Java (JDK 21)**: Linguaguem de Programação Java para desenvolvimento do backend
- **Spring Boot (3.2.5)**: Framework Java para desenvolvimento de aplicações web e microserviços.
- **MongoDB**: Banco de dados NoSQL para armazenamento dos dados dos clientes.
- **Redis**: Sistema de armazenamento de dados em memória usado para caching e melhoria de desempenho.
- **Lombok**: Biblioteca que ajuda a reduzir o código boilerplate.
- **Spring Data MongoDB**: Integração do Spring Framework com o MongoDB.
- **Spring Data Redis**: Integração do Spring Framework com o Redis.

## Principais Funcionalidades

### Controllers

#### CustomerController

- **@POST /save**: Salva ou atualiza um cliente no banco de dados.
- **@GET /{document}**: Consulta um cliente pelo documento usando cache para melhorar o desempenho.

### Services

#### CustomerService

- **saveOrUpdateCustomer(Person person)**: Valida e persiste os dados do cliente, atualizando o cache.
- **getCustomerByDocument(String document)**: Realiza a busca de um cliente por documento, utilizando cache.

### Modelos de Domínio

- **Person**: DTO para transferência de dados do cliente.
- **PersonCollection**: Entidade mapeada para o MongoDB com um ID gerado automaticamente.

## Configuração de Cache

O caching é realizado com Redis, permitindo respostas mais rápidas para consultas frequentes.

## Performance

A utilização do cache proporciona um ganho de performance nas consultas, em comparação com consultas diretas ao MongoDB.

## Exemplos de Uso

```bash
# Para salvar ou atualizar um cliente
POST /api/v1/customers/save
{
 {
  "name": "Wodoa Inrer Irpledei Zeous",
  "document": "17333479099",
  "email": "17333479099@uol.com.br",
  "phone": "(11)98563-0123",
  "tier": {
    "id": "1",
    "name": "silver",
    "averagePurchasePrice": 100,
    "purchaseDate": "2024-05-10T00:00:05.876Z"
  },
  "address": "Agostinho",
  "city": "Sao Paulo",
  "state": "Sao Paulo",
  "zipCode": "08000-000",
  "country": "Brasil",
  "updatedAt": "2024-05-10T00:00:05.876Z",
  "birthDate": "2024-05-10T00:00:05.876Z",
  "gender": "female",
  "purchases": [
    {
      "id": "1",
      "amount": 99,
      "purchaseDate": "2024-05-10T00:00:05.876Z"
    }
  ]
 }
}

# Para consultar um cliente pelo documento
GET /api/v1/customers/{document}
- "/api/v1/customers/17333479099"


Cache Details
@CachePut(value = "customer", key = "#person.document"): Atualiza o cache a cada operação de inserção ou atualização.
@Cacheable(value = "customer", key = "#document"): Consulta o cache antes de acessar o banco de dados.
```

#### Desenvolvido por Jeferson Siqueira

- Github: https://github.com/jeferson0306
- LinkedIn: https://www.linkedin.com/in/developerjefersonsiqueira/
