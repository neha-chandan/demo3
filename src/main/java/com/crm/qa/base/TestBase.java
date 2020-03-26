package com.crm.qa.base;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.qa.Util.TestUtil;

public class TestBase {

	
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase() {
		try {
	
			prop=new Properties();
			FileInputStream propFile=new FileInputStream("C:\\Users\\admin\\eclipse-workspace\\FreeCRMProject\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");			
			prop.load(propFile);
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void initialization() {
		
		String browserName=prop.getProperty("browser");
		
		switch(browserName) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "F:\\Selenium\\chromedriver.exe");
			driver = new ChromeDriver();
			break;	
		case "firefox":
			System.setProperty("webdriver.gecko.driver", "F:\\Selenium\\geckodriver.exe");
			driver = new FirefoxDriver();
			break;	
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(TestUtil.implict_wait, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("Url"));
		driver.manage().timeouts().pageLoadTimeout(TestUtil.page_load_timeout, TimeUnit.SECONDS);
		
	}
	
	
	
	
	
	
}
