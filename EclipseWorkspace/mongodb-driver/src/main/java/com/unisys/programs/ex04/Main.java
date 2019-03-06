package com.unisys.programs.ex04;

import static com.mongodb.client.model.Filters.eq;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.bson.types.ObjectId;

import com.mongodb.MongoClientSettings;
import com.mongodb.client.FindIterable;
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
		
		FindIterable<Customer> list = customers.find(eq("country", "Turkey"));
		for(Customer c: list) {
			System.out.println(c);
		}
		list.iterator().close();
		
		Customer c1 = customers.find(eq("_id", new ObjectId("5c7f5b8fae6ae747acd44556"))).first();
		System.out.println(c1);
		
		// c1.setState("Silesian Voivodeship");
		// customers.updateOne(eq("_id", new ObjectId("5c7f5b8fae6ae747acd44556")), c1);
		
		mc.close();
		
	}
}
