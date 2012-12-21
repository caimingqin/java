package com.cmq.module;

public enum WeekDay {
	Mon("01"), Tue("02"), Wed("03"), Thu("04"), Fri("05"), Sat("06"), Sun("07");

	private  String day;

	private WeekDay(String day) {
		this.day = day;
	}

	public String getDay() {
		return day;
	}

}