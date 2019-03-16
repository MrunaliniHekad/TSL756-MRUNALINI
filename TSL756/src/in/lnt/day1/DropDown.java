package in.lnt.day1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDown
{
	public static void main(String[] args) 
	{
	System.setProperty("webdriver.chrome.driver",".\\Drivers\\chromedriver.exe ");
	WebDriver driver=new ChromeDriver();
	driver.get("http://www.blazedemo.com/");
	Select select=new Select(driver.findElement(By.name("fromPort")));
	select.selectByValue("Boston");
	//select.selectByIndex(4);
	System.out.println(driver.findElement(By.name("fromPort")).getText());
	
//	List<WebElement> list = select.getOptions();
//	for(int i=0; i<list.size(); i++)
//	{
//		System.out.println(list.get(i).getText());
//	}	
//	
	new Select(driver.findElement(By.name("toPort"))).selectByVisibleText("Rome");
	driver.findElement(By.cssSelector("input[value='Find Flights']")).click();
	
	driver.findElement(By.cssSelector("input[value='Choose This Flight']")).click();
	
	//List<WebElement> all = driver.findElement(By.cssSelector("input[value='Choose This Flight']")).click();
	driver.findElement(By.cssSelector("input[name='inputName']")).sendKeys("shalmali kulkarni");

	driver.findElement(By.cssSelector("input[name='address']")).sendKeys("Hiranandani Estate");
	driver.findElement(By.cssSelector("input[name='city']")).sendKeys("Thane");
	driver.findElement(By.cssSelector("input[name='state']")).sendKeys("Maharashtra");
	driver.findElement(By.cssSelector("input[name='zipCode']")).sendKeys("400607");
	Select select1=new Select(driver.findElement(By.name("cardType")));
	select1.selectByVisibleText("Visa");
	driver.findElement(By.cssSelector("input[name='creditCardNumber']")).sendKeys("5201365479914102");
	driver.findElement(By.cssSelector("input[name='creditCardMonth']")).sendKeys("January");
	driver.findElement(By.cssSelector("input[name='creditCardYear']")).sendKeys("2022");
	driver.findElement(By.cssSelector("input[name='nameOnCard']")).sendKeys("Shalmali Kulkarni");
	//driver.findElement(By.cssSelector("select[name=['cardType']")).sendKeys("2022");
	
	//driver.findElement(By.cssSelector("label[class='checkbox']")).click();
	driver.findElement(By.cssSelector("input[name='rememberMe']")).click();
	driver.findElement(By.cssSelector("input[value='Purchase Flight']")).click();
	
	
	}
}