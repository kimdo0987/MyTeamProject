package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class GetCategorytLectureLists {
	public static int lecCnt=0;
	public static String[][] getLectureLists(String category) {
		
		
		String sql = "SELECT * FROM lecture_lists WHERE lecture_category = ?";
		if(category=="ALL") {
			sql = "SELECT * FROM lecture_lists";	
		}
		
		try (
				Connection con = OjdbcConnection.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);

		) {
			if(category!="ALL") {
				pstmt.setString(1, category);				
			}
			ResultSet rs = pstmt.executeQuery();
			
			ArrayList<String[]> list = new ArrayList<String[]>();
			lecCnt=0;
			while(rs.next()) {
				lecCnt++;
				list.add(new String[] {
						rs.getString("lecture_name"),
						rs.getString("teacher_name"),
						rs.getString("lecture_category"),
						rs.getString("lecture_start_date")
				});
			}
			panels.LectureSearchPanel.lectureCntLabel.setText("총 "+lecCnt+"개의 강의를 검색하였습니다");
			
			System.out.println("The data has been fetched2");
			String[][] arr = new String[list.size()][4];
			
			return list.toArray(arr);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return null;			
		}
	}
}
