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

public class MpPhoneNumChangePanel extends JPanel {
	
	public String newPhoneNum;
	
	public MpPhoneNumChangePanel() {
		
		String sql = "UPDATE members SET phone_number = ? WHERE member_id = ?";
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

		/////////////////////////////////////////////////////////////////////////////////////
		JButton emailChangeBtn = new JButton("이메일 변경");
		emailChangeBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MpChangePanel.mpLayout.show(MpChangePanel.mpPanel, "email");

			}

		});
		emailChangeBtn.setBounds(260, 50, 202, 78);
		add(emailChangeBtn);

		/////////////////////////////////////////////////////////////////////////////////////

		JButton pwChangeBtn = new JButton("비밀번호 변경");
		pwChangeBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MpChangePanel.mpLayout.show(MpChangePanel.mpPanel, "password");

			}

		});
		pwChangeBtn.setBounds(56, 50, 202, 78);
		add(pwChangeBtn);

		/////////////////////////////////////////////////////////////////////////////////////

		JLabel pnLabel = new JLabel("010-1234-1234");
		pnLabel.setBounds(196, 162, 469, 51);
		add(pnLabel);

		JTextField newPnField = new JTextField();
		newPnField.setBounds(196, 223, 469, 51);
		newPnField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				newPhoneNum = newPnField.getText();
			}

		});
		add(newPnField);

		JLabel pnLabel2 = new JLabel("기존 전화번호");
		pnLabel2.setBounds(56, 162, 124, 51);
		add(pnLabel2);

		JLabel newPnLabel = new JLabel("새 전화번호");
		newPnLabel.setBounds(56, 223, 124, 51);
		add(newPnLabel);

		JButton ChangeOkBtn = new JButton("변경 하기");
		ChangeOkBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try(
					Connection conn = OjdbcConnection.getConnection(); 
					PreparedStatement pstmt = conn.prepareStatement(sql);
				) {
					conn.setAutoCommit(false);
					pstmt.setString(1, newPhoneNum);
					pstmt.setString(2, MainPanel.currUserId);
					
					pstmt.executeUpdate();
					conn.commit();
					
				} catch (SQLException e1) {

					e1.printStackTrace();
				}
				
				JOptionPane.showMessageDialog(MainPanel.thisFrame, newPhoneNum + "로 번호가 변경되었습니다", "변경 완료", 1);
				newPnField.setText("");
			}
		});
		ChangeOkBtn.setBounds(260, 346, 202, 78);
		add(ChangeOkBtn);
		} catch (Exception e) {

		}
	}
}
