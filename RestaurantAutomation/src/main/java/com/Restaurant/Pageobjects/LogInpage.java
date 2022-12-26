package com.Restaurant.Pageobjects;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Restaurant.Baseclass.BaseClass;

public class LogInpage extends BaseClass{
//page object with page object factory
	
	//logo
	//WebDriver driver;
	@FindBy(xpath="//img[@alt='logo']")
	WebElement logo;
	
	//username
	@FindBy(xpath="//input[@name='username']")
	WebElement Username;
	
	//password
	@FindBy(name="password")
	WebElement Password;
	
	//Login button
	@FindBy(xpath="//input[@name='submit']")
	WebElement Loginbtn;
	
	//Logout
	@FindBy(xpath="//i[@class='fa fa-sign-out fa-lg']")
	WebElement Logout;
	
	public LogInpage() 
	{
		
		//this.driver=driver;
		PageFactory.initElements(getDriver(), this);
	}
	
	public WebElement lgo()
	{
	return logo;
	}
	
	public WebElement Uname()
	{
	return Username;
	}
	
	public WebElement Pword()
	{
	return Password;
	}
	public WebElement Lgbutton()
	{
	return Loginbtn;
	}
	public WebElement LogOut()
	{
	return Logout;
	}
	//Method to check whether the login page is loaded properly
	public boolean IsLogoPresent()
	{
		return action.isDisplayed(getDriver(), logo);
		
	}
	public void loginusingparameter(String username, String password)
	{
		
			action.type(Uname(), username);
			action.type(Pword(), password);
			action.click1(Loginbtn, "Clicking on login button");
	}
	
	public void ValidLogin()
	{		
	action.type(Username,prop.getProperty("Username"));
	action.type(Password, prop.getProperty("Password"));
	action.click1(Loginbtn,"Clicking on login button");
	
		}
	
	public void InvalidLogin(String Username,String password)
	{
		action.type(Uname(), Username);
		action.type(Password, password);
		action.click1(Loginbtn, "Loginbutton");
		
	}
	public void ClickLogOut()
	{
		
		action.click1(Logout, "Clicking on logout");
	}
}
