package com.learning;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.utilities.Cavalry;

public class tstSrcnSht {
	
	WebDriver driver;
	Cavalry screenshot;
	
	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\dell46\\eclipse-workspace\\MavenProjEclipse\\DriverWarehouse\\chromedriver1.exe");
	    driver = new ChromeDriver();
	    screenshot = new Cavalry();
	}

	@Test
	public void verifyhomepage() throws InterruptedException, IOException {		
		driver.manage().window().maximize();		
		driver.navigate().to("https://apollo.talentoz.com/#/login");
		Thread.sleep(2000);
		if(!driver.getTitle().contains("Apollo")) {
			screenshot.capturescreen(driver, "Title Not Matched");
		}	else {
			loginIntoApollo();
		}
	}
		
	public void loginIntoApollo() throws InterruptedException {
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("optimus@gm.cn");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("test@123");
		driver.findElement(By.xpath("//button[@class='btn btn-block login-btn mb-4']")).click();
		Thread.sleep(2000);
		String user = driver.findElement(By.xpath("//a[@id='navbarDropdown']")).getText();
		if(!user.equals("Optimus Prime")) {
			screenshot.capturescreen(driver, "User Not Matched");
		}
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}
