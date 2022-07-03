package mypagepanel_comps.mp6;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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

import database.OjdbcConnection;
import methods.OnlyNumKeyAdaptor;
import methods.RestrictTextLength;
import panels.MainPanel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;

public class MpPhoneNumChangePanel extends JPanel {
	
	String newPhoneNum;
	String currPhoneNum;

	public MpPhoneNumChangePanel() {
		String sql2 = "SELECT * FROM members WHERE member_id = ?";
		try (Connection conn2 = OjdbcConnection.getConnection();
				PreparedStatement pstmt2 = conn2.prepareStatement(sql2);) {

			pstmt2.setString(1, MainPanel.currUserId);

			try (ResultSet rs = pstmt2.executeQuery()) {
				while (rs.next()) {

					currPhoneNum = rs.getString("phone_number");

				}
			}

		} catch (Exception e) {

		}

		String sql = "UPDATE members SET phone_number = ? WHERE member_id = ?";
		try (Connection conn = OjdbcConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);) {
			setLayout(null);

			setBounds(0, 58, 730, 511);

			///////////////////////////////////////////////////////////////////////
			ImageIcon icon1 = new ImageIcon("images/changeButton/하늘전화번호변경버튼.png");
			ImageIcon icon2 = new ImageIcon("images/changeButton/이메일변경버튼.png");
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
			pnChangeBtn.setFont(new Font("배달의민족 도현", Font.PLAIN, 0));
			pnChangeBtn.setIcon(new ImageIcon(changeImg1));
			pnChangeBtn.setBorder(BorderFactory.createEmptyBorder());
//		pnChangeBtn.setRolloverIcon(new ImageIcon(changeImg4));
			pnChangeBtn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					MpChangePanel.mpLayout.show(MpChangePanel.mpPanel, "phoneNum");
				}
			});
			pnChangeBtn.setBounds(463, 50, 196, 50);
			add(pnChangeBtn);

			/////////////////////////////////////////////////////////////////////////////////////
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

			/////////////////////////////////////////////////////////////////////////////////////

			JButton pwChangeBtn = new JButton("비밀번호 변경");
			pwChangeBtn.setFont(new Font("배달의민족 도현", Font.PLAIN, 0));
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

			/////////////////////////////////////////////////////////////////////////////////////

			JLabel pnLabel = new JLabel(currPhoneNum);
			pnLabel.setForeground(Color.WHITE);
			pnLabel.setFont(new Font("배달의민족 도현", Font.PLAIN, 16));
			pnLabel.setBounds(196, 162, 469, 51);
			add(pnLabel);
			
			JTextField textField1 = new JTextField("");
			textField1.setBounds(187, 229, 73, 36);
			textField1.addKeyListener(new RestrictTextLength(textField1, 3));//글자수 3자로 제한
			textField1.addKeyListener(new OnlyNumKeyAdaptor()); //숫자만 입력가능, 복붙차단
			add(textField1);
			
			
			JTextField textField2 = new JTextField("");
			textField2.setColumns(10);
			textField2.setBounds(285, 229, 84, 36);
			textField2.addKeyListener(new RestrictTextLength(textField2, 4));//글자수 3자로 제한
			textField2.addKeyListener(new OnlyNumKeyAdaptor()); //숫자만 입력가능, 복붙차단
			add(textField2);
			
			JTextField textField3 = new JTextField("");
			textField3.setColumns(10);
			textField3.setBounds(390, 229, 84, 36);
			textField3.addKeyListener(new RestrictTextLength(textField3, 4));//글자수 3자로 제한
			textField3.addKeyListener(new OnlyNumKeyAdaptor()); //숫자만 입력가능, 복붙차단
			add(textField3);
			
			KeyListener phoneNumKeyAdapter = new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					textField1.setFont(new Font("배달의민족 도현", Font.PLAIN, 20));
					textField2.setFont(new Font("배달의민족 도현", Font.PLAIN, 20));
					textField3.setFont(new Font("배달의민족 도현", Font.PLAIN, 20));
				}

				@Override
				public void keyReleased(KeyEvent e) {
					newPhoneNum = textField1.getText()+textField2.getText()+textField3.getText();
				}
			};
			textField1.addKeyListener(phoneNumKeyAdapter);		
			textField2.addKeyListener(phoneNumKeyAdapter);
			textField3.addKeyListener(phoneNumKeyAdapter);
			
			
			JLabel lblNewLabel = new JLabel("-");
			lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 15));
			lblNewLabel.setForeground(Color.WHITE);
			lblNewLabel.setBounds(267, 229, 20, 36);
			add(lblNewLabel);
			
			JLabel lblNewLabel_1 = new JLabel("-");
			lblNewLabel_1.setFont(new Font("굴림", Font.PLAIN, 15));
			lblNewLabel_1.setForeground(Color.WHITE);
			lblNewLabel_1.setBounds(377, 229, 20, 36);
			add(lblNewLabel_1);
			

			JLabel pnLabel2 = new JLabel("기존 전화번호");
			pnLabel2.setForeground(Color.WHITE);
			pnLabel2.setFont(new Font("배달의민족 도현", Font.PLAIN, 16));
			pnLabel2.setBounds(56, 162, 124, 51);
			add(pnLabel2);

			JLabel newPnLabel = new JLabel("새 전화번호");
			newPnLabel.setForeground(Color.WHITE);
			newPnLabel.setFont(new Font("배달의민족 도현", Font.PLAIN, 16));
			newPnLabel.setBounds(56, 223, 124, 51);
			add(newPnLabel);

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

					if (textField1.getText().equals("") || textField2.getText().equals("")|| textField3.getText().equals("")) {
						JOptionPane.showMessageDialog(MainPanel.thisFrame, "올바른 전화번호를 입력해 주세요");
					} else {
						try (Connection conn = OjdbcConnection.getConnection();
								PreparedStatement pstmt = conn.prepareStatement(sql);) {
							conn.setAutoCommit(false);
							pstmt.setString(1, newPhoneNum);
							pstmt.setString(2, MainPanel.currUserId);

							pstmt.executeUpdate();
							conn.commit();

						} catch (SQLException e1) {

							e1.printStackTrace();
						}

						JOptionPane.showMessageDialog(MainPanel.thisFrame, newPhoneNum + "로 번호가 변경되었습니다", "변경 완료", 1);
						textField1.setText("");
						textField2.setText("");
						textField3.setText("");
					}
				}
			});
			add(changeButton);

		} catch (Exception e) {

		}

	}
}
