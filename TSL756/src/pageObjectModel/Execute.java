package  pageObjectModel;


import org.testng.annotations.Test;
import util.Base2;

public class Execute extends Base2{
	
  @Test
  public void f() throws InterruptedException {
	  Login LN = new Login(driver);
	  SQL_Command command =new SQL_Command(driver);
	  
	  driver.get("http://127.0.0.1:8080/htmldb");
	  LN.LoginProcess("sys", "Newuser123");
	  command.WriteCommand();
	  Thread.sleep(1000);
	  command.LogoutProcess();
  }
  
}
