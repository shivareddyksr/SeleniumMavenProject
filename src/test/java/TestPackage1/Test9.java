package TestPackage1;

import java.beans.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;
import org.testng.annotations.Test;

import com.github.dockerjava.api.model.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import okhttp3.Connection;

public class Test9 {

	@Test
	public void tc1() throws SQLException
	{
		WebDriverManager.chromedriver().setup();
		// Register to the DB
		Driver dr = new Driver();
		DriverManager.registerDriver((java.sql.Driver) dr);
		
		//steps to connect to database
		Connection con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/XE","scott","tiger");
		
		//create a sql query statement
		//Statement s = con.createStatement();
		
		String query = "select * from emp";
		
		//ResultSet result = s.executeQuery(query);
	}
}
