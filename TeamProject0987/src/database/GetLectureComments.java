package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import LectureInfoPanel_comps.LectureInfoPanel2;
import panels.LectureInfoPanel;

public class GetLectureComments {
	
	public static String rateAvg = "";

	public static String[][] getLectureComments(int num) {

		
		String sql = "SELECT member_id, comment_msg, rating FROM lecture_comments WHERE lecture_id = ?";
		
		try (
				Connection con = OjdbcConnection.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);

		) {

				pstmt.setInt(1, num);				

			
			ResultSet rs = pstmt.executeQuery();
			
			ArrayList<String[]> list = new ArrayList<String[]>();
			int commentCnt = 0 ;
			int ratingSum = 0 ;
			while(rs.next()) {
				commentCnt++;
				ratingSum = ratingSum += Integer.parseInt(rs.getString("rating"));
				
				list.add(new String[] {
						rs.getString("member_id").substring(0,4)+"****",
						rs.getString("comment_msg"),
						rs.getString("rating")
				});
			}
			
			if(commentCnt!=0) {
			LectureInfoPanel.rateAvgLabel.setText(String.format("강의 평점 : %.2f", (double)ratingSum/commentCnt));
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
