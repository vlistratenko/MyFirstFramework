package com.vitalii.vitaliiFramework2.pages;

import com.vitalii.vitaliiFramework2.elements.Button;

public class ActivitiesPage extends BasePage {

	//Locators:
	private final Button signupFormsPageTabLabel = new Button("Sign-Up Forms Tab Label", "//*[@autotest-id='SUBSCRIBE'][1]");

	public SignUpFormsPage goToSignUpFormsPage(){
		getWaiters().fluentWaitIgnoringNoSuchElementExceptionAndElementNotVisibleException(signupFormsPageTabLabel.getLocator());
		//signupFormsPageTabLabel.click(signupFormsPageTabLabel.getLocator());
		signupFormsPageTabLabel.click();
		return new SignUpFormsPage();
	}
}
