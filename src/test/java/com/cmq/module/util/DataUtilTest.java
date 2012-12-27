package com.cmq.module.util;

import java.util.Calendar;
import java.util.Date;

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
		boolean beetween = DateUtils.beetween(DateUtils.formatDateToString(new Date(), pattern),
				DateUtils.formatDateToString(new Date(), pattern), DateUtils.formatDateToString(new Date(), pattern));
		
		System.out.println(beetween);
	}
}
