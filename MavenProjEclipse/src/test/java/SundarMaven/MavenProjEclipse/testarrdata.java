package SundarMaven.MavenProjEclipse;

import java.io.IOException;

import org.testng.annotations.Test;

public class testarrdata {
	
	@Test
	public void convertMyData2Arr() throws IOException {
			
		apiExcelSupport ex = new apiExcelSupport();		
		
		int rc = ex.rowcount("Sheet1");
		System.out.println(rc);
		
		String a[][] = new String[rc][3];
		
		for(int i=2;i<rc;i++) {
			for(int j=1;j<3;j++) {				
			  a[i-2][j-1] = ex.getStringData("Sheet1", i, j);
			}
		}
		
		System.out.println(a[5][1]);
	    ex.closeex();
		
	}
	
	

}
