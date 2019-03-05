use unisysdb;

db.sales_data.aggregate([
    {
        $match: {
            quarter: { $in: [1, 2] }
        }
    },
    {
        $group: {
            _id: '$category',
            totalSales: { $sum: 1 },
            totalSalesAmount: { $sum: '$sales_amount' },
            maxSalesAmount: { $max: '$sales_amount' },
            minSalesAmount: { $min: '$sales_amount' }
        }
    },
    {
        $match: {
            totalSalesAmount: { $gte: 35000 }
        }
    },
    {
        $sort: {
            totalSalesAmount: -1
        }
    },
    {
        $limit: 3
    }
]).pretty();