package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.LandingPage;
import com.crm.qa.pages.LoginPage;

public class LandingPageTest extends TestBase {
	LandingPage lp;
	LoginPage loginPage;
	
	public LandingPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		lp=new LandingPage();
	}
	
	@Test(priority=-2)
	public void LandingPageTitleTest() {
		String pageTitle=lp.validateLandingPageTitle();
		Assert.assertEquals(pageTitle, "Free CRM #1 cloud software for any business large or small");
	}
	
	@Test(priority=-1)
	public void crmLogoTest() {
		
		boolean crmLogo=lp.validatelogo();
		Assert.assertTrue(crmLogo);
	}
	
	@Test(priority=0)
	public void ClickLoginButtonTest() {
	loginPage=lp.clickOnLoginButton();
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
