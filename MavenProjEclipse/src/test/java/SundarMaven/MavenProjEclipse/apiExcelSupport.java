package SundarMaven.MavenProjEclipse;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class apiExcelSupport {
	
	XSSFWorkbook wb;

	public apiExcelSupport() throws IOException {
		
		File src = new File("C:\\Users\\dell46\\eclipse-workspace\\MavenProjEclipse\\TestData\\APIData.xlsx");
		FileInputStream FIS = new FileInputStream(src);
	    wb = new XSSFWorkbook(FIS);		
	}
	
	public String getStringData(String sheetname, int row, int cell) {
		String value = wb.getSheet(sheetname).getRow(row).getCell(cell).getStringCellValue();
		return value;
	}
	
	public double getNumericData(String sheetname, int row, int cell) {
		double value = wb.getSheet(sheetname).getRow(row).getCell(cell).getNumericCellValue();
		return value;
	}
	
	public int rowcount(String sheetname) {
		int rowcount = wb.getSheet(sheetname).getPhysicalNumberOfRows();
		return rowcount;
	}
	
	public void closeex() throws IOException {
		wb.close();
	}
	
}
