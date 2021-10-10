package SundarMaven.MavenProjEclipse;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class apiConfigSupport {

	Properties prop;
	
	public apiConfigSupport() {
		
		File src = new File("C:\\Users\\dell46\\eclipse-workspace\\MavenProjEclipse\\TestData\\apiconfig.properties");
		try {
			FileInputStream fc = new FileInputStream(src);
		    prop = new Properties();
			prop.load(fc);
		} catch (IOException e) {
			System.out.println("Dude, Something's bad with config file loading \t" +e.getMessage());
		}		
		}
	
	public String getKeyValue(String Key) {
		return prop.getProperty(Key);
	}
	}
	
	

