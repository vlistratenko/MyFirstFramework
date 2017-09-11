package com.vitalii.vitaliiFramework2.pages;

import com.vitalii.vitaliiFramework2.elements.GenericElement;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import com.vitalii.vitaliiFramework2.driver.DriverFactory;
import com.vitalii.vitaliiFramework2.helpers.Waiters;

public class Browser {
	
	private WebDriver driver;
	private Logger logger;
	private Waiters waiters;
	private GenericElement genericElement;
	
	public Browser (){
		try {
			this.driver = DriverFactory.getDriver();
			//driver = WebDriverWrapper.getWebDriverTest();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.logger = Logger.getLogger(Browser.class);
		this.waiters = new Waiters();
		this.genericElement = new GenericElement();
	}

	public Waiters getWaiters(){
		return this.waiters;
	}

	public GenericElement getGenericElement(){
		return this.genericElement;
	}

	public WebDriver getDriver(){
		return this.driver;
	}
	
	public boolean isLoggedIn(){
		String url = driver.getCurrentUrl();
		if(url.contains("login")) return false; return true;
		/*boolean a = !driver.getCurrentUrl().contains("login") ? true : false; 
		return a;*/
	}

	protected void open(String url) {
		logger.info("Opening " + url);
		this.driver.navigate().to(url);
	}

	public WebElement findPageElementByXpath (String locator){
		logger.info("Locating element with the following locator: " + locator);
		WebElement el = null;
		try {
			el = this.driver.findElement(By.xpath(locator));
		} catch (NoSuchElementException e) {
			logger.error("Element with locator " + locator + " was not found at " + driver.getCurrentUrl() + " page", e);
		}
		return el;
	}
}
