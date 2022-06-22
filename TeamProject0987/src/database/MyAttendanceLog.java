package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class MyAttendanceLog {
	public static String[][] getMyAttendanceLog() {
		String sql = "select "
				+ "attendance_date, "
				+ "member_id, "
				+ "lecture_name, "
				+ "attendance_state "
				+ "from "
				+ "attendance_log a, "
				+ "lecture_lists l "
				+ "where "
				+ "a.lecture_id = l.lecture_id";
		
		try (
				Connection con = OjdbcConnection.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
		) {
			ResultSet result = pstmt.executeQuery();
			ArrayList<String[]> list = new ArrayList<String[]>();
			while(result.next()) {
				list.add(new String[] {
						result.getString("attendance_date"),
						result.getString("member_id"),
						result.getString("lecture_name"),
						result.getString("attendance_state")
				});
			}
			System.out.println("The data has been fetched");
			String[][] arr = new String[list.size()][4];
			return list.toArray(arr);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return null;			
		}
	}
}
