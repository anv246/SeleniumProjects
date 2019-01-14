package com.testng1;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

public class IAnnotationTransformer_Listener implements IAnnotationTransformer {
  

@Override
public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
	// TODO Auto-generated method stub
	
	String testcase = testMethod.getName();
	
	switch(testcase) {
	
	case "browserproperty":
		
		annotation.setPriority(1);
		annotation.setEnabled(true);
		break;
		
	case "navigateURL":
		annotation.setPriority(2);
		annotation.setEnabled(true);
		break;
		
	case "getPageInfo":
		annotation.setPriority(3);
		annotation.setEnabled(true);
		
	case "amazonsearch":
		annotation.setPriority(4);
		annotation.setEnabled(true);
		break;
		
	case "results":
		annotation.setPriority(5);
		annotation.setEnabled(true);
		
	default:
		System.out.println("test case not found");
		break;
		
	}
	
}
}
