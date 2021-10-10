package com.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Cavalry {
	
	public void capturescreen(WebDriver driver, String ssname) {		
		String date = new SimpleDateFormat("dd-MM-yyyy_HH-mm-ss").format(new Date());
		String newName = ssname+"_"+date.replaceAll("\\s","_");
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest = new File("C:\\Users\\dell46\\eclipse-workspace\\MavenProjEclipse\\Screenshots\\"
                +newName+".png");
		try {
			FileHandler.copy(src,dest);
		}catch(IOException e){
			System.out.println("Aww! Couldn't get a snap\t " +e.getMessage());
		}
		System.out.println("Screenshot Captured");
	}
	
	public void switchframe() {
		
	}

}
