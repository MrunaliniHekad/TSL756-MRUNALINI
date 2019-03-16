package database;

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
		ResultSet R2=C.createStatement().executeQuery("select count(*) from oracleLogin");
		//ResultSet R=C.createStatement().executeQuery("select * from Login");
		R2.next();
		Object data[][]=new Object[R2.getInt(1)][2];
		int i=0;
		ResultSet R=C.createStatement().executeQuery("select * from oracleLogin");
		while(R.next())
		{
			System.out.println(R.getString(1));
		System.out.println(R.getString(2));
		}
  }
}
