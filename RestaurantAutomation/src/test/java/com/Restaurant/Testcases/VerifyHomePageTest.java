package com.Restaurant.Testcases;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Restaurant.Baseclass.BaseClass;
import com.Restaurant.Pageobjects.HomePage;
import com.Restaurant.Pageobjects.LogInpage;
import com.Restaurant.Utilities.Log;

public class VerifyHomePageTest extends BaseClass {
	@Test
	
	public void VerifyHomePage() 
	{
		Log.startTestCase("VerifyHomePageTest");
		lp.ValidLogin();
		hp.ClickOnFrenchLanguage();
	    Assert.assertTrue(hp.IsFrenchLanguagePresent(),"Portugal lang is not present");
		hp.ClickOnPortugalLanguage();
		Assert.assertTrue(hp.IsPortugeseLanguagePresent(),"Portugal lang is not present");
		hp.ClickOnEnglishLanguage();
		Assert.assertTrue(hp.IsEnglishLanguagePresent(),"English is not present");
		Log.endTestCase("VerifyHomePageTest");
		
		
	}
	

}
