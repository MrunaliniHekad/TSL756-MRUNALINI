package in.lnt.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import util.BrowserSetup;

public class DragNDrop
{
	public static void main(String[] args) 
	{
		WebDriver driver=BrowserSetup.browserStart("chrome","https://jqueryui.com/droppable/");
		Actions action = new Actions(driver);
		driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
		
		WebElement srcElement = driver.findElement(By.id("draggable"));
		WebElement destElement = driver.findElement(By.id("droppable"));
		
		action.dragAndDrop(srcElement, destElement).perform();
		
	}
}
