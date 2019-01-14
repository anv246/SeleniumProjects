package com.testng1;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.annotations.Test;

public class IRetryAnalyzer_Listener implements IRetryAnalyzer{
  
	int icount = 0;
	int iretry = 5;

@Override
public boolean retry(ITestResult result) {
	
	if(icount<iretry)
	{
		icount++;
		return true;
	}
	return false;
}
}
