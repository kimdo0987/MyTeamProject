package mypagepanel_comps;

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

import buttons.WishButton;
import database.OjdbcConnection;
import labels.TopLabel;
import methods.RestrictTextLength;
import panels.CustomerServicePanel;
import panels.ImagePanel;
import panels.MainPanel;

//회원 탈퇴 Panel이 될 JPanel입니다

public class MyPageMainPanel7 extends ImagePanel {
	
	private static String pwText = "";
	private static String searchPw;
	
	public MyPageMainPanel7() {
		setBackground(new Color(204, 200, 204));
		setBounds(118, 0, 1093, 800);	
		setLayout(null);
		
		JPanel panel = new JPanel(); //탈퇴시 안내사항label, 비밀번호작성 textField,버튼 이 들어가는 패널 (장바구니 panel)
		panel.setBounds(162, 155, 730, 569);
		panel.setLayout(null);
		add(panel);
		
		JLabel report = new JLabel("탈퇴시 안내사항");
		report.setBounds(320,80,200,200);
		panel.add(report);
		
		JLabel  explain = new JLabel("비밀번호를 입력해주세요");
		explain.setBounds(220,300,200,60);
		panel.add(explain);
		
		JPasswordField pwInput = new JPasswordField();
		add(pwInput);
		pwInput.setBounds(380, 500, 300, 30);
		pwInput.addKeyListener(new RestrictTextLength(pwInput, 12)); //글자수제한
		
//		pwInput.addKeyListener(new KeyAdapter() {				// 입력한것을 pwText에 받기
//			@Override
//			public void keyReleased(KeyEvent e) {
//				pwText = pwInput.getText().toString();
//			}	
//		});
		
		JButton leaveBtn = new JButton("탈퇴하기");
		leaveBtn.setBounds(260, 500, 200,40);
		panel.add(leaveBtn);
		
		leaveBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
//				JOptionPane.showMessageDialog(null, "정말 탈퇴하시겠습니까?", "WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
				
				int logoutBtnresult = JOptionPane.showConfirmDialog(MainPanel.thisFrame, "정말 탈퇴하시겠습니까?","Message",
						JOptionPane.OK_CANCEL_OPTION, 1);
				
				

				// currUserId에 해당하는 member_password 가 현재 pwText가 맞다면 -> 탈퇴진행
				if (logoutBtnresult == 0) {

					
					try (Connection conn = OjdbcConnection.getConnection();
							PreparedStatement pstmt1 = conn
									.prepareStatement("SELECT member_password FROM members "
											+ "WHERE member_id = ?");) {
						pstmt1.setString(1, MainPanel.currUserId);
						ResultSet rs1 = pstmt1.executeQuery();
						
						while (rs1.next()) {
							searchPw = rs1.getString(1);
						}
						
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					
					if (searchPw == null) {		// nullPointer 오류 잡기
						searchPw = "";
					}
					
					if (searchPw.equals(pwText)) {
						JOptionPane.showMessageDialog(null, "탈퇴가 완료되었습니다. \r\n이용해주셔서 감사합니다."			// 탈퇴멘트
								, "WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
						
						
						String sql1 = "DELETE FROM members WHERE member_id = ?";
						try (Connection conn = OjdbcConnection.getConnection();					// 데이터 삭제완료
								PreparedStatement pstmt = conn.prepareStatement(sql1);
								){
							conn.setAutoCommit(false);
							pstmt.setString(1, MainPanel.currUserId);
							pstmt.executeQuery();
							
							conn.commit();
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
//					커밋 시켜주기
						
						// currUserId 비워주기
						MainPanel.currUserId = "logout";
						
						// 입력했던 비밀번호 textfield와 그걸받은 값을 다시비워주기
						pwInput.setText("");
						pwText = "";
						
						// 로그아웃버튼  -> 로그인 버튼으로 만들어주기
						MainPanel.loginBtn.setVisible(true);
						MainPanel.logoutBtn.setVisible(false);
						
						CustomerServicePanel.loginBtn.setVisible(false);
						CustomerServicePanel.logoutBtn.setVisible(true);
						
						// 메인페이지로 설정해주기
						MainPanel.currPanel.setVisible(false);
						MainPanel.mainPanel.setVisible(true);			
						//이전 페이지가 없기 때문에 이전페이지설정 안함
						MainPanel.currPanel = MainPanel.mainPanel;
						
					} else {
						JOptionPane.showMessageDialog(null, "비밀번호가 일치하지 않습니다. \r\n다시 확인해주세요."
								, "WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
					}
					
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
