package com.learning;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class jsexecutor {

	WebDriver driver;
	
	@Test
	public void TestJSE() throws Exception {
		try {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\dell46\\eclipse-workspace\\MavenProjEclipse\\DriverWarehouse\\chromedriver1.exe");
	    driver = new ChromeDriver();
		driver.get("https://apollo.talentoz.com/api/swagger/index.html");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		Thread.sleep(2000);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,600)"); // To scroll down
		Thread.sleep(5000);
		jse.executeScript("history.go(0)"); // Too refresh
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		jse.executeScript("window.scrollBy(0,document.body.scrollHeight)"); // To scroll down completely
		Thread.sleep(10000);
		String url =jse.executeScript("return document.URL").toString(); // Return url
		System.out.println(url);
		}
		finally {
			quit();
		}
	}
	
	
	public void quit() {
		driver.quit();
	}
	
}
