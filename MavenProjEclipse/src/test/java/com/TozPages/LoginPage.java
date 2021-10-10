package com.TozPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.tozTCs.BaseClass;
import com.utilities.Excelsupport;

public class LoginPage {
	
	WebDriver driver;	
	BaseClass BC = new BaseClass();

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(how=How.XPATH,using="//*[@id=\'txt_name\']")
	WebElement username;
	
	@FindBy(how=How.XPATH,using="//*[@id=\'txt_pass\']")
	WebElement password;
	
	@FindBy(how=How.XPATH,using="//*[@id=\'btn_submit\']")
	WebElement loginbtn;
	
	public void verifylogin(Excelsupport exsupport) throws InterruptedException {		
		username.sendKeys(exsupport.getStringData("Sheet2", 1, 1));
		password.sendKeys(exsupport.getStringData("Sheet2", 1, 2));
		loginbtn.click();
		System.out.println("Waiting to be logged in...");
		Thread.sleep(10000);
	}

}
