package com.cmq.module.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class DateUtils {

	public static String formatDateToString(Date date, String pattern) {
		if (date != null) {
			DateFormat dateFormat = new SimpleDateFormat(pattern);
			return dateFormat.format(date);
		}
		return pattern;
	}
	
	public static Date get(long times){
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
	
}
