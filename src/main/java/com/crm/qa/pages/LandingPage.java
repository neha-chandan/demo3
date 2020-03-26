package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LandingPage extends TestBase{
	
	//Page Factory Or Object Repository
	
	@FindBy(xpath="//*[@class='rd-navbar-brand']//*[@class='brand-name' and @title='free crm home']")
	WebElement crmLogo;
	
	@FindBy(xpath="//span[contains(text(),'Log In')]")
	WebElement logInLink;
	
	@FindBy(xpath="//*[text()='Sign Up']")
	WebElement singUp;
	
	
	
	
	//Initializing the Page Object

	public LandingPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	
	public LoginPage clickOnLoginButton() {
		logInLink.click();
		return new LoginPage();
	}
	
	public void clickOnSignUpButton() {
		singUp.click();
	}
	public String validateLandingPageTitle() {
		return driver.getTitle();
	}
	
	public String validateCrmLogoHoverText() {
		return driver.getTitle();
	}
	
	public boolean validatelogo() {
		return crmLogo.isDisplayed();
	}
	

}
