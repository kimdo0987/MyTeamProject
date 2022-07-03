package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import panels.MainPanel;

public class MyCouponLists {
	
	public static String[][] getMyCouponLists() {
		String sql = "select "
				+ "coupon_id, "
				+ "coupon_name, "
				+ "coupon_code, "
				+ "discount_percent||'%'||'', "
				+ "expiration_period||''||'', "
				+ "used_or_unused "
				+ "from "
				+ "coupon_lists "
				+ "where "
				+ "member_id = ?"
				+ " ORDER BY used_or_unused, expiration_period";
		
		try (
				Connection con = OjdbcConnection.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
		) {
			pstmt.setString(1, MainPanel.currUserId);
			ResultSet result = pstmt.executeQuery();
			ArrayList<String[]> list = new ArrayList<String[]>();
			while(result.next()) {
				list.add(new String[] {
						result.getString("coupon_id"),
						result.getString("coupon_name"),
						result.getString("coupon_code"),
						result.getString("discount_percent||'%'||''"),
						result.getString("expiration_period||''||''"),
						result.getString("used_or_unused")
				});
			}
			System.out.println("The data(MyCouponLists) has been fetched");
			String[][] arr = new String[list.size()][6];
			return list.toArray(arr);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return null;			
		}
	}
	
}
