package com.tozTCs;

import java.io.IOException;

import org.testng.annotations.Test;

public class TozLogin { 
	
	@Test
	public void Main() throws InterruptedException, IOException {
		
		String path = "C:\\Users\\dell46\\eclipse-workspace\\MavenProjEclipse\\TestData\\Data.xlsx";
		
		BaseClass BC = new BaseClass();
	    BC.setup(path);
	    BC.envsetup();
		BC.Enter();
		BC.Exit();	
		BC.teardown();		
	}
	

}
