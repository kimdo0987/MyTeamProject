package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

public class CouponListsDataClass {
//	public static void main(String[] args) {
//		DataLectureLists data = new DataLectureLists();
//		ArrayList<String> couponCode = data.getCouponCodeArr();
//		
//		String sql = "UPDATE coupon_lists SET coupon_code = ? WHERE coupon_id = ?";
//		
//		try (
//				Connection con = OjdbcConnection.getConnection();
//				PreparedStatement pstmt = con.prepareStatement(sql);
//		) {
//			con.setAutoCommit(false);
//			
//			for (int i = 0; i < couponCode.size(); i++) {
//				pstmt.setString(1, couponCode.get(i));
//				pstmt.setInt(2, i + 1);
//				pstmt.executeUpdate();
//				System.out.println("1행 update 완료");
//			}
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//			e.printStackTrace();
//		}
//	} 
}
