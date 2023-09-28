package com.framework.commons;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.framework.base.BasePage;
import com.framework.reports.Reports;
import com.framework.utilities.ReadProp;

public class WebCommons {

	// Will have all the common methods to perform different actions on web application

	public WebDriver driver = new BasePage().getDriver();
	public Properties prop = ReadProp.readData(System.getProperty("user.dir")+"\\Config\\Config.properties");

	// method to launch the application
	public void launchApplication(String url) {
		driver.get(url);
	}

	// method to scroll to element
	public void scrollToElement(WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView()", element);
	}

	// method to click on element
	public void click(WebElement element) {
		scrollToElement(element);
		element.click();
	}

	// method to type text into text element
	public void enterInfo(WebElement element, String value) {
		scrollToElement(element);
		element.clear();
		element.sendKeys(value);
	}

	// method to select the checkbox
	public void selectCheckbox(WebElement element) {
		scrollToElement(element);
		if (!element.isSelected())
			element.click();
	}

	// method to select the checkbox
	public void selectOption(WebElement element, String method, String option) {
		Select s = new Select(element);
		if (method.equalsIgnoreCase("visibleText"))
			s.selectByVisibleText(option);
		else if (method.equalsIgnoreCase("value"))
			s.selectByValue(option);
		else if (method.equalsIgnoreCase("Index"))
			s.selectByIndex(Integer.parseInt(option));
	}

	// method to wait (java wait)
	public void wait(int sec) {
		try {
			Thread.sleep(sec * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// implicit wait
	public void implicitWait(int sec) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(sec));
	}

	// explicit wait
	public void waitForElement(By locator, int sec) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(sec));
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(locator, 0));
	}

	// take screenshot of element and get the screenshot path
	public static String takeScreenshotOfElement(WebElement element, String name) throws IOException {
		String filePath = System.getProperty("user.dir") + "\\Sceenshots\\" + name + ".png";
		File scrFile = element.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File(filePath));
		return filePath;
	}

	// take screenshot of window and get the screenshot path
	public static String takeScreenshotOfWindow(WebDriver driver, String name) throws IOException {
		String filePath = System.getProperty("user.dir") + "\\Sceenshots\\" + name + ".png";
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File(filePath));
		return filePath;
	}

	// get element text
	public String getElementText(WebElement element) {
		return element.getText();
	}

	// get title of the window
	public String getTitle() {
		return driver.getTitle();
	}
	
	//to print message in the report
	public void log(String status, String message) {
		if (status.equalsIgnoreCase("info"))
			Reports.logger.info(message);
		else if (status.equalsIgnoreCase("pass"))
			Reports.logger.pass(message);
		else if (status.equalsIgnoreCase("fail"))
			Reports.logger.fail(message);
		else if (status.equalsIgnoreCase("warning"))
			Reports.logger.warning(message);
	}
	
	// check element is displayed 
	public boolean isElementDisplayed(WebElement element) {
		return element.isDisplayed();
	}
	
	
}
