package com.Restaurant.Pageobjects;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Restaurant.Baseclass.BaseClass;

public class ReportsPage extends BaseClass{
	
public ReportsPage()
{
	PageFactory.initElements(getDriver(), this);
}
//reports button
@FindBy(xpath="//span[contains(text(),'Reports')]")
WebElement Reports;

//top 5 products
@FindBy(xpath="//h3[contains(text(),'Top 5 Products this year')]")
WebElement Top5Prod;
//Client Stat
@FindBy(xpath="//h3[text()='Clients Stats']")
WebElement ClientsStat;
//selectclient Dropdown
@FindBy(xpath="(//b[@role='presentation'])[1]")
WebElement SelectClientDrop;
//Calander of client
@FindBy(xpath="//input[@id='CustomerRange']")
WebElement ClientCalender;
//report of client
@FindBy(xpath="(//button[contains(text(),'Get Report')])[1]")
WebElement ClientReport;
//ClientStat
@FindBy (xpath="//h4[@id='stats']")
WebElement StatusOfReport;
@FindBy(xpath="//button[text()='Close']")
WebElement Close;
//prod Status
@FindBy(xpath="(//span[@role='presentation'])[2]")
WebElement ProductStatus;

//productRange
@FindBy(xpath="//input[@id='ProductRange']")
WebElement ProdRange;
//product report
@FindBy(xpath="(//button[contains(text(),'Get Report')])[2]")
WebElement ProdReport;
@FindBy(xpath="//h3[text()='Stock stats']")
WebElement StoreStat; 
//SelectOmstore
@FindBy(xpath="//span[contains(text(),'MCDS')]")
WebElement SelectStore;
//regisstore calender
@FindBy(xpath="//input[@id='RegisterRange']")
WebElement RegisCal;
@FindBy(xpath="(//button[contains(text(),'Get Report')])[3]")
WebElement RegReport;
		
public WebElement ProdReport()
{
	return ProdReport;
	}
public WebElement SelectRegStore()
{
	return SelectStore;
	}
public WebElement RegisCal()
{
	return RegisCal;
	}

public WebElement Report()
{
	return Reports;
}
public WebElement RegRepo()
{
	return RegReport;
	}
public WebElement TopProducts()
{
	return Top5Prod;
	
}
public WebElement Clientstat()
{
	return ClientsStat;
}
public WebElement ClientDrop()
{
	return SelectClientDrop;
}
public WebElement ClientCal()
{
	return ClientCalender;
}
public WebElement ClientRep()
{
	return ClientReport;
}
public WebElement Producttat()
{
	return ProductStatus;
}
public WebElement Productrange()
{
	return ProdRange;
}

public WebElement ProdRep()
{
	return ProdReport;
}

public void ClickOnReports()
{
	action.click1(Reports, "Clicking on Reports");
}
public void ClickOnSelectClient()
{
	ClickOnReports();
	action.moveToElement(getDriver(), ClientsStat);
	action.click1(SelectClientDrop, "Clicking on Select Product");
	action.type(SelectClientDrop, "MCDS");
	action.type(ClientCalender, "01/01/2022 - 12/31/2022");
	action.explicitWait(getDriver(), ClientReport, Duration.ofSeconds(20));
	action.click1(ClientReport, "Clicking on Report");
	
	
}
public void ClickOnSelectProduct()
{
	ClickOnReports();
	action.moveToElement(getDriver(), ProductStatus);
	action.click1(SelectClientDrop, "Clicking on Select Product");
	action.type(ProdRange, "01/01/2022 - 12/31/2022");
	action.explicitWait(getDriver(), ProdReport, Duration.ofSeconds(20));
	action.click1(ProdReport, "Clicking on Report");
	
	
}
public void ClickOnSelectStore()
{
	ClickOnReports();
	action.moveToElement(getDriver(), StoreStat);
	action.click1(SelectStore, "Clicking on Select store");
	action.type(SelectStore, "MCDS");
	action.type(RegisCal, "01/01/2022 - 12/31/2022");
	action.explicitWait(getDriver(), RegReport, Duration.ofSeconds(20));
	action.click1(RegReport, "Clicking on Report");
	
	}
public Boolean IsStatPresent()
{
	return action.isDisplayed(getDriver(), StatusOfReport);
}
public Boolean IsTop5ProductsPresent()
{
	return action.isDisplayed(getDriver(), Top5Prod);
}
public boolean IsReportStatusPresent()
{
return action.isDisplayed(getDriver(), StatusOfReport);	
}
public void ClickonClose()
{
	action.click1(Close, "ClickingonClose");
	}

}
