package in.lnt.day3;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import util.BrowserSetup;

public class NseIndia
{
	public static void main(String[] args) 
	{
		WebDriver driver =BrowserSetup.browserStart("chrome","https://www.nseindia.com/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		BrowserSetup.getScreenShot("snehal");
		Actions action= new Actions(driver);
		driver.findElement(By.xpath("//*[@id=\"keyword\"]")).sendKeys("reliance industries limited"); // xpath of search tab
	
		driver.findElement(By.xpath("//*[@id=\"ajax_response\"]/ol/li/a/b")).click();   // xpath of reliance Industries 
		/*
		 * absolute x-path
		 * */
		
		/*WebElement element=driver.findElement(By.linkText("52 week low"));
		//WebElement high=driver.findElement(By.xpath("//*[@id=\"fundamentals_tbl\"]/ul/li[8]"));
		String high= driver.findElement(By.xpath("//div[@id='fundamentals_tbl']//ul//li[8]")).getText();
		WebElement low=driver.findElement(By.xpath("//*[@id=\"fundamentals_tbl\"]/ul/li[9]"));
		//System.out.println(high.getText());
		System.out.println("high"+high);
		System.out.println(low.getText());*/
		/*
		 * relative x-path
		 * */
		
		String faceHigh=driver.findElement(By.xpath("//*[@id='high52']/font")).getText();
		System.out.println("52 high value "+faceHigh);
		
		String faceLow=driver.findElement(By.xpath("//*[@id='low52']/font")).getText();
		System.out.println("52 low value "+faceLow);
	}
}
