package com.Restaurant.Utilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class ReRunAutomation implements IRetryAnalyzer {

	private int retrycount = 0;
	private static final int maxcount = 2;

	public boolean retry(ITestResult result) {
		if (retrycount < maxcount) {
			retrycount++;
			return true;
		}

		return false;
	}

}

