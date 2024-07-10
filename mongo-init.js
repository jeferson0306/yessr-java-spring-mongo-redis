db = db.getSiblingDB('admin');
db.createCollection('PERSON');
db.PERSON.insertMany([
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
    },
    {
        "name": "John Doe",
        "document": "12345678901",
        "email": "johndoe@example.com",
        "phone": "(21)99999-9999",
        "tier": {
            "id": "2",
            "name": "gold",
            "averagePurchasePrice": 200,
            "purchaseDate": "2024-05-15T10:30:00.000Z"
        },
        "address": "Rua Exemplo, 123",
        "city": "Rio de Janeiro",
        "state": "RJ",
        "zipCode": "20000-000",
        "country": "Brasil",
        "updatedAt": "2024-05-15T10:30:00.000Z",
        "birthDate": "1990-01-01T00:00:00.000Z",
        "gender": "male",
        "purchases": [
            {
                "id": "2",
                "amount": 150,
                "purchaseDate": "2024-05-15T10:30:00.000Z"
            }
        ]
    },
    {
        "name": "Jane Smith",
        "document": "98765432100",
        "email": "janesmith@example.com",
        "phone": "(11)98888-8888",
        "tier": {
            "id": "3",
            "name": "platinum",
            "averagePurchasePrice": 300,
            "purchaseDate": "2024-06-01T15:00:00.000Z"
        },
        "address": "Avenida Paulista, 1000",
        "city": "São Paulo",
        "state": "SP",
        "zipCode": "01310-100",
        "country": "Brasil",
        "updatedAt": "2024-06-01T15:00:00.000Z",
        "birthDate": "1985-05-05T00:00:00.000Z",
        "gender": "female",
        "purchases": [
            {
                "id": "3",
                "amount": 250,
                "purchaseDate": "2024-06-01T15:00:00.000Z"
            }
        ]
    },
    {
        "name": "Alice Johnson",
        "document": "19283746500",
        "email": "alicejohnson@example.com",
        "phone": "(31)97777-7777",
        "tier": {
            "id": "4",
            "name": "bronze",
            "averagePurchasePrice": 80,
            "purchaseDate": "2024-06-10T12:00:00.000Z"
        },
        "address": "Praça da Liberdade, 200",
        "city": "Belo Horizonte",
        "state": "MG",
        "zipCode": "30140-010",
        "country": "Brasil",
        "updatedAt": "2024-06-10T12:00:00.000Z",
        "birthDate": "1992-12-12T00:00:00.000Z",
        "gender": "female",
        "purchases": [
            {
                "id": "4",
                "amount": 70,
                "purchaseDate": "2024-06-10T12:00:00.000Z"
            }
        ]
    },
    {
        "name": "Bob Brown",
        "document": "56473829100",
        "email": "bobbrown@example.com",
        "phone": "(41)96666-6666",
        "tier": {
            "id": "5",
            "name": "silver",
            "averagePurchasePrice": 90,
            "purchaseDate": "2024-06-20T18:00:00.000Z"
        },
        "address": "Rua XV de Novembro, 300",
        "city": "Curitiba",
        "state": "PR",
        "zipCode": "80020-310",
        "country": "Brasil",
        "updatedAt": "2024-06-20T18:00:00.000Z",
        "birthDate": "1980-11-11T00:00:00.000Z",
        "gender": "male",
        "purchases": [
            {
                "id": "5",
                "amount": 85,
                "purchaseDate": "2024-06-20T18:00:00.000Z"
            }
        ]
    }
]);
