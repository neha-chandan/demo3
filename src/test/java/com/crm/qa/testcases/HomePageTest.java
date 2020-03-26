package com.crm.qa.testcases;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LandingPage;
import com.crm.qa.pages.LoginPage;

public class HomePageTest extends TestBase{
	
	LandingPage lp;
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	public HomePageTest() {
		super();
	}
	
	
	//TestCases should be separate -- independent with each other
	//Before each Testcase -- launch the browser
	//@Test-- execute testcase
	//After each Testcase -- close the browser
	
	@BeforeMethod()
	public void init() {
		initialization();
		lp=new LandingPage();
		loginPage=lp.clickOnLoginButton();
		homePage=loginPage.login(prop.getProperty("Email"), prop.getProperty("Password"));

	}
	
	@Test(priority=1)
	public void verifyHomePageTitleTest() {
	String homePageTitle=homePage.verifyHomePageTitle();
	Assert.assertEquals(homePageTitle, "Cogmento CRM");
	}
	
	@Test(priority=2)
	public void verifyUserNameTest() {
		Assert.assertTrue(homePage.verifyLoggedInUser());
	}
	
	@Test(priority=3)
	public void clickContactTabTest() {
		contactsPage=homePage.clickOnContactsTab();
	}
	
	@AfterMethod()
	public void teardown() {
		driver.quit();
	}
}
