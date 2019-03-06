package com.unisys.programs.ex01;

import com.mongodb.MongoClient;
import com.unisys.entity.Customer;

import xyz.morphia.Datastore;
import xyz.morphia.Morphia;

public class Main {

	public static void main(String[] args) {
		MongoClient mc = new MongoClient(); // mongodb://localhost:27017
		
		Morphia m = new Morphia();
		m.mapPackage("com.unisys.entity");
		Datastore store = m.createDatastore(mc, "unisysdb");
		
		Customer c = new Customer();
		c.setName("Kishore");
		c.setEmail("kishore@example.com");
		c.setCity("Vasco");
		c.setState("Goa");
		c.setCountry("India");
		
		store.save(c);
		
		System.out.println("Data saved!");
		mc.close();
	}
}
