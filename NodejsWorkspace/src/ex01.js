const mc = require('mongodb').MongoClient;

mc.connect('mongodb://localhost:27017', (err, conn) => {
    if (err) throw err;

    const db = conn.db("unisysdb");
    const customers = db.collection("customers");

    // customers.findOne({ "email": "kishore@example.com" }, (err, data) => {
    //     if (err) throw err;

    //     console.log(data);
    //     conn.close();
    // });

    customers.find({ "country": "United States" }).toArray((err, data) => {
        if (err) throw err;

        console.log(data);
        conn.close();
    });


});