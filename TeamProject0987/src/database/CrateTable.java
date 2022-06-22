package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CrateTable {

	public static void main(String[] args) {
		
		String sql = "CREATE TABLE customer_info ("
				+ "    customer_id  int(10) ,"
				+ "    customer_name VARCHAR(255) NOT NULL,"
				+ "    cutomer_pw VARCHAR(255) NOT NULL,"
				+ "		CONSTRAINT customer_id_pk PRIMARY KEY (customer_id))";
		
		String sql2 = "CREATE TABLE IF NOT EXISTS members ("
				+ "    member_id		VARCHAR(255),	CONSTRAINT member_id_pk PRIMARY KEY(member_id),"
				+ "    member_password	VARCHAR(255),"
				+ "    member_name		VARCHAR(255),"
				+ "    age				INTEGER(3),"
				+ "    phone_number		VARCHAR(255),"
				+ "    email			VARCHAR(255),"
				+ "    J_number			VARCHAR(15))";
		
		String sql3 = "INSERT INTO members"
				+ "(member_id, member_password, member_name, age, phone_number, email, s_s_number)"
				+ "VALUES"
				+ String.format("('%s','%s','%s','%d','%s','%s','%s')" , 
						"asd","asd","kimdo",99,"010-1234-5678","dohyun@naver.com","123456-1234567");
		
		try (
				Connection con = OjdbcConnection.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql3);
		){
			pstmt.execute();
			
			
			
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			
		} finally {
			System.out.println("테이블 생성 시도 완료 (이미 있는 테이블이면 생성되지않음)");
		}
		
	}
	
}
