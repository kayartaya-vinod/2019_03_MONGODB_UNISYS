use unisysdb;

db.books.update({
    title: 'Mongodb A-Z'
}, {
    title: 'Mongodb A-Z',
    price: 900
}, {
    upsert: true
});

