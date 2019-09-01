package pkg.Util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Cls_writeData {

	public static Workbook inwb;
	public static int sheetcount;
	public static XSSFWorkbook outwb;
	public static Sheet insheet;
	public static XSSFSheet outsheet;
	public static Cls_readData crd;
	
	private static void copycontent(Sheet insheet, XSSFSheet outsheet) {
		int rowCount=insheet.getLastRowNum();
        System.out.println(rowCount+" rows in inputsheet "+insheet.getSheetName()); 
         
          int currentRowIndex=0;
          if(rowCount>0) {
        	  Iterator rowIterator=insheet.iterator();
        	  while(rowIterator.hasNext()) {
        		  int currentCellIndex=0;
        		  Iterator cellIterator=((Row) rowIterator.next()).cellIterator();
        		  	while(cellIterator.hasNext()) {
        		  		//  Creating new Row, Cell and Input value in the newly created sheet. 
        		  		String cellData=cellIterator.next().toString();
        		  		if(currentCellIndex==0)
        		  			outsheet.createRow(currentRowIndex).createCell(currentCellIndex).setCellValue(cellData);
        		  		else
        		  			outsheet.getRow(currentRowIndex).createCell(currentCellIndex).setCellValue(cellData);
        		  			currentCellIndex++;
        		  	}
        		  	currentRowIndex++;
        	  }
        	  System.out.println((currentRowIndex-1)+" rows added to outputsheet "+outsheet.getSheetName());
        	  System.out.println();
		}
	}
	
	//Copy Data From One Excel To Another Using Selenium WebDriver
	
	public static void copysheet(String filepath, String outfilepath) throws IOException {
		inwb=Cls_readData.getWorkbook(filepath);
		sheetcount=Cls_readData.getSheetcount(filepath);
		System.out.println("Input sheetCount: "+sheetcount);
		
		FileOutputStream fos=new FileOutputStream(outfilepath);
		outwb=new XSSFWorkbook();
		for(int i=0;i<sheetcount;i++) { 
				insheet=inwb.getSheetAt(i); 
				String insheetname=inwb.getSheetName(i);
				outsheet=outwb.createSheet(insheetname); 
				// Create and call method to copy the sheet and content in new workbook. 
				copycontent(insheet,outsheet); 
        }
		outwb.write(fos); 
		fos.close(); 
	}

	//Add new column in the excel
	public static void addnewcolumn(String filepath, String ColumnName) {
		inwb=Cls_readData.getWorkbook(filepath);
	    Sheet datatypeSheet = inwb.getSheetAt(0);
	    Iterator<Row> iterator = datatypeSheet.iterator();

	    // Add additional column for results
	    while (iterator.hasNext()) {
	        Row currentRow = iterator.next();
	        Cell cell = currentRow.createCell(currentRow.getLastCellNum(), CellType.STRING);
	        if(currentRow.getRowNum() == 0)
	            cell.setCellValue(ColumnName);
	    }
	}
	
	//Write text in the newly added column
	
	
}
