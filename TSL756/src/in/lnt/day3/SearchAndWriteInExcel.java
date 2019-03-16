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

public class SearchAndWriteInExcel {
	public static void main(String[] args) throws Exception {
		WebDriver driver = BrowserSetup.browserStart("chrome", "https://www.nseindia.com/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		FileInputStream fileIn = new FileInputStream("D:\\NseIndia.xlsx");
		XSSFWorkbook book = new XSSFWorkbook(fileIn);
		XSSFSheet sheet = book.getSheet("Sheet1");

		BrowserSetup.getScreenShot("screen1");
		Actions action = new Actions(driver);

		driver.findElement(By.xpath("//*[@id=\"keyword\"]")).sendKeys("Mahindra & Mahindra Limited");
		String wb = driver.findElement(By.xpath("//*[@id=\"ajax_response\"]/ol/li[1]")).getText();

		sheet.createRow(1).createCell(0).setCellValue(wb);
		driver.findElement(By.xpath("//*[@id=\"ajax_response\"]/ol/li/a/b")).click();

		BrowserSetup.getScreenShot("screen2");
		String faceHigh = driver.findElement(By.xpath("//*[@id='high52']/font")).getText();
		System.out.println("52 high value " + faceHigh);

		String faceLow = driver.findElement(By.xpath("//*[@id='low52']/font")).getText();
		System.out.println("52 low value " + faceLow);

		driver.findElement(By.xpath("//*[@id=\"keyword\"]")).sendKeys("Bajaj Finserv Limited");
		String wb1 = driver.findElement(By.xpath("//*[@id=\"ajax_response\"]/ol/li[1]")).getText();

		sheet.createRow(2).createCell(0).setCellValue(wb1);
		driver.findElement(By.xpath("//*[@id=\"ajax_response\"]/ol/li/a/b")).click();
		BrowserSetup.getScreenShot("screen3");

		String faceHigh1 = driver.findElement(By.xpath("//*[@id='high52']/font")).getText();
		System.out.println("52 high value " + faceHigh1);

		String faceLow1 = driver.findElement(By.xpath("//*[@id='low52']/font")).getText();
		System.out.println("52 low value " + faceLow1);

		driver.findElement(By.xpath("//*[@id=\"keyword\"]")).sendKeys("Hindustan Unilever Limited");
		String wb2 = driver.findElement(By.xpath("//*[@id=\"ajax_response\"]/ol/li[1]")).getText();

		sheet.createRow(3).createCell(0).setCellValue(wb2);
		driver.findElement(By.xpath("//*[@id=\"ajax_response\"]/ol/li/a/b")).click();
		BrowserSetup.getScreenShot("screen4");

		String faceHigh2 = driver.findElement(By.xpath("//*[@id='high52']/font")).getText();
		System.out.println("52 high value " + faceHigh2);

		String faceLow2 = driver.findElement(By.xpath("//*[@id='low52']/font")).getText();
		System.out.println("52 low value " + faceLow2);

		FileOutputStream fileOut = new FileOutputStream("D:\\Screen.xlsx");
		book.write(fileOut);

	}
}
