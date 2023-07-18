package readwrite;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Write_Excel {
	public static void main(String[] args) throws IOException {
		String path="C:\\Users\\Abhishek\\OneDrive\\Desktop\\Auto_SalePoint\\Excel_Files\\Test1.xlsx";
		
		File f= new File(path);
		FileInputStream fi= new FileInputStream(f);
		
		XSSFWorkbook wb= new XSSFWorkbook(fi);
		XSSFSheet sh= wb.getSheet("Sheet1");
		Row row= sh.getRow(1);
		Cell cell= row.createCell(2);
		cell.setCellValue("Checked");
		FileOutputStream fo= new FileOutputStream(f);
		wb.write(fo);
		fo.close();
		System.out.println("Done");
	}

}
