package com.nal.qa.testcases;

import static org.testng.Assert.assertEquals;

import java.io.FileNotFoundException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.nal.qa.base.TestBase;
import com.nal.qa.pages.NalHomePage;

public class NalHomePageTest extends TestBase{

	NalHomePage nalHomePage;
	String contactUsPageTitle;
	String loginPageTitle;
	String registerPageTitle;
	
	public NalHomePageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp() throws FileNotFoundException
	{
		initialization();
		nalHomePage = new NalHomePage();	
	}
	
	//@Test(priority = 1)
	public void homePageTitleTest()
	{
		nalHomePage.homePageTitle();
		System.out.println("Home page Title is "  + nalHomePage.homePageTitle);
		Assert.assertEquals(nalHomePage.homePageTitle, "Your Store");
	}
	//@Test(priority = 2)
	public void currencySymbolTest()
	{
		nalHomePage.currencySymbol();
		
		Assert.assertEquals(nalHomePage.currencySymbolText, "$","currencySymbol does not matched");	
	}
	
	//@Test(priority = 3)
	public void contactUsLinkTest() throws InterruptedException
	{
		nalHomePage.contactUsLink();
		contactUsPageTitle = driver.getTitle();	
		Assert.assertEquals(contactUsPageTitle, "Contact Us","Contact Us page title does not matched");	
		driver.navigate().back();
		Assert.assertEquals(driver.getTitle(), "Your Store","Home Page title does not matched");	
	}
	
	//@Test(priority = 4)
	public void AccountDropDownMenuSizeTest() throws InterruptedException
	{
		nalHomePage.AccountDropDownMenu();
		Assert.assertEquals(nalHomePage.AccountLinkDropDownMenuList, 2,"Account Drop Down Count does not matched");	
			
	}
	
	
	@Test(priority = 5)
	public void myAccountLinkToLoginTest() throws InterruptedException
	{
		nalHomePage.myAccountLinkToLogin();
		Thread.sleep(2000);
		loginPageTitle = driver.getTitle();	
		Assert.assertEquals(loginPageTitle, "Account Login","Login Page title does not matched");	
		driver.navigate().back();
		Assert.assertEquals(driver.getTitle(), "Your Store","Home Page title does not matched");	
	}
	
	@Test(priority = 6)
	public void myAccountLinkToRegisterTest() throws InterruptedException
	{
		nalHomePage.myAccountLinkToRegister();
		Thread.sleep(2000);
		registerPageTitle = driver.getTitle();	
		Assert.assertEquals(registerPageTitle, "Register Account","Register Page title does not matched");	
		driver.navigate().back();
		Assert.assertEquals(driver.getTitle(), "Your Store","Home Page title does not matched");	
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	
	
	
}
