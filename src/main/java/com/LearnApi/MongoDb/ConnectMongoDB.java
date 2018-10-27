package com.LearnApi.MongoDb;

import java.net.ConnectException;

import org.bson.Document;
import org.testng.Assert;

import com.LearnApi.Utilities.ReadProperties;
import com.mongodb.MongoClient;
import com.mongodb.MongoSocketOpenException;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;

public class ConnectMongoDB {
	
	public MongoClient m_client;
	MongoDatabase m_dataBase;
	FindIterable<Document> collectionDoc;
	String jsonString;

	public ConnectMongoDB() {
		m_client = new MongoClient(ReadProperties.getProperty("mongoHost"), Integer.parseInt(ReadProperties.getProperty("mongoPort")));
		m_dataBase = m_client.getDatabase(ReadProperties.getProperty("dbName"));
	}
	
	public String getCollection(String collection){
		collectionDoc = m_dataBase.getCollection(collection).find();
		for(Document doc : collectionDoc){
			jsonString = doc.toJson();
		}
		
		return jsonString;
		
	}

}
