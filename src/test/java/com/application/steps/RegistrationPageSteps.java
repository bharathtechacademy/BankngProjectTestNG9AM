package com.application.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.application.elements.RegistrationPageElements;

public class RegistrationPageSteps extends RegistrationPageElements{
	
	public RegistrationPageSteps(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void verifyRegistrationPageIsLaunched() {
		waitForElement(registrationPageHeader, 10);
		log("info","Registration page is launched");
	}	
	
	public void updateRegistrationDetails(String user,String pass) {
		enterInfo(firstName, "Bharath");
		enterInfo(lastName, "Reddy");
		enterInfo(address, "HitechCity");
		enterInfo(city, "Hyd");
		enterInfo(state, "TS");
		enterInfo(zipCode, "600081");
		enterInfo(phoneNumber, "9553220022");
		enterInfo(ssn, "123456789");
		enterInfo(username, user);
		enterInfo(password, pass);
		enterInfo(confirmPassword, pass);
	}
	
	public void clickOnRegisterButton() {
		click(registerButton);
		log("info","Clicked on Register button");
	}

	public void verifyRegistrationIsSuccessful() {
		waitForElement(registrationSuccess, 10);
		log("info","Registration is successful");
	}
	

}
