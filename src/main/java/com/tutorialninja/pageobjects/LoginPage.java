package com.tutorialninja.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	
	public LoginPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy(xpath = "//*[@id=\"input-email\"]")
	private WebElement email;
	
	@FindBy(xpath = "//*[@id=\"input-password\"]")
	private WebElement password;
	
	@FindBy(xpath = "//*[@id=\"content\"]/div/div[2]/div/form/input")
	private WebElement submit;
	
	
	
	public void enterEmail(String emailid) {
		email.sendKeys(emailid);
	}
	public void enterPassword(String passwords) {
		password.sendKeys(passwords);
	}
	public void clickSubmit() {
		submit.click();
	}
	
	
	
	
	
	
	
	
	
	

}
