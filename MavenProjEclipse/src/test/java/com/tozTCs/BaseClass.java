package com.tozTCs;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;

import com.utilities.Configsupport;
import com.utilities.Excelsupport;

public class BaseClass {
	
	public WebDriver driver;
	public Excelsupport exsupport;
	public Configsupport configfile;
	
	
	public void setup(String path) {
		 String path1 =path;
		 exsupport = new Excelsupport(path1);
		 configfile = new Configsupport();
	}
	
	public void envsetup() throws InterruptedException {		
		Browserfactory B = new Browserfactory(configfile.getConfigData("Browser"),configfile.getConfigData("stageURL"));
		driver = B.launchbrowser();
	}
	
	public void Enter() throws IOException {			
		driver.findElement(By.xpath("//*[@id=\'txt_name\']")).sendKeys(exsupport.getStringData("Sheet2", 1, 1));		
		driver.findElement(By.xpath("//*[@id=\'txt_pass\']")).sendKeys(exsupport.getStringData("Sheet2", 1, 2));
		driver.findElement(By.xpath("//*[@id=\'btn_submit\']")).click();
		System.out.println("Waiting");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);		
	}
	
	public void Exit() throws InterruptedException {		
		driver.findElement(By.xpath("//*[@id=\'undivname\']")).click();
		driver.findElement(By.xpath("//*[@id='liitem2btnlistLog']")).click();
		Thread.sleep(3000);
	}
	
	@AfterMethod
	public void teardown() {
		exsupport.closexel();	
		driver.close();
	}

}
