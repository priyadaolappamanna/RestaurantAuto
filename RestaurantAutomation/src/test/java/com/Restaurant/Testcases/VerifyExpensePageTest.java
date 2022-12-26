package com.Restaurant.Testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Restaurant.Baseclass.BaseClass;
import com.Restaurant.Pageobjects.ExpensePage;
import com.Restaurant.Pageobjects.LogInpage;

import com.Restaurant.Utilities.Log;

public class VerifyExpensePageTest extends BaseClass {

	@Test(priority = 1)
	public void VerifyAddExpense() throws InterruptedException {
		Log.startTestCase("VerifyAddExpense");
		
		lp.ValidLogin();
		Ep.AddExpence();
		Thread.sleep(3000);
		Assert.assertTrue(Ep.SearchExpence(), "Add Expense Label is not loaded");
		Thread.sleep(3000);
		Log.endTestCase("VerifyAddExpense");

	}

	
	@Test(priority = 4)
	public void VerifyDeleteExpense() throws InterruptedException {
		Log.startTestCase("VerifyDeleteExpense");
		lp.ValidLogin();
		Ep.DeleteExpence();
		Assert.assertTrue(Ep.ConfirmDelete(), "Searched expense not found");
		Log.endTestCase("VerifyDeleteExpense");

	}

	@Test(priority = 3)
	public void VerifyEditExpense() throws InterruptedException {
		Log.startTestCase("VerifyEditExpense");
		lp.ValidLogin();
		ExpensePage Ep = new ExpensePage();
		Assert.assertTrue(Ep.IsExpensePresent(), "Expense Label is not loaded");
		Ep.EditExpence();
		Assert.assertTrue(Ep.ConfirmEdit(), "Edit not success");
		Log.endTestCase("VerifyEditExpense");

	}
}