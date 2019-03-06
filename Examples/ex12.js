use unisysdb;

var mapFn = function () {
    // 'this' corresponds to a single order document
    var customerName = this.customer.customerName;
    var orderTotal = 0;

    this.products.forEach(function (p) {
        orderTotal += (p.price * p.quantity) * (1 - p.discountPercent);
    });

    emit(customerName, orderTotal)
}

// function reduceFn(customerName, orderTotals) {
//     return Array.sum(orderTotals);
// }

var options = {
    out: { inline: true }
};

db.orders.mapReduce(mapFn, reduceFn, options);
// reduceFn is in utils.js
// to execute this ex12.js run the following command:
// mongo --shell Examples/utils.js < Examples/ex12.js