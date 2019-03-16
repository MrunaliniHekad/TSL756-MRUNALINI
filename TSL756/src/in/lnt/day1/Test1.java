package in.lnt.day1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test1
{
	public static void main(String[] args) {
		
	System.setProperty("webdriver.chrome.driver",".\\Drivers\\chromedriver.exe ");
	WebDriver driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
	
	driver.findElement(By.cssSelector("input#txtUsername")).sendKeys("Admin");
	driver.findElement(By.cssSelector("input#txtPassword")).sendKeys("admin123");
	driver.findElement(By.cssSelector("input[value='LOGIN']")).click();
	driver.findElement(By.linkText("Welcome Admin")).click();
/*	try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}*/
	driver.findElement(By.linkText("Logout")).click();
}
}