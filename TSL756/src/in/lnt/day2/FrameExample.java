package in.lnt.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import util.BrowserSetup;

public class FrameExample
{
	public static void main(String[] args) 
	{
		WebDriver driver = BrowserSetup.browserStart("chrome","file:///C:/Users/vshadmin/Desktop/frame.html");
		driver.switchTo().frame(0);
		driver.findElement(By.name("q")).sendKeys("LNT");
		driver.switchTo().defaultContent();	
		//search frame inside frame we need to switch back to the before frame thats and then we need to go on other frame
		driver.switchTo().frame("new");
		driver.findElement(By.name("userName")).sendKeys("123");
		driver.switchTo().parentFrame();			//switch back to parent folder
		driver.switchTo().frame(2);
		//driver.switchTo().frame( driver.findElement(By.xpath("/html/body/iframe[3]")));
		//we can use anything xpath int value or name 
		driver.findElement(By.name("p_t01")).sendKeys("system");
		driver.findElement(By.name("p_t02")).sendKeys("Newuser123");
		driver.findElement(By.cssSelector("input[value='Login']")).click();
		
	}
}
