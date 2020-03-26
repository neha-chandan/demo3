package com.crm.qa.testcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LandingPage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{

	LandingPage lp;
	LoginPage loginPage;
	HomePage homePage;
	LoginPageTest(){
		super();
	}
	
	@BeforeMethod
	public void init() {
		initialization();
		lp=new LandingPage();
		loginPage=lp.clickOnLoginButton();
	}
	
	@Test(priority=1)
	public void pageTitleTest() {
		String loginPageTitle=loginPage.verifyLoginPageTitle();
		Assert.assertEquals(loginPageTitle, prop.getProperty("LoginPageTitle"));
	}
	
	@Test(priority=2)
	public void loginTest() {
	homePage=loginPage.login(prop.getProperty("Email"), prop.getProperty("Password"));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
	
	
}
