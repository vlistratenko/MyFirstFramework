package com.vitalii.vitaliiFramework2.tests;

import org.testng.annotations.Listeners;

import com.vitalii.vitaliiFramework2.driver.DriverFactory;
import com.vitalii.vitaliiFramework2.listeners.RetryListener;
import com.vitalii.vitaliiFramework2.listeners.ScreenshotListener;
import com.vitalii.vitaliiFramework2.listeners.TestResultListener;

@Listeners({ScreenshotListener.class, TestResultListener.class, RetryListener.class})
public abstract class Base extends DriverFactory {
	
	
	
}