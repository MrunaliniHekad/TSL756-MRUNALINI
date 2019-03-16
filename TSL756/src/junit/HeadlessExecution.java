package junit;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.WebElement;

import util.BrowserSetup;

public class HeadlessExecution {
	static WebDriver driver;
//*************haedless execution can be done with help of:
	//1. HTML UNIT DRIVER 2.chromeOption 3. Phantom JS using Ghost Driver(not used now) 3.FireFoxOption**************
	@BeforeClass

				public static void setUpBeforeClass() throws Exception {
	//*************htmlunit driver*************************************	
//		
//		driver =BrowserSetup.browserStart("chrome");
//		driver = new HtmlUnitDriver(true);
		//		driver = new HtmlUnitDriver();  it is  possible without true but it will not support javaScript
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	//************************chromeOption******************************	
		
					System.setProperty("webdriver.chrome.driver",".\\Drivers\\geckodriver.exe");
			FirefoxOptions op =new FirefoxOptions();
					op.addArguments("---headless");
					op.addArguments("----start- maximized");
					driver=new FirefoxDriver(op);
					
					//driver.manage().window().maximize();
	//	driver.manage().window().maximize();  // maximize the window
			
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	driver.quit();
	}

	@Test
	public void test() {
		
		driver.get("https://www.seleniumhq.org/");
		assertEquals("Google", driver.getTitle());
	
		assertTrue(driver.findElement(By.linkText("Maven users")).isDisplayed());
		
	}

}
