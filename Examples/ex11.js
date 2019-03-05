use unisysdb;

db.sales_data.mapReduce(
    function () {
        var code = this.category.substr(0, 4).toUpperCase();
        emit(code, this.sales_amount);
    },
    function (key, values) {
        return Array.sum(values)
    },
    {
        out: { inline: true }
    });

db.orders.mapReduce(
    function(){
        // param1 = this.customer.customerId
        // param2 = calculate the order total using 
        // unitPrice, quantity and discount
        emit(param1, param2);
    },
    function(customerId, orderTotals) {
        return Array.sum(orderTotals)
    },
    {
        out: { inline: true }
    }
)