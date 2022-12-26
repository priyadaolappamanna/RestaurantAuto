package com.Restaurant.Pageobjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.Restaurant.Baseclass.BaseClass;

public class PeopleAddCustomerPage extends BaseClass
{
	
	public PeopleAddCustomerPage() {
		
		PageFactory.initElements(getDriver(), this);
	}

//people
	@FindBy(xpath = "//i[@class='fa fa-users']")
	WebElement people;

//customer
	@FindBy(xpath = "//span[contains(text(),'Customers')]")
	WebElement Customers;
	//add customer
	@FindBy(xpath = "//button[contains(text(),'Add Customer')]")
	WebElement AddCust;
	//form header for customer
	@FindBy (xpath="//h4[contains(text(),'Add Customer')]")
	WebElement FormHeaderCust;
	
	//add customer name
	@FindBy(xpath="//input[@id='CustomerName']")
	WebElement CustName;
	
	//add waiter for phone number
	@FindBy(xpath="//input[@id='CustomerPhone']")
	WebElement CustPhone;
	
	//add waiter for email
	@FindBy(xpath="//input[@id='CustomerEmail']")
	WebElement CustEmail;
	//customer discount
	@FindBy(xpath="//input[@id='CustomerDiscount']")
	WebElement CustDisc;
	//submit button 
	@FindBy(xpath="//button[@class='btn btn-add']")
	WebElement Submit;
	
	@FindBy(xpath="//input[@type='search']")
	WebElement searchcustomer;
	
	//Result of search
	@FindBy(xpath="//table[@id='Table']/tbody/tr/td[1]")
	WebElement SearchName;
	//edit button
	@FindBy(xpath="//i[@class='fa fa-pencil']")
	WebElement Editbtncust;
	//back button of edit 
	@FindBy(xpath="//a[@class='btn btn-default float-right']")
	WebElement Back;
	
	@FindBy(xpath="//div[@class='dataTables_info']")
	WebElement ShowEntry;
	
	@FindBy(xpath="//select[@name='Table_length']")
	WebElement Numdrop;
	
	@FindBy(id="Table_info")
	WebElement showentry;
	
	//delete button
		@FindBy(xpath="//a[@data-toggle='popover']")
		WebElement Delete;
		//confirm delete
		@FindBy(xpath="//a[contains(text(),'Yes, delete it!')]")
		WebElement CfmDel;
		
		@FindBy(xpath="//td[@class='dataTables_empty']")
		WebElement Nomatch;
		
		
		
		public WebElement Confirmdel()
		{
			return CfmDel;
			
		}
		public WebElement Deletebtn()
		{
			return Delete;
			
		}
	public WebElement showentryy()
	{
		return showentry;
		
	}
	public void SelectNum()
	{
		action.click1(people, "clicking on people");
		action.click1(Customers, "clicking on customers");
		Select sel=new Select(Numdrop);
		sel.selectByIndex(1);
	}
	public WebElement Backbutton()
	{
		return Back;
	}
	
	public WebElement CustEdit()
	{
		return Editbtncust;
	}


public WebElement people() {
	return people;
}

public WebElement cust() {
	return Customers;
}
public WebElement AddCust() {
	return AddCust;
	
}
public WebElement Form() {
	return FormHeaderCust;
}
public WebElement Customername() {
	return CustName;
}
public WebElement Customerphone() {
	return CustPhone;
}
public WebElement Customeremail() {
	return CustEmail;
}
public WebElement CustomerDiscount() {
	return CustDisc;
}

public WebElement Submit() {
	return Submit;
}
public WebElement SearchCust() {
	return searchcustomer;
}
public WebElement Searchname() {
	return SearchName;
}


public boolean IsAddCustomerPresent() {
	return action.isDisplayed(getDriver(), AddCust);

}

public boolean IsFormHeaderPresent() {
	return action.isDisplayed(getDriver(),FormHeaderCust );

}
public boolean IsEditCustBackButonPresent() {
	return action.isDisplayed(getDriver(), Back);

}
public void FillAddCustomerForm()
{
	action.click1(people, "clicking on people");
	action.click1(Customers, "clicking on customers");
	action.moveToElement(getDriver(), AddCust);
	action.click1(AddCust, "clicking on add customer");
	action.explicitWait(getDriver(), AddCust, Duration.ofSeconds(20));
	action.type(CustName, "Vinay");
	action.type(CustPhone, "544532432");
	action.type(CustEmail, "viany05@gmail.com");
	action.explicitWait(getDriver(), AddCust, Duration.ofSeconds(20));
	action.click1(Submit, "Clicking on submit");
	
	
			
	}
public void ClickOnSubmit()
{
	action.click1(Submit, "clicking on submit button");
	}

public boolean SearchCustomers()
{
	action.click1(searchcustomer, "Clicking on search");
	action.type(searchcustomer, "Vinay");
	
	String Result=SearchName.getText();
	 boolean status=false;
	 if(Result.equalsIgnoreCase("vinay"))
	 {
		 status=true;
	 }
	return status;	
}
public void EditCustomers() {
	action.click1(people, "clicking on people");
	action.click1(Customers, "clicking on customers");
	action.click1(searchcustomer, "clicking on search");
	action.explicitWait(getDriver(), searchcustomer, Duration.ofSeconds(20));
	action.type(searchcustomer, "Vinay");
	action.click1(Editbtncust, "click to edit athul");
	//action.explicitWait(getDriver(), AddCust, Duration.ofSeconds(20));
	action.type(CustEmail, "vinay05@gmail.com");
	action.click1(Submit, "clicking on submit");
}
public boolean ConfirmEdit()
{
	action.click1(searchcustomer, "cliking on search");
	action.type(searchcustomer, "vinay");
	//action.explicitWait(getDriver(), AddCust, Duration.ofSeconds(20));
	String Res=CustEmail.getText();
	boolean stat=false;
	if(Res.equalsIgnoreCase("vinay05@gmail.com"));
	{
		stat=true;
	}
	return stat;
}
public boolean IsCustomersshowentriesPresent()
{
	//action.explicitWait(getDriver(), AddCust, Duration.ofSeconds(20));
	
	 action.click1(Numdrop, "25 entries");
	 action.moveToElement(getDriver(), AddCust);
	return action.isDisplayed(getDriver(),ShowEntry );
	
}
public boolean CustomerDelete()
{
	action.click1(people, "clicking on people");
	action.click1(Customers, "clicking on customers");
	action.click1(searchcustomer, "clicking on search");
	action.type(searchcustomer, "Vinay");
	action.click1(Delete, "clicking on delete");
	action.click1(CfmDel, "Confirming the delete has happ");
	action.type(searchcustomer, "Vinay");
	action.explicitWait(getDriver(), Nomatch, Duration.ofSeconds(20));
	String Ress=Nomatch.getText();
	boolean stat=false;
	if(Ress.equalsIgnoreCase("No matching records found"));
	{
		stat=true;
	}
	return stat;
	
		}
}