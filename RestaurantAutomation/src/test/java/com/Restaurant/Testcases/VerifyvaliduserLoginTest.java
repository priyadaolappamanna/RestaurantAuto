package com.Restaurant.Testcases;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Restaurant.Baseclass.BaseClass;
import com.Restaurant.Pageobjects.LogInpage;
import com.Restaurant.Utilities.Log;


public class VerifyvaliduserLoginTest extends BaseClass {
@Test (priority=1)
@Parameters({"Username","Password"})
public void VerifyUserLogin(String Username,String Password) throws InterruptedException
{
	Log.startTestCase("Verifyuserlogin");
	Assert.assertTrue(lp.IsLogoPresent(),"LogInpage is not loaded");
	lp.loginusingparameter(Username,Password);
	Assert.assertTrue(lp.IsLogoPresent(),"Homepage is not loaded");
	lp.ClickLogOut();
	Log.endTestCase("Verifyuserlogin");	
	}
@Test(dataProvider="InvalidLoginDatas")

public void VerifyInvalidUserLogin(String Username,String password)
{
	Log.startTestCase("VerifyInvaliduserlogin");
	Assert.assertTrue(lp.IsLogoPresent(),"LogInpage is not loaded");
	lp.InvalidLogin(Username, password);
	Log.endTestCase("VerifyInvaliduserlogin");
}


}
