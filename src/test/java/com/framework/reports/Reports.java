package com.framework.reports;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Reports {
	//will have common methods to generate reports using extent reports
	
	public static ExtentHtmlReporter html= null; //empty html report (white paper)
	public static ExtentReports extent= null; // to set configurations and pass instruction (printer)
	public static ExtentTest logger= null; //to print colorful messages in the report (ink)
	
	@BeforeSuite(alwaysRun=true)
	public static void setupReport() {
		html = new ExtentHtmlReporter(System.getProperty("user.dir")+"\\Reports\\AutomationTestReport.html");//creating white paper
		extent = new ExtentReports();
		extent.attachReporter(html); //inserting into printer
	}
	
	public static void startReporting(String testcase) {
		logger = extent.createTest(testcase); //fill up ink and start printing process
	}
	
	@AfterSuite(alwaysRun=true)
	public static void stopReporting() {
		extent.flush(); //stop printing for testcase
	}
}
