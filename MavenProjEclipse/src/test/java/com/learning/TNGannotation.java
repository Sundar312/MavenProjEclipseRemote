package com.learning;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TNGannotation {
	
	@BeforeSuite
	public void m1() {
		System.out.println("In before suite");
	}
	
	@BeforeTest
	public void m2() {
		System.out.println("In before test");
	}
	
	@BeforeClass
	public void m3() {
		System.out.println("In before class");
	}
	
	@BeforeMethod
	public void m4() {
		System.out.println("In before method");
	}

	@BeforeGroups
	public void m5() {
		System.out.println("In before groups");
	}
	
	@Test
	public void main() {
		System.out.println("Started");
	}
}
