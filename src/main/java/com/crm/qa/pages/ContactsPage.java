package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase{
	
	@FindBy(xpath="//div[text()='Contacts']")
	WebElement contactsLabel;
	//*[text()='New']
	
	@FindBy(xpath="//*[@class='actions']//button[text()='Delete']")
	WebElement deleteButton;
	
	@FindBy(xpath="//*[@role='button']")
	WebElement selectAction;
	
	
	@FindBy(xpath="//*[text()='New']")
	WebElement newContactsBtn;
	
	@FindBy(xpath="//*[@name='first_name']")
	WebElement firstName;
	
	@FindBy(xpath="//*[@name='last_name']")
	WebElement lastName;
	
	@FindBy(xpath="//div[@name='company']//input")
	WebElement companyName;
	
	@FindBy(xpath="//*[text()='Save']")
	WebElement saveBtn;
	
	
	
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void verifyContactsPagelabel() {
		contactsLabel.isDisplayed();
	}
	
	public void verifySelectContactName(String name) {
		driver.findElement(By.xpath("//td[contains(text(), '"+ name +"')]")).click();
	}
	
	public void createNewContact(String fname, String lname) {
		newContactsBtn.click();
		firstName.sendKeys(fname);
		lastName.sendKeys(lname);
	//	companyName.sendKeys(company);
		saveBtn.click();
		
	}
	public void deleteContacts() {
		selectAction.click();
		//deleteButton.click();
	}

}
