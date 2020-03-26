package com.crm.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.qa.Util.TestUtil;
import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LandingPage;
import com.crm.qa.pages.LoginPage;
@Listeners(com.crm.qa.Util.TestNgListeners.class)
public class ContactsPageTest extends TestBase{
	
	LandingPage lp;
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	String sheetName="contactest_data";
	public ContactsPageTest() {
		super();
	}
	
	@BeforeMethod
	public void init() {
		initialization();
		lp=new LandingPage();
		loginPage=lp.clickOnLoginButton();
		homePage=loginPage.login(prop.getProperty("Email"), prop.getProperty("Password"));
		contactsPage=homePage.clickOnContactsTab();
	}
	
	
	@Test(priority=1)
	public void verifyContactPageLabelTest(){
		contactsPage.verifyContactsPagelabel();
	}
	
	@Test(priority=2)
	public void verifySingleSelectContactNameTest(){
		contactsPage.verifySelectContactName("ASasS ADAD");
	}
	
	@Test(priority=3)
	public void verifyMulitiSelectContactNameTest(){
		contactsPage.verifySelectContactName("ASasS ADAD");
		contactsPage.verifySelectContactName("sssss ssss");
	}
	
	@Test(priority=4)
	public void verifyDeletecontactTest(){
		contactsPage.deleteContacts();
	}
	
	@DataProvider
	public Object[][] getCrmTestdata(){
	Object data[][]=TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority=0, dataProvider="getCrmTestdata")
	public void verifyCreateNewContact(String fName, String lName) {
		contactsPage.createNewContact(fName, lName);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
