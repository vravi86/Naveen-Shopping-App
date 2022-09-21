package com.nal.qa.pages;

import java.io.FileNotFoundException;
import java.util.List;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.nal.qa.base.TestBase;

public class NalHomePage extends TestBase{
	
	public String currencySymbolText;
	public String homePageTitle;
	public int AccountLinkDropDownMenuList;

	@FindBy(xpath = "//*[@class ='btn btn-link dropdown-toggle']/strong")
	WebElement currencySymbol;
	
	@FindBy(xpath = "//*[@class = 'fa fa-phone']")
	WebElement contactUs;
	
	@FindBy(linkText = "My Account")
	WebElement myAccountDropDown;
	
//	@FindBy(linkText = "Login")
//	WebElement LoginLink;
	
	@FindBy(xpath = "//*[@class = 'dropdown-menu dropdown-menu-right']/li")
	List<WebElement> AccountLinkDropDownMenu;
	
	public NalHomePage() throws FileNotFoundException {
		
		PageFactory.initElements(driver, this); // Page Factory has initElements method to intialize the elements. Here this refers to intialize the elements in this class.
			
		}
	
	public String homePageTitle()
	{
		homePageTitle = driver.getTitle();
		return homePageTitle;
	}
	public String currencySymbol()
	{
		if(currencySymbol.isDisplayed())
			{
			  currencySymbolText = currencySymbol.getText();
			}
		return currencySymbolText;
	}
	
	public ContactUsPage contactUsLink() throws InterruptedException
	{
		if(contactUs.isDisplayed())
		{
		contactUs.click();
		}
//		else
//		{
//		Thread.sleep(3000);	
//		}
		return new ContactUsPage();
	}
	
	public int AccountDropDownMenu()
	{
		AccountLinkDropDownMenuList = AccountLinkDropDownMenu.size();
//		AccountLinkDropDownMenuList = AccountLinkDropDownMenu;
//		AccountLinkDropDownMenuList.size();
				return AccountLinkDropDownMenuList;
	}
	
	public NalLoginPage myAccountLinkToLogin() throws InterruptedException
	{
//		Actions action = new Actions(driver);
//		action.moveToElement(myAccountDropDown).build().perform();
		
		myAccountDropDown.click();
		
		for(int i=0; i<AccountLinkDropDownMenu.size(); i++)
		{
			if(AccountLinkDropDownMenu.get(i).getText().equals("Login"))		
				{
					AccountLinkDropDownMenu.get(i).click();
					break;
				}
		}
		Thread.sleep(3000);
//		Select select = new Select(myAccountDropDown);
//		select.selectByVisibleText("Login");                                                                                                                                                                                                                                                  
		
		return new NalLoginPage();
		
	}
		
		public NalRegisterPage myAccountLinkToRegister() throws InterruptedException
	{
			myAccountDropDown.click();
			
			for(int i=0; i<AccountLinkDropDownMenu.size(); i++)
			{
				if(AccountLinkDropDownMenu.get(i).getText().equals("Register"))		
					{
						AccountLinkDropDownMenu.get(i).click();
						break;
					}
			}
			Thread.sleep(3000);
			
			return new NalRegisterPage();
			
	}
	
	
}
