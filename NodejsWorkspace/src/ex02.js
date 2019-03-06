const mc = require('mongodb').MongoClient;


setTimeout(async () => {

    const conn = await mc.connect('mongodb://localhost:27017', { useNewUrlParser: true });
    const db = conn.db('unisysdb');
    const customers = db.collection('customers');
    const c1 = await customers.findOne({ 'email': 'kishore@example.com' });
    console.log(c1);
    conn.close();

}, 0);