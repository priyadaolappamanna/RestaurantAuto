package com.Restaurant.Testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Restaurant.Baseclass.BaseClass;
import com.Restaurant.Pageobjects.LogInpage;
import com.Restaurant.Pageobjects.PeopleAddWaiterPage;
import com.Restaurant.Pageobjects.ProductPage;
import com.Restaurant.Pageobjects.StoresPage;
import com.Restaurant.Utilities.Log;

public class VerifyProductPage extends BaseClass{
@Test(priority=1)
public void VerifyAddProduct() throws InterruptedException
{
	Log.startTestCase("VerifyPeopleAddProductPageTest");
	lp.ValidLogin();
	pp.ClickOnProduct();
	//Thread.sleep(3000);
	Assert.assertTrue(pp.isAddProductPresent());
	pp.ClickOnAddProduct();
    Thread.sleep(3000);
	Assert.assertTrue(pp.IsAddProductFormHeaderPresent(),"form header is not present");
	pp.FillAddProductForm();
	Assert.assertTrue(pp.SearchProduct(),"Product  not found");
	Log.endTestCase("VerifyPeopleAddProductPageTest");
		}
@Test(priority=2)
public void VerifyEditProduct() throws InterruptedException
{
	
		Log.startTestCase("VerifyEditProdTest");
		lp.ValidLogin();
		ProductPage pp=new ProductPage();
		pp.EditProduct();
		Thread.sleep(3000);		
		Assert.assertTrue(pp.ConfirmEdit(),"field is not edited");	
		Log.endTestCase("VerifyEditProdTest");
		
	}
@Test(priority=3)
public void verifyProductDelete() throws InterruptedException
{
	Log.startTestCase("VerifyProductdeletePageTest");
	lp.ValidLogin();
	ProductPage pp=new ProductPage();
	Thread.sleep(3000);
	pp.ProductDelete();
	Assert.assertTrue(pp.ProductDelete(),"not deleted");
	Log.endTestCase("VerifyProductdeletePageTest");
	
	
}

}
