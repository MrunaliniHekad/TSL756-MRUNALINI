package util;


import org.testng.annotations.BeforeTest;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

public class Base2 {
public WebDriver driver;  // make it public because it must be access outside this package as well
  


@BeforeTest(alwaysRun=true)

 public void beforeTest( ) {
	  
	  driver= BrowserSetup.browserStart("chrome");
}


  @AfterTest
  public void afterTest()
  {
	  driver.quit();
  }

}
