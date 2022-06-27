package buttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import panels.MainPanel;
import panels.SignupPanel;

public class SignupButton extends JButton{

	private static ActionListener eventListener = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
								
			MainPanel.currPanel.setVisible(false);
			SignupPanel newSignupPanel = new SignupPanel();
			MainPanel.thisFrame.add(newSignupPanel);
			MainPanel.signUpPanel = newSignupPanel;
			
			MainPanel.signUpPanel.setVisible(true);
			MainPanel.lastPanel = MainPanel.currPanel;
			MainPanel.currPanel = MainPanel.signUpPanel;				
		}
	};
	
	public SignupButton(String name) {
		super(name);
		addActionListener(eventListener);
		
	}

}
