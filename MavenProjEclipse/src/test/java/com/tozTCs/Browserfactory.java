package com.tozTCs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Browserfactory {
	
	WebDriver driver;
	String browser;
	String URL;
	
	public Browserfactory(String browser, String URL) {
		this.browser=browser;
		this.URL=URL;
	}
	
	public WebDriver launchbrowser() throws InterruptedException {
		
		if(browser.contains("Chrome")) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\dell46\\eclipse-workspace\\MavenProjEclipse\\DriverWarehouse\\chromedriver1.exe");
		driver = new ChromeDriver();
		} 
		else if(browser.contains("IE")) {
			System.setProperty("webdriver.ie.driver", "C:\\Users\\dell46\\eclipse-workspace\\MavenProjEclipse\\DriverWarehouse\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
        else if(browser.contains("Firefox")) {
        	System.setProperty("webdriver.gecko.driver", "C:\\Users\\dell46\\eclipse-workspace\\MavenProjEclipse\\DriverWarehouse\\geckodriver.exe");
		    driver = new FirefoxDriver();			
		}
        else {
        	System.out.println("We do not support this Browser, Sorry for incovenience");
        }
				
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.navigate().to(URL);
		Thread.sleep(4000);
		
		return driver;
	}

}
