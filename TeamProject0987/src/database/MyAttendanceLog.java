package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class MyAttendanceLog {
	public static String[][] getMyAttendanceLog() {
		String sql = "select "
				+ "attendance_date||''||'', "
				+ "lecture_name, "
				+ "teacher_name, "
				+ "attendance_state "
				+ "from "
				+ "attendance_log a, "
				+ "lecture_lists l "
				+ "where "
				+ "a.lecture_id = l.lecture_id "
				+ "and "
				+ "member_id = 'hansm1119'"; //member_id 나중에 물음표찍고 mainPanel 에서 currId 받아와서 넣으면될듯?
		
		try (
				Connection con = OjdbcConnection.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
		) {
			ResultSet result = pstmt.executeQuery();
			ArrayList<String[]> list = new ArrayList<String[]>();
			while(result.next()) {
				list.add(new String[] {
						result.getString("attendance_date||''||''"),
						result.getString("lecture_name"),
						result.getString("teacher_name"),
						result.getString("attendance_state")
				});
			}
			System.out.println("The data(MyAttendanceLog) has been fetched");
			String[][] arr = new String[list.size()][4];
			return list.toArray(arr);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return null;			
		}
	}
}
