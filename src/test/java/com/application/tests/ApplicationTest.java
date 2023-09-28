package com.application.tests;

import org.testng.annotations.Test;

import com.framework.base.BaseTest;

public class ApplicationTest extends BaseTest{	
	
	@Test(priority=1)
	public void verifyWhetherApplicationIsLaunched() {
		loginPage.launchApplication();
	}
	
	@Test(priority=2)
	public void verifyLogoAndCaption() {
		loginPage.launchApplication();
		loginPage.verifyLogoAndCaption();
	}
	
	@Test(priority=3)
	public void verifyLoginPageHeader() {
		loginPage.launchApplication();
		loginPage.verifyLoginHeader();
	}
	
	@Test(priority=4,dataProvider="data")
	public void verifyRegistrationFeature(String username,String password) {
		loginPage.launchApplication();
		loginPage.clickOnRegistrationLink();
		regPage.verifyRegistrationPageIsLaunched();
		regPage.updateRegistrationDetails(username, password);
		regPage.clickOnRegisterButton();
		regPage.verifyRegistrationIsSuccessful();
	}
	
	@Test(priority=5,dataProvider="data")
	public void verifyLoginFeature(String username,String password) {
		loginPage.launchApplication();
		loginPage.enterCredentials(username, password);
		loginPage.clickOnLogInButton();
		loginPage.verifyLoginIsSuccessful();		
	}

}
