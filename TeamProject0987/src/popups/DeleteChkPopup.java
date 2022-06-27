package popups;

import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import database.OjdbcConnection;
import panels.MainPanel;
 
public class DeleteChkPopup extends JDialog{
	public static int currLectureId;
	public static String currLectureName;
	
	public DeleteChkPopup(Window parent, String lecture_name) {
		
		super(parent, "안내 메시지", ModalityType.APPLICATION_MODAL);
		
		setSize(254, 176);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel msgLabel = new JLabel("장바구니에서 삭제하시겠습니까?");
		msgLabel.setFont(new Font("굴림", Font.PLAIN, 13));
		msgLabel.setBounds(12, 38, 214, 31);
		msgLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		getContentPane().add(msgLabel);
		
		JButton confirmBtn = new JButton("확인");
		confirmBtn.setBounds(38, 91, 64, 23);
		getContentPane().add(confirmBtn);
		
		String sql2 = "SELECT lecture_id"
				+ " FROM lecture_lists WHERE lecture_name = ?";
		
		
		try (
				Connection conn2 = OjdbcConnection.getConnection(); 
				PreparedStatement pstmt2 = conn2.prepareStatement(sql2);
		) {
			
			pstmt2.setString(1, currLectureName);
			
			try (ResultSet rs = pstmt2.executeQuery()) {
				while (rs.next()) {
					currLectureId = rs.getInt("lecture_id");
				}
			}
		System.out.println(currLectureId);		
		}catch (Exception e1) {
			e1.printStackTrace();
		}
		

		confirmBtn.addActionListener(new ActionListener() {
				
			@Override
			public void actionPerformed(ActionEvent e) {

				System.out.println(currLectureId);
			
				
				String sql = "DELETE FROM wish_lists WHERE user_id = ? AND lecture_id = ?";
			
				try (
						Connection conn = OjdbcConnection.getConnection(); 
						PreparedStatement pstmt = conn.prepareStatement(sql);
				) {
					
					conn.setAutoCommit(false);
					
					pstmt.setString(1, MainPanel.currUserId);
					pstmt.setInt(2, currLectureId);
					
					pstmt.executeUpdate();
					conn.commit();
				}catch (Exception e1) {
					e1.printStackTrace();
				}

				dispose();	
			}
		});
		
		JButton cancelBtn = new JButton("취소");
		cancelBtn.setBounds(125, 91, 64, 23);
		getContentPane().add(cancelBtn);
		cancelBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();				
			}
		});
		
		
		setVisible(true);
		
		
	}
}
