package com.vitalii.vitaliiFramework2.driver;

import java.net.MalformedURLException;

import com.vitalii.vitaliiFramework2.driver.DriverType;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import static com.vitalii.vitaliiFramework2.driver.DriverType.FIREFOX;
import static com.vitalii.vitaliiFramework2.driver.DriverType.valueOf;
import org.apache.log4j.Logger;

public class WebDriverThread {
	private WebDriver webdriver;
	private DriverType selectedDriverType;
	private final DriverType defaultDriverType = FIREFOX;
	private final String browser = System.getProperty("browser").toUpperCase();
	//private final String browser = "FIREFOX";
	// TODO: write method for the case when test us ran thru UI and system properties can't be reached 
	//private final String operatingSystem = System.getProperty("os.name").toUpperCase();
	//private final String systemArchitecture = System.getProperty("os.arch");
	private Logger logger = Logger.getLogger(WebDriverThread.class);
		
	public WebDriver getDriver() throws Exception {
		logger.debug("! ========== Getting Driver instance ============= !");
		if (null == webdriver) {
			logger.info("! ========== New Driver instance is created ============= !");
			selectedDriverType = determineEffectiveDriverType();
			DesiredCapabilities desiredCapabilities = selectedDriverType
					.getDesiredCapabilities();
			instantiateWebDriver(desiredCapabilities);
		} logger.debug("Existing driver instance is used");
		return webdriver;
	}

	public void quitDriver() {
		if (null != webdriver) {
			webdriver.quit();
		}
	}

	private DriverType determineEffectiveDriverType() {
		DriverType driverType = defaultDriverType;
		try {
			driverType = valueOf(browser);
		} catch (IllegalArgumentException ignored) {
			System.err.println("Unknown driver specified, defaulting to '"
					+ driverType + "'...");
		} catch (NullPointerException ignored) {
			System.err.println("No driver specified, defaulting to '"
					+ driverType + "'...");
		}
		return driverType;
	}

	private void instantiateWebDriver(DesiredCapabilities desiredCapabilities)
			throws MalformedURLException {
		System.out.println(" ");
		//System.out.println("Current Operating System: " + operatingSystem);
		//System.out.println("Current Architecture: " + systemArchitecture);
		System.out.println("Current Browser Selection: " + selectedDriverType);
		System.out.println(" ");
		webdriver = selectedDriverType.getWebDriverObject(desiredCapabilities);
	}
}
