package com.kingtop.databases.mongodb.dao;

import java.util.List;
import java.util.Map;

import com.kingtop.databases.mongodb.model.User;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;

public interface UserMongodbDao {

	DB getDb();

	DBCollection getCollection(String collectionName);

	boolean insert(String collectionName, DBObject object);

	boolean update(String collectionName, DBObject query, DBObject updateValue);

	List<DBObject> find(String collectionName, Map<String, Object> map, int num);

	List<DBObject> findAll(String collectionName);

	/*List<User> findListByName(String name);*/

}