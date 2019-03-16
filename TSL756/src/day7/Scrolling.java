package day7;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import util.Base;

public class Scrolling extends Base{
  @Test
  public void scroll() throws InterruptedException {
	  JavascriptExecutor js=(JavascriptExecutor)driver;
	  driver.get(" https://www.seleniumhq.org/  ");
	  
	  
	  //*****it will scroll till selenium blog***************
  js.executeScript("arguments[0].scrollIntoView();",driver.findElement(By.linkText("Selenium blog"))); //argument[0] because only one argumnet is passed if e passsed two then it will come 1
 Thread.sleep(3000);

 // scroll up************that is why -700 if we have to scroll down then 700  
	  
	  js.executeScript("window.scrollBy(0,-700)");
	  Thread.sleep(6000);
	  
	  //**********scroll at end of page*********
	  js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	  Thread.sleep(6000);
	  
	  
//	  ***scroll at begin of page***********
	  js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
	  Thread.sleep(6000);
	  
  }
}
