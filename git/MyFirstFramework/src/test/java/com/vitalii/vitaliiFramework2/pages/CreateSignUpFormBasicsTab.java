package com.vitalii.vitaliiFramework2.pages;

import com.vitalii.vitaliiFramework2.elements.Button;
import com.vitalii.vitaliiFramework2.elements.TextField;

public class CreateSignUpFormBasicsTab extends BasePage {
	
private final TextField signUpFormName = new TextField("Signup form name text field", "//*[@id='activityForm']/div[3]/div/div[2]/div/validation-message/div/span/input");
	private final TextField signUpFormDescription = new TextField("Signup form description text field", "//*[@id='activityForm']/div[3]/div/div[3]/div/validation-message/div/span/textarea");
	private final Button nextButton = new Button("The basics tab Next button", "//*[@id='btnGo-setup-compose']");

	public CreateSignUpFormBasicsTab specifySignUpFormName (String name){
		getWaiters().waitElementIsClickable(signUpFormName.getLocator());
		signUpFormName.typeText(name);
		return this;
	}

	public CreateSignUpFormSelectLayoutTab clickNextButtonToSelectLayoutTab(){
		getWaiters().waitElementIsPresent(nextButton.getLocator());
		nextButton.click(nextButton.getLocator());
		return new CreateSignUpFormSelectLayoutTab();
	}
}
