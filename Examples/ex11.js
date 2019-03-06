use unisysdb;

// db.sales_data.mapReduce(
//     function () {
//         var code = this.category.substr(0, 4).toUpperCase();
//         emit(code, this.sales_amount);
//     },
//     function (key, values) {
//         return Array.sum(values)
//     },
//     {
//         out: { inline: true }
//     });

db.orders.mapReduce(
    function () {
        var customerId = this.customer.customerId
        var total = 0;
        this.products.forEach(function(p){
            // total += p.discount;
            total += (p.price * p.quantity) * (1 - p.discountPercent);
        });
        emit(customerId, total);
    },
    function (customerId, orderTotals) {
        return Array.sum(orderTotals);
    },
    {
        out: { inline: true }
    }
)