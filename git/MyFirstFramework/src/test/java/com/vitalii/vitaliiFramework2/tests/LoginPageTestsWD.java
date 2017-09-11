package com.vitalii.vitaliiFramework2.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.vitalii.vitaliiFramework2.helpers.Helper;
import com.vitalii.vitaliiFramework2.helpers.RetryAnalyzer;
import com.vitalii.vitaliiFramework2.pages.DashboardPage;
import com.vitalii.vitaliiFramework2.pages.LoginPage;

public class LoginPageTestsWD extends Base {
	
	@Test
	@Parameters({"userEmailAddress", "userPassword"})
	public void verifyPublishedFormLabelTextIsDisplayed(String userEmailAddress, String userPassword){
		LoginPage page = new LoginPage();
		page.doSuccessfulLogin(userEmailAddress, userPassword).
		goToActivitiesPage().
		goToSignUpFormsPage().
		clickCreateSignupFormButton().
		specifySignUpFormName(Helper.getCurrentDateAndTime()).
		clickNextButtonToSelectLayoutTab();

		//TODO: implement smart waiters before assertaion
		
		try {
			Thread.sleep(7000);
			String currentUrl = getDriver().getCurrentUrl();
			System.out.println("assertions doSuccessfulLoginTest");
			Assert.assertEquals(currentUrl.contains("compose"), true,
					"Compose text is not found at " + getDriver().getCurrentUrl() + " page URL");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test (enabled=false)
	public void verifyPromoteThisViaEmailButtonIsDisplayed(){
		LoginPage page = new LoginPage();
		page.doSuccessfulLogin("ir2.0bb16be1@mailosaur.in", "qwerty").
		goToActivitiesPage().
		goToSignUpFormsPage().
		clickCreateSignupFormButton().
		specifySignUpFormName(Helper.getCurrentDateAndTime()).
		clickNextButtonToSelectLayoutTab().
		selectLayout().
		clickNextButtonToComposeTab().
		clickNextButtonToAutorespondersTab().
		clickPulblishButton(); 

		//TODO: implement smart waiters before assertaion
		
		try {
 			Thread.sleep(7000);
 			WebElement notice = getDriver().findElement(By.xpath("//*[@id='activityForm']/div[3]/div/div[1]/div[1]/div[2]/button"));
			System.out.println("assertions doSuccessfulLoginTestAndPublishSignupForm");
			Assert.assertEquals(notice.isDisplayed(), true, "Promote this via email button is not displayed at " + getDriver().getCurrentUrl() + " page");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
