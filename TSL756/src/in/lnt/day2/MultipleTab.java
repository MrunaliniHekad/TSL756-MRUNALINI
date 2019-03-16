package in.lnt.day2;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import util.BrowserSetup;

public class MultipleTab 
{
	public static void main(String[] args) 
	{
		WebDriver driver=BrowserSetup.browserStart("chrome","https://www.seleniumhq.org/");
		WebElement ele= driver.findElement(By.linkText("Download"));
		
		String parentId=driver.getWindowHandle();
		
		List<WebElement> ls= driver.findElements(By.xpath("/html/body/div[3]/div[1]/ul/li"));
		for (WebElement webElement : ls)
		{
			new Actions(driver)
			.keyDown(Keys.CONTROL)
			.click(webElement)
			.keyUp(Keys.CONTROL)
			.perform();
		}
		
		Set<String>allWin= driver.getWindowHandles();
		Iterator< String> itr= allWin.iterator();
		while(itr.hasNext())
		{
			String id=itr.next();
			System.out.println(id);
			if(!id.equals(parentId))
			{
				driver.switchTo().window(id);
				System.out.println("you are on "+driver.getTitle());
				driver.close();//closing tab or window
			}
			driver.switchTo().window(parentId);
		}
		
	}
	}

