package com.unisys.programs.ex02;

import org.bson.types.ObjectId;

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
		
		Customer c1 = new Customer();
		c1.setId(new ObjectId("5c7f9389102d555486b7301a"));
		
		c1 = store.get(c1);
		System.out.println(c1);
		mc.close();
	}
}
