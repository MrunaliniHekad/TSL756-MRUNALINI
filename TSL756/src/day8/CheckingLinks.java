package day8;

import java.util.List;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;

import util.Base2;

public class CheckingLinks extends Base2 {
  @Test
  public void link() throws InterruptedException {
	  driver.get(" http://www.newtours.demoaut.com/ ");
List<WebElement>all= driver.findElements(By.xpath("//a"));
for(int i=0;i<all.size();i++)
{
	all=driver.findElements(By.xpath("//a"));// to avoid stale exception
	all.get(i).click();
	Thread.sleep(1000);
	driver.navigate().back();
	
}
	  
	  
  }
}
