package com.testng1;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;
import org.testng.annotations.Test;

public class IAnnotationTransformer_RetryAnalyzer_Listener implements IAnnotationTransformer {
  
@Override
public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
	
	annotation.setRetryAnalyzer(com.testng1.IRetryAnalyzer_Listener.class);
	
}
}
