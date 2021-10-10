package com.utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excelsupport {

	XSSFWorkbook WB;
	
	public Excelsupport(String path) {			
		try {
			FileInputStream FI = new FileInputStream(path);
		    WB= new XSSFWorkbook(FI);
		}catch(IOException e){
		   System.out.println("File cannot be found:\t" + e.getMessage());
		}		
	}
		
	public String getStringData(String sheetname, int row, int cell) {
		String sValue = WB.getSheet(sheetname).getRow(row).getCell(cell).getStringCellValue();
		return sValue;
	}
	
	public double getNumericData(String sheetname, int row, int cell) {
		double sValue = WB.getSheet(sheetname).getRow(row).getCell(cell).getNumericCellValue();
		return sValue;
	}
	
	public int getPhysicalRowCount(String sheetname) {
		int i = WB.getSheet(sheetname).getPhysicalNumberOfRows();
		int rows = i-1;
		return rows;
	}
	
	public void writeData(String path, String sheet, String Reqno) throws Exception {
		FileInputStream FI2 = new FileInputStream(path);
		XSSFWorkbook WB2 = new XSSFWorkbook(FI2);
	    XSSFSheet S2 = WB2.getSheet(sheet);	    
	    S2.createRow(1).createCell(0).setCellValue(1);
		S2.getRow(1).createCell(1).setCellValue(Reqno);
		FileOutputStream fout = new FileOutputStream(path);
		WB2.write(fout);
		WB2.close();		
	}
	
	public void closexel() {
		try {
			WB.close();
			System.out.println("Excel got closed");
		}catch(IOException e){
			System.out.println("Damn! Unable to Close, Come check this out\t" +e.getMessage());
		}
	}
}
