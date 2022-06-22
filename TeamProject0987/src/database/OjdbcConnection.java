package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OjdbcConnection {
	// AWS 공유 컴퓨터에 접속
	
	private static String driverName = "oracle.jdbc.driver.OracleDriver";
	private static String url = "jdbc:oracle:thin:@3.37.62.115:1521:XE";
	private static String user = "hr";
	private static String password = "1234";
	
	
	static {		
		try {
			Class.forName(driverName);
		} catch (ClassNotFoundException e) {
			System.out.println("driver Name Error : " + driverName);



		}		

    

	}
	
	public static Connection getConnection() throws SQLException{
		System.out.println("The connection Sucessful");
		return DriverManager.getConnection(url,user,password);
	}
	public static void main(String[] args) {
		try {
			getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("connection error ...");
		}
	}

}
