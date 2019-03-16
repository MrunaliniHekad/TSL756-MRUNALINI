package util;


import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

public class Base {
public WebDriver driver;  // make it public because it must be access outside this package as well
  


@BeforeTest(alwaysRun=true)
 @Parameters("browser")
 public void beforeTest(String browser) {
	  
	 // driver= BrowserSetup.browserStart("chrome");
	 
	 	  if(browser.equalsIgnoreCase("firefox"))
	 	  driver=BrowserSetup.browserStart("firefox");
	 	  else if(browser.equalsIgnoreCase("chrome"))
	 		  driver=BrowserSetup.browserStart("chrome");
  }
  @AfterTest
  public void afterTest()
  {
	  driver.quit();
  }

}
