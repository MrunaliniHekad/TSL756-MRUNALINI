package in.lnt.day2;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;

import util.BrowserSetup;

public class ScreenShot
{
	public static void main(String[] args) 
	{
		WebDriver driver=BrowserSetup.browserStart("firefox","https://jqueryui.com/droppable/");
		Actions action = new Actions(driver);
		driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
		
		WebElement srcElement = driver.findElement(By.id("draggable"));
		WebElement destElement = driver.findElement(By.id("droppable"));
		
		action.dragAndDrop(srcElement, destElement).perform();
		//driver.switchTo().defaultContent();//for chome they give same screenshot and firefox give the frame screenshot
		BrowserSetup.getScreenShot("abc");
	
	}
}
