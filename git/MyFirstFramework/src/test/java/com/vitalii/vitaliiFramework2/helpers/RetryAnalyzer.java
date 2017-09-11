package com.vitalii.vitaliiFramework2.helpers;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {
	
	private static int count = 0;
	public static final int MAX_ATTEMPTS = 2;

	@Override
	public boolean retry(ITestResult result) {
		if (count < MAX_ATTEMPTS) {
			count ++;
			return true;
		}
		return false;
	}
}
