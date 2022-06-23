package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class GetCategorytLectureLists {

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
			
			while(rs.next()) {
				list.add(new String[] {
						rs.getString("lecture_name"),
						rs.getString("teacher_name"),
						rs.getString("lecture_category"),
						rs.getString("lecture_start_date"),
						"강의상세보기"
				});
			}
			
			System.out.println("The data has been fetched2");
			String[][] arr = new String[list.size()][5];
			
			return list.toArray(arr);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return null;			
		}
	}
}
