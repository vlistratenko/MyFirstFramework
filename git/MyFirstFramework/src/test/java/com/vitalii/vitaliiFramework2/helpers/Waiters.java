package com.vitalii.vitaliiFramework2.helpers;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.xml.serialize.ElementState;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.vitalii.vitaliiFramework2.driver.DriverFactory;

public class Waiters {

	//TODO: use function and predicates as conditions for fluent waits (p.101)

	private WebDriver driver;
	private Logger logger;

	public Waiters() {

		this.logger = Logger.getLogger(Waiters.class);
		try {
			this.driver = DriverFactory.getDriver();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	class ExceptionsToIgnore {
		public ArrayList<Class <? extends Throwable>> getExceptionsList(){
			ArrayList<Class <? extends Throwable>> exc = new ArrayList<Class <? extends Throwable>>();
			exc.add(NoSuchElementException.class);
			exc.add(ElementNotVisibleException.class);
			exc.add(StaleElementReferenceException.class);
			exc.add(InvalidElementStateException.class);
			return exc;
		}
	}

	//TODO: return WebElement  in order to make click then
	
	/*public WebElement waitElementToLoad(String locator) {
		logger.info("Waiting for element with locator " + locator + " to load");
		WebDriverWait wait = new WebDriverWait(driver, 15, 100);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
		return element;
	}*/

	public void waitElementIsPresent(String locator) {
		logger.debug("Waiting for element with locator " + locator + " to become present in " + driver.getCurrentUrl() + " page");
		WebDriverWait wait = new WebDriverWait(driver, 15, 100);
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
	}

	public void waitElementIsVisible(String locator) {
		logger.debug("Waiting for element with locator " + locator + " to become visible in " + driver.getCurrentUrl() + " page");
		WebDriverWait wait = new WebDriverWait(driver, 15, 100);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
	}

	public void waitElementIsClickable(String locator) {
		logger.debug("Waiting for element with locator " + locator + " to become clickable in " + driver.getCurrentUrl() + " page");
		WebDriverWait wait = new WebDriverWait(driver, 15, 100);
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
	}

	public void waitPageToOpen(String url) {
		logger.info("Waiting for page with url " + url + " to load");
		WebDriverWait wait = new WebDriverWait(driver, 15, 100);
		//wait.until(ExpectedConditions.urlContains(url));
		wait.until(ExpectedConditions.urlContains(url));
	}

	public WebElement explicitWaitUntilElementIsClickable(String locator, long timeOutInSeconds){
		//TODO: make timeOutInSeconds variable (i.e set in config file, class field, etc.)
		timeOutInSeconds = 10;
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		//WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
		return element;
	}

	public void fluentWaitIgnoringNoSuchElementExceptionAndElementNotVisibleException(final String locator){
		Waiters waiters = new Waiters();
		Waiters.ExceptionsToIgnore exceptionsToIgnore = waiters.new ExceptionsToIgnore();
		long waitingTime = 30;
		long pollingInterval = 500;
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(waitingTime, TimeUnit.SECONDS)
				.pollingEvery(pollingInterval, TimeUnit.MILLISECONDS)
				.ignoreAll(exceptionsToIgnore.getExceptionsList())
				.withMessage("Fluent wait of " + waitingTime + " seconds with " + pollingInterval +
						" milliseconds polling interval was unable to locate element with locator " + locator);
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
	}
	
/*	public void fluentWaitIgnoringNoSuchElementExceptionAndElementNotVisibleException(final String locator){
		long waitingTime = 30; 
		long pollingInterval = 500;
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(waitingTime, TimeUnit.SECONDS)
				.pollingEvery(pollingInterval, TimeUnit.MILLISECONDS)
				.ignoring(NoSuchElementException.class)
				.ignoring(ElementNotVisibleException.class)
				.withMessage("Fluent wait of " + waitingTime + " seconds with " + pollingInterval + 
						" milliseconds polling interval was unable to locate element with locator " + locator);
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
	}*/
	
/*	public WebElement fluentWaitIgnoringNoSuchElementExceptionAndElementNotVisibleException(final String locator, long waitingTime, long pollingInterval){
		waitingTime = 30; 
		pollingInterval = 500;
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(waitingTime, TimeUnit.SECONDS)
				.pollingEvery(pollingInterval, TimeUnit.MILLISECONDS)
				.ignoring(NoSuchElementException.class)
				.ignoring(ElementNotVisibleException.class)
				.withMessage("Fluent wait of " + waitingTime + " seconds with " + pollingInterval + " milliseconds polling interval was unable to locate element with locator " + locator);
		
		WebElement el = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(By.xpath(locator));
				
			}
		});
		return el;
	}*/
}
