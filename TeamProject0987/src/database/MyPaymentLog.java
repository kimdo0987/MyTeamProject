package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import panels.MainPanel;

public class MyPaymentLog {
	public static String[][] getMyPaymentLog() {
		String sql = "select "
				+ "order_num, "
				+ "lecture_name, "
				+ "coupon_name, "
				+ "lecture_price, "
				+ "total_price, "
				+ "payment_date||''||'', "
				+ "payment_type "
				+ "from "
				+ "payment_log p, lecture_lists l, coupon_lists c "
				+ "where p.lecture_id = l.lecture_id "
				+ "AND p.coupon_id = c.coupon_id "
				+ "AND p.member_id = ?"
				+ "ORDER BY payment_date DESC ";
		
		try (
				Connection con = OjdbcConnection.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
		) {
			pstmt.setString(1, MainPanel.currUserId);
			ResultSet result = pstmt.executeQuery();
			ArrayList<String[]> list = new ArrayList<String[]>();
			while(result.next()) {
				list.add(new String[] {
						result.getString("order_num"),
						result.getString("payment_date||''||''"),
						result.getString("lecture_name"),
						result.getString("coupon_name"),
						result.getString("lecture_price"),
						result.getString("total_price"),
						result.getString("payment_type")
				});
			}
			System.out.println("The data(MyPaymentLog) has been fetched");
			String[][] arr = new String[list.size()][6];
			return list.toArray(arr);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return null;			
		}
	}
}
