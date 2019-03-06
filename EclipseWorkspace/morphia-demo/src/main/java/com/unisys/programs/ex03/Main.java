package com.unisys.programs.ex03;

import java.util.List;

import com.mongodb.MongoClient;
import com.unisys.entity.Customer;

import xyz.morphia.Datastore;
import xyz.morphia.Morphia;
import xyz.morphia.query.Query;

public class Main {

	public static void main(String[] args) {
		MongoClient mc = new MongoClient(); // mongodb://localhost:27017

		Morphia m = new Morphia();
		m.mapPackage("com.unisys.entity");
		Datastore store = m.createDatastore(mc, "unisysdb");
		
		Query<Customer> qry = store.createQuery(Customer.class);
		List<Customer> list = qry
				//.filter("country", "United States")
				//.field("country").equal("United States")
				// .filter("salary <=", 40000)
				.filter("country !=", "United States")
				.asList();
		
		for(Customer c: list) {
			System.out.println(c.getName() + " lives in " + c.getCity());
		}
		
		mc.close();
	}
}
