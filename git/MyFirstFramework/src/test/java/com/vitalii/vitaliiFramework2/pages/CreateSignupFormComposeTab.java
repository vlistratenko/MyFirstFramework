package com.vitalii.vitaliiFramework2.pages;

import com.vitalii.vitaliiFramework2.elements.Button;

public class CreateSignupFormComposeTab extends BasePage {

	private final Button nextButton = new Button("Next button in Signup form Compose tab", "//*[@id='btnGo-compose-autoresponders']");
	
	public CreateSignupFormAutorespondersTab clickNextButtonToAutorespondersTab(){
		getWaiters().waitElementIsVisible(nextButton.getLocator());
		getWaiters().waitElementIsPresent(nextButton.getLocator());
		nextButton.click(nextButton.getLocator());
		return new CreateSignupFormAutorespondersTab();
	}
	


}
