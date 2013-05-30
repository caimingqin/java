package com.cmq.module.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

public class DateUtils {
     
	public static String formatDateToString(Date date, String pattern) {
		if (date != null) {
			DateFormat dateFormat = new SimpleDateFormat(pattern);
			return dateFormat.format(date);
		}
		return pattern;
	}

	public static Date formatStringToDate(String date, String pattern) {
		try {
			if (date != null) {
				DateFormat dateFormat = new SimpleDateFormat(pattern);
				return dateFormat.parse(date);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static Date get(long times) {
		Calendar dd = Calendar.getInstance();
		dd.setTimeInMillis(times);
		return dd.getTime();
	}

	public static boolean beetween(String start, String end, String middle) {
		if (middle.compareTo(start) >= 0 && middle.compareTo(end) <= 0) {
			return true;
		}
		return false;
	}

	public String getMils(String yyyyMMdd) {
              Date date = formatStringToDate(yyyyMMdd, "yyyyMMdd");
              return date.getTime()+"";
	}
	
	
	private Date parse(String source) {

		DateFormat format = new SimpleDateFormat("yyyyMMdd");
		if (source.length()==8) {
			try {
				return format.parse(source);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public static String getCurrentDay(){
		Calendar c = Calendar.getInstance();
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH)+1;
		int day = c.get(Calendar.DAY_OF_MONTH);
		System.out.println(year+","+month+","+day);
		String mon=""+month;
		if(month<10){
			mon="0"+mon;
		}
		String d=""+day;
		if(day<10){
			d="0"+day;
		}
		return year+mon+""+d;
	}
	
	@Test
	public void test(){
		double a=1361458800000.0;//
		double b=1361462400000.0;
		
		double c=b-a;
		System.out.println(c);
		System.out.println(getMils("20130222"));
		System.out.println(get(new Long("1364530657566")).toLocaleString());
		
		System.out.println(parse("20130222").getTime());
	}
	
	@Test
	public void getCurrentDayTest(){
//		System.out.println(get(new Long("1362067200000")).toLocaleString());
//		System.out.println(get(new Long("1381593600000")).toLocaleString());
//		System.out.println(get(new Long("1381420800000")).toLocaleString());
//		System.out.println(get(new Long("1381766400000")).toLocaleString());//1381766400000
//		System.out.println(get(new Long("1364486400000")).toLocaleString());
//		System.out.println(getCurrentDay());
		
		
		Calendar c=Calendar.getInstance();
		c.setTimeInMillis(new Long("1381766400000"));
		
		Date date =c.getTime();
		System.out.println(date.toLocaleString());
	}

}
