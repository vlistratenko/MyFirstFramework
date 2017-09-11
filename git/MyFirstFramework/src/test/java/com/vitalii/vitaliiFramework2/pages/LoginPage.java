package com.vitalii.vitaliiFramework2.pages;

import com.vitalii.vitaliiFramework2.helpers.Configurations;
import com.vitalii.vitaliiFramework2.elements.*;

public class LoginPage extends BasePage {
	
	//Locators
	private final Button loginButton = new Button("Login button", "//button");
	private final TextField emailTextField = new TextField("Email text field", "//*[@id='email']");
	private final TextField passwordTextField = new TextField("Password text field", "//*[@id='password']");
	
	public LoginPage openLoginPage(){
		open(Configurations.getEnvironmentUrl());
		return this;
	}	
	
	public DashboardPage doSuccessfulLogin(String emailAddress, String password){
		openLoginPage();
		if (!isLoggedIn()) {
			passwordTextField.removeAtributeWithJs(passwordTextField.getLocator(), "readonly");
			emailTextField.typeText(emailAddress);
			passwordTextField.typeText(password);
			loginButton.click();
		return new DashboardPage();}	
		return new DashboardPage();
	}

	
	public LoginPage doFailedLogin(String emailAddress, String password){
		openLoginPage();
		/*type(emailTextField, emailAddress);
		type(passwordTextField, password);
		click(loginButton);*/
		return this;
	}
}
