package com.vitalii.vitaliiFramework2.pages;

import static com.vitalii.vitaliiFramework2.driver.DriverFactory.getDriver;
import org.openqa.selenium.By;

public interface ActivityAndMessagePageTemplate {

    public  <T extends ActivityAndMessagePageTemplateImpl> void cloneForm(String formName);

    public default String getFormIdByName(String formName) {
        String formId = null;
        try {
            formId = getDriver()
                    .findElement(By.xpath("//*[contains(text(),'" + formName + "')]//ancestor::tr"))
                    .getAttribute("id");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return formId;
    }
}
