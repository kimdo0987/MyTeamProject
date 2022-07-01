package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

import panels.MainPanel;

public class MyLectureLists {
	
	public static String[][] getMyLectureLists() {
		
		String sql = "SELECT lecture_name, count(*) as 출석일, teacher_name, "
				+ "l.lecture_id, lecture_start_date||'~'||lecture_end_date, "
				+ "TO_DATE(lecture_end_date)-TO_DATE(lecture_start_date) as 총 "
				+ " FROM "
				+ "attendance_log a, lecture_lists l , mylecture_lists m "
				+ "WHERE "
				+ "a.lecture_id = l.lecture_id "
				+ "and "
				+ "m.lecture_id = l.lecture_id "
				+ "and "
				+ "attendance_state = '출석' "
				+ "and "
				+ "a.member_id = ? "
				+ "GROUP BY lecture_name, teacher_name, l.lecture_start_date,l.lecture_end_date, "
				+ "l.lecture_id";
		

		try (
				Connection con = OjdbcConnection.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
			
		) {
			pstmt.setString(1, MainPanel.currUserId);
			ResultSet result = pstmt.executeQuery();
	
			ArrayList<String[]> list = new ArrayList<String[]>();
			
			while(result.next()) {
				
				list.add(new String[] {
						result.getString(1),
						result.getString(3),
						result.getString(5),
						"수강평작성",
						"수강포기",
						String.format("%.1f%%", (double)result.getInt(2)/result.getInt(6)*100)
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
