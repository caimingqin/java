package com.cmq.module;

import org.junit.Test;

import com.cmq.module.http.AppContext;

public class AppContextTest {

	@Test
	public void test() {
//		{"commandName":"mongoCommand","contents":"{\"colName\":\"SurveyRequest\",\"query\":\"{'code':140}\",\"fields\":\"{'_id':'0'}\"}"}
//		String query = "{'commandName':'mongoCommand','contents':'{\"colName\":\"SurveyRequest\",\"query\":\"{'code':140}\",\"fields\":\"{'_id':'0'}\"}'}";
//		String query = "{\"commandName\":\"mongoCommand\",\"contents\":\"{\"colName\":\"SurveyRequest\",\"query\":\"{'code':140}\",\"fields\":\"{'_id':'0'}\"}\"}";
		String query = "{\"commandName\":\"mongoCommand\",\"contents\":{\"colName\":\"SurveyRequest\",\"query\":\"{'code':140}\",\"fields\":\"{'_id':'0'}\"}}";
		AppContext.command(query);
	}
}
