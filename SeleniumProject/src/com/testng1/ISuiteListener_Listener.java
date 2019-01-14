package com.testng1;

import org.testng.ISuite;
import org.testng.ISuiteListener;

public class ISuiteListener_Listener implements ISuiteListener{
	
	long starttime;
	long executiontime;
  
@Override
public void onStart(ISuite suite) {
	System.out.println("Suite started and suite's name is: "+suite.getName());
	starttime = System.currentTimeMillis();
	System.out.println("current time in milli seconds while the suite starts execution is: "+starttime);
	// TODO Auto-generated method stub
	
}

@Override
public void onFinish(ISuite suite) {
	
	System.out.println("Suite completed and suite's name is: "+suite.getName());
	executiontime = (System.currentTimeMillis()-starttime);
	System.out.println("total time taken for suite execution is: "+executiontime);
	// TODO Auto-generated method stub
	
}
}
