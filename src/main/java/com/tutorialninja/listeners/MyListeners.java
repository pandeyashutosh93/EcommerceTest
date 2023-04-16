package com.tutorialninja.listeners;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.tutorialninja.utils.ExtentReporter;
import com.tutorialninja.utils.Utils;

public class MyListeners implements ITestListener{
	ExtentReports extentreport;
	ExtentTest et;
	@Override
	public void onStart(ITestContext context) {
		extentreport = ExtentReporter.generateExtentReports();
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String testname =result.getName();
		
		WebDriver driver = null;
	try {	
	driver =	(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	
	String destpath = Utils.captureSS(driver , result.getName());
	
	
	et.addScreenCaptureFromPath(destpath);
	et.log(Status.INFO, result.getThrowable());
	et.log(Status.FAIL, testname + "got failed");
		
	}

	@Override
	public void onTestStart(ITestResult result) {
		String testname =result.getName();
		et = extentreport.createTest(testname);
		et.log(Status.INFO, testname+ "Start Executing");
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		String testname =result.getName();
		et.log(Status.PASS, testname + "got successfully Executed");
 		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		et.log(Status.INFO, result.getThrowable());
		et.log(Status.SKIP, result.getName() + "got skipped");
		
	}
	

	@Override
	public void onFinish(ITestContext context) {
		extentreport.flush();
	}
	

}
