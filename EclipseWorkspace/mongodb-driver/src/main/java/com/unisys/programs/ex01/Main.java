package com.unisys.programs.ex01;

import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;

public class Main {

	static void line() {
		System.out.println("-------------------------------------");
	}

	public static void main(String[] args) {
		MongoClient mc = MongoClients.create(); // mongodb://localhost:27017
		MongoDatabase db = mc.getDatabase("unisysdb");

		MongoIterable<String> collectionNames = db.listCollectionNames();

		System.out.println("Following collections found: ");
		for (String name : collectionNames) {
			System.out.println(name);
		}
		line();

		MongoCollection<Document> contacts = db.getCollection("contacts");
		long count = contacts.countDocuments();
		System.out.println(count + " contacts exist.");

		line();

		Document p1 = contacts.find().first();
		System.out.println(p1);
		
		line();

		MongoCollection<Document> customers = db.getCollection("customers");
		FindIterable<Document> turkeyCustomers = customers.find(new Document("country", "Turkey"));
		for (Document d : turkeyCustomers) {
			System.out.println(d.getString("name") + " lives in " + d.getString("city"));
		}

		mc.close();
	}
}
