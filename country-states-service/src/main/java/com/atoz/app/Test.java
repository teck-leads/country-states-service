package com.atoz.app;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

public class Test {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		//Timestamp timestamp = new Timestamp(new Date());
		Calendar c=null;
		c=Calendar.getInstance();
		//get current hout of the day
		int hour = c.get(Calendar.HOUR_OF_DAY);
		Date time = c.getTime();
		
		System.out.println(time);
		
//		if(hour<12) {
//			return "Good morning";
//		}else if(hour<16)
		
	
	//	System.out.println(date);

	}

}
