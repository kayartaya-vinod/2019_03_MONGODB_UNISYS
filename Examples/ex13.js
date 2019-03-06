use unisysdb;

// this works only if 'coords' is indexed using geo-spacial index

// db.atms.ensureIndex({ coords: '2d' })
// db.atms.dropIndex('coords_2dsphere')

db.atms.find({
    coords: {
        $near: [12.947126, 77.531818]
    }
}, {
    _id: 0
}).limit(5).pretty()