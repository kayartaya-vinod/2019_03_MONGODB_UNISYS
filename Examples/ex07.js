use unisysdb;

db.sales_data.find({ quarter: 1 }, { sales: true }).limit(5);

db.sales_data.update(
    { quarter: true },             // where condition
    { $inc: { sales: true } },     // document to update
    { multi: true });              // additional options

db.sales_data.find({ quarter: 1 }, { sales: true }).limit(5);
