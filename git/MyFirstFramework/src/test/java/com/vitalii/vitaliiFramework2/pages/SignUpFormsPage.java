package com.vitalii.vitaliiFramework2.pages;

import com.vitalii.vitaliiFramework2.elements.Button;

public class SignUpFormsPage extends ActivityAndMessagePageTemplateImpl {

	//Locators:
	private final Button createNewSignUpFormButton = new Button("Create new signup form button", "//*[@autotest-id='btn_create_subscribe_form_forms_dashboard']");

	public CreateSignUpFormBasicsTab clickCreateSignupFormButton(){
		getWaiters().waitElementIsPresent(createNewSignUpFormButton.getLocator());
		createNewSignUpFormButton.click(createNewSignUpFormButton.getLocator());
		return new CreateSignUpFormBasicsTab();
	}

}
