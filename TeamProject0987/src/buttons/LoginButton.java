package buttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import panels.LoginPanel;
import panels.MainPanel;
import panels.SignupPanel;

public class LoginButton extends JButton {
	static ImageIcon loginBtn_img = new ImageIcon("images/dohyun5.png");
	static ImageIcon loginBtn1_img = new ImageIcon("images/dohyun5-1.png");
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
		super(name, loginBtn_img);
		
		setBorderPainted(false);//테두리 안보이게하기
		setRolloverIcon(loginBtn1_img);//마우스 올렸을때 이미지
		addActionListener(eventListener);

	}

}
