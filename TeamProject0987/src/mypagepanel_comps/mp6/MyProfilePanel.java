package mypagepanel_comps.mp6;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import database.OjdbcConnection;
import panels.MainPanel;
import java.awt.Font;
import java.awt.Image;

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
		nameLabel.setFont(new Font("굴림", Font.PLAIN, 18));
		nameLabel.setForeground(Color.WHITE);
		nameLabel.setBounds(214, 95, 76, 50);
		add(nameLabel); 

		JLabel lbl1 = new JLabel("이름 넣는 곳");
		lbl1.setFont(new Font("굴림", Font.PLAIN, 18));
		lbl1.setForeground(Color.WHITE);
		add(lbl1);
		lbl1.setBounds(344, 95, 250, 50);
		
		JLabel idLabel = new JLabel("ID");
		idLabel.setFont(new Font("굴림", Font.PLAIN, 18));
		idLabel.setForeground(Color.WHITE);
		idLabel.setBounds(214, 145, 76, 50);
		add(idLabel);
		
		JLabel lbl2 = new JLabel("ID 넣는 곳");
		lbl2.setFont(new Font("굴림", Font.PLAIN, 18));
		lbl2.setForeground(Color.WHITE);
		add(lbl2);
		lbl2.setBounds(344, 145, 250, 50);
		
		JLabel birthLabel = new JLabel("생년월일");
		birthLabel.setFont(new Font("굴림", Font.PLAIN, 18));
		birthLabel.setForeground(Color.WHITE);
		birthLabel.setBounds(214, 195, 76, 50);
		add(birthLabel);
		
		JLabel lbl3 = new JLabel("생년월일 넣는 곳");
		lbl3.setFont(new Font("굴림", Font.PLAIN, 18));
		lbl3.setForeground(Color.WHITE);
		add(lbl3);
		lbl3.setBounds(344, 195, 250, 50);
		
		JLabel phoneNumberLabel = new JLabel("전화번호");
		phoneNumberLabel.setFont(new Font("굴림", Font.PLAIN, 18));
		phoneNumberLabel.setForeground(Color.WHITE);
		phoneNumberLabel.setBounds(214, 245, 76, 50);
		add(phoneNumberLabel);
		
		JLabel lbl4 = new JLabel("전화번호 넣는 곳");
		lbl4.setFont(new Font("굴림", Font.PLAIN, 18));
		lbl4.setForeground(Color.WHITE);
		add(lbl4);
		lbl4.setBounds(344, 245, 250, 50);
		
		JLabel emailLabel = new JLabel("이메일");
		emailLabel.setFont(new Font("굴림", Font.PLAIN, 18));
		emailLabel.setForeground(Color.WHITE);
		emailLabel.setBounds(214, 295, 76, 50);
		add(emailLabel);
		
		JLabel lbl5 = new JLabel("이메일 넣는 곳");
		lbl5.setFont(new Font("굴림", Font.PLAIN, 18));
		lbl5.setForeground(Color.WHITE);
		add(lbl5);
		lbl5.setBounds(344, 295, 250, 50);
		
		/*
		
		/////////////////////////////////////////////////////////
		ImageIcon changeBtnicon1 = new ImageIcon("images/changeButton/변경하기버튼.png");
		Image changeBtnimg1 = changeBtnicon1.getImage();
		Image changeBtn1 = changeBtnimg1.getScaledInstance(200, 50, Image.SCALE_SMOOTH);
		ImageIcon changeBtnicon2 = new ImageIcon("images/changeButton/노란변경하기버튼.png");
		Image changeBtnimg2 = changeBtnicon2.getImage();
		Image changeBtn2 = changeBtnimg2.getScaledInstance(200, 50, Image.SCALE_SMOOTH);
		/////////////////////////////////////////////////////////
		JButton changeButton = new JButton(new ImageIcon(changeBtn1));
		changeButton.setFont(new Font("굴림", Font.PLAIN, 0));
		changeButton.setBounds(260, 346, 196, 50);
		changeButton.setBorder(BorderFactory.createEmptyBorder());
		changeButton.setRolloverIcon(new ImageIcon(changeBtn2));	
		changeButton.addActionListener(new ActionListener() {
		 
		 */
		
		ImageIcon modifyBtnicon1 = new ImageIcon("images/changeButton/내정보수정하기버튼.png");
		Image modifyBtnimg1 = modifyBtnicon1.getImage();
		Image modifyBtn1 = modifyBtnimg1.getScaledInstance(300, 75, Image.SCALE_SMOOTH);
		ImageIcon modifyBtnicon2 = new ImageIcon("images/changeButton/노란내정보수정하기버튼.png");
		Image modifyBtnimg2 = modifyBtnicon2.getImage();
		Image modifyBtn2 = modifyBtnimg2.getScaledInstance(300, 75, Image.SCALE_SMOOTH);
		/////////////////////////////////////////////////////////
		JButton modifyButton = new JButton(new ImageIcon(modifyBtn1));
		modifyButton.setFont(new Font("굴림", Font.PLAIN, 0));
		modifyButton.setBounds(251, 379, 294, 75);
		modifyButton.setBorder(BorderFactory.createEmptyBorder());
		modifyButton.setRolloverIcon(new ImageIcon(modifyBtn2));	
		modifyButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MpChangePanel.mpLayout.show(MpChangePanel.mpPanel, "password");
				
			}
		});
		add(modifyButton);
		
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
		lblNewLabel.setBounds(314, 95, 2, 240);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("나의 정보를 확인합니다.");
		lblNewLabel_1.setFont(new Font("굴림", Font.PLAIN, 18));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(0, -11, 200, 40);
		add(lblNewLabel_1);
		
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		
	}
}
