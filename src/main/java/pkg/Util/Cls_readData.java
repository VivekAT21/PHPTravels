//Reading Multiple Rows from excel using Apache POI in Selenium WebDriver
package pkg.Util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import pkg.BaseClass.Cls_Base;

public class Cls_readData extends Cls_Base {
	
	public Cls_readData() throws FileNotFoundException {
		super();
	}

	public static String filepath;
	public static String outputfilepath;
	public static Sheet sheetname;
	public static int sheetcount;
	public static Workbook wb;
	public static Properties prop;
	public static String sname;
	public static int rowcount = 0;
	public static int colcount = 0;
	//public static Object[][] celldata = null;
	
	public static Workbook getWorkbook(String filepath) {
		try {
			FileInputStream fis = null; 
			fis = new FileInputStream(filepath);
			
			wb = WorkbookFactory.create(fis);
			} catch (EncryptedDocumentException e) {
				System.out.println("1st Error is: " + e);
				e.printStackTrace();
			} catch (IOException e) {
				System.out.println("2nd Error is: " + e);
				e.printStackTrace();
			}
		return wb;
	}
	
	public static int getSheetcount(String filepath) {
		sheetcount = getWorkbook(filepath).getNumberOfSheets();
		return sheetcount;
	}
	
	public static String getSheetAt(String filepath, int index) {
	for (int i=0; i<=index; i++) {
			sname = getWorkbook(filepath).getSheetName(i);
		}
		return sname;
	}
	
	public static int getRowcont(String filepath, int index) {
		sname = getSheetAt(filepath, index);
		sheetname = getWorkbook(filepath).getSheet(sname);
		rowcount = sheetname.getPhysicalNumberOfRows();
		return rowcount;
	}
	
	public static Sheet getSheet(String filepath, int index) {
		sname = getSheetAt(filepath, index);
		sheetname = getWorkbook(filepath).getSheet(sname);
		return sheetname;
	}
	
	
	public static int getColcount(String filepath, int index) {
		sname = getSheetAt(filepath, index);
		sheetname = getWorkbook(filepath).getSheet(sname);
		colcount = sheetname.getRow(0).getPhysicalNumberOfCells();
		return colcount;
	}
	
	public static Object[][] getData(String filepath, int index) {
		sname = getSheetAt(filepath, index);
		sheetname = getWorkbook(filepath).getSheet(sname);
		rowcount = getRowcont(filepath, index)-1;
		colcount = getColcount(filepath,index);
		
		Object[][] celldata = new Object[rowcount][colcount];
		for (int i=0; i<rowcount; i++) {
			for (int j=0; j<colcount; j++) {
				celldata[i][j] = sheetname.getRow(i+1).getCell(j).toString();
				System.out.print(celldata[i][j]+" | ");
			}System.out.println();
		}
		return celldata;
	}
}
