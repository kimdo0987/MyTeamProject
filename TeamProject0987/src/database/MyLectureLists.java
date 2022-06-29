package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import panels.MainPanel;

public class MyLectureLists {
	
	public static String[][] getMyLectureLists() {
		String sql = "SELECT "
				+ "lecture_name, "
				+ "teacher_name, "
				+ "lecture_start_date||'~'||lecture_end_date "
				+ "FROM "
				+ "lecture_lists l, "
				+ "mylecture_lists m "
				+ "WHERE "
				+ "l.lecture_id = m.lecture_id "
				+ "AND "
				+ "m.member_id = ?";
		
		try (
				Connection con = OjdbcConnection.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
		) {
			pstmt.setString(1, MainPanel.currUserId);
			ResultSet result = pstmt.executeQuery();
			ArrayList<String[]> list = new ArrayList<String[]>();
			while(result.next()) {
				list.add(new String[] {
						result.getString("lecture_name"),
						result.getString("teacher_name"),
						result.getString("lecture_start_date||'~'||lecture_end_date"),
						"수강평작성",
						"수강포기"
				});
			}
			System.out.println("The data(MyLectureLists) has been fetched");
			String[][] arr = new String[list.size()][5];
			return list.toArray(arr);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return null;			
		}
	}
}
