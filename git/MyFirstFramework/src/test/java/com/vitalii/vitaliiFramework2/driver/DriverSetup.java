package com.vitalii.vitaliiFramework2.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public interface DriverSetup {
	WebDriver getWebDriverObject(DesiredCapabilities desiredCapabilities);
	DesiredCapabilities getDesiredCapabilities();
}
