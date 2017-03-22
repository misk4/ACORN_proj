package com.service;

import java.util.Calendar;

public class CalendarService {
	
	
	public static String getyymmdd(){
		
		Calendar cal = Calendar.getInstance();
		
		int year = cal.get(cal.YEAR);
		int month = cal.get(cal.MONTH)+1;
		int date = cal.get(cal.DATE);
		
		String yymmdd = String.valueOf(year).substring(2, 4)+"/"+String.format("%02d",month)+"/"+date;
		
		
		return yymmdd;
	}
	public static String gethhmmss(){
		
		
Calendar cal = Calendar.getInstance();
		
		int hour = cal.get(cal.HOUR_OF_DAY);
		int min = cal.get(cal.MINUTE)+1;
		String min2 = String.format("%02d", min);
		int sec = cal.get(cal.SECOND);
		
		
		String hhmmss = String.valueOf(hour)+":"+min2+":"+sec;
		
		
		return hhmmss;

	}
	
}
