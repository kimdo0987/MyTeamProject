package mypagepanel_comps.mp6;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import database.OjdbcConnection;
import panels.MainPanel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

public class MpPwChangePanel extends JPanel {
	String newPassword;
	String newPasswordCheck;
	String userName;
	
	
	public MpPwChangePanel() {
		String sql2 = "SELECT * FROM members WHERE member_id = ?";
		try (
				Connection conn2 = OjdbcConnection.getConnection(); 
				PreparedStatement pstmt2 = conn2.prepareStatement(sql2);
		) {
			
			pstmt2.setString(1, MainPanel.currUserId);
			
			try (ResultSet rs = pstmt2.executeQuery()) {
				while (rs.next()) {
					
					userName = rs.getString("member_name");
					
				}
			}
				
		}catch (Exception e) {

		}
		
		String sql = "UPDATE members SET member_password = ? WHERE member_id = ?";
		
		try (
				Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
		) {
			
			setLayout(null);

			setBounds(0, 58, 730, 511);
			
			///////////////////////////////////////////////////////////////////////
			ImageIcon icon1 = new ImageIcon("images/changeButton/전화번호변경버튼.png");
			ImageIcon icon2 = new ImageIcon("images/changeButton/이메일변경버튼.png");
			ImageIcon icon3 = new ImageIcon("images/changeButton/하늘비밀번호변경버튼.png");
			ImageIcon icon4 = new ImageIcon("images/changeButton/노란전화번호변경버튼.png");
			ImageIcon icon5 = new ImageIcon("images/changeButton/노란이메일변경버튼.png");
			ImageIcon icon6 = new ImageIcon("images/changeButton/노란비밀번호변경버튼.png");
			
			Image img1 = icon1.getImage();
			Image img2 = icon2.getImage();
			Image img3 = icon3.getImage();
			Image img4 = icon4.getImage();
			Image img5 = icon5.getImage();
			Image img6 = icon6.getImage();
			
			Image changeImg1 = img1.getScaledInstance(200, 50, Image.SCALE_SMOOTH);
			Image changeImg2 = img2.getScaledInstance(200, 50, Image.SCALE_SMOOTH);
			Image changeImg3 = img3.getScaledInstance(200, 50, Image.SCALE_SMOOTH);
			Image changeImg4 = img4.getScaledInstance(200, 50, Image.SCALE_SMOOTH);
			Image changeImg5 = img5.getScaledInstance(200, 50, Image.SCALE_SMOOTH);
			Image changeImg6 = img6.getScaledInstance(200, 50, Image.SCALE_SMOOTH);
			///////////////////////////////////////////////////////////////////////

			JButton pnChangeBtn = new JButton("전화번호 변경");
			pnChangeBtn.setFont(new Font("배달의민족 도현", Font.PLAIN, 0));
			pnChangeBtn.setIcon(new ImageIcon(changeImg1));
			pnChangeBtn.setBorder(BorderFactory.createEmptyBorder());
			pnChangeBtn.setRolloverIcon(new ImageIcon(changeImg4));
			pnChangeBtn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					MpChangePanel.mpLayout.show(MpChangePanel.mpPanel, "phoneNum");
				}
			});
			pnChangeBtn.setBounds(463, 50, 196, 50);
			add(pnChangeBtn);

			/////////////////////////////////////////////////////////////////////////

			JButton emailChangeBtn = new JButton("이메일 변경");
			emailChangeBtn.setFont(new Font("배달의민족 도현", Font.PLAIN, 0));
			emailChangeBtn.setIcon(new ImageIcon(changeImg2));
			emailChangeBtn.setRolloverIcon(new ImageIcon(changeImg5));
			emailChangeBtn.setBorder(BorderFactory.createEmptyBorder());
			emailChangeBtn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					MpChangePanel.mpLayout.show(MpChangePanel.mpPanel, "email");

				}
			});
			emailChangeBtn.setBounds(260, 50, 196, 50);
			add(emailChangeBtn);

			/////////////////////////////////////////////////////////////////////////////////
      
			JButton pwChangeBtn = new JButton("비밀번호 변경");
			pwChangeBtn.setFont(new Font("배달의민족 도현", Font.PLAIN, 0));
			pwChangeBtn.setIcon(new ImageIcon(changeImg3));
