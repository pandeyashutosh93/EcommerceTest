package com.tutorialninja.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;
	
	//Page Elements
	@FindBy(xpath="//*[@id=\"top-links\"]/ul/li[2]/a/span[1]")
	private WebElement myAccDropMenu;
	
	@FindBy(xpath="//*[@id=\"top-links\"]/ul/li[2]/ul/li[2]/a")
	private WebElement login;
	
	@FindBy(linkText="Register")
	private WebElement register;
	
	
	// Constructor
	public HomePage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	//Action
	
	
	
	public void clickMyAccount() {
		myAccDropMenu.click();
	}
	
	public void clickLogin() {
		login.click();
	}
	public void clickRegister() {
		register.click();
	}
	
	
	
	
	
	
	

}
