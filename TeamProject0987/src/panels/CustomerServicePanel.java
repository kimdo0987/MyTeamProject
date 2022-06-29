package panels;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;

import buttons.GoToButton;
import buttons.LoginButton;
import buttons.LogoutButton;
import buttons.SignupButton;
import labels.TopLabel;

public class CustomerServicePanel extends JPanel {
	
	public static LoginButton loginBtn;
	public static LogoutButton logoutBtn;
	
	public CustomerServicePanel() {
		
		setBounds(0, 0, 1200, 800);
		setLayout(null);
		
		GoToButton mainBtn = new GoToButton("메인");
		mainBtn.setBounds(10, 10, 92, 66);
		add(mainBtn);
		
		TopLabel toplabel = new TopLabel("고객 문의");
		add(toplabel);		

		JButton privacy = new JButton("개인정보처리방침");
		privacy.setBounds(172, 150, 192, 80);
		add(privacy);
		
		JButton use = new JButton("이용약관");
		use.setBounds(461, 150, 192, 80);
		add(use);
		
		JButton road = new JButton("찾아오시는 길");
		road.setBounds(741, 150, 192, 80);
		add(road);
		
		SignupButton join = new SignupButton("회원가입");
		join.setBounds(331, 660, 153, 100 );
		add(join);
		
		loginBtn = new LoginButton ("로그인");
		loginBtn.setBounds(645, 660, 144, 100);
		add(loginBtn);
		
		logoutBtn = new LogoutButton("로그아웃");
		logoutBtn.setBounds(645, 660, 144, 100);
		add(logoutBtn);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 153, 204));
		panel.setBounds(159, 257, 802, 370);
		add(panel);
		
		
		
		setVisible(true);
	}
}
