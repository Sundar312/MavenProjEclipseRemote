package com.learning;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class screenShot {
	
	TakesScreenshot tss;
	
	public screenShot(WebDriver driver) {
	    tss = (TakesScreenshot)driver;
	}
	
	public void takescreenshot(String ssname) throws IOException{	
		try {
		File filesrc = tss.getScreenshotAs(OutputType.FILE);
		File filedest = new File("C:\\Users\\dell46\\eclipse-workspace\\MavenProjEclipse\\Screenshots\\"+ssname+ ".png");
		FileUtils.copyFile(filesrc, filedest);
		System.out.println("Screenshot captured");
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}	
	}
}
