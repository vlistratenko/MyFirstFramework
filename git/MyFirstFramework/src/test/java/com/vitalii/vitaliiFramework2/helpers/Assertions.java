package com.vitalii.vitaliiFramework2.helpers;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.vitalii.vitaliiFramework2.driver.DriverFactory;

public class Assertions {
	
	WebDriver driver;
	private Logger logger;
		
	public Assertions() {
		
		this.logger = Logger.getLogger(Assertions.class);
		try {
			this.driver = DriverFactory.getDriver();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
