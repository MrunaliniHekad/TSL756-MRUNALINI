package in.lnt.day3;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Write
{
	public static void main(String[] args) throws Exception
	{
		FileInputStream fileIn = new FileInputStream("D:\\Book1.xlsx");                          
		XSSFWorkbook book=new  XSSFWorkbook(fileIn);                                            
		XSSFSheet sheet=book.getSheet("Sheet1");        
		
		sheet.getRow(2).getCell(1).setCellValue("LNT");
		sheet.getRow(0).createCell(2).setCellValue("LNT");
		//sheet.createRow(10).createCell(10).setCellValue("Snehal");
		//sheet.createRow(12).createCell(12).setCellValue("Simran");
		FileOutputStream fileOut = new FileOutputStream("D:\\Book2.xlsx");
		book.write(fileOut);
	}
	         
}
