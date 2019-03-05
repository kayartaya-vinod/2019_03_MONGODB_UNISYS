use unisysdb;

db.books.insert([
    {
        title: 'Java Unleasehed',
        price: 788
    },
    {
        title: 'Mongodb Unleashed',
        price: 500,
        publisher: 'BPB'
    }
]);

var c = db.books.count();
print('Total books = ' + c);

// db.books.find().explain("executionStats")