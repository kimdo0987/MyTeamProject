package mypagepanel_comps;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
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
import mypagepanel_comps.mp6.MpChangePanel;
import mypagepanel_comps.mp6.MyProfilePanel;
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
					panel.setOpaque(false);
					panel.setBounds(80, 152, 800, 612);
					panel.setLayout(mpLayout);
					add(panel);
					
					JLabel tableNameLabel = new JLabel("계정 관리");
					tableNameLabel.setForeground(Color.WHITE);
					tableNameLabel.setBounds(80, 60, 321, 60);
					add(tableNameLabel);
					tableNameLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 58));
					
					JPanel tablePanel = new JPanel();
					tablePanel.setOpaque(false);
					tablePanel.setBounds(0, 58, 730, 511);
					
					tablePanel.setLayout(null);

					panel.add(tablePanel);
					panel.add(mpPanel);

					JLabel pwChangeLabel = new JLabel("비밀번호를 입력해주세요");
					pwChangeLabel.setForeground(Color.WHITE);
					pwChangeLabel.setFont(new Font("맑은 고딕", Font.BOLD, 18));
					pwChangeLabel.setBounds(205, 163, 356, 57);
					tablePanel.add(pwChangeLabel);

					JPasswordField pwInputField = new JPasswordField();
					pwInputField.addKeyListener(new KeyAdapter() {
						
						@Override
						public void keyReleased(KeyEvent e) {
							char[] a = pwInputField.getPassword();
							
								inputPw = String.valueOf(a);				
						}	
					});
					
					pwInputField.setBounds(205, 223, 418, 73);		
					tablePanel.add(pwInputField);
					
					JLabel pwLabel = new JLabel("비밀번호");
					pwLabel.setForeground(Color.WHITE);
					pwLabel.setFont(new Font("맑은 고딕", Font.BOLD, 18));
					pwLabel.setBounds(101, 222, 92, 73);
					tablePanel.add(pwLabel);
					
					
					JLabel lblNewLabel_1 = new JLabel("<html><body>계정 관리 페이지는 보안 사고 예방을 위해 <br/> 고객님의 비밀번호 재 확인이 필요합니다.</body></html>");
					lblNewLabel_1.setFont(new Font("맑은 고딕", Font.BOLD, 24));
					lblNewLabel_1.setForeground(Color.WHITE);
					lblNewLabel_1.setBounds(0, -16, 498, 112);
					tablePanel.add(lblNewLabel_1);
					
					ImageIcon okBtnicon1 = new ImageIcon("images/mongBtn/chkButton.png");
					Image okBtnimg1 = okBtnicon1.getImage();
					Image okBtn1 = okBtnimg1.getScaledInstance(70, 70, Image.SCALE_SMOOTH);
					ImageIcon okBtnicon2 = new ImageIcon("images/mongBtn/YchkButton.png");
					Image okBtnimg2 = okBtnicon2.getImage();
					Image okBtn2 = okBtnimg2.getScaledInstance(70, 70, Image.SCALE_SMOOTH);
					
					JButton okButton = new JButton(new ImageIcon(okBtn1));
					okButton.setFont(new Font("굴림", Font.PLAIN, 0));
					okButton.setBounds(552, 306, 69, 69);
					okButton.setBorder(BorderFactory.createEmptyBorder());
					okButton.setRolloverIcon(new ImageIcon(okBtn2));
					tablePanel.add(okButton);
					okButton.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							if(pw.equals(inputPw)) {
								JOptionPane.showMessageDialog(MainPanel.thisFrame, "비밀번호가 일치합니다",
										"비밀번호 확인", 1);
								tablePanel.setVisible(false);
								mpPanel = new MpChangePanel();
								panel.add(mpPanel);
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
