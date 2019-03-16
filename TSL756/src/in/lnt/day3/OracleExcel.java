package in.lnt.day3;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import util.BrowserSetup;

public class OracleExcel
{
	public static void main(String[] args) throws Exception
	{
		WebDriver driver=BrowserSetup.browserStart("chrome","http://127.0.0.1:8080/htmldb/f?p=4550:11:4546249387511957955::NO:::");
		FileInputStream fileIn = new FileInputStream("D:\\Book1.xlsx");                            //taking file as input
		XSSFWorkbook book=new  XSSFWorkbook(fileIn);                                              // for reading Workbook
				XSSFSheet sheet=book.getSheet("Sheet1");                                                   //for reading Sheet
				for(int i=0;i<=sheet.getLastRowNum();i++)
				{
					String data= sheet.getRow(i).getCell(0).toString();                                         
					System.out.print(data);
					
					String data1= sheet.getRow(i).getCell(1).toString();                                           
					System.out.println(" "+data1);
					
					driver.findElement(By.cssSelector("input#P11_USERNAME")).clear();
					driver.findElement(By.cssSelector("input[type='password']")).clear();
					driver.findElement(By.cssSelector("input#P11_USERNAME")).sendKeys(data);
					driver.findElement(By.cssSelector("input[type='password']")).sendKeys(data1);
					driver.findElement(By.cssSelector("input[value='Login']")).click();
				
					if (driver.getTitle().equals("Oracle"))
					{
					driver.findElement(By.cssSelector("img[title='Logout']")).click();///html/body/form/a[4]/img
					driver.findElement(By.cssSelector("a.htmldbInstruct")).click();
					System.out.println("login done");
					System.out.println("--------------------------------------------------------------------------");
					}
					else
					{
						System.out.println("login fail");
						System.out.println("--------------------------------------------------------------------------");
					}
				
				
			}
				
				
	}
}
