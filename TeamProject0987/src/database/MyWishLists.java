package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import panels.MainPanel;

public class MyWishLists {
	public static String[][] getMyWishLists() {
		String sql = "select "
				+ "lecture_name, "
				+ "teacher_name, "
				+ "lecture_start_date||'~'||lecture_end_date, "
				+ "lecture_price "
				+ "from "
				+ "lecture_lists l, "
				+ "wish_lists w "
				+ "where "
				+ "l.lecture_id = w.lecture_id "
				+ "AND "
				+ "user_id = ?"; 
		
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
						result.getString("lecture_price"),
						"삭제하기","쿠폰선택","결제금액"
				});
			}
			System.out.println("The data(MyWishLists) has been fetched");
			String[][] arr = new String[list.size()][5];
			return list.toArray(arr);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return null;			
		}
	}
}
