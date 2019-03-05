use unisysdb;

db.employees.drop();

db.createCollection('employees', {
    validator: {
        $jsonSchema: {
            required: ['name', 'email', 'phone', 'dept', 'salary'],
            properties: {
                name: {
                    bsonType: 'string',
                    minLength: 5,
                    description: 'Name must be a string of at least 5 letters'
                },
                email: {
                    bsonType: 'string',
                    description: 'Email id must be a string'
                },
                // phone: {
                //     bsonType: 'string',
                //     pattern: '\d{10,12}',
                //     description: 'Phone must be 10-12 digits only'
                // },
                dept: {
                    bsonType: 'string',
                    enum: ['ADMIN', 'ACCOUNTING', 'PRODUCTION', 'RND'],
                    description: 'Department must be one of ADMIN, ACCOUNTING, PRODUCTION, RND'
                },
                salary: {
                    bsonType: 'double',
                    minimum: 15000
                },
                skills: {
                    bsonType: 'array',
                    uniqueItems: true,
                    maxItems: 3
                }
            }
        }
    }
});

db.employees.insert({
    name: 'Ramesh',
    skills: ['Java', 'Mongodb', 'Nodejs'],
    salary: 25000,
    dept: 'ADMIN',
    email: 'ramesh@example.com',
    phone: '9800293456'
});

db.employees.find().pretty();