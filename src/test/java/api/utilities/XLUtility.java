package api.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtility {
	
	public FileInputStream fi;  //excel ko read krta hai
	public FileOutputStream fo;  // excel me kuchh likhna ho tb use krna hota hai
	public XSSFWorkbook workbook; // pura excel file means jitne sheet hoti hai sb workbook me hoti hai
	public XSSFSheet sheet; // workbook ke under ek sheet
	public XSSFRow row; // for row
	public XSSFCell cell; // for column means single box
	public CellStyle style; // font ki formatting ke liye jaise bold , style etc
	String path;

	public XLUtility(String path) {
		this.path = path;
	}
	
	public int getRowCount(String sheetname) throws IOException {
		 fi = new FileInputStream(path);
		 workbook = new XSSFWorkbook(fi);
		 sheet = workbook.getSheet(sheetname);
		 int rowCount = sheet.getLastRowNum();
		 workbook.close();
		 fi.close();
		 return rowCount;
		 
	}
	
	public int getCellCount(String sheetName, int rownum) throws IOException {
		fi = new FileInputStream(path);
		 workbook = new XSSFWorkbook(fi);
		 sheet = workbook.getSheet(sheetName);
		 row = sheet.getRow(rownum);
		 int cellCount = row.getLastCellNum();
		 workbook.close();
		 fi.close();
		 return cellCount;
	}
	
	public String getCellData(String sheetName, int rownum,int column) throws IOException {
		fi = new FileInputStream(path);
		 workbook = new XSSFWorkbook(fi);
		 sheet = workbook.getSheet(sheetName);
		 row = sheet.getRow(rownum); // give particular row data
		 cell = row.getCell(column); // take data of particular cell or column
		 DataFormatter formatter = new DataFormatter();  // convert data into string 
		 String data;
		 
		 try {
			 
		 data = formatter.formatCellValue(cell);
		 
		 }catch(Exception e) {
		   data = "";	 
		 }
		 
		 workbook.close();
		 fi.close();
		 return data;
	}
	
	
}
