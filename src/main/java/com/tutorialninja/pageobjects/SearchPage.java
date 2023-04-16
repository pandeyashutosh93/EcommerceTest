package com.tutorialninja.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {

	WebDriver driver;
	
	public SearchPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	@FindBy(name="search")
	private WebElement searchbox;
	
	
	@FindBy(xpath="(//button[contains(@class,'btn-lg')])[1]")
	private WebElement searchbtn;
	
	@FindBy(linkText="HP LP3065")
	private WebElement searchresult;
	
	@FindBy(xpath="//*[@id=\"content\"]/p[2]")
	private WebElement alertmessage;
	
	
	
	
	
	
	public void enterSearchBox(String product) {
		searchbox.sendKeys(product);
	}
	
	public void clickSearch() {
		searchbtn.click();
	}
	
	public boolean getProductDisplayStatus() {
		boolean productstatus = searchresult.isDisplayed();
		return productstatus;
	}
	public boolean getAlertMessageStatus() {
		boolean alertmsgdispaly = alertmessage.isDisplayed();
		return alertmsgdispaly;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
