package com.Restaurant.Testcases;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Restaurant.Baseclass.BaseClass;
import com.Restaurant.Pageobjects.LogInpage;
import com.Restaurant.Pageobjects.PeopleAddSupplierPage;
import com.Restaurant.Pageobjects.StoresPage;
import com.Restaurant.Utilities.Log;

public class VerifyStoresPageTest extends BaseClass {
	@Test(priority=1)
	public void VerifyAddStore() throws InterruptedException
	{
		Log.startTestCase("VerifyAddStorePage");
		lp.ValidLogin();
		sp.FillAddStoreForm();
	 	Assert.assertTrue(sp.SearchStores(),"Add store is not happened");
		Log.endTestCase("VerifyAddStorePage");
		}
	@Test (priority=2,enabled=true)
	
	public void verifyeditstore() throws InterruptedException 
	{
		Log.startTestCase("VerifyEditStoreTest");
		lp.ValidLogin();
		sp.EditStores();
		Assert.assertTrue(sp.ConfirmEdit(),"field is not edited");	
		Log.endTestCase("VerifyEditStoreTest");
		
	}
	@Test(priority=3,dependsOnMethods= {"verifyeditstore"})
	public void verifyStoreDelete() 
	{
		Log.startTestCase("VerifyStoreDeletePageTest");
		lp.ValidLogin();
		sp.StoreDelete();
		Assert.assertTrue(sp.StoreDelete(),"not deleted");
		Log.endTestCase("VerifyStoreDeletePageTest");
		
		
	}

}
