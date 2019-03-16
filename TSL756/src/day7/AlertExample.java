package day7;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import util.Base;

@Test
public class AlertExample extends Base {
  public void alertTest() throws InterruptedException{
	  
	  driver.get("https://www.magneticautomation.in/2019/01/alert-example.html");
	  

	  Thread.sleep(4000);
	  driver.findElement(By.xpath("//button [@onclick='myFunction1()']")).click();
	  Alert A = driver.switchTo().alert();
	  String txt = A.getText();
	  
	  System.out.println(txt);
	  Thread.sleep(4000);
	  A.accept();
	  Thread.sleep(2000);
	  
	  driver.findElement(By.xpath("//button [@onclick='myFunction()']")).click();
	  //driver.findElement(arg0)
	  Alert Alert = driver.switchTo().alert();
	  Alert.getText();
	  Thread.sleep(3000);
	  Alert.sendKeys("sys");
	  Thread.sleep(4000);
	  Alert.accept();
	  
	  Alert.dismiss();
	 


	  
	  
	  
	  
  }
}
