package mypagepanel_comps;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import database.OjdbcConnection;
import labels.TopLabel;
import mypagepanel_comps.mp6.MpChangePanel;
import panels.ImagePanel;
import panels.MainPanel;

//계정 관리 Panel이 될 JPanel입니다

public class MyPageMainPanel6 extends ImagePanel {


	MpChangePanel mpPanel = new MpChangePanel();
	public static String pw;
	public static String inputPw;
	public MyPageMainPanel6(){
		
		
		String sql = "SELECT * FROM members WHERE member_id = ? ";
		
		try(
				Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				
		){
			
			
			pstmt.setString(1,MainPanel.currUserId);
			
			try (ResultSet rs = pstmt.executeQuery()) {
				while (rs.next()) {
					
					pw = rs.getString("member_password");
					
					setBackground(new Color(204, 235, 204));
					setBounds(118, 0, 1093, 800);	
					setLayout(null);
					CardLayout mpLayout = new CardLayout();
					
					JPanel panel = new JPanel(); 
					panel.setBounds(162, 155, 730, 569);
					panel.setLayout(mpLayout);
					add(panel);
					
					JLabel tableNameLabel = new JLabel("계정 관리");
					tableNameLabel.setForeground(Color.WHITE);
					tableNameLabel.setBounds(80, 60, 321, 60);
					add(tableNameLabel);
					tableNameLabel.setFont(new Font("Dialog", Font.BOLD, 58));
					
					JPanel tablePanel = new JPanel();
					tablePanel.setBounds(0, 58, 730, 511);
					
					tablePanel.setLayout(null);

					panel.add(tablePanel);
					panel.add(mpPanel);

					JLabel pwChangeLabel = new JLabel("비밀번호를 입력해주세요");
					pwChangeLabel.setFont(new Font("굴림", Font.PLAIN, 14));
					pwChangeLabel.setBounds(203, 50, 195, 39);
					tablePanel.add(pwChangeLabel);

					JPasswordField pwInputField = new JPasswordField();
					pwInputField.addKeyListener(new KeyAdapter() {
						
						@Override
						public void keyReleased(KeyEvent e) {
							char[] a = pwInputField.getPassword();
							
								inputPw = String.valueOf(a);				
						}	
					});
					
					pwInputField.setBounds(203, 100, 418, 73);		
					tablePanel.add(pwInputField);
					
					JLabel pwLabel = new JLabel("비밀번호");
					pwLabel.setFont(new Font("굴림", Font.PLAIN, 18));
					pwLabel.setBounds(72, 110, 108, 73);
					tablePanel.add(pwLabel);
					
					
					JButton okBtn = new JButton("확인");
					okBtn.setBounds(250, 270, 260, 83);
					tablePanel.add(okBtn);
					
					okBtn.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							
									if(pw.equals(inputPw)) {
										JOptionPane.showMessageDialog(MainPanel.thisFrame, "비밀번호가 일치합니다",
												"비밀번호 확인", 1);
										tablePanel.setVisible(false);
										mpPanel.setVisible(true);
									} else {
										JOptionPane.showMessageDialog(MainPanel.thisFrame, "비밀번호가 일치하지 않습니다",
												"비밀번호 오류", 1);
									}
						}
					});
					
					JLabel lblNewLabel = new JLabel("");
					lblNewLabel.setBackground(Color.WHITE);
					lblNewLabel.setOpaque(true);
					lblNewLabel.setBounds(80, 124, 800, 3);
					add(lblNewLabel);
				}
			}

		}  catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
}
