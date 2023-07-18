package readwrite;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Read_Excel {
	public static void main(String[] args) throws IOException {
		File f= new File("C:\\Users\\Abhishek\\OneDrive\\Desktop\\Auto_SalePoint\\Excel_Files\\Test1.xlsx");
		FileInputStream fi= new FileInputStream(f);
		
		//open workbook
		XSSFWorkbook wb= new XSSFWorkbook(fi);
		
		//go to sheet
		XSSFSheet sh= wb.getSheet("Sheet1");
		
		//get how many rows are occupied
		int lastrow= sh.getLastRowNum();
		System.out.println("how many rows are occupied: "+lastrow);
		
		//get how many cols are occupied in 1st row
		int lastcol= sh.getRow(1).getLastCellNum();
		System.out.println("columns occupied in 1st row: "+lastcol);
		
		//get rows and cells
		XSSFRow row1= sh.getRow(1);
		XSSFCell cell= row1.getCell(0);
		System.out.println(cell);
		
	}
}
