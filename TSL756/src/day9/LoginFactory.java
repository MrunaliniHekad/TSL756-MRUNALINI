package day9;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginFactory {
	private WebDriver driver;
	
	LoginFactory(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
	
	@FindBy(name="p+t01")WebElement element_username;
	@FindBy(name="p+t02")WebElement element_password;
	@FindBy(xpath="//*[@value='Login']")WebElement element_Login;
//	@FindBy(how=How.XPATH,using="//*[@value='Login']")WebElement element_Login1;
	
	
	public void LoginProcess(String Username, String Password)
	{
		element_username.sendKeys(Username);
		 element_password.sendKeys(Password);
		 element_Login.click();
	}
	

}
