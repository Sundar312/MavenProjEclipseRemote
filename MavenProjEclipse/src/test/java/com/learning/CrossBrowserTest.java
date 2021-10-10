package com.learning;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowserTest {
			
	 WebDriver driver;
	@Test
	@Parameters("Browser")
	public  void CrssBrwoserTesting(String Browsername) throws InterruptedException {
			
		if(Browsername.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\dell46\\eclipse-workspace\\MavenProjEclipse\\DriverWarehouse\\geckodriver.exe");
		    driver = new FirefoxDriver();
		}
		else if(Browsername.equalsIgnoreCase("Chrome")){
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\dell46\\eclipse-workspace\\MavenProjEclipse\\DriverWarehouse\\chromedriver1.exe");
		    driver = new ChromeDriver();
		}
		else if(Browsername.equalsIgnoreCase("IE")){
			System.setProperty("webdriver.ie.driver", "C:\\Users\\dell46\\eclipse-workspace\\MavenProjEclipse\\DriverWarehouse\\IEDriverServer.exe");
		   driver = new InternetExplorerDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.navigate().to("https://stage.talentoz.com/Weblogin.aspx");
		Thread.sleep(4000);
		
		driver.close();

	}

}
