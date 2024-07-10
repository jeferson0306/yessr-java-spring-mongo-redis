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
    }
]);
