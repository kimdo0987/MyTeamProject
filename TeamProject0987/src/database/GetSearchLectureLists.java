package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import panels.LectureSearchPanel;

public class GetSearchLectureLists {
	
	public static int lecCnt=0;
	public static String[][] getSearchList(String SearchWord) {
		
		String sql = "SELECT lecture_name,teacher_name,lecture_category,lecture_start_date||''||'' FROM lecture_lists WHERE LOWER(lecture_name) LIKE LOWER(?)";
		
		
		try (
				Connection con = OjdbcConnection.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);

		) {
				pstmt.setString(1,"%"+SearchWord+"%");				
			
			ResultSet rs = pstmt.executeQuery();
			
			ArrayList<String[]> list = new ArrayList<String[]>();
			
			lecCnt=0;
			while(rs.next()) {
				lecCnt++;
				list.add(new String[] {
						rs.getString("lecture_name"),
						rs.getString("teacher_name"),
						rs.getString("lecture_category"),
						rs.getString("lecture_start_date||''||''")
				});
			}
			panels.LectureSearchPanel.lectureCntLabel.setText("<검색어 :"+SearchWord+"> "+lecCnt+"개의 강의를 검색하였습니다");
			
			System.out.println("The data has been fetched4");
			String[][] arr = new String[list.size()][4];
			
			return list.toArray(arr);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return null;			
		}
		
	}
}
