package in.lnt.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import util.BrowserSetup;

public class Google 
{
	public static void main(String[] args) 
	{
		WebDriver driver = BrowserSetup.browserStart("chrome","https://www.google.com/");
		Actions action = new Actions(driver);
		WebElement search= driver.findElement(By.name("q")); //find element
		
		Action act=action.moveToElement(search)
		.keyDown(Keys.SHIFT) // when we want to user for longer time
		.sendKeys(search, "lnt")
		.keyUp(Keys.SHIFT)
		//1).contextClick(search)//for right click
		//2).doubleClick(search)//used to double click in  this case it select the sentence
		//3)
		.sendKeys(search, Keys.ENTER)//when we want to use for single time
		.build();
		
		act.perform();
		
	}
}
