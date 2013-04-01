package com.cmq.module.jndi;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.Mongo;

public class MongoLisentener implements ServletContextListener {

	private Log logger = LogFactory.getLog(this.getClass().getName());

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		logger.info("MongoLisentener================>>>>>");
		Context context = null;
		try {
			context = new InitialContext();
			Mongo mongo = (Mongo) context.lookup("java:comp/env/db/mongo");
			logger.info(" mongo====>>>>>>>>>>>>>>>" + mongo);
			DB db = mongo.getDB("dmsdb");
			DBCollection collection = db.getCollection("test");
			DBCursor find = collection.find();
			System.out.println("find.toArray()=======>>>>"+find.toArray());
		} catch (NamingException e) {
			logger.info("NamingException================>>>>>" + e.getMessage());
		} finally {
			if (context != null) {
				try {
					context.close();
				} catch (NamingException e) {
					logger.info("context.close================>>>>>" + e.getMessage());
				}
			}

		}
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub

	}

}
