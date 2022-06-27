package buttons;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import database.OjdbcConnection;
import panels.MainPanel;

public class WishButton extends JButton {
	
	public static int currLectureId;
	
		private static ActionListener eventListener = new ActionListener() {
			ArrayList<Integer>lecIdArr = new ArrayList<>();
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				if (MainPanel.currUserId.equals("")) {
					JOptionPane.showMessageDialog(MainPanel.thisFrame, "회원만 이용 가능합니다\n로그인해 주세요");
					
					return;
				} 
				
				
				String sql2 = "SELECT * FROM wish_lists WHERE lecture_id = ?";
				try (
						Connection conn2 = OjdbcConnection.getConnection(); 
						PreparedStatement pstmt2 = conn2.prepareStatement(sql2);
				) {
					
					pstmt2.setInt(1,  currLectureId);
					
					try (ResultSet rs = pstmt2.executeQuery()) {
						while (rs.next()) {
							
							lecIdArr.add(rs.getInt("lecture_id"));
							
						}
					}
						
				}catch (Exception e1) {

				}
				
				if(lecIdArr.contains(currLectureId)) {
					JOptionPane.showMessageDialog(MainPanel.thisFrame, "이미 장바구니에 담겨있습니다");
					
					return;
				}
				
				String sql = "INSERT INTO wish_lists values(WISH_LIST_SEQ.nextval,?,?)";
				
				try (
						Connection conn = OjdbcConnection.getConnection(); 
						PreparedStatement pstmt = conn.prepareStatement(sql);
				) {
					conn.setAutoCommit(false);
					
						pstmt.setString(1, MainPanel.currUserId);
						pstmt.setInt(2, currLectureId);

						pstmt.executeUpdate();
						conn.commit();
	
						JOptionPane.showMessageDialog(MainPanel.thisFrame, "장바구니에 담았습니다");
				}catch (Exception e2) {


				}
				
				
			
			}
		};

		public WishButton() {
			setText("장바구니 담기");
			setBackground(Color.ORANGE);
			addActionListener(eventListener);
			
		}
}


