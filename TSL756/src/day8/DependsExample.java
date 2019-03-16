package day8;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import util.Base;

public class DependsExample extends Base{
  @Test
  public void test1() 
  {
	  driver.get("http://google.com");
	  Assert.assertEquals(driver.getTitle(), "Google");
  }
  
  @Test(dependsOnMethods ="test1")
  public void test2() 
  {
	  boolean display = driver.findElement(By.name("q")).isDisplayed();
	  Assert.assertTrue(display);
  }
  
  @Test(dependsOnMethods ="test2")
  public void test3() 
  {
	  String data ="Narendra Modi";
	 driver.findElement(By.name("q")).sendKeys(data);
//	
	 new WebDriverWait(driver,20).until(ExpectedConditions.elementToBeClickable(By.className("btnK")));
	 driver.findElement(By.name("btnK")).click();
	 
	 Assert.assertEquals(driver.getTitle(), data+"-Google");
	 Assert.assertTrue(driver.getTitle().contains(data));
	  
  }
}

