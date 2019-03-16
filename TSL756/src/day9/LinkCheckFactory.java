package day9;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LinkCheckFactory {
	private WebDriver driver;
	LinkCheckFactory(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
	@FindBy(tagName="a") List<WebElement> list;
	
	public void CheckLink()
	{
		for(int i=0;i<list.size();i++)
		{
			list=driver.findElements(By.xpath("//a"));
			list.get(i).click();
			
			try
			{
				Thread.sleep(1000);
			} 
			
			catch (InterruptedException e)
			{
			
				e.printStackTrace();
			}
			
			driver.navigate().back();
			
		}
	}

}
