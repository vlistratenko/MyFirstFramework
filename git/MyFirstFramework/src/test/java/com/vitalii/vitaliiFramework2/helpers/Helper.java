package com.vitalii.vitaliiFramework2.helpers;

import java.text.SimpleDateFormat;
import java.util.Calendar;


public class Helper {
	
	public static String getCurrentDateAndTime(){
		return new SimpleDateFormat("yyyyMMddHHmmss").format(Calendar.getInstance().getTime());
	}
}
