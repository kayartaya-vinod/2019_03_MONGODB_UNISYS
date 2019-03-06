
function reduceFn(customerName, orderTotals) {
    return Array.sum(orderTotals);
    // return { 'orderTotals': orderTotals, 'total': Array.sum(orderTotals) }
}