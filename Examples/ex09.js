use unisysdb;

// db.sales_data.find({
//     sales_amount: { $gte: 10000 }
// }).sort({
//     sales_amount: -1
// }).pretty();


// db.sales_data.find({
//     $and: [
//     {sales_amount: { $gte: 5000 }}, 
//     {sales_amount: { $lte: 5100 }}
//     ]
// }).sort({
//     sales_amount: -1
// }).pretty();

// db.sales_data.find({
//     $and: [
//         { sales_amount: { $gte: 5000 } },
//         { sales_amount: { $lte: 5500 } },
//         { quarter: { $in: [1, 3, 2] } }
//     ]
// }).sort({
//     sales_amount: -1
// }).pretty();

db.sales_data.find({
    $where: "this.sales_amount>=5000 && this.sales_amount<=6000 && this.quarter==1"
}).sort({
    sales_amount: -1
}).pretty();