//			pwChangeBtn.setRolloverIcon(new ImageIcon(changeImg6));
			pwChangeBtn.setBorder(BorderFactory.createEmptyBorder());
			pwChangeBtn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					MpChangePanel.mpLayout.show(MpChangePanel.mpPanel, "password");

				}
			});
			pwChangeBtn.setBounds(56, 50, 196, 50);
			add(pwChangeBtn);
			///////////////////////////////////////////////////////////////////////
			ImageIcon profileBtnicon1 = new ImageIcon("images/changeButton/내정보버튼.png");
			Image profileBtnimg1 = profileBtnicon1.getImage();
			Image profileBtn1 = profileBtnimg1.getScaledInstance(200, 50, Image.SCALE_SMOOTH);
			ImageIcon profileBtnicon2 = new ImageIcon("images/changeButton/노란내정보버튼.png");
			Image profileBtnimg2 = profileBtnicon2.getImage();
			Image profileBtn2 = profileBtnimg2.getScaledInstance(200, 50, Image.SCALE_SMOOTH);
			JButton profileButton = new JButton(new ImageIcon(profileBtn1));
			profileButton.setFont(new Font("배달의민족 도현", Font.PLAIN, 0));
			profileButton.setBorder(BorderFactory.createEmptyBorder());
			profileButton.setRolloverIcon(new ImageIcon(profileBtn2));
			profileButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					MpChangePanel.mpLayout.show(MpChangePanel.mpPanel, "profile");
				}
	  	  	});
			profileButton.setBounds(56, 10, 100, 25);
		  	add(profileButton);


			JPasswordField newPwField = new JPasswordField();
			newPwField.setBounds(196, 212, 469, 51);
			newPwField.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					newPwField.setEchoChar('*');
					newPwField.setFont(new Font("배달의민족 도현", Font.PLAIN, 18));

				}
				
				@Override
				public void keyReleased(KeyEvent e) {
					char[] a = newPwField.getPassword();
					
						newPassword = String.valueOf(a);				
				}	
			});
			add(newPwField);

			JPasswordField newPwField2 = new JPasswordField();
			newPwField2.setColumns(10);
			newPwField2.setBounds(196, 273, 469, 51);
			newPwField2.addKeyListener(new KeyAdapter() {
				
				@Override
				public void keyTyped(KeyEvent e) {
					newPwField2.setEchoChar('*');
					newPwField2.setFont(new Font("배달의민족 도현", Font.PLAIN, 18));
				
				}
				@Override
				public void keyReleased(KeyEvent e) {
					char[] a = newPwField2.getPassword();
					
						newPasswordCheck = String.valueOf(a);				
				}	
			});
			add(newPwField2);

			JLabel newPwLabel = new JLabel("새 비밀번호");
			newPwLabel.setForeground(Color.WHITE);
			newPwLabel.setFont(new Font("배달의민족 도현", Font.PLAIN, 16));
			newPwLabel.setBounds(56, 212, 124, 51);
			add(newPwLabel);

			JLabel newPwLabel2 = new JLabel("새 비밀번호 확인");
			newPwLabel2.setFont(new Font("배달의민족 도현", Font.PLAIN, 16));
			newPwLabel2.setForeground(Color.WHITE);
			newPwLabel2.setBounds(56, 273, 124, 51);
			add(newPwLabel2);

			JLabel nameLabel = new JLabel("이름");
			nameLabel.setFont(new Font("배달의민족 도현", Font.PLAIN, 16));
			nameLabel.setForeground(Color.WHITE);
			nameLabel.setBounds(56, 151, 124, 51);
			add(nameLabel);

			JLabel nameLabel2 = new JLabel(userName);
			nameLabel2.setFont(new Font("배달의민족 도현", Font.PLAIN, 16));
			nameLabel2.setForeground(Color.WHITE);
			nameLabel2.setBounds(197, 151, 207, 51);
			add(nameLabel2);
			
			/////////////////////////////////////////////////////////
			ImageIcon changeBtnicon1 = new ImageIcon("images/changeButton/변경하기버튼.png");
			Image changeBtnimg1 = changeBtnicon1.getImage();
			Image changeBtn1 = changeBtnimg1.getScaledInstance(200, 50, Image.SCALE_SMOOTH);
			ImageIcon changeBtnicon2 = new ImageIcon("images/changeButton/노란변경하기버튼.png");
			Image changeBtnimg2 = changeBtnicon2.getImage();
			Image changeBtn2 = changeBtnimg2.getScaledInstance(200, 50, Image.SCALE_SMOOTH);
			/////////////////////////////////////////////////////////
			JButton changeButton = new JButton(new ImageIcon(changeBtn1));
			changeButton.setFont(new Font("배달의민족 도현", Font.PLAIN, 0));
			changeButton.setBounds(260, 346, 196, 50);
			changeButton.setBorder(BorderFactory.createEmptyBorder());
			changeButton.setRolloverIcon(new ImageIcon(changeBtn2));
			changeButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					try(
						Connection conn = OjdbcConnection.getConnection(); 
						PreparedStatement pstmt = conn.prepareStatement(sql);
					) {
						conn.setAutoCommit(false);
						if(newPasswordCheck.equals(newPassword)){
						pstmt.setString(1, newPasswordCheck);
						pstmt.setString(2, MainPanel.currUserId);
						
						pstmt.executeUpdate();
						conn.commit();
						
						JOptionPane.showMessageDialog(
								MainPanel.thisFrame, "비밀번호가 변경되었습니다", "변경 완료", 1);
						newPwField.setText("");
						newPwField2.setText("");
							
						} else if (!newPasswordCheck.equals(newPassword)) {
							JOptionPane.showMessageDialog(
									MainPanel.thisFrame, "비밀번호가 일치하지않습니다", "변경 완료", 1);
							newPwField.setText("");
							newPwField2.setText("");
						}
					} catch (SQLException e1) {

						e1.printStackTrace();
					}
					
				}
			});
			add(changeButton);

		} catch (Exception e) {

		}


	}

}
