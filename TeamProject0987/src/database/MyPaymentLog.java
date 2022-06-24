package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class MyPaymentLog {
	public static String[][] getMyPaymentLog() {
		String sql = "";
		
		try (
				Connection con = OjdbcConnection.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
		) {
			ResultSet result = pstmt.executeQuery();
			ArrayList<String[]> list = new ArrayList<String[]>();
			while(result.next()) {
				list.add(new String[] {
						result.getString("attendance_date||''||''")
						
				});
			}
			System.out.println("The data(MyPaymentLog) has been fetched");
			String[][] arr = new String[list.size()][4];
			return list.toArray(arr);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return null;			
		}
	}
}
