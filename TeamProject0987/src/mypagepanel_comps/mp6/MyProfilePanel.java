package mypagepanel_comps.mp6;

import java.awt.BorderLayout;
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
import java.awt.Font;

public class MyProfilePanel extends JPanel {
	private String name;
	private String id;
	private String jNum;
	private String birth;
	private String phone;
	private String mail;

	public MyProfilePanel() {
		setBackground(Color.DARK_GRAY);
		setLayout(null);

		setBounds(0, 58, 730, 511);
		String sql = "SELECT * FROM members";
		
		JLabel nameLabel = new JLabel("이름");
		nameLabel.setFont(new Font("굴림", Font.PLAIN, 16));
		nameLabel.setForeground(Color.WHITE);
		nameLabel.setBounds(193, 100, 76, 50);
		add(nameLabel); 

		JLabel lbl1 = new JLabel("이름 넣는 곳");
		lbl1.setFont(new Font("굴림", Font.PLAIN, 16));
		lbl1.setForeground(Color.WHITE);
		add(lbl1);
		lbl1.setBounds(300, 100, 250, 50);
		
		JLabel idLabel = new JLabel("ID");
		idLabel.setFont(new Font("굴림", Font.PLAIN, 16));
		idLabel.setForeground(Color.WHITE);
		idLabel.setBounds(193, 140, 76, 50);
		add(idLabel);
		
		JLabel lbl2 = new JLabel("ID 넣는 곳");
		lbl2.setFont(new Font("굴림", Font.PLAIN, 16));
		lbl2.setForeground(Color.WHITE);
		add(lbl2);
		lbl2.setBounds(300, 140, 250, 50);
		
		JLabel birthLabel = new JLabel("생년월일");
		birthLabel.setFont(new Font("굴림", Font.PLAIN, 16));
		birthLabel.setForeground(Color.WHITE);
		birthLabel.setBounds(193, 180, 76, 50);
		add(birthLabel);
		
		JLabel lbl3 = new JLabel("생년월일 넣는 곳");
		lbl3.setFont(new Font("굴림", Font.PLAIN, 16));
		lbl3.setForeground(Color.WHITE);
		add(lbl3);
		lbl3.setBounds(300, 180, 250, 50);
		
		JLabel phoneNumberLabel = new JLabel("전화번호");
		phoneNumberLabel.setFont(new Font("굴림", Font.PLAIN, 16));
		phoneNumberLabel.setForeground(Color.WHITE);
		phoneNumberLabel.setBounds(193, 220, 76, 50);
		add(phoneNumberLabel);
		
		JLabel lbl4 = new JLabel("전화번호 넣는 곳");
		lbl4.setFont(new Font("굴림", Font.PLAIN, 16));
		lbl4.setForeground(Color.WHITE);
		add(lbl4);
		lbl4.setBounds(300, 220, 250, 50);
		
		JLabel emailLabel = new JLabel("이메일");
		emailLabel.setFont(new Font("굴림", Font.PLAIN, 16));
		emailLabel.setForeground(Color.WHITE);
		emailLabel.setBounds(193, 260, 76, 50);
		add(emailLabel);
		
		JLabel lbl5 = new JLabel("이메일 넣는 곳");
		lbl5.setFont(new Font("굴림", Font.PLAIN, 16));
		lbl5.setForeground(Color.WHITE);
		add(lbl5);
		lbl5.setBounds(300, 260, 250, 50);
		
		JButton modifyBtn = new JButton("내 정보 수정하기");
		modifyBtn.setBounds(300, 360, 150, 50);
		modifyBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MpChangePanel.mpLayout.show(MpChangePanel.mpPanel, "password");
				
			}
		});
		add(modifyBtn);
		
		String sql1 = " SELECT * FROM members WHERE member_id = ?";
		
		try ( Connection conn = OjdbcConnection.getConnection();
			  PreparedStatement pstmt = conn.prepareStatement(sql1);
				)
		{ 
		pstmt.setString(1, MainPanel.currUserId);
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) { 
			name = (rs.getString("member_name"));
			id = (rs.getString("member_id"));
			jNum = (rs.getString("j_number"));
			phone = (rs.getString("phone_number"));
			mail = (rs.getString("email"));
			birth = jNum.substring(0,2)+"년"+jNum.substring(2,4)+"월"+jNum.substring(4,6)+"일";
		}
		
		lbl1.setText(name);
		lbl2.setText(id);	
		lbl3.setText(birth);	
		lbl4.setText(phone);	
		lbl5.setText(mail);	
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBounds(281, 100, 2, 210);
		add(lblNewLabel);
		
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		
	}
}
