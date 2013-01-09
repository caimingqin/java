package com.cmq.module;

import java.util.Calendar;

import org.junit.Test;

import com.cmq.module.enmu.WeekDay;


public class WeekDayTest{

	@Test
	public void test(){
		
		System.out.println(WeekDay.Mon);
		System.out.println(WeekDay.Mon.getDay());
		
	}
	
	@Test
	public void week(){
		System.out.println(Calendar.getInstance().get(Calendar.WEEK_OF_YEAR));
	}
	
}