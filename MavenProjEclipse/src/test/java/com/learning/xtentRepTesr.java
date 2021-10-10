package com.learning;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.utilities.Cavalry;

@Listeners
public class xtentRepTesr {

	ExtentSparkReporter htmlReporter;
	ExtentReports extent;
	WebDriver driver;
	ExtentTest test;
	Cavalry cavalry;

	@BeforeSuite
	public void xtentsetup() {
		htmlReporter = new ExtentSparkReporter("Extent.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		htmlReporter.config().setTheme(Theme.DARK);
	}

	@BeforeTest
	public void DriverrSetup() {	
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\dell46\\eclipse-workspace\\MavenProjEclipse\\DriverWarehouse\\chromedriver1.exe");
		driver = new ChromeDriver();
	    cavalry = new Cavalry();
	}
	
	@BeforeMethod
	public void startXtentReportGeneration() {
		test = extent.createTest("Apollo test");
	}

	@Test
	public void loginApollo() throws InterruptedException {    
		test.log(Status.INFO, "Igniting the Login Page Test");
		driver.manage().window().maximize();
		driver.navigate().to("https://apollo.talentoz.com/#/login?returnUrl=%2F");
		Thread.sleep(3000);
		Assert.assertEquals("Apolo", driver.getTitle());
		System.out.println(driver.getTitle());
		test.info("Test 1 completed");
	}
	
	@Test
	public void loginintoApollo() throws InterruptedException {
		test.log(Status.INFO, "Igniting the Home Page Test");
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("optimus@gm.cn");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("test@123");
		driver.findElement(By.xpath("//button[@class='btn btn-block login-btn mb-4']")).click();
		Thread.sleep(4000);
		test.info("Test 2 completed");
	}
	
	@AfterMethod
	public void verifyAndAttach(ITestResult result) {
	    if(result.getStatus()==ITestResult.FAILURE) {
	    	test.log(Status.FAIL, "Test has been failed due to" +result.getThrowable());
	        test.addScreenCaptureFromPath("C:\\Users\\dell46\\eclipse-workspace\\MavenProjEclipse\\"
	    			        + "Screenshots\\Title Not Matched.png");
	    }
	    else if(result.getStatus()==ITestResult.SUCCESS) {
	    	test.log(Status.PASS, "Tes has been passed\t" +result.getTestClass().getName());
	    }
	    else{
	    	System.out.println("Test of yours couldn't be categorized");
	    }
	}
	
	@AfterTest
	public void tesrdown() {		
		extent.flush();
		driver.quit();
	}
}
