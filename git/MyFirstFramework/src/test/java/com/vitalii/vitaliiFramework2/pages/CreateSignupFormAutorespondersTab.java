package com.vitalii.vitaliiFramework2.pages;

import com.vitalii.vitaliiFramework2.elements.Button;

public class CreateSignupFormAutorespondersTab extends BasePage {
	
/*	public CreateSignupFormAutorespondersTab() {
		super("compose");
	}*/

	private final Button publishButton = new Button("Signup form publish button", "//*[@id='btnGo-autoresponders-publish']");

	public CreateSignupFormPublishedDetailsTab clickPulblishButton(){
		getWaiters().waitElementIsPresent(publishButton.getLocator());
		publishButton.click(publishButton.getLocator());
		return new CreateSignupFormPublishedDetailsTab();
	}
}
