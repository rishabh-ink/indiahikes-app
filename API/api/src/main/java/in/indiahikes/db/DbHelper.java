package in.indiahikes.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbHelper
{

	Connection conn;

	public Connection getConnection()
	{
		String url = "jdbc:mysql://instance33218.db.xeround.com:13681/";
		String dbName = "greentrail";
		String driver = "com.mysql.jdbc.Driver";
		String userName = "rhok_green";
		String password = "abcd1234";
		String connectionStr =
		        "jdbc:mysql://instance33218.db.xeround.com:13681/greentrail?user=rhok_green&password=abcd1234";
		try
		{
			Class.forName(driver).newInstance();
			conn = DriverManager.getConnection(connectionStr);
			System.out.println("Connected to the database");
		}
		catch (Exception e)
		{
			e.printStackTrace();

		}
		return conn;

	}

	public static void main(String[] args)
	{
		DbHelper helper = new DbHelper();
		helper.getConnection();
	}

}
