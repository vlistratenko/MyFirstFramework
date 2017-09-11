package com.vitalii.vitaliiFramework2.elements;

import org.openqa.selenium.WebElement;

public class Button extends GenericElement {

    public Button (String name, String locator) {
        super(name, locator);
    }

    public Button (String locator) {
        super(locator);
    }


}
