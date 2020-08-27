package com.qa.test;


import org.testng.Assert;
import org.testng.annotations.Test;

public class DemoTest {
	
	
		
	@Test
	public void testSum()	{
		System.out.println("SUM");
		int a= 2;
		int b =2;
		Assert.assertEquals(4, a+b);
	}
	
	@Test
	public void testMultiply()	{
		System.out.println("MULTIPLY");
		int a= 2;
		int b =2;
		Assert.assertEquals(4, a*b);
	}
	
	
}
