package com.unisys.programs.ex03;

import static com.mongodb.client.model.Filters.*;

import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class Main {
	public static void main(String[] args) {
		MongoClient mc = MongoClients.create(); // mongodb://localhost:27017
		MongoDatabase db = mc.getDatabase("unisysdb");
		MongoCollection<Document> salesData = db.getCollection("sales_data");
		
		FindIterable<Document> list = salesData.find(
				and(gte("sales_amount", 5000), lte("sales_amount", 5500), eq("quarter", 1)));
		for(Document d: list) {
			System.out.println(d);
		}
		mc.close();
	}
}
