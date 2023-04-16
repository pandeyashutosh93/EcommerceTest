package com.tutorialsninja.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {
	
	WebDriver driver;
	public Properties prop;
	public Properties dataprop;
	
	public Base() {
	    prop = new Properties();
		File file = new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\tutorialninja\\config\\config.properties");
		try {
			FileInputStream fis = new FileInputStream(file);
			prop.load(fis);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		dataprop = new Properties();
		File file1 = new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\tutorialninja\\testdata\\testdata.properties");
		try {
			FileInputStream fis1 = new FileInputStream(file1);
			dataprop.load(fis1);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
		
		
		
	}
	

	public WebDriver initializeBrowserAndLaunchApp(String browsername) {

		
		if (browsername.equals("chrome")) {
			driver = new ChromeDriver();

		}
		else if(browsername.equals("firefox")){
			driver = new FirefoxDriver();
		}
		else if(browsername.equals("edge")){
			driver = new EdgeDriver();
		}
		
	   
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.get(prop.getProperty("url"));
		
		return driver;
	}
	
	
	
	
	
	

}
