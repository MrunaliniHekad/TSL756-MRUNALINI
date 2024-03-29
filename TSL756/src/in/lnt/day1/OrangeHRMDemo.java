package in.lnt.day1;

import java.util.concurrent.TimeUnit;
import util.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import util.BrowserSetup;
public class OrangeHRMDemo{

	public static void main(String[] args) throws InterruptedException {
		//System.setProperty("webdriver.chrome.driver",".\\Drivers\\chromedriver.exe ");
		WebDriver driver=BrowserSetup.browserStart("chrome","https://opensource-demo.orangehrmlive.com/");
		Actions action=new Actions(driver);
	
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		/*Implict way of giving time to load all the objects of AUT(application under test)
		 * >it is a Global wait*/
		
		/* Implict way of giving time to load all the objects of AUT(application under test)*/
	//	WebDriverWait wt = new WebDriverWait(driver, 30);
		/*we have to use this object for multiple combinations like setvisible,setinvisible*/
		
		
		//driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		
		driver.findElement(By.id("btnLogin")).click();
	//	
		
		action.moveToElement(driver.findElement(By.id("menu_admin_viewAdminModule"))).perform();
		action.moveToElement(driver.findElement(By.id("menu_admin_Organization"))).perform();
		action.click(driver.findElement(By.id("menu_admin_viewOrganizationGeneralInformation"))).perform();
		//Thread.sleep(3000);
		//we need time after clicking welcome to load the logout object
		// Thread.sleep is a feature of java and not of selenium so it is not recommended to use thread.sleep
		
		/*here we will use object of WebDriverWait to give wait time*/
	//	wt.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Logout")));
		driver.findElement(By.id("welcome")).click();
		action.click(driver.findElement(By.linkText("Logout"))).perform();
		//String title =driver.getTitle();
		
		//System.out.println("I am on"+title+"Page");
	
	
	}

}
