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
import javax.swing.JTextField;

import LectureInfoPanel_comps.LectureInfoPanel1;
import buttons.GoToButton;
import database.OjdbcConnection;
import panels.LectureInfoPanel;
import panels.LectureSearchPanel;
import panels.MainPanel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;

public class MpEmailChangePanel extends JPanel {
	String newEmail;
	String currEmail;
	
	public MpEmailChangePanel() {
		setOpaque(false);
		setBackground(Color.DARK_GRAY);
		String sql2 = "SELECT * FROM members WHERE member_id = ?";
		try (
				Connection conn2 = OjdbcConnection.getConnection(); 
				PreparedStatement pstmt2 = conn2.prepareStatement(sql2);
		) {
			
			pstmt2.setString(1, MainPanel.currUserId);
			
			try (ResultSet rs = pstmt2.executeQuery()) {
				while (rs.next()) {
					
					currEmail = rs.getString("email");
					
				}
			}
				
		}catch (Exception e) {

		}

		String sql = "UPDATE members SET email = ? WHERE member_id = ?";
		try (
				Connection conn = OjdbcConnection.getConnection(); 
				PreparedStatement pstmt = conn.prepareStatement(sql);
		) {

			
			setLayout(null);

			setBounds(0, 58, 730, 511);
			
//			ImageIcon icon = new ImageIcon("images/homeBtn.png");
//			
//			Image img = icon.getImage();
//			// 창의 사이즈인 500,500에 맞춰서 이미지를 변경
//			Image changeImg = img.getScaledInstance(80, 80, Image.SCALE_SMOOTH);
//			ImageIcon changeIcon = new ImageIcon(changeImg);
//				
//
//				GoToButton mainBtn = new GoToButton("메인");
//				mainBtn.setFont(new Font("굴림", Font.PLAIN, 0));
//				mainBtn.setIcon(new ImageIcon("images/homeBtn.png"));
//				mainBtn.setBorderPainted(false);
//				mainBtn.setBounds(1037, 38, 46, 44);
			///////////////////////////////////////////////////////////////////////
			ImageIcon icon1 = new ImageIcon("images/changeButton/전화번호변경버튼.png");
			ImageIcon icon2 = new ImageIcon("images/changeButton/하늘이메일변경버튼.png");
			ImageIcon icon3 = new ImageIcon("images/changeButton/비밀번호변경버튼.png");
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
			pnChangeBtn.setFont(new Font("굴림", Font.PLAIN, 0));
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

			///////////////////////////////////////////////////////////////////////

			JButton emailChangeBtn = new JButton("이메일 변경");
			emailChangeBtn.setFont(new Font("굴림", Font.PLAIN, 0));
			emailChangeBtn.setIcon(new ImageIcon(changeImg2));
//			emailChangeBtn.setRolloverIcon(new ImageIcon(changeImg5));
			emailChangeBtn.setBorder(BorderFactory.createEmptyBorder());
			emailChangeBtn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					MpChangePanel.mpLayout.show(MpChangePanel.mpPanel, "email");

				}
			});
			emailChangeBtn.setBounds(260, 50, 196, 50);
			add(emailChangeBtn);

			///////////////////////////////////////////////////////////////////////

			JButton pwChangeBtn = new JButton("비밀번호 변경");
			pwChangeBtn.setFont(new Font("굴림", Font.PLAIN, 0));
			pwChangeBtn.setIcon(new ImageIcon(changeImg3));
			pwChangeBtn.setRolloverIcon(new ImageIcon(changeImg6));
			pwChangeBtn.setBorder(BorderFactory.createEmptyBorder());
			pwChangeBtn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					MpChangePanel.mpLayout.show(MpChangePanel.mpPanel, "password");

				}
			});
			pwChangeBtn.setBounds(56, 50, 196, 50);
			add(pwChangeBtn);
			
			/////////////////////////////////////////////////////////////////////////////////

			JLabel emailLabel = new JLabel(currEmail);
			emailLabel.setForeground(Color.WHITE);
			emailLabel.setFont(new Font("굴림", Font.PLAIN, 16));
			emailLabel.setBounds(196, 162, 469, 51);
			add(emailLabel);

			JTextField newEmailField = new JTextField();
			newEmailField.setBounds(196, 223, 469, 51);
			newEmailField.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					newEmail = newEmailField.getText();
				}

			});

			add(newEmailField);

			JLabel emailLabel2 = new JLabel("기존 이메일");
			emailLabel2.setForeground(Color.WHITE);
			emailLabel2.setFont(new Font("굴림", Font.PLAIN, 16));
			emailLabel2.setBounds(56, 162, 124, 51);
			add(emailLabel2);

			JLabel newEmailLabel = new JLabel("새 이메일");
			newEmailLabel.setForeground(Color.WHITE);
			newEmailLabel.setFont(new Font("굴림", Font.PLAIN, 16));
			newEmailLabel.setBounds(56, 223, 124, 51);
			add(newEmailLabel);

	  	JButton emailChangeOkBtn = new JButton("변경 하기");
	  	emailChangeOkBtn.setBounds(260, 346, 202, 78);
  		add(emailChangeOkBtn);
      
   		JButton profileBtn = new JButton("내 정보");
  		profileBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MpChangePanel.mpLayout.show(MpChangePanel.mpPanel, "profile");
			}
		});
		profileBtn.setBounds(56, 10, 93, 23);
		add(profileBtn);


		emailChangeOkBtn.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					try(
						Connection conn = OjdbcConnection.getConnection(); 
						PreparedStatement pstmt = conn.prepareStatement(sql);
					) {
						conn.setAutoCommit(false);
						pstmt.setString(1, newEmail);
						pstmt.setString(2, MainPanel.currUserId);
						
						pstmt.executeUpdate();
						conn.commit();
						
					} catch (SQLException e1) {

						e1.printStackTrace();
					}
					
					JOptionPane.showMessageDialog(
							MainPanel.thisFrame, newEmail + "로 이메일이 변경되었습니다", "변경 완료", 1);
					newEmailField.setText("");
					
					
				}
			});



		} catch (Exception e) {

		}


	}

	}

