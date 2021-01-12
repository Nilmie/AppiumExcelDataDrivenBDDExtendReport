package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	 public static String readExcel(int row,  int col, String fileName,String sheetName) throws IOException{
		
		   
		 
		   File file =    new File(fileName);

		   	DataFormatter formatter = new DataFormatter();
		    FileInputStream inputStream = new FileInputStream(file);
			 
		    XSSFWorkbook ExcelWBook = new XSSFWorkbook(inputStream);
		   
		    XSSFSheet excelSheet = ExcelWBook.getSheet(sheetName);
		   return formatter.formatCellValue(excelSheet.getRow(row).getCell(col));
		   

         
	 }

}