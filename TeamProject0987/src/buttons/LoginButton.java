package buttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import panels.LoginPanel;
import panels.MainPanel;
import panels.SignupPanel;

public class LoginButton extends JButton {

private static ActionListener eventListener = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
								
			MainPanel.currPanel.setVisible(false);
			MainPanel.thisFrame.remove(MainPanel.loginPanel);
			LoginPanel newLoginPanel = new LoginPanel();
			MainPanel.thisFrame.add(newLoginPanel);
			MainPanel.loginPanel = newLoginPanel;
			MainPanel.loginPanel.setVisible(true);
			
			MainPanel.lastPanel = MainPanel.currPanel;
			MainPanel.currPanel = MainPanel.loginPanel;				
		}
	};
	
	public LoginButton(String name) {
		super(name);
		addActionListener(eventListener);
		
	}
	
}
