package com.kingtop.databases.mongodb.dao.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;



import com.kingtop.databases.mongodb.dao.UserMongodbDao;
import com.kingtop.databases.mongodb.model.User;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;

public class UserMongoDaoImpl implements UserMongodbDao {

	private static final UserMongoDaoImpl mongoDao = new UserMongoDaoImpl();

	private final String HOST = "192.168.100.141";
	private final String DB_NAME = "mydb";
	private MongoClient mongoClient = null;

//	private MongoTemplate mongoTemplate;

	public static UserMongoDaoImpl getInstance() {
		return mongoDao;
	}

	public UserMongoDaoImpl() {
		if (mongoClient == null) {
			MongoClientOptions.Builder build = new MongoClientOptions.Builder();
			build.connectionsPerHost(50); // 与目标数据库能够建立的最大connection数量为50
			build.threadsAllowedToBlockForConnectionMultiplier(50); // 如果当前所有的connection都在使用中，则每个connection上可以有50个线程排队等待
			build.maxWaitTime(1000 * 60 * 2);
			build.connectTimeout(1000 * 60 * 1); // 与数据库建立连接的timeout设置为1分钟
			MongoClientOptions myOptions = build.build();
			try {
				// 数据库连接实例
				mongoClient = new MongoClient(HOST, myOptions);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	@SuppressWarnings("deprecation")
	public DB getDb() {
		return mongoClient.getDB(DB_NAME);
	}

	@Override
	@SuppressWarnings("deprecation")
	public DBCollection getCollection(String collectionName) {
		return mongoClient.getDB(DB_NAME).getCollection(collectionName);
	}

	@Override
	public boolean insert(String collectionName, DBObject object) {
		DBCollection collection = this.getCollection(collectionName);
		collection.insert(object);
		return true;
	}

	@Override
	public boolean update(String collectionName, DBObject query, DBObject updateValue) {
		DBCollection collection = this.getCollection(collectionName);
		collection.update(query, updateValue);
		return true;
	}

	@Override
	public List<DBObject> find(String collectionName, Map<String, Object> map, int num) {
		List<DBObject> resultList = new ArrayList<DBObject>();

		DBCollection dbCollection = null;
		DBCursor cursor = null;
		if (map != null) {
			try {
				dbCollection = this.getCollection(collectionName);

				// 构建查询条件
				BasicDBObject queryObj = new BasicDBObject();
				Iterator<String> it = map.keySet().iterator();
				while (it.hasNext()) {
					String key = it.next();
					Object value = map.get(key);

					queryObj.put(key, value);

					System.out.println("key: " + key.toString());
					// System.out.println("value: "+value.toString());
				}

				cursor = dbCollection.find(queryObj); // 查询获取数据
				int count = 0;
				if (num != -1) { // 判断是否是返回全部数据，num=-1返回查询全部数据，num!=-1则返回指定的num数据
					while (count != num && cursor.hasNext()) {
						resultList.add(cursor.next());
						count++;
					}
				} else {
					while (cursor.hasNext()) {
						resultList.add(cursor.next());
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (null != cursor) {
					cursor.close();
				}
			}
		}

		return resultList;
	}

	@Override
	public List<DBObject> findAll(String collectionName) {
		List<DBObject> resultList = new ArrayList<DBObject>();

		DBCollection dbCollection = null;
		DBCursor cursor = null;
		try {
			dbCollection = this.getCollection(collectionName);

			cursor = dbCollection.find();
			while (cursor.hasNext()) {
				resultList.add(cursor.next());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (null != cursor) {
				cursor.close();
			}
		}

		return resultList;
	}
//	@Override
//	public List<User> findListByName(String name) {
//		Query query = new Query();
//		query.addCriteria(new Criteria("name").is(name));
//		return this.mongoTemplate.find(query, User.class);
//	}
}
