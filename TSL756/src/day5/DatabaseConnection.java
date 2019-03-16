package day5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.testng.annotations.Test;

public class DatabaseConnection {
  @Test
  public void f() throws Exception 
  {
		DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
		Connection C  = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "Newuser123");
		
		ResultSet R=C.createStatement().executeQuery("select * from oracleLogin");
		while(R.next())
		{
			System.out.println(R.getString(1));
		System.out.println(R.getString(2));
		}
  }
}
