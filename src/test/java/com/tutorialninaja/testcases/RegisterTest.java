package com.tutorialninaja.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialninja.pageobjects.HomePage;
import com.tutorialninja.pageobjects.RegisterPage;
import com.tutorialninja.utils.Utils;
import com.tutorialsninja.base.Base;

public class RegisterTest extends Base {
	
	WebDriver driver;
	//Properties prop;
	
	public RegisterTest() {
		super();
	}
	
	
	
	
	@BeforeMethod
	public void setUp()  {
        
	    driver = initializeBrowserAndLaunchApp(prop.getProperty("browser"));
	    HomePage hp = new HomePage(driver);
	    hp.clickMyAccount();
	    hp.clickRegister();
		
	}
	
	@Test
	public void RegisterOnlyMandateFields() {
		
		
		RegisterPage rg = new RegisterPage(driver);
		
		rg.enterFirstName("Ashu");
		rg.enterLastName("pandey");
		rg.enterEmailId(Utils.generateEmail());
		rg.enterMobileNum("7048387625");
		rg.enterPassword("12345");
		rg.enterConfirmPassword("12345");
		rg.clickConsent();
		rg.clickSubmit();
		
		String expected = driver.findElement(By.xpath("//div[@id='content']/h1")).getText();
		Assert.assertEquals("Your Account Has Been Created!", expected , "NoT Passed");
		
	}
	
	@Test
	public void RegisterWithAllFields() {
		RegisterPage rg = new RegisterPage(driver);
		rg.enterFirstName("Ashu");
		rg.enterLastName("pandey");
		rg.enterEmailId(Utils.generateEmail());
		rg.enterMobileNum("7048387625");
		rg.enterPassword("12345");
		rg.enterConfirmPassword("12345");
		rg.clicknewsletter();
		rg.clickConsent();
		rg.clickSubmit();
     
		String expected = driver.findElement(By.xpath("//div[@id='content']/h1")).getText();
		Assert.assertEquals("Your Account Has Been Created!", expected , "NoT Passed");
		
		
		
	}
	
	@Test
	public void RegisterWithExistingAccount() {
		
		RegisterPage rg = new RegisterPage(driver);
		rg.enterFirstName("Ashu");
		rg.enterLastName("pandey");
		rg.enterEmailId("abc@gmail.com");
		rg.enterMobileNum("7048387625");
		rg.enterPassword("12345");
		rg.enterConfirmPassword("12345");
		rg.clicknewsletter();
		rg.clickConsent();
		rg.clickSubmit();
        
        String alertmsg = driver.findElement(By.xpath("//*[@id=\"account-register\"]/div[1]")).getText();
		Assert.assertEquals("Warning: E-Mail Address is already registered!", alertmsg , "Existing Acc NoT Passed");

	}
	
	
	@Test
	public void RegisterWithEmptyData() {
		RegisterPage rg = new RegisterPage(driver);
		rg.clickSubmit();
       
        
        String warningmsg = driver.findElement(By.xpath("//*[@id=\"account-register\"]/div[1]")).getText();
		Assert.assertEquals("Warning: You must agree to the Privacy Policy!", warningmsg , "Warning Msg not dispalyed");
		
		String firstname = driver.findElement(By.xpath("//*[@id=\"account\"]/div[2]/div/div")).getText();
		Assert.assertEquals("First Name must be between 1 and 32 characters!", firstname , "firstname Msg not dispalyed");
		
		String lastname = driver.findElement(By.xpath("//*[@id=\"account\"]/div[3]/div/div")).getText();
		Assert.assertEquals("Last Name must be between 1 and 32 characters!", lastname , "lastname Msg not dispalyed");
		
		String email = driver.findElement(By.xpath("//*[@id=\"account\"]/div[4]/div/div")).getText();
		Assert.assertEquals("E-Mail Address does not appear to be valid!", email , "email Msg not dispalyed");

		
        
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
