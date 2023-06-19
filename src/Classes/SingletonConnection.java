package Classes;

import java.sql.Connection;
import java.sql.DriverManager;
public class SingletonConnection {
	private static Connection ret = null;
 
	public static Connection getConnection() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			String mysqlConnUrl = "jdbc:mysql://localhost:3306/deliberationdb";

			
			String mysqlUserName = "root";

			String mysqlPassword = "0000";

			ret = DriverManager.getConnection(mysqlConnUrl, mysqlUserName, mysqlPassword);

			

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return ret;

	}

}

