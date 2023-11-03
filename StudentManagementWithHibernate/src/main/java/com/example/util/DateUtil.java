package com.example.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
public class DateUtil {

	//for calling Date object
	public static Date getDateIndianFormat (String date_string ) {
		Date date=null;
		try {
		 
			//Instantiating the SimpleDateFormat class
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");      
			//used to convert a date string in the "dd-MM-yyyy"

			date = formatter.parse(date_string);
		} 
		catch (ParseException e) {
			// If the input string doesn't match the specified format, a ParseException may be thrown.
			e.printStackTrace();
		} 
		return date;
	}
}
