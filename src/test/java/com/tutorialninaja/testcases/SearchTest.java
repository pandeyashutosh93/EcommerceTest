package com.tutorialninaja.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialninja.pageobjects.SearchPage;
import com.tutorialsninja.base.Base;

public class SearchTest extends Base {
	
	WebDriver driver;
	
	
	public SearchTest() {
		super();
	}
	
	

	
	@BeforeMethod
	public void setUp(){
		 driver = initializeBrowserAndLaunchApp(prop.getProperty("browser"));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	
	@Test
	public void verifySearchWithValidProduct() {
		
		SearchPage sp = new SearchPage(driver);
		sp.enterSearchBox("HP");
		sp.clickSearch();
		Assert.assertTrue(sp.getProductDisplayStatus());
	}
	
	@Test
	public void verifySearchWithInvalidProduct() {
		
		
		SearchPage sp = new SearchPage(driver);
		sp.enterSearchBox("Honda");
		sp.clickSearch(); 
		 Assert.assertTrue(sp.getAlertMessageStatus());
		
		
	}
	
	
	@Test
	public void verifySearchWithoutProduct() {
		SearchPage sp = new SearchPage(driver);
		sp.clickSearch();
		Assert.assertTrue(sp.getAlertMessageStatus());
		
	}
	
	
	
	
	
	
}
