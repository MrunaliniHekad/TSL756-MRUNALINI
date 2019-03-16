package day9;

import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class GridExample {
	  WebDriver driver;
  @Test

  public void grid() throws Exception {

	  

	  driver.get(" https://www.seleniumhq.org/");
	  Assert.assertEquals(driver.getTitle(), " Selenium - Web Browser Automation");
	  driver.quit();
	  
  }
  
  @BeforeTest
  @Parameters("browser")
  public void BeforeTest(String browser)throws Exception
  {
	  DesiredCapabilities des= null;
	  if(browser.equalsIgnoreCase("chrome"))
	  {
 des=  DesiredCapabilities.chrome();
	  des.setPlatform(Platform.WINDOWS);
	  des.setBrowserName("chrome");
	  
  }
	  else if(browser.equalsIgnoreCase("firefox"))
	  {
 des=  DesiredCapabilities.chrome();
		  des.setPlatform(Platform.WINDOWS);
		  des.setBrowserName("firefox");
	  }
	 // driver=new RemoteWebDriver(new URL("http://192.168.100.159:4444/wd/hub"), des);
  }
  @org.testng.annotations.AfterTest
  public void AfterTest()
  {
	  driver.quit();	  
  }
}
