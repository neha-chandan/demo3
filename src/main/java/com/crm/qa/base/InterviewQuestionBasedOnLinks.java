package com.crm.qa.base;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InterviewQuestionBasedOnLinks {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException  {
		

/*		System.setProperty("webdriver.chrome.driver", "F:\\Selenium Data\\browser exe\\chromedriver.exe");
*/		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://www.rathi.com/");
	    driver.manage().window().maximize();
	    switchToWindow(1);

	    driver.findElement(By.xpath("//*[text()='Login']")).click();
	    System.out.println(driver.getCurrentUrl());
	    switchToWindow(2);
	    Thread.sleep(3000);
	    System.out.println(driver.getCurrentUrl());
	    driver.findElement(By.xpath("//*[@id='ancLogin']")).click();
	    driver.findElement(By.xpath("//div[@class='login_dropdown login_bfr']//*[text()='Trade Online']")).click();
	    switchToWindow(3);
	    System.out.println(driver.getCurrentUrl());
	    driver.findElement(By.id("userId")).sendKeys("Test");
	    driver.findElement(By.xpath("//a[contains(text(),'Forgot')] ")).click();
	    switchToWindow(4);
	    System.out.println(driver.getCurrentUrl());
	    Thread.sleep(5000);
	    switchToWindow(2);
	    System.out.println(driver.getCurrentUrl());
	    driver.close();
	    System.out.println(driver.getCurrentUrl());
	}
	
	public static  void switchToWindow(int index) {
		
		String windowIdString=null;
		Set<String> windowsId=driver.getWindowHandles();
		System.out.println("Currently opened windows: "+windowsId.size());
		Iterator<String> iter=windowsId.iterator();
		
		for(int i=1;i<=index;i++) {
			windowIdString=iter.next();
		}
		
		driver.switchTo().window(windowIdString);

	}
	

}
