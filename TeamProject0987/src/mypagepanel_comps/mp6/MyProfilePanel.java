package mypagepanel_comps.mp6;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import database.OjdbcConnection;
import panels.MainPanel;

public class MyProfilePanel extends JPanel {
	public MyProfilePanel() {
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
		
		JLabel lbl1 = new JLabel("이름뜨는창");
		lbl1.setBounds(157, 106, 187, 38);
		
		lbl1.setText("g");
		add(lbl1);
		
		JLabel lbl2 = new JLabel("id 넣는곳");
		lbl2.setBounds(157, 146, 187, 38);
		add(lbl2);
		
		JLabel lbl3 = new JLabel("생일 넣는곳");
		lbl3.setBounds(157, 186, 187, 38);
		add(lbl3);
		
		JLabel lbl4 = new JLabel("전화번호 넣는곳");
		lbl4.setBounds(157, 226, 187, 38);
		add(lbl4);
		
		JLabel lbl5 = new JLabel("이메일 넣는곳");
		lbl5.setBounds(157, 266, 187, 38);
		add(lbl5);
		
		
		
		String sql = "SELECT * FROM members WHERE member_id = ?";
				
		try (
				Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);				
				)		
		{
			pstmt.setString(1, MainPanel.currUserId);
			ResultSet rs = pstmt.executeQuery();
			
			rs.next();
				
			lbl2.setText(rs.getString("member_id")); 
			lbl1.setText(rs.getString("member_name"));	
				
			
			
			
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		
		
		
		
		
		
	}
}
