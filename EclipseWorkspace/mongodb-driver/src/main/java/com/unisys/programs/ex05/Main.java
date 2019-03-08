package com.unisys.programs.ex05;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.unisys.entity.Customer;

public class Main {

	public static void main(String[] args) {
		MongoClient mc = MongoClients.create(); // mongodb://localhost:27017
		
		CodecRegistry pojoCodecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(),
                fromProviders(PojoCodecProvider.builder().automatic(true).build()));
		
		MongoDatabase db = mc.getDatabase("unisysdb").withCodecRegistry(pojoCodecRegistry);
		MongoCollection<Customer> customers = db.getCollection("customers", Customer.class);
		
		for(int i=0; i<10000000; ) {
			try {
				Customer c = new Customer();
				c.setName("Kishore");
				c.setEmail("kishore@example.com");
				c.setCity("Vasco");
				c.setState("Goa");
				c.setCountry("India");
				i++;
				
				customers.insertOne(c);
				System.out.println("Added " + i + " contacts");
			} catch (Exception e) {
				System.out.println("There was an error: " + e.getMessage());
			}
		}
		
		mc.close();
		
	}
}
