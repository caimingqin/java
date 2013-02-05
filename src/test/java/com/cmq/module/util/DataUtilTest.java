package com.cmq.module.util;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.junit.Test;

public class DataUtilTest {

	@Test
	public void query() {
		String query = "{'code':'" + "141" + "'}";
		System.out.println(query);
	}

	@Test
	public void format() {
		System.out.println(DateUtils.formatDateToString(new Date(), "yyyy-MM-dd"));
	}

	@Test
	public void calendar() {
		// 1356278400000~1356364800000

		System.out.println(get(new Long("1356278400000")).toLocaleString());
		System.out.println(get(new Long("1356364800000")).toLocaleString());
	}

	public static Date get(long times) {
		Calendar dd = Calendar.getInstance();
		dd.setTimeInMillis(times);
		return dd.getTime();
	}

	@Test
	public void stringBetween() {
		Date date = new Date();
		String pattern = "yyyyMMdd";
		Date date1= new Date(new Long("1356537600000"));
		Date date2 = new Date(new Long("1356537600000"));
		String formatDateToString1 = DateUtils.formatDateToString(date1, pattern);
		String formatDateToString2 = DateUtils.formatDateToString(date2, pattern);
		String formatDateToString3 = DateUtils.formatDateToString(new Date(), pattern);
		System.out.println(formatDateToString1);
		System.out.println(formatDateToString2);
		System.out.println(formatDateToString3);
		boolean beetween = DateUtils.beetween(formatDateToString1,formatDateToString2,formatDateToString3);
		
		System.out.println(beetween);
	}
	@Test
	public void formatDateToString1() {
		String pattern = "yyyyMMdd";
		Date date1= new Date(new Long("1357430400000"));
		String formatDateToString1 = DateUtils.formatDateToString(date1, pattern);
		System.out.println(formatDateToString1);
	}
	@Test
	public void map(){
		Map<String, Object> params=new HashMap<String, Object>();
		params.put("userCode", "999");
		params.put("from", "89900");
		params.put("date", new Date());
		params.put("aaa", "");
		params.put("bbb", null);
		System.out.println(JsonParser.encode(params));
	}
	@Test
	public void hava(){
		for(int i=0;i<100;i++){
			System.out.println(i);
			System.out.println(i%2);
		}
	}
	@Test
	public void uuid(){
		System.out.println(UUID.randomUUID().toString());
	}
	
	@Test
	public void substring(){
		String url="http://ppppppp/pppp/a.png";
		System.out.println(url.substring(url.lastIndexOf("/")+1));
	}
	
	@Test
	public void replace(){
//		String url="&nbsp;caimgÇë";
		String url="&nbcaimgÇë";
		String replaceAll = url.replaceAll("&nbsp;", "");
		System.out.println(replaceAll);
	}
}
