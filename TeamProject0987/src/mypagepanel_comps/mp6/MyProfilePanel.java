package mypagepanel_comps.mp6;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import database.OjdbcConnection;
import panels.MainPanel;

public class MyProfilePanel extends JPanel {
	String userName;
	String userId;
	String userEmail;
	String phoneNum;
	String jNum;
	
	public MyProfilePanel() {
		
		String sql2 = "SELECT * FROM members WHERE member_id = ?";
		try (
				Connection conn2 = OjdbcConnection.getConnection(); 
				PreparedStatement pstmt2 = conn2.prepareStatement(sql2);
		) {
			
			pstmt2.setString(1, MainPanel.currUserId);
			
			try (ResultSet rs = pstmt2.executeQuery()) {
				while (rs.next()) {
					userId = rs.getString("member_ID");
					userName = rs.getString("member_name");
					userEmail = rs.getString("email");
					jNum = rs.getString("j_number");
					phoneNum = rs.getString("phone_number");
					
				}
			}
				
		}catch (Exception e) {

		}
		String a = jNum.charAt(2)+""+jNum.charAt(3)+"월"+jNum.charAt(4)+""+jNum.charAt(5)+"일";
		setLayout(null);

		setBounds(0, 58, 730, 511);
		
		JLabel nameLabel = new JLabel("이름");
		nameLabel.setBounds(110, 100, 50, 50);
		add(nameLabel);
		
		JLabel idLabel = new JLabel("ID");
		idLabel.setBounds(120, 140, 50, 50);
		add(idLabel);
		
		JLabel birthLabel = new JLabel("생년월일");
		birthLabel.setBounds(100, 180, 50, 50);
		add(birthLabel);
		
		JLabel phoneNumberLabel = new JLabel("전화번호");
		phoneNumberLabel.setBounds(100, 220, 50, 50);
		add(phoneNumberLabel);
		
		JLabel emailLabel = new JLabel("이메일");
		emailLabel.setBounds(105, 260, 50, 50);
		add(emailLabel);
		
		JButton modifyBtn = new JButton("내 정보 수정하기");
		modifyBtn.setBounds(276, 349, 145, 50);
		modifyBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MpChangePanel.mpLayout.show(MpChangePanel.mpPanel, "password");
				
			}
		});
		add(modifyBtn);
		
		JLabel lbl1 = new JLabel(userName);
		lbl1.setBounds(157, 106, 187, 38);
		add(lbl1);
		
		JLabel lbl2 = new JLabel(userId);
		lbl2.setBounds(157, 146, 187, 38);
		add(lbl2);
		
		JLabel lbl3 = new JLabel(a);
		lbl3.setBounds(157, 186, 187, 38);
		add(lbl3);
		
		JLabel lbl4 = new JLabel(phoneNum);
		lbl4.setBounds(157, 226, 187, 38);
		add(lbl4);
		
		JLabel lbl5 = new JLabel(userEmail);
		lbl5.setBounds(157, 266, 187, 38);
		add(lbl5);
		
		
		
		
		
		
		
		
		
		
	}
}
