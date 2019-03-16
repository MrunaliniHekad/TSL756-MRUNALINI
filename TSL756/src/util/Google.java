package util;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.SendKeysAction;

public class Google {
public static void main(String[] args) {
	
	WebDriver driver=BrowserSetup.browserStart("chrome", "file://192.168.100.162/Share%20Folder/AutomationTesting/frame.html");
	//Actions action=new Actions(driver);
	//driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
	driver.switchTo().frame(0);
	driver.findElement(By.name("q")).sendKeys("LNT");
     driver.switchTo().defaultContent();
 	driver.switchTo().frame(1);
	driver.findElement(By.name("userName")).sendKeys("123");
    driver.switchTo().defaultContent();
    driver.switchTo().frame(driver.findElement(By.xpath("/html/body/iframe[3]")));
	driver.findElement(By.name("p_t01")).sendKeys("system");
	driver.findElement(By.name("p_t02")).sendKeys("Newuser123");
	driver.findElement(By.cssSelector("input[value='Login']")).click();
	/*WebElement src=driver.findElement(By.id("draggable"));
	WebElement des=driver.findElement(By.id("droppable"));
	action.dragAndDrop(src, des).perform();*/
	//driver.quit();
	/*WebElement search=driver.findElement(By.name("q"));
	
	action.moveToElement(search).keyDown(Keys.SHIFT).sendKeys(search,"lnt").keyUp(Keys.SHIFT)
	.sendKeys(search,Keys.ENTER).perform();*/
}
}
