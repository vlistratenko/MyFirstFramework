package com.vitalii.vitaliiFramework2.elements;


import org.openqa.selenium.WebElement;

public class TextField extends GenericElement {

    public TextField(String name, String locator) {
        super(name, locator);
    }

    public void typeText(String text){
        WebElement el = this.getBrowser().findPageElementByXpath(this.getLocator());
        this.getLogger().info("Typing " + text + " into " + this.getName());
        super.click(this.getLocator());
        el.clear();
        el.sendKeys(text);
    }
}
