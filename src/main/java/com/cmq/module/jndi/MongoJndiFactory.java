package com.cmq.module.jndi;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.Name;
import javax.naming.spi.ObjectFactory;

import com.mongodb.Mongo;

public class MongoJndiFactory implements ObjectFactory {

	@Override
	public Object getObjectInstance(Object obj, Name name, Context nameCtx,
			Hashtable<?, ?> environment) throws Exception {
		//if add more paramters for mongo ,look tomcat api in web.
		return new Mongo();
	}

}
