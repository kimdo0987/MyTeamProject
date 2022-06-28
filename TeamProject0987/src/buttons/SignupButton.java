package buttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import panels.MainPanel;
import panels.SignupPanel;

public class SignupButton extends JButton{
	static ImageIcon signUpBtn_img = new ImageIcon("images/dohyun4.png");
	static ImageIcon signUpBtn1_img = new ImageIcon("images/dohyun4-1.png");
	private static ActionListener eventListener = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
								
			MainPanel.currPanel.setVisible(false);
			MainPanel.thisFrame.remove(MainPanel.signUpPanel); 
			SignupPanel newSignupPanel = new SignupPanel();
			MainPanel.thisFrame.add(newSignupPanel);
			MainPanel.signUpPanel = newSignupPanel;
			MainPanel.signUpPanel.setVisible(true);
			
			MainPanel.lastPanel = MainPanel.currPanel;
			MainPanel.currPanel = MainPanel.signUpPanel;				
		}
	};
	
	public SignupButton(String name) {
		super(name, signUpBtn_img);

		setBorderPainted(false);//테두리 안보이게하기
		setRolloverIcon(signUpBtn1_img);//마우스 올렸을때 이미지
		addActionListener(eventListener);
		
	}

}
