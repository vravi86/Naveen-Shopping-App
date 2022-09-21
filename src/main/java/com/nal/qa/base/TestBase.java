package com.nal.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
//import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.nal.qa.utilities.TestUtil;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties property;
	public static FileInputStream fis;
	
	public void TestBase() throws IOException 
	{
		 property = new Properties();
		 
		 fis = new FileInputStream("D:\\Java Projects\\NaveenOpencartAutomation\\src\\main\\java\\com\\nal\\qa\\config\\config.properties");
		 try {
				property.load(fis);  
		 	 } 
		 catch (FileNotFoundException e) 
		 	{
			e.printStackTrace();
		 	}		 
	}
	

	public static void initialization()
	{
	
		String browserName = "chrome";
		if(browserName.equals("firefox"))
		{
			System.setProperty("webdriver.firefox.driver","C:/Users/Admin/Downloads/geckodriver-v0.30.0-win64/geckodriver.exe");
			 driver = new FirefoxDriver();
		}
		
		else if (browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","C:/Users/Admin/Downloads/chromedriver_win32 (1)/chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.pageLoadTimeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.implicitWaitTime, TimeUnit.SECONDS);
		
		
		driver.get("https://naveenautomationlabs.com/opencart/");
	}
	
}
