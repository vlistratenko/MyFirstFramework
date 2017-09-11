package com.vitalii.vitaliiFramework2.pages;

import com.vitalii.vitaliiFramework2.elements.Button;

public class CreateSignUpFormSelectLayoutTab extends BasePage {

	private final Button heroSideBarLayout = new Button("Hero Side Bar Layout icon", "//*[@id='activityForm']/div[3]/div/div[1]/div/div[1]/div[1]/div[1]/div[4]/div[2]/div/img");
	private final Button nextButton = new Button("Signup form Select layoyt Tab Next button", "//*[@id='btnCompose']");

	public CreateSignUpFormSelectLayoutTab selectLayout(){
		getWaiters().waitElementIsPresent(heroSideBarLayout.getLocator());
		heroSideBarLayout.click(heroSideBarLayout.getLocator());
		return this;

	}

	public CreateSignupFormComposeTab clickNextButtonToComposeTab(){
		getWaiters().waitElementIsPresent(nextButton.getLocator());
		getWaiters().waitElementIsVisible(nextButton.getLocator());
		nextButton.click(nextButton.getLocator());
		return new CreateSignupFormComposeTab();

	}

}
