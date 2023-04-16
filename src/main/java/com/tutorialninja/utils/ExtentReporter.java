package com.tutorialninja.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporter {

	
	public static ExtentReports generateExtentReports() {
		
		ExtentReports er = new ExtentReports();
		File extentreportfile = new File(System.getProperty("user.dir")+ "\\test-output\\ExtentReports\\ExtentReports.html");
		ExtentSparkReporter spark = new ExtentSparkReporter(extentreportfile);
		spark.config().setTheme(Theme.DARK);
		spark.config().setReportName("Test Automation Result");
		spark.config().setDocumentTitle("TN Automation Result");
		spark.config().setTimeStampFormat("dd/mm/yyyy hh:mm:ss");
		
		er.attachReporter(spark);
		
		Properties configProp = new Properties();
		File f = new File("EcommerceProject\\src\\main\\java\\com\\tutorialninja\\config\\config.properties");
		try {
			FileInputStream fis = new FileInputStream(f);
			configProp.load(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		er.setSystemInfo("Application URL", configProp.getProperty("url") );
		er.setSystemInfo("Browsername",configProp.getProperty("browser") );
		er.setSystemInfo("Operating System: ",System.getProperty("os.name") );
		er.setSystemInfo("Script Executed by",System.getProperty("user.name") );
		er.setSystemInfo("Java Version",System.getProperty("java.version") );
		
		return er;
		
	}
}
