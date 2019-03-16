package day7;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import util.Base;

public class DeleteCookie extends Base {
  @Test
  public void deleteCookie() throws InterruptedException {
	  driver.get("http://127.0.0.1:8080/htmldb/f?p=4500:1003:8626637103882335975::NO:::");
	  driver.findElement(By.xpath("//*[@type='text']")).sendKeys("sys");
	  driver.findElement(By.xpath("//*[@type='password']")).sendKeys("Newuser123");
	  driver.findElement(By.xpath("//*[@value='Login']")).click();
	  
	
	  driver.manage().deleteAllCookies();
	  
	  //**********two ways to check whethr it takes to login page after cookie is delete********************
	  driver.findElement(By.linkText("SQL")).click();
	  //driver.navigate().refresh(); //to refresh the page  

	  // **************************ways to check whether the page is login or not

	  //  Assert.assertEquals(driver.getTitle(), "HTML DB Login");
	//  Assert.assertEquals(  driver.findElement(By.xpath("//*[@type='text']")).isDisplayed(), true);
	 
	  Assert.assertTrue( driver.findElement(By.xpath("//*[@type='text']")).isDisplayed()); // to check the condition and return true or false
	Thread.sleep(3000);
	  	
	 

  }
}
