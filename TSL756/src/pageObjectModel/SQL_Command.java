package  pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class SQL_Command {

	private WebDriver driver;
	SQL_Command(WebDriver driver)
	{
		this.driver = driver;
	}
	private By e_Logout = By.linkText("Logout");
	private By e_sql = By.linkText("SQL");
	private By e_sql1 = By.linkText("SQL Commands");
	private By e_sqlTextArea = By.id("P1003_SQL_COMMAND1");
	private By runbtn = By.cssSelector("input[value='Run']");
	private By dropD = By.id("P1003_ROWS");
	
	public void LogoutProcess()
	{
		driver.findElement(e_Logout).click();
		
	}
	
	public void WriteCommand()
	{
		driver.findElement(e_sql).click();
		driver.findElement(e_sql1).click();
		new Select(driver.findElement(dropD)).selectByIndex(4);
		//select.selectByIndex(4);
		driver.findElement(e_sqlTextArea).sendKeys("select * from logindetails");
		driver.findElement(runbtn).click();
	
	}
}
