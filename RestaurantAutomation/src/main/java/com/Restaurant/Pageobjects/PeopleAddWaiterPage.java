package com.Restaurant.Pageobjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.Restaurant.Baseclass.BaseClass;

public class PeopleAddWaiterPage extends BaseClass {


public PeopleAddWaiterPage() {

PageFactory.initElements(getDriver(), this);
}

//people
@FindBy(xpath = "//i[@class='fa fa-users']")
WebElement people;

//waiters
@FindBy(xpath = "//span[contains(text(),'Waiters')]")
WebElement Waiters;

// add waiter text
@FindBy(xpath = "//button[contains(text(),'Add Waiter')]")
WebElement AddWaiter;

// add waiter form headertext
@FindBy (xpath="//h4[@id='myModalLabel']")
WebElement FormHeader;

//add waiter for waitername field
@FindBy(xpath="//input[@id='WaiterName']")
WebElement WaiterName;

//add waiter for phone number
@FindBy(xpath="//input[@id='WaiterPhone']")
WebElement WaiterPhone;

//add waiter for email
@FindBy(xpath="//input[@id='WaiterEmail']")
WebElement WaiterEmail;

//add waiter for Store
@FindBy(xpath="//select[@id='WaiterStore']")
WebElement Staticdrop;
//select class for static drpdown to select store
public void SelectStore()
{
Select sele=new Select(Staticdrop);
sele.selectByValue("168");
}
@FindBy(xpath="//select[@name='Table_length']")
WebElement Numdrop;
public void SelectNum()
{
	ClickOnPeople();
	ClickOnWaiters();
Select sel=new Select(Numdrop);
sel.selectByIndex(1);

}
@FindBy(xpath="//div[@class='dataTables_info']")
WebElement ShowEntry;

//add waiter submit
@FindBy(xpath="//button[@class='btn btn-add']")
WebElement Submit;

//search button
@FindBy(xpath="//input[@type='search']")
WebElement searchwaiter;

//Result of search
@FindBy(xpath="//table[@id='Table']/tbody/tr/td[1]")
WebElement SearchName;
//edit button
@FindBy(xpath="//a[@data-original-title='Edit']")
WebElement EditBtn;

//back button when edit is clicked
@FindBy(xpath="//a[@class='btn btn-default float-right']")
WebElement Backbtn;
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

public WebElement BackButton()
{
return Backbtn;

}

public WebElement edit()
{
return EditBtn;

}

public WebElement people() {
return people;
}

public WebElement waiter() {
return Waiters;
}

public WebElement Addwaiter() {
return AddWaiter;
}
public WebElement Form() {
return FormHeader;
}
public WebElement Waitername() {
return WaiterName;
}
public WebElement Waiterphone() {
return WaiterPhone;
}
public WebElement Waiteremail() {
return WaiterEmail;
}
public WebElement Submit() {
return Submit;
}
public WebElement Search() {
return searchwaiter;
}
public WebElement Searchname() {
return SearchName;
}
public void ClickOnPeople() {
action.click1(people, "Clicking on people button");
}

public void ClickOnWaiters() {
action.click1(Waiters, "Clicking on waiters");
}

public boolean IsAddWaitersPresent() {
return action.isDisplayed(getDriver(), AddWaiter);

}
public boolean IsFormHeaderPresent() {
return action.isDisplayed(getDriver(),FormHeader );

}
public boolean IsEdiWaitersBackButonPresent() {
return action.isDisplayed(getDriver(), Backbtn);

}

public void FillAddWaiterForm()
{
action.click1(people, "clicking on people");
action.click1(Waiters, "Clicking on waiters");
action.moveToElement(getDriver(), AddWaiter);
action.click1(AddWaiter, "Clicking on Add waiters");
action.explicitWait(getDriver(), WaiterName, Duration.ofSeconds(20));
action.type(WaiterName, "Athul");
action.type(WaiterPhone, "9865433456");
action.type(WaiterEmail, "Athul005@gmail.com");
action.click1(Staticdrop, "Cliking on store dropdown");
SelectStore();
action.click1(Submit, "Clicking on submit");
}

public boolean SearchWaiters()
{

action.click1(searchwaiter, "Clicking on search");
action.type(searchwaiter, "Athul");
String Result=SearchName.getText();
boolean status=false;
if(Result.equalsIgnoreCase("Athul"))
{
status=true;
}
return status;
}
public void EditWaiters() {
action.click1(people, "clicking on people");
action.click1(Waiters, "Clicking on waiters");
action.click1(searchwaiter, "clicking on search");
action.type(searchwaiter, "Athul");
action.click1(EditBtn, "click to edit athul");
action.type(WaiterPhone, "7643334545");
action.click1(Submit, "Clicking on submit");
action.type(searchwaiter, "Athul");

}
public boolean ConfirmEdit()
{
String Res=WaiterPhone.getText();
boolean statuc=false;
if(Res.equalsIgnoreCase("7643334545"));
{
statuc=true;
}
return statuc;

}
public boolean IsWaitershowentriesPresent()
{
action.click1(people, "clicking on people");
action.click1(Waiters, "Clicking on waiters");
action.click1(Numdrop, "25 entries");
action.moveToElement(getDriver(), AddWaiter);
return action.isDisplayed(getDriver(),ShowEntry );

}
public boolean WaiterDelete()
{
ClickOnPeople();
ClickOnWaiters();
action.click1(searchwaiter, "clicking on search");
action.type(searchwaiter, "Athul");
action.click1(Delete, "clicking on delete");
action.click1(CfmDel, "Confirming the delete has happ");
action.type(searchwaiter, "Athul");
String Ress=Nomatch.getText();
boolean statuc=false;
if(Ress.equalsIgnoreCase("No matching records found"));
{
statuc=true;
}
return statuc;

}


}