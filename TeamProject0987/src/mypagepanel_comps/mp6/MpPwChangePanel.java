package mypagepanel_comps.mp6;

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
import panels.MainPanel;

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
      
      JButton profileBtn = new JButton("내 정보");
      profileBtn.addActionListener(new ActionListener() {
			  public void actionPerformed(ActionEvent e) {
			  MpChangePanel.mpLayout.show(MpChangePanel.mpPanel, "profile");
			  }
  	  });
      profileBtn.setBounds(24, 9, 93, 23);
	  	add(profileBtn);

			JButton pwChangeBtn = new JButton("비밀번호 변경");
			pwChangeBtn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					MpChangePanel.mpLayout.show(MpChangePanel.mpPanel, "password");

				}

			});
			pwChangeBtn.setBounds(56, 50, 202, 78);
			add(pwChangeBtn);

			JPasswordField newPwField = new JPasswordField();
			newPwField.setBounds(196, 212, 469, 51);
			newPwField.addKeyListener(new KeyAdapter() {
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
				public void keyReleased(KeyEvent e) {
					char[] a = newPwField2.getPassword();
					
						newPasswordCheck = String.valueOf(a);				
				}	
			});
			add(newPwField2);

			JLabel newPwLabel = new JLabel("새 비밀번호");
			newPwLabel.setBounds(56, 212, 124, 51);
			add(newPwLabel);

			JLabel newPwLabel2 = new JLabel("새 비밀번호 확인");
			newPwLabel2.setBounds(56, 273, 124, 51);
			add(newPwLabel2);

			JLabel nameLabel = new JLabel("이름");
			nameLabel.setBounds(56, 151, 124, 51);
			add(nameLabel);

			JLabel nameLabel2 = new JLabel(userName);
			nameLabel2.setBounds(197, 151, 207, 51);
			add(nameLabel2);

			JButton pwChangeOkBtn = new JButton("변경 하기");
			pwChangeOkBtn.setBounds(260, 346, 202, 78);
			pwChangeOkBtn.addActionListener(new ActionListener() {

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
			add(pwChangeOkBtn);

		} catch (Exception e) {

		}


	}

}
