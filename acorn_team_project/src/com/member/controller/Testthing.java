package com.member.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import com.service.CalendarService;

public class Testthing {

	public static void main(String[] args) {
		
		CalendarService service = new CalendarService();
		
		System.out.println(service.getyymmdd().substring(3,5));
		
			
			
			

	}

}
