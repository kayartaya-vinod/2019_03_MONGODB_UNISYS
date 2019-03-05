use unisysdb;

var cur = db.contacts.find();

var n = 1;
while(cur.hasNext()) {
    var p1 = cur.next();
    if(p1.city !== 'Zijin') continue;

    print(n++ + ' ' + p1.first_name + ' ' + p1.last_name);
}
