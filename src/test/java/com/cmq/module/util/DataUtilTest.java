package com.cmq.module.util;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

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
//		10,endTime:1368720000000,start:1367856000000 
//		acceptDate:{'$lte':1368720000000,'$gte':1367856000000}
		
		System.out.println(get(new Long("1368720000000")).toLocaleString());
		System.out.println(get(new Long("1367856000000")).toLocaleString());
		
		
//		System.out.println(get(new Long("1356278400000")).toLocaleString());
//		System.out.println(get(new Long("1361980800000")).toLocaleString());
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
//		String url="&nbsp;caimg��";
		String url="&nbcaimg��";
		String replaceAll = url.replaceAll("&nbsp;", "");
		System.out.println(replaceAll);
	}
	
	@Test
	public void md5() throws NoSuchAlgorithmException, UnsupportedEncodingException{
//		String pwd="111111";
//		MessageDigest md = MessageDigest.getInstance("MD5");
//	
//		BASE64Encoder encoder = new BASE64Encoder();
//		String encode = encoder.encode(md.digest("1111111".getBytes("utf-8")));//f6goKtkwR6TW/mERyTswig==
//		 System.out.println(encode);
		System.out.println(MD5Utils.md5("DIjVZpTC+zvMQW4SLBBy6w=="));
	}
	@Test
	public void md6() throws ParseException {
		Date date = new Date();
		DateFormat format=new SimpleDateFormat("yyyyMMdd");//86400000
		String format2 = format.format(date);
		Date parse = format.parse(format2);
		System.out.println(parse.getTime());
		
		long time = parse.getTime()+86400000;
		
		Date date2 = new Date(time);
		System.out.println(date2.getTime());
		System.out.println(format.format(date2));
	}
	final private List<String> townList = new CopyOnWriteArrayList<String>();
	@Test
	public void copyOnWriteArrayList() {
		this.townList.clear();
		
	}
}
