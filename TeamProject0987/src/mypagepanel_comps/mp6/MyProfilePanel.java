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

public class MyProfilePanel extends JPanel {
	private String name;
	private String id;
	private String birth;
	private String phone;
	private String mail;

	public MyProfilePanel() {
		setLayout(null);

		setBounds(0, 58, 730, 511);
		String sql = "SELECT * FROM members";
		
		JLabel nameLabel = new JLabel("이름");
		nameLabel.setBounds(110, 100, 50, 50);
		add(nameLabel); 

		JLabel lbl1 = new JLabel("이름 넣는 곳");
		add(lbl1);
		lbl1.setBounds(170, 100, 50, 50);
		
		JLabel idLabel = new JLabel("ID");
		idLabel.setBounds(120, 140, 50, 50);
		add(idLabel);
		
		JLabel lbl2 = new JLabel("ID 넣는 곳");
		add(lbl2);
		lbl2.setBounds(170, 140, 100, 50);
		
		JLabel birthLabel = new JLabel("생년월일");
		birthLabel.setBounds(100, 180, 50, 50);
		add(birthLabel);
		
		JLabel lbl3 = new JLabel("생년월일 넣는 곳");
		add(lbl3);
		lbl3.setBounds(170, 180, 100, 50);
		
		JLabel phoneNumberLabel = new JLabel("전화번호");
		phoneNumberLabel.setBounds(100, 220, 50, 50);
		add(phoneNumberLabel);
		
		JLabel lbl4 = new JLabel("전화번호 넣는 곳");
		add(lbl4);
		lbl4.setBounds(170, 220, 100, 50);
		
		JLabel emailLabel = new JLabel("이메일");
		emailLabel.setBounds(105, 260, 50, 50);
		add(emailLabel);
		
		JLabel lbl5 = new JLabel("이메일 넣는 곳");
		add(lbl5);
		lbl5.setBounds(170, 260, 100, 50);
		
		JButton modifyBtn = new JButton("내 정보 수정하기");
		modifyBtn.setBounds(276, 349, 145, 50);
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
			birth = (rs.getString("j_number"));
			phone = (rs.getString("phone_number"));
			mail = (rs.getString("member_id"));
			
		}
		
		lbl1.setText(name);
		lbl2.setText(id);	
		lbl3.setText(birth);	
		lbl4.setText(phone);	
		lbl5.setText(mail);	
		
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		
	}
//	
//	public static void main(String[] args) {
//		JFrame frame = new JFrame();
//		JPanel panel = new JPanel();
//		frame.getContentPane().add(panel);
//		panel.setBounds(100, 100, 1200, 800);
//		panel.setBackground(Color.white);
//		panel.setLayout(null);
//
//		panel.add(new MyProfilePanel());
//
//		frame.setBounds(100, 100, 1200, 800);
//		frame.setLocationRelativeTo(null);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setVisible(true);	
//		
//	}
}


