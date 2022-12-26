package com.Restaurant.Pageobjects;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.Restaurant.Baseclass.BaseClass;

public class ProductPage extends BaseClass {
	
public ProductPage()
{
	PageFactory.initElements(getDriver(), this);
}
//prodcut heading
@FindBy(xpath="(//span[@class='menu-text'][normalize-space()='Product'])[1]")
WebElement Product;
 //add product
 @FindBy(xpath="//button[contains(text(),'Add Product')]")
 WebElement AddProduct;
 @FindBy(xpath="(//h4[@id='myModalLabel'])[2]")
 WebElement AddProductFormHeader;
 @FindBy(xpath="//select[@id='Type']")
 WebElement SelectTypeDrop;
 public void SelectType()
	{
		Select sel=new Select(SelectTypeDrop);
		sel.selectByIndex(1);
		}
 @FindBy(xpath="//input[@id='ProductCode']")
 WebElement ProductCode;
 
 @FindBy(xpath="//input[@placeholder='Name']")
 WebElement ProdName;
 @FindBy (xpath="//select[@name='category']")
 WebElement CateDrop;
 
 public void SelectCategoryy()
	{
		Select selca=new Select(CateDrop);
		selca.selectByValue("vegetables");
		}
 @FindBy(xpath="//input[@id='Tax']")
 WebElement TaxPercent;
 @FindBy(xpath="//select[@id='taxType']")
 WebElement TaxTypeDrop;
 
 public void SelectTaxType()
	{
		Select seltax=new Select(TaxTypeDrop);
		seltax.selectByIndex(1);
		}
 @FindBy(xpath="//input[@id='Price']")
 WebElement ProdPrice;
 @FindBy(xpath="//select[@id='taxType']")
 WebElement TaxMethodDrop;
 public void SelectTaxMethod()
 {
	 Select seltax=new Select(TaxMethodDrop);
		seltax.selectByValue("1");
 }
 @FindBy(xpath="//textarea[@id='ProductOptions']")
 WebElement ProdOption;
 @FindBy(xpath="(//button[@class='btn btn-add'])[1]")
 WebElement Submit;
 @FindBy(xpath="//button[@class='btn btn-green col-md-6 flat-box-btn waves-effect waves-button']")
 WebElement SubmitEdit;
 @FindBy(xpath="//input[@type='search']")
 WebElement Search;
 @FindBy (xpath="//table[@id='Table']/tbody/tr[1]/td[2]")
 WebElement SearchResult;
 //Edit Button
 @FindBy(xpath="//a[@data-original-title='Edit']")
 WebElement Edit;
 @FindBy(xpath="//a[@data-original-title='Are you sure ?']")
 WebElement Delete;
 @FindBy(xpath="//a[contains(text(),'Yes, delete it!')]")
 WebElement CfmDelete;
 @FindBy(xpath="//td[@class='dataTables_empty']")
 WebElement Nomatch;
 public WebElement Searchbut()
 {
	 return Search;
 }
 public WebElement Productopt()
 {
	 return ProdOption;
 }
 public WebElement ProductPric()
 {
	 return ProdPrice;
 }
 public WebElement Product()
 {
	 return Product;
 }
 public WebElement AddProduct()
 {
	 return AddProduct;
 }
 public WebElement AddProductFill()
 {
	 return AddProductFormHeader;
 }
 public WebElement ProductCode()
 {
	 return ProductCode;
 }
 public WebElement ProductTyp()
 {
	 return SelectTypeDrop;
 }
 public WebElement Prodname()
 {
	 return ProdName;
 }
 public WebElement Category()
 {
	 return CateDrop;
 }
 public WebElement Tax()
 {
	 return TaxPercent;
 }
 public void ClickOnProduct()
 {
	 action.click1(Product, "Clicking on Product");
	  
 }
 
 public boolean isAddProductPresent()
 {
	 
	 return action.isDisplayed(getDriver(), AddProduct);
 }
 public void ClickOnAddProduct()
 { 
	 action.moveToElement(getDriver(), AddProduct);
	 action.click1(AddProduct, "Clicking on AddProduct");
 }
 public boolean IsAddProductFormHeaderPresent()
 {
	 
	 return action.isDisplayed(getDriver(), AddProductFormHeader);
 }
 public void FillAddProductForm()
 {
	SelectType();
	action.type(ProductCode, "1244");
	action.type(ProdName, "capsicum");
	SelectCategoryy();
	action.type(TaxPercent, "3");
	SelectTaxMethod();
	action.type(ProdPrice, "34");
	action.explicitWait(getDriver(), ProdOption, Duration.ofSeconds(20));
	action.moveToElement(getDriver(), ProdOption);
	action.type(ProdOption, "fresh,green");
	action.explicitWait(getDriver(), Submit, Duration.ofSeconds(40));
	action.click1(Submit, "Clicking on Submit");
	
 }
 
 public boolean SearchProduct()
 {
 	
 	action.click1(Search, "Clicking on search");
 	action.type(Search, "capsicum");
 	String Result=SearchResult.getText();
 	 boolean status=false;
 	 if(Result.equalsIgnoreCase("capsicum"))
 	 {
 		 status=true;
 	 }
 	return status;	
 }
 public void EditProduct() {
		ClickOnProduct();
		
		action.click1(Search, "clicking on search");
		action.type(Search, "capsicum");
		action.click1(Edit, "click to edit code");
		action.type(ProductCode, "11111");
		action.click1(SubmitEdit, "Click submit after edit");
		
	}
	public boolean ConfirmEdit()
	{
		String Res=ProductCode.getText();
		boolean statuc=false;
		if(Res.equalsIgnoreCase("1111"));
		{
			statuc=true;
		}
		return statuc;
	}
	public boolean ProductDelete()
	{
		ClickOnProduct();
		
		action.click1(Search, "clicking on search");
		action.type(Search, "capsicum");
		action.click1(Delete, "clicking on delete");
		action.click1(CfmDelete, "confirming the delete");
		action.type(Search, "capsicum");
		String Ress=Nomatch.getText();
		boolean statuc=false;
		if(Ress.equalsIgnoreCase("No matching records found"));
		{
			statuc=true;
		}
		return statuc;
	}
}
