package in.lnt.day4;

import org.testng.annotations.Test;

import util.BrowserSetup;
import util.Excel;

import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

public class Para {
	WebDriver driver;

	@Test(dataProvider = "dp")
  
  public void Login(String UserName, String Password) // no of parameter must be equal to number of column mention in
  { 
	  driver.get("http://127.0.0.1:8080/htmldb");
	  driver.findElement(By.xpath("//*[@type='text']")).sendKeys(UserName);
	  driver.findElement(By.xpath("//*[@type='password']")).sendKeys(Password);
	  driver.findElement(By.xpath("//*[@value='Login']")).click();
	  driver.findElement(By.linkText("Logout")).click();
	  driver.findElement(By.partialLinkText("Log")).click();
	  
	  
  }

  @DataProvider
  public Object[][] dp()
  {
Object data[][]= new Object[4][2];
Excel excel=new Excel("D:\\Excel\\Mrunalini.xlsx");
for(int i=0;i<=excel.rowCount("Sheet1");i++)
{

data[i][0]=excel.Read("Sheet1",i, 0); //read data from row o and column 0
data[i][1]=excel.Read("Sheet1",i, 1);//read data from row o and column 1
}

//data[0][0]="sys";
//data[0][1]="Newuser123";
//data[1][0]="system";
//data[1][1]="Newuser123";
//data[2][0]="sys";
//data[2][1]="123";
//data[3][0]="sys";
//data[3][1]="sysfeff";
return data;

  }
  
  @AfterMethod //Run for each Test methods
  public void AfterMethod(ITestResult result)
  {
		System.out.println(  ITestResult.FAILURE);
		System.out.println(  ITestResult.SUCCESS);
		System.out.println(  ITestResult.SKIP);
	  if(result.getStatus()==ITestResult.FAILURE)
	  {
		System.out.println("Taking Scsreenshot");  
		BrowserSetup.getScreenShot(result.getName());
	  }

  }
  @BeforeTest
  public void beforeTest() {
	  
 driver=BrowserSetup.browserStart("chrome");

	  
  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
