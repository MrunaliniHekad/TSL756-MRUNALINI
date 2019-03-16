package database;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

import org.testng.annotations.Test;

import util.BrowserSetup;


import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class NewTest {
	WebDriver driver;
	  Connection C;
	 PreparedStatement statement;
	
	@Test(dataProvider = "dp")
  public void Login(String UserName, String Password) throws SQLException {
	 driver.get("http://127.0.0.1:8080/htmldb");
	  driver.findElement(By.xpath("//*[@type='text']")).sendKeys(UserName);
	  driver.findElement(By.xpath("//*[@type='password']")).sendKeys(Password);
	  driver.findElement(By.xpath("//*[@value='Login']")).click();
	  
	  statement=C.prepareStatement("Update oracleLogin set status=? where USERNAME=? and PASSWORD=?");
  	statement.setString(2, UserName);
	  statement.setString(3,Password);
	  System.out.println("hI");
	  driver.findElement(By.linkText("Logout")).click();
	  driver.findElement(By.partialLinkText("Log")).click();
	  

  }

  @AfterMethod
  public void afterMethod(ITestResult result) throws SQLException {
	  try {
	  if(result.getStatus()==ITestResult.FAILURE)
	  {
		System.out.println("Taking Scsreenshot");  
		BrowserSetup.getScreenShot(result.getName());
	 	statement.setString(1, "Fail");
	  }
	  else
	  {
		  statement.setString(1, "Pass");
	  }

	  statement.executeUpdate();
  } catch (SQLException e) {
	
		e.printStackTrace();
	}
}
	  
  


  @DataProvider
  public Object[][] dp() throws Exception 
  {
	  DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
	  Connection C=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","sys", "Newuser123");
	  ResultSet R2=C.createStatement().executeQuery(("select count(*) from oracleLogin"));//counitng number of rows
	  R2.next(); //starting reading say compiler to move in next data
	  Object data[][]=new Object[R2.getInt(1)][2];// 2 dim array no of rows(R2) available 
	  
	  int i=0;
	  ResultSet R= C.createStatement().executeQuery(("Select * from oracleLogin"));
while (R.next())
{
	data[i][0]=R.getString(1);
	data[i][1]=R.getString(2);
	 i++;
    };
	return data;

  }
  @BeforeTest
  public void beforeTest() {
	  
	  driver= BrowserSetup.browserStart("Chrome");
  }
  @AfterTest
  public void afterTest()
  {
	  driver.quit();
  }

  
}
