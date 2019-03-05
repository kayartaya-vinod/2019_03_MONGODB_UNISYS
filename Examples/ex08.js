use unisysdb;

db.books.find({
    title: {
        $exists: true
    }
}).pretty();
