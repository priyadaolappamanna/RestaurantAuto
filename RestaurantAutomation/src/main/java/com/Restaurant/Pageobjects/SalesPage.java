package com.Restaurant.Pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Restaurant.Baseclass.BaseClass;

public class SalesPage extends BaseClass{
	public SalesPage() {
		//this.driver = driver;
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy (xpath="//span[text()='Sales']")
	WebElement SalesBtn;
	
	@FindBy(xpath="//h3[text()='Sales']")
	WebElement Heading;
	
	
	
	 public WebElement sales()
	 {
		 return SalesBtn;
	 }
	 public WebElement Head()
	 {
		 return Heading;
	 }
	 
	 public void ClickonSales()
	 {
		 
		 action.click1(SalesBtn, "Clicking on salesbtn");
		 
	 }
	public boolean IsSalesPresent()
	{
		return action.isDisplayed(getDriver(), Heading);
	}
}
