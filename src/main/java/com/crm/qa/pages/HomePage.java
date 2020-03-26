package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{
	
	@FindBy(xpath="//*[@class='right menu']//*[contains(text(),'Neha Mahajan')]")
	WebElement userLabel;

	@FindBy(xpath="//*[text()='Contacts']")
	WebElement contactsTab;
	
	@FindBy(xpath="//*[@class='item']//*[text()='Deals']")
	WebElement dealsTab;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle() {
		return driver.getTitle();
	}
	
	
	public boolean verifyLoggedInUser() {
		return userLabel.isDisplayed();
		
	}
	
	
	public ContactsPage clickOnContactsTab() {
		contactsTab.click();
		return new ContactsPage();
	}
	
	public DealsPage clickOnDealsTab() {
		dealsTab.click();
		return new DealsPage();
	}
}
