package com.vitalii.vitaliiFramework2.elements;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import com.vitalii.vitaliiFramework2.driver.DriverFactory;
import com.vitalii.vitaliiFramework2.pages.Browser;

public class GenericElement {

    private String name;
    private String locator;
    private WebDriver driver;
    private Browser browser;
    private Logger logger;

    public GenericElement(){}

    public GenericElement (String name, String locator) {
        this.name = name;
        this.locator = locator;
        this.browser = new Browser();
        this.logger = Logger.getLogger(this.getClass());
        try {
            this.driver = DriverFactory.getDriver();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public GenericElement (String locator) {
        this.locator = locator;
        this.browser = new Browser();
        this.logger = Logger.getLogger(this.getClass());
        try {
            this.driver = DriverFactory.getDriver();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public WebDriver getDriver(){
        return this.driver;
    }

    public Logger getLogger(){
        return this.logger;
    }

    protected String getName() {
        return this.name;
    }

    public String getLocator() {
        return this.locator;
    }

    protected Browser getBrowser() {
        return this.browser;
    }

    public void click(String locator){
        WebElement element = browser.findPageElementByXpath(locator);
        element.click();
        this.getLogger().info(this.getName() + " with locator " + this.getLocator() + " was clicked.");
    }

    public void click(){
        WebElement element = browser.findPageElementByXpath(this.getLocator());
        element.click();
        this.getLogger().info(this.getName() + " with locator " + this.getLocator() + " was clicked.");
    }

    public void clickJs(String locator){
        //waiters.fluentWaitIgnoringNoSuchElementExceptionAndElementNotVisibleException(locator, 15, 500);
        WebElement el = browser.findPageElementByXpath(locator);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", el);
        this.getLogger().info(this.getName() + " with locator " + locator + " was clicked.");
    }

    public void removeAtributeWithJs(String locator, String attribute) {
        this.getLogger().debug("Removing attribute " + attribute + " in " + getDriver().getCurrentUrl() + " page");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(("arguments[0].removeAttribute('" + attribute + "')"), browser.findPageElementByXpath(locator));
    }

    protected void clickJs(WebElement el){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", el);
    }

    protected void doubleClick(String locator){
        //waiters.waitElementIsVisible(locator);
        Actions action = new Actions(driver);
        action.doubleClick(browser.findPageElementByXpath(locator)).perform();
    }

}
