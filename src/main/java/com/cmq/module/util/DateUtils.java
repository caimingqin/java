package com.cmq.module.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

import sun.security.action.GetLongAction;

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
	
	@Test
	public void test(){
		double a=1361458800000.0;//
		double b=1361462400000.0;
		
		double c=b-a;
		System.out.println(c);
		System.out.println(getMils("20130222"));
		System.out.println(get(new Long("1361462400000")).toLocaleString());
		
		System.out.println(parse("20130222").getTime());
	}

}
