package com.vitalii.vitaliiFramework2.listeners;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;
import com.vitalii.vitaliiFramework2.helpers.RetryAnalyzer;

public class RetryListener implements IAnnotationTransformer {
	
	    @Override
	    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
	    	annotation.setRetryAnalyzer(RetryAnalyzer.class);
	    	/*	        IRetryAnalyzer retry = annotation.getRetryAnalyzer();
	        if (retry == null) {
	            annotation.setRetryAnalyzer(RetryAnalyzer.class);
	        }*/
	    }
}
