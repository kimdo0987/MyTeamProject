package mypagepanel_comps.mp6;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import database.OjdbcConnection;
import panels.MainPanel;

public class MpEmailChangePanel extends JPanel {
	public String newEmail;

	public MpEmailChangePanel() {

		String sql = "UPDATE members SET email = ? WHERE member_id = ?";
		try (
				Connection conn = OjdbcConnection.getConnection(); 
				PreparedStatement pstmt = conn.prepareStatement(sql);
		) {

			
			setLayout(null);

			setBounds(0, 58, 730, 511);

			JButton pnChangeBtn = new JButton("전화번호 변경");
			pnChangeBtn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					MpChangePanel.mpLayout.show(MpChangePanel.mpPanel, "phoneNum");

				}
			});
			pnChangeBtn.setBounds(463, 50, 202, 78);
			add(pnChangeBtn);

			/////////////////////////////////////////////////////////////////////////

			JButton emailChangeBtn = new JButton("이메일 변경");
			emailChangeBtn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					MpChangePanel.mpLayout.show(MpChangePanel.mpPanel, "email");

				}

			});
			emailChangeBtn.setBounds(260, 50, 202, 78);
			add(emailChangeBtn);

			/////////////////////////////////////////////////////////////////////////////////

			JButton pwChangeBtn = new JButton("비밀번호 변경");
			pwChangeBtn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					MpChangePanel.mpLayout.show(MpChangePanel.mpPanel, "password");

				}

			});
			pwChangeBtn.setBounds(56, 50, 202, 78);
			add(pwChangeBtn);

			JLabel emailLabel = new JLabel("abcde@naver.com");
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
			emailLabel2.setBounds(56, 162, 124, 51);
			add(emailLabel2);

			JLabel newEmailLabel = new JLabel("새 이메일");
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
		profileBtn.setBounds(24, 9, 93, 23);
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
