package com.vitalii.vitaliiFramework2.driver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.vitalii.vitaliiFramework2.pages.Browser;
import com.vitalii.vitaliiFramework2.pages.LoginPage;

public class DriverFactory {
	private static List<WebDriverThread> webDriverThreadPool = Collections.synchronizedList(new ArrayList<WebDriverThread>());
	private static ThreadLocal<WebDriverThread> driverThread;
//test
	@BeforeSuite
	public void beforeSuite(){
		instantiateDriverObject();
	}
	
	public static void instantiateDriverObject() {
		driverThread = new ThreadLocal<WebDriverThread>() {
			@Override
			protected WebDriverThread initialValue() {
				WebDriverThread webDriverThread = new WebDriverThread();
				webDriverThreadPool.add(webDriverThread);
				//Configurations conf = new Configurations();
				return webDriverThread;
			}
		};
	}
	
/*	@BeforeSuite
	public static void instantiateDriverObject() {
		driverThread = new ThreadLocal<WebDriverThread>() {
			@Override
			protected WebDriverThread initialValue() {
				WebDriverThread webDriverThread = new WebDriverThread();
				webDriverThreadPool.add(webDriverThread);
				//Configurations conf = new Configurations();
				return webDriverThread;
			}
		};
	}*/

	public static WebDriver getDriver() throws Exception {
		return driverThread.get().getDriver();
	}
	
	@BeforeMethod
	public void beforeTest(){
	}

	@AfterMethod
	public static void clearCookies() throws Exception {
		getDriver().manage().deleteAllCookies();
	}

	/*@AfterSuite
	public static void closeDriverObjects() {
		for (WebDriverThread webDriverThread : webDriverThreadPool) {
			webDriverThread.quitDriver();
		}
	}*/
}
