package com.unisys.programs.ex02;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class Main {

	public static void main(String[] args) {
		MongoClient mc = MongoClients.create(); // mongodb://localhost:27017
		MongoDatabase db = mc.getDatabase("unisysdb");
		MongoCollection<Document> customers = db.getCollection("customers");
		
		Document c1 = new Document("name", "Vinod")
				.append("email", "vinod@vinod.co")
				.append("phone", "9731424784")
				.append("city", "Bangalore")
				.append("state", "Karnataka")
				.append("country", "India");
		
		customers.insertOne(c1);
		System.out.println("Inserted data: " + c1.toJson());
		mc.close();
		// > db.customers.find().sort({_id: -1}).limit(1).pretty();
	}
}
