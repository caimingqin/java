package com.cmq.module.server.mongo;

import org.junit.Test;

import com.mongodb.util.JSON;

public class MongoTest {

	@Test
	public void parse(){
//		String target="department.code:10&code:12&name:aaaa";
		String target="managementType.code:01&customer.code:2&department.code:110&acceptDate:1357660800000&requestStatus:normal";
		StringBuilder query=new StringBuilder();
		query.append("{");
		String[] arr = target.split("&");
		for(String s:arr){
			String[] keyValue = s.split(":");
			query.append(keyValue[0]).append(":").append("'").append(keyValue[1]).append("'").append(",");
		}
		String json = query.substring(0, query.lastIndexOf(",")+1)+"}";
		System.out.println(json);
		System.out.println(JSON.parse(json));;
	}
}
