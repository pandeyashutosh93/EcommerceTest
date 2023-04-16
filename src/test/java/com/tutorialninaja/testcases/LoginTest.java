package com.tutorialninaja.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tutorialninja.pageobjects.AccountPage;
import com.tutorialninja.pageobjects.HomePage;
import com.tutorialninja.pageobjects.LoginPage;
import com.tutorialninja.utils.Utils;
import com.tutorialsninja.base.Base;



public class LoginTest extends Base {

	
	public LoginTest() {
		super();
	}
	
	
	
	
	
	WebDriver driver;
	LoginPage lp;
	
	@BeforeMethod
	public void setUp() {
		
		driver = initializeBrowserAndLaunchApp(prop.getProperty("browser"));
		HomePage pg = new HomePage(driver);
		pg.clickMyAccount();
		pg.clickLogin();
	}
	
	
	@DataProvider
	public Object[][] DataSupplier() {
		Object[][] dt  = Utils.getTestData("Login");
		return dt;
	}
	
	
	
	
	
	@Test (priority=1, dataProvider = "DataSupplier")
	public void   VerifyLoginWithValidCredentials(String un, String pw) {
		
	    lp = new LoginPage(driver);
		lp.enterEmail(un);
		lp.enterPassword(pw);
		lp.clickSubmit();
		
		AccountPage ap = new AccountPage(driver);
Assert.assertTrue(ap.getDisplayStatusOfEditYourAccInfo());


			
	}
	@Test (priority=2)
	public void LoginWithInvalidCred() {
		
		lp = new LoginPage(driver);
	    lp.enterEmail(Utils.generateEmail());
	    lp.enterPassword(dataprop.getProperty("invalidpassword"));
	    lp.clickSubmit();
		
		Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"account-login\"]/div[1]")).isDisplayed());

	
		
	
	}
	
	
	@Test (priority=3)
	public void LoginWithInvalidEmail() {
		
		lp = new LoginPage(driver);
		lp.enterEmail(Utils.generateEmail());
	    lp.enterPassword("ashu@1993");
	    lp.clickSubmit();
		
		Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"account-login\"]/div[1]")).isDisplayed());
		
		
		
	}
	
	@Test(priority=4)
	public void LoginWithInvalidPassword() {
		
		 
		lp = new LoginPage(driver);
		lp.enterEmail(Utils.generateEmail());
	    lp.enterPassword(dataprop.getProperty("invalidpassword"));
	    lp.clickSubmit();
		
		Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"account-login\"]/div[1]")).isDisplayed());
		
		
		
	}
	
	
	@Test(priority=5)
	public void LoginWithoutCred() {
		
		
		lp = new LoginPage(driver);
		lp.enterEmail("");
	    lp.enterPassword("");
	    lp.clickSubmit();
		
		Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"account-login\"]/div[1]")).isDisplayed());
		
		
		
	}
	
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
