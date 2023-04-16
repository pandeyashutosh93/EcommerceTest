 package com.tutorialninja.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	
	
	WebDriver driver;
	
	
	public RegisterPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
		
	}
	
	
	@FindBy(id="input-firstname")
	private WebElement firstname;
	
	@FindBy(xpath="//*[@id=\"input-lastname\"]")
	private WebElement lastname;
	
	@FindBy(xpath="//*[@id=\"input-email\"]")
	private WebElement emailid;
	
	@FindBy(xpath="//*[@id=\"input-telephone\"]")
	private WebElement mobileno;
	
	@FindBy(xpath="//*[@id=\"input-password\"]")
	private WebElement password;
	
	@FindBy(xpath= "//*[@id=\"input-confirm\"]")
	private WebElement confirmpassword;
	
	@FindBy(xpath="//*[@id=\"content\"]/form/fieldset[3]/div/div/label[1]/input")
	private WebElement newsletter;
	
	@FindBy(xpath="//*[@id=\"content\"]/form/div/div/input[1]")
	private WebElement consent;
	
	@FindBy(xpath="//*[@id=\"content\"]/form/div/div/input[2]")
	private WebElement submit;
	
	@FindBy(xpath="//*[@id=\"top-links\"]/ul/li[2]/a/span[1]")
	private WebElement myAccDropMenu;
	
	
	
	public void enterFirstName(String fname) {
		firstname.sendKeys(fname);
	}
	public void enterLastName(String lname) {
		lastname.sendKeys(lname);
	}
	public void enterEmailId(String email) {
		emailid.sendKeys(email);
	}
	public void enterMobileNum(String num) {
		mobileno.sendKeys(num);
	}
	
	
	
	public void enterPassword(String pw) {
		password.sendKeys(pw);
	}
	public void enterConfirmPassword(String confirmpasswords) {
		confirmpassword.sendKeys(confirmpasswords);
	}
	public void clicknewsletter() {
		newsletter.click();
	}
	
	public void clickConsent() {
		consent.click();
	}
	public void clickSubmit() {
		submit.click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
