package com.testng1;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ITestListener_Listener implements ITestListener{
  

@Override
public void onTestStart(ITestResult result) {
	System.out.println("test case started and its name is: "+result.getName());
	System.out.println("status of test case is: "+result.getStatus());
	
	
}

@Override
public void onTestSuccess(ITestResult result) {
	
	System.out.println("test case execution success and its name is: "+result.getName());
	System.out.println("status of test case is: "+result.getStatus());
		
}

@Override
public void onTestFailure(ITestResult result) {
	
	System.out.println("test case execution failed and its name is: "+result.getName());
	System.out.println("status of test case is: "+result.getStatus());
	
}

@Override
public void onTestSkipped(ITestResult result) {
	
	System.out.println("test case execution skipped and its name is: "+result.getName());
	System.out.println("status of test case is: "+result.getStatus());
	
}

@Override
public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	// TODO Auto-generated method stub
	
}

@Override
public void onStart(ITestContext context) {
	
	System.out.println("Test started and the name of the test is: "+context.getName());
	
}

@Override
public void onFinish(ITestContext context) {
	
	System.out.println("Test finished and the name of the test is: "+context.getName());
	
}
}
