package com.tozTCs;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ApplyClaim {
	
	@Test
	public void Main() throws InterruptedException, IOException {
		
		String path = "C:\\Java\\Claims data.xlsx";
		
		BaseClass BC = new BaseClass();
		BC.setup(path);
		BC.envsetup();
		BC.Enter();
		
		WebDriver driver =BC.driver;
		
		//Entering Claim menu
		WebElement claimmenu = driver.findElement(By.xpath("//*[@id='mainmenuHdr8']/a"));
		Actions A1 = new Actions(driver);
		A1.moveToElement(claimmenu).build().perform();
		System.out.println("*****Clicked Claim Menu********");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Entering Apply Claim page
		WebElement Applyclaim = driver.findElement(By.xpath("//*[@id='132']"));
		A1.moveToElement(Applyclaim).perform();
		Thread.sleep(5000);
		Applyclaim.getText();
		System.out.println("Menu clicked on is:\t" +Applyclaim.getText());
		A1.click(Applyclaim).perform();
		Thread.sleep(5000);
		
		
		
		
		
		BC.teardown();
		
	}

}
