package com.testng1;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestngAnnotations {
	
  @Test
  public void btestcase1() {
	  System.out.println("in testcase 1");
  }
  
 @Test(priority=1,enabled=true,invocationCount=2)
   public void atestcase2(){
	  System.out.println("in testcase 2");
	  
  }
  
  @BeforeMethod
  public void beforemethod(){
	  System.out.println("in before method");
  }
  
  @AfterMethod
  public void aftermethod() {
	  System.out.println("in aftermethod");
  }
  
  @BeforeClass
  
  public void beforeclass() {
	  System.out.println("before class annotaion");
  }
  
  @AfterClass
  
  public void afterclass() {
	  System.out.println("after class annotation");
	 
  }
  
  @BeforeTest
  
  public void beforetest() {
	  System.out.println("beforetest annotation");
	 
  }
  
  @AfterTest
  
  public void aftertest() {
	  System.out.println("after test annotation");
  }
  
  @BeforeSuite
  public void beforesuit() {
	  System.out.println("beforesuite annotation");
	  
  }
  
  @AfterSuite
  
  public void aftersuite() {
	  
	  System.out.println("aftersuite annotation");
  }
}
