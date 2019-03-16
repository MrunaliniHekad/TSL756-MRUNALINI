package in.lnt.day3;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import util.BrowserSetup;

public class ForLoop 
{
public static void main(String[] args) throws Exception 
{
				WebDriver driver = BrowserSetup.browserStart("chrome", "https://www.nseindia.com/");
				Actions action = new Actions(driver);
				//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

			FileInputStream fileIn = new FileInputStream("D:\\Screen.xlsx");
				XSSFWorkbook book = new XSSFWorkbook(fileIn);
				XSSFSheet sheet = book.getSheet("Sheet1");

				BrowserSetup.getScreenShot("screen1");
			
				
				for(int  i=0;i<=sheet.getLastRowNum();i++)
				{
					String Keyword=sheet.getRow(i).getCell(0).toString();
					driver.findElement(By.xpath("//*[@id=\"keyword\"]")).sendKeys(Keyword);
					WebElement web1=driver.findElement(By.xpath("//*[text()='"+Keyword+"']"));
					
					WebElement E=driver.findElement(By.xpath("//*[contains(text(),'"+Keyword+"')]"));;
					action.moveToElement(E).click(E).perform();
					String faceV=driver.findElement(By.xpath("//span[@id='face Value']")).getText();
					System.out.println("Face value is "+faceV);
					BrowserSetup.getScreenShot(Keyword);
						
				
				
					}
		}
		
}
		

	

