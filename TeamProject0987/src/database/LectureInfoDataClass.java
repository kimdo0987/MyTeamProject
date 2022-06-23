package database;

import java.io.BufferedReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class LectureInfoDataClass {
	public static void main(String[] args) {
		DataLectureLists data = new DataLectureLists();
		ArrayList<String> lectureInfo = data.getLectureInfoArr();
		
		String sql = "UPDATE lecture_lists SET lecture_info = ? WHERE lecture_id = ?";
		
		try (
				Connection con = OjdbcConnection.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
		) {
			con.setAutoCommit(false);
			
			for (int i = 0; i < lectureInfo.size(); i++) {
				pstmt.setString(1, lectureInfo.get(i));
				pstmt.setInt(2, i + 1);
				pstmt.executeUpdate();
				System.out.println("1행 update 완료");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
	}
}
