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

import panels.MainPanel;

public class LogoutButton extends JButton {
	
	public LogoutButton(String text) {
		this.setBounds(609, 432, 118, 54);
		this.setText(text);
		
		addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int logoutBtnresult = JOptionPane.showConfirmDialog(MainPanel.thisFrame, "로그아웃 하시겠습니까?","Message",
						JOptionPane.OK_CANCEL_OPTION, 1);
				
				if (logoutBtnresult == 0) {
					MainPanel.logoutBtn.setVisible(false);
					MainPanel.loginBtn.setVisible(true);
					MainPanel.currUserId = "";
					
					System.out.println(MainPanel.currUserId);
				}
				
				
			}
			
		});
	}
	

}
