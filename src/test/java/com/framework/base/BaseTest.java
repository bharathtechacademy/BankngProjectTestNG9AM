package com.framework.base;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import com.application.steps.LoginPageSteps;
import com.application.steps.RegistrationPageSteps;
import com.framework.utilities.ReadExcel;

public class BaseTest extends BasePage{
	
	public LoginPageSteps loginPage = null;
	public RegistrationPageSteps regPage = null;
	
	
	@BeforeMethod(alwaysRun=true,dependsOnMethods="setupBrowser")
	public void initiateAllClassesWithValidDriver() {
		WebDriver driver = new BasePage().getDriver();
		loginPage= new LoginPageSteps(driver);
		regPage=new RegistrationPageSteps(driver);
	}
	
	
	@DataProvider(name="data")
	public String [][] testData(Method method){
		String [][] data = ReadExcel.readData("TestData.xlsx", method.getName());
		return data;
	}
		
}
