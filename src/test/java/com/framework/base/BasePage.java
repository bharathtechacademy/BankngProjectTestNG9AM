package com.framework.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.framework.reports.Reports;

public class BasePage extends Reports {

	// will have common methods to launch the browser and close browser
	private static WebDriver driver = null;

	// method to launch browser
	@BeforeMethod(alwaysRun = true)
	@Parameters(value = "browser")
	public void setupBrowser(String browser) {
		if (browser.equalsIgnoreCase("Chrome"))
			driver = new ChromeDriver();
		else if (browser.equalsIgnoreCase("Firefox"))
			driver = new FirefoxDriver();
		else if (browser.equalsIgnoreCase("Edge"))
			driver = new EdgeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
	}

	// method to close browser
	@AfterMethod(alwaysRun = true)
	public void tearDownBrowser() {
		driver.quit();
	}

	// method to share driver
	public WebDriver getDriver() {
		return driver;
	}

}
