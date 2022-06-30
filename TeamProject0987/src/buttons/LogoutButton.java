package buttons;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import panels.CustomerServicePanel;
import panels.MainPanel;

public class LogoutButton extends JButton {
	static ImageIcon logoutBtn_img = new ImageIcon("images/logoutBtn.png");
	static ImageIcon logoutBtn1_img = new ImageIcon("images/logoutBtn2.png");
	public LogoutButton(String text) {
		this.setBounds(609, 432, 118, 54);
		this.setText(text);
			
		this.setIcon(logoutBtn_img);
		this.setBorderPainted(false);//테두리 안보이게하기
		this.setRolloverIcon(logoutBtn1_img);//마우스 올렸을때 이미지

		
		addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int logoutBtnresult = JOptionPane.showConfirmDialog(MainPanel.thisFrame, "로그아웃 하시겠습니까?","Message",
						JOptionPane.OK_CANCEL_OPTION, 1);
				
				if (logoutBtnresult == 0) {
					
					//패널에관한 내용
					MainPanel.currPanel.setVisible(false);
					MainPanel.mainPanel.setVisible(true);
					MainPanel.lastPanel = MainPanel.currPanel;
					MainPanel.currPanel = MainPanel.mainPanel;
					
					
					
					
					//밑에부터는 버튼들에관한 내용
					MainPanel.logoutBtn.setVisible(false);
					MainPanel.loginBtn.setVisible(true);
					
					WishButton.lecIdArr.clear();
					CustomerServicePanel.logoutBtn.setVisible(false);
					CustomerServicePanel.loginBtn.setVisible(true);
					
					MainPanel.currUserId = "logout";
					
					// 회원가입 버튼 다시 보이게설정함
					MainPanel.signUpBtn.setVisible(true);
					CustomerServicePanel.join.setVisible(true);
					
				}
				
				
			}
			
		});
		
	
	}
	
	

}
