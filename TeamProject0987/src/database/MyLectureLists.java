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
		
		String sql2 = "SELECT lecture_name, count(*)-1 as 출석일, teacher_name, "
				+ "l.lecture_id, lecture_start_date||'~'||lecture_end_date, "
				+ "TO_DATE(lecture_end_date)-TO_DATE(lecture_start_date) as 총 "
				+ " FROM "
				+ "payment_log p, lecture_lists l , mylecture_lists m "
				+ "WHERE "
				+ "p.lecture_id = l.lecture_id "
				+ "and "
				+ "m.lecture_id = l.lecture_id "
				+ "and "
				+ "p.refund_status = 'null' "
				+ "and "
				+ "p.member_id = ? "
				+ "GROUP BY lecture_name, teacher_name, l.lecture_start_date,l.lecture_end_date, "
				+ "l.lecture_id";
		
		
		try (
				Connection con = OjdbcConnection.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				PreparedStatement pstmt2 = con.prepareStatement(sql2);
			
		) {
			pstmt.setString(1, MainPanel.currUserId);
			pstmt2.setString(1, MainPanel.currUserId);
			ResultSet result = pstmt.executeQuery();
			ResultSet result2 = pstmt2.executeQuery();
	
			ArrayList<String[]> list = new ArrayList<String[]>();
			ArrayList<String> lectureIdArr = new ArrayList<>();
			
			while(result.next()) {
				lectureIdArr.add(result.getString("lecture_name"));
				list.add(new String[] {
						result.getString(1),
						result.getString(3),
						result.getString(5),
						"수강평작성",
						"수강포기",
						String.format("%.1f%%", (double)result.getInt(2)/result.getInt(6)*100)
				});
				
					}
			
			while(result2.next()) {
				if(!lectureIdArr.contains(result2.getString("lecture_name"))) {
					list.add(new String[] {
							result2.getString(1),
							result2.getString(3),
							result2.getString(5),
							"수강평작성",
							"수강포기",
							String.format("%.1f%%", (double)(result2.getInt(2)-1)/result2.getInt(6)*100)
					});
				}
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
