package day7;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.testng.annotations.Test;

import util.Base;

public class CookieTest extends Base {
  @Test
  public void Google() {
	  driver.get("https://www.lntinfotech.com/");
	  Set<Cookie> allCookies=driver.manage().getCookies();
//		driver.navigate().to("https://www.lntinfotech.com/");
//		driver.manage().deleteAllCookies();
	  for(Cookie C:allCookies)
	  {
  System.out.println("Cookie Name is"+C.getName());
		  System.out.println("Cookie Domain is"+C.getDomain());
		  System.out.println("Cookie path is"+C.getPath());
		  System.out.println("Cookie Value is"+C.getValue());
		  System.out.println("Cookie Expiry is"+C.getExpiry());
	  }
  
	  
  }
}


