use unisysdb;


// text index required for $text query
// db.blogs.ensureIndex({ 'title.text': 'text' })
// db.blogs.ensureIndex({ 'content.text': 'text' })

// $search: '"sapling"+"blossom"'

var c = db.blogs.find({
    $text: {
        $search: '"sapling too to blossom"'
    }
}).count();

print(c + ' documents found!');
