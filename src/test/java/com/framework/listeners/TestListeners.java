package com.framework.listeners;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.framework.base.BasePage;
import com.framework.commons.WebCommons;
import com.framework.reports.Reports;

public class TestListeners extends Reports implements ITestListener  {

	public void onTestStart(ITestResult result) {
		String TestCaseName = result.getMethod().getMethodName();
		startReporting(TestCaseName);
		logger.info("Test Execution Started for the test case ==> "+TestCaseName);
	}

	public void onTestSuccess(ITestResult result) {
		String TestCaseName = result.getMethod().getMethodName();
		logger.pass("Test Execution is successfully completed and results printed for the test case ==> "+TestCaseName);
		stopReporting();
	}

	public void onTestFailure(ITestResult result) {
		String TestCaseName = result.getMethod().getMethodName();
		logger.fail("Test Execution is Failed for the test case ==> "+TestCaseName);
		logger.fail("Test Execution is Failed due to ==> "+result.getThrowable().getMessage());
		try {
			logger.addScreenCaptureFromPath(WebCommons.takeScreenshotOfWindow(new BasePage().getDriver(), TestCaseName));
		} catch (IOException e) {
			e.printStackTrace();
		}
		stopReporting();
	}

	public void onTestSkipped(ITestResult result) {
		String TestCaseName = result.getMethod().getMethodName();
		logger.warning("Test Execution is Skipped for the test case ==> "+TestCaseName);
		logger.warning("Test Execution is Skipped due to ==> "+result.getThrowable().getMessage());
		logger.warning("Take Screenshot ...........");
		stopReporting();
	}
}
