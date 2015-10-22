package com.netbuilder.DBConnector;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

public class MongoPull {

	private MongoDBConnector mdbc = new MongoDBConnector();

	public MongoPull() {

	}

	public void find(String collectionName, String field, String value, String field1, String field2) {

		mdbc.mongoConnect();

		DB db = mdbc.getConnection().getDB("nbgardensdata");

		System.out.println(db.getCollectionNames());

		DBCollection collection = db.getCollection(collectionName);

		BasicDBObject whereQuery = new BasicDBObject();
		whereQuery.put("idAddress", 0.0);
		BasicDBObject fields = new BasicDBObject();
		fields.put("idAddress", 1.0);

		DBCursor cursor = collection.find(whereQuery);
		while (cursor.hasNext()) {
			System.out.println(cursor.next());
		}

		mdbc.mongoDisconnect();
	}
}
