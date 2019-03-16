package in.lnt.day3;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

import util.BrowserSetup;

public class Read
{
	public static void main(String[] args) throws Exception
	{
		FileInputStream fileIn = new FileInputStream("D:\\Book1.xlsx");                            //taking file as input
		XSSFWorkbook book=new  XSSFWorkbook(fileIn);                                              // for reading Workbook
				XSSFSheet sheet=book.getSheet("Sheet1");                                                   //for reading Sheet
				for(int i=0;i<=sheet.getLastRowNum();i++)
				{
					String data= sheet.getRow(i).getCell(0).toString();                                            //for reading cell
					System.out.print(data);
					String data1= sheet.getRow(i).getCell(1).toString();                                            //for reading cell
					System.out.println(" "+data1);
				}
				
				WebDriver driver=BrowserSetup.browserStart("chrome","http://127.0.0.1:8080/htmldb/f?p=4550:11:4546249387511957955::NO:::");
	}
}
