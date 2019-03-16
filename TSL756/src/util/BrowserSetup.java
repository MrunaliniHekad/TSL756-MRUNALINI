package util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;

public class BrowserSetup
{
	 static WebDriver driver;
	public static WebDriver browserStart(String name)
	{
	
		if(name.equalsIgnoreCase("chrome"))
		{
		System.setProperty("webdriver.chrome.driver",".\\Drivers\\chromedriver.exe ");
		driver=new ChromeDriver();
		}
		else if(name.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver",".\\Drivers\\geckodriver.exe ");
			 driver=new FirefoxDriver();
		}
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		return driver;
	}
	
	public static WebDriver browserStart(String name,String url)
	{
		WebDriver driver=browserStart(name);
		driver.get(url);
		return driver;
	}
	
	public static String timestamp() 
	{
        return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
	}
	/*
	 * for displaying time in screenshot create this method (static) and use in line no 62
	 * */
	
	public static void getScreenShot(String name)
	{
		/*Date d = new Date();
		String date=d.toString().replaceAll(" ","_").replaceAll(":","_");*/
		
		TakesScreenshot screenShort=(TakesScreenshot)driver;
		File src= screenShort.getScreenshotAs(OutputType.FILE);
	
		try {
			FileHandler.copy(src, new File(".\\"+name+timestamp()/*+date {line no 52-53 (optional)}*/+".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("error");
		}
	}

	
}