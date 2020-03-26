package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;


public class LoginPage extends TestBase{

	
	@FindBy(name="email")
	WebElement emailId;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//*[text()='Login']")
	WebElement LoginButton;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyLoginPageTitle() {
		return driver.getTitle();
	}
	
	public HomePage login(String email, String pwd)
	{
	emailId.sendKeys(email);
	password.sendKeys(pwd);
	LoginButton.click();
	return new  HomePage();
	}
}
