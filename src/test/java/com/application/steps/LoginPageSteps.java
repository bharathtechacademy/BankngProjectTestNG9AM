package com.application.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.application.elements.LoginPageElements;

public class LoginPageSteps extends LoginPageElements{
	
	public LoginPageSteps(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void launchApplication() {
		launchApplication(prop.getProperty("url"));
		Assert.assertEquals(getTitle(), prop.getProperty("title"));
		log("info","Application launched successfully");
	}
	
	public void verifyLogoAndCaption() {
		Assert.assertTrue(isElementDisplayed(logo));
		log("info","Application logo displayed successfully");
		Assert.assertEquals(getElementText(caption), prop.getProperty("caption"));
		log("info","Application caption displayed correctly");
	}
	
	public void verifyLoginHeader() {
		Assert.assertEquals(getElementText(loginPageHeader), prop.getProperty("header"));
		log("info","Application login page header displayed correctly");
	}
	
	public void enterCredentials(String username,String password) {
		enterInfo(usernameTxtb, username);
		enterInfo(passwordTxtb, password);
		log("info","Credentials entered are "+username+" , "+password);
	}
	
	public void clickOnLogInButton() {
		click(loginBtn);
		log("info","Clicked on Login button");
	}

	public void verifyLoginIsSuccessful() {
		waitForElement(accountOverviewPageHeader, 10);
		log("info","Account overview page is displayed");
	}
	
	public void clickOnRegistrationLink() {
		click(registrationLink);
		log("info","Clicked on Registration link");
	}

}
