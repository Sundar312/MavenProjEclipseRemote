package com.TozPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.tozTCs.BaseClass;
import com.utilities.Excelsupport;


public class RunnerClass {
	
	String path;
	WebDriver driver;
	BaseClass BC;
	Excelsupport exsupport;
	String ReqNo;
	
	@BeforeSuite
	public void startsetup() throws InterruptedException {	
	    path = "C:\\Users\\dell46\\eclipse-workspace\\MavenProjEclipse\\TestData\\Data.xlsx";
	    BC = new BaseClass();	
		BC.setup(path);
		exsupport = BC.exsupport;
		BC.envsetup();
		driver = BC.driver;
	}
	
	@Test(priority=1)
	public void login() throws InterruptedException {
		LoginPage lp =PageFactory.initElements(driver, LoginPage.class);
        lp.verifylogin(exsupport);
	}
	
	@Test(priority=2)
	public void submitclaim() throws Exception {
		ApplyClaim ac =PageFactory.initElements(driver, ApplyClaim.class);
		ac.clickClaimMenu();
		ReqNo = ac.submitClaim();
	}
	
	@Test(priority=3)
	public void CheckInList() throws Exception {
		ClaimList cl =PageFactory.initElements(driver, ClaimList.class);
		cl.ViewInClaimList(exsupport, ReqNo);
	}
	
	@AfterClass
	public void teardown() throws Exception {
		BC.Exit();
		BC.teardown();
	}
	
	

}
