package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class GetLectureComments {
	
	public static String[][] getLectureComments(int num) {
		
		String sql = "SELECT member_id, comment_msg, rating FROM lecture_comments WHERE lecture_id = ?";
		
		try (
				Connection con = OjdbcConnection.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);

		) {
				pstmt.setInt(1, num);				
			
			ResultSet rs = pstmt.executeQuery();
			
			ArrayList<String[]> list = new ArrayList<String[]>();
			
			while(rs.next()) {
				list.add(new String[] {
						rs.getString("member_id"),
						rs.getString("comment_msg"),
						rs.getString("rating")
				});
			}
			
			System.out.println("The data has been fetched3");
			String[][] arr = new String[list.size()][3];
			
			return list.toArray(arr);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return null;			
		}
		
	}
}
