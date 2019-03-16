package day9;

import org.testng.annotations.Test;

import util.Base2;
import util.Keywords;

public class KeywordExecute extends Base2 {
	 @Test
	  public void f() {
	Keywords Key=new Keywords(driver);
	Key.openUrl("https://opensource-demo.orangehrmlive.com/");
	Key.type("txtUsername_name", "admin" );
	Key.type("txtPassword_id", "admin123" );
	Key.click("//*[@type='submit']_xpath");
	Key.click("//*[@id='welcome']_xpath");
	Key.click("Logout_linktext");
	Key.getScreenShot("Orange");
		  
		  
	  }
	  
	  
  }

