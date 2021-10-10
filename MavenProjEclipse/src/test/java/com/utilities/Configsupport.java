package com.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Configsupport {
	
	Properties prop;
	
	public Configsupport(){		
		    File src = new File("C:\\Users\\dell46\\eclipse-workspace\\MavenProjEclipse\\TestData\\configuration.properties");		
		try{			
			FileInputStream cfig = new  FileInputStream(src); 		
		    prop = new Properties(); // To read Configuration files
		    prop.load(cfig);
		}catch (IOException e) {
			System.out.println("Seriously? No Config file readable? \t" +e.getMessage());
		}		
	}
	
	public String getConfigData(String key) {
		return prop.getProperty(key);
	}

}
