use unisysdb;


print('Before update: ');
db.contacts.findOne({ "_id" : ObjectId("5c7e1762d406e47a12e0c107") });

db.contacts.update(
    { "_id" : ObjectId("5c7e1762d406e47a12e0c107") },
    {
        $set: {
            city: 'Mysore',
            country: {
                code: 'IN',
                name: 'India'
            }
        }
    }
);

print('After update: ');
db.contacts.findOne({ "_id" : ObjectId("5c7e1762d406e47a12e0c107") });
