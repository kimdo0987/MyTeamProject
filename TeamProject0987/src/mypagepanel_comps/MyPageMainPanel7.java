package mypagepanel_comps;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
		panel.setBackground(Color.WHITE);
		panel.setBounds(80, 154, 800, 424);
		panel.setLayout(null);
		add(panel);
		
		JLabel tableNameLabel = new JLabel("회원 탈퇴");
		tableNameLabel.setForeground(Color.WHITE);
		tableNameLabel.setBounds(80, 40, 400, 90);
		add(tableNameLabel);
		tableNameLabel.setFont(new Font("배달의민족 도현", Font.PLAIN, 58));
		
		/*
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
		*/
		
		ImageIcon notifyicon = new ImageIcon("images/mp7/탈퇴안내.png");
		Image notifyimg = notifyicon.getImage();
		Image notify = notifyimg.getScaledInstance(570, 400, Image.SCALE_SMOOTH);
		JLabel report = new JLabel(new ImageIcon(notify));
		report.setBounds(12,10,570,400);
		report.setFont(new Font("굴림", Font.PLAIN, 0));
		panel.add(report);
		
		JPasswordField pwInput = new JPasswordField();
		add(pwInput);
		pwInput.setBounds(437, 604, 273, 45);
		pwInput.addKeyListener(new RestrictTextLength(pwInput, 12)); //글자수제한
		
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBounds(80, 124, 800, 3);
		add(lblNewLabel);
		
//		pwInput.addKeyListener(new KeyAdapter() {				// 입력한것을 pwText에 받기
//			@Override
//			public void keyReleased(KeyEvent e) {
//				pwText = pwInput.getText().toString();
//			}	
//		});
		
		ImageIcon leaveBtnicon1 = new ImageIcon("images/mp7/탈퇴하기버튼.png");
		Image leaveBtnimg1 = leaveBtnicon1.getImage();
		Image leaveBtn1 = leaveBtnimg1.getScaledInstance(300, 75, Image.SCALE_SMOOTH);
		ImageIcon leaveBtnicon2 = new ImageIcon("images/mp7/노란탈퇴하기버튼.png");
		Image leaveBtnimg2 = leaveBtnicon2.getImage();
		Image leaveBtn2 = leaveBtnimg2.getScaledInstance(300, 75, Image.SCALE_SMOOTH);
		JButton leaveButton = new JButton(new ImageIcon(leaveBtn1));
		leaveButton.setFont(new Font("굴림", Font.PLAIN, 0));
		leaveButton.setBounds(351, 658, 294, 75);
		leaveButton.setBorder(BorderFactory.createEmptyBorder());
		leaveButton.setRolloverIcon(new ImageIcon(leaveBtn2));
		add(leaveButton);
		
		JLabel explain = new JLabel("비밀번호를 입력해주세요");
		explain.setFont(new Font("배달의민족 도현", Font.PLAIN, 16));
		explain.setForeground(Color.WHITE);
		explain.setBounds(237, 595, 200, 60);
		add(explain);
		
		
		
		leaveButton.addActionListener(new ActionListener() {
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
					
					pwText = String.valueOf(pwInput.getPassword());
					System.out.println(pwText);
					if (searchPw.equals(pwText)) {
						JOptionPane.showMessageDialog(null, "탈퇴가 완료되었습니다. \r\n이용해주셔서 감사합니다."			// 탈퇴멘트
								, "WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
						
						
						String sql1 = "DELETE FROM members WHERE member_id = ?";
						String sql2 = "DELETE FROM favorite_category WHERE member_id = ?";
						try (Connection conn = OjdbcConnection.getConnection();					// 데이터 삭제완료
								PreparedStatement pstmt = conn.prepareStatement(sql1);
								PreparedStatement pstmt2 = conn.prepareStatement(sql2);
								){
							conn.setAutoCommit(false);
							pstmt.setString(1, MainPanel.currUserId);
							pstmt2.setString(2, MainPanel.currUserId);
							pstmt.executeQuery();
							pstmt2.executeQuery();
							
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
	}
}
