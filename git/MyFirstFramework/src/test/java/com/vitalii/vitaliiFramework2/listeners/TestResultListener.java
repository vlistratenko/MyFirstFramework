package com.vitalii.vitaliiFramework2.listeners;

import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.SkipException;

public class TestResultListener implements ITestListener {
	
	Logger logger = Logger.getLogger(TestResultListener.class);
	

	@Override
	public void onTestStart(ITestResult result) {
		logger.info("- - - - - Test " + result.getName() + " in " + result.getInstanceName() + " class has STARTED - - - - -");
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		logger.info("- - - - - Test " + result.getName() + " in " + result.getInstanceName() + " class has PASSED - - - - -");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		logger.error("- - - - - Test " + result.getName() + " in " + result.getInstanceName() + " class has FAILED and will be restarted" );
		
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		logger.warn("- - - - - Test " + result.getName() + " in " + result.getInstanceName() + " class was SKIPPED - - - - -");
		throw new SkipException("This test has been skipped");
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
