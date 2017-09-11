package com.vitalii.vitaliiFramework2.pages;

import com.vitalii.vitaliiFramework2.elements.Button;

public class DashboardPage extends ActivityAndMessagePageTemplateImpl {

    //Locators:
    Button activitiesPage = new Button("Activities label","//a[@href='/#/activities']//span");

    public ActivitiesPage goToActivitiesPage(){
        getWaiters().fluentWaitIgnoringNoSuchElementExceptionAndElementNotVisibleException(activitiesPage.getLocator());
        //waiters.waitElementIsPresent(activitiesPage);
        activitiesPage.clickJs(activitiesPage.getLocator());
        return new ActivitiesPage();
    }
}


