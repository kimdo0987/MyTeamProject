package mainpackage;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CustomServicePanel extends JPanel {
	public CustomServicePanel() {
		
		setBounds(0, 0, 677, 574);
		setLayout(null);
		
		JButton home = new JButton("메인");
		home.setBounds(10, 10, 100, 100);
		add(home);
		
		JLabel customask = new JLabel("고객문의");
		customask.setBounds(320, 10, 100, 100);
		add(customask);

		JButton privacy = new JButton("개인정보처리방침");
		privacy.setBounds(100, 150, 150, 80);
		add(privacy);
		
		JButton use = new JButton("이용약관");
		use.setBounds(260, 150, 150, 80);
		add(use);
		
		JButton road = new JButton("찾아오시는 길");
		road.setBounds(420, 150, 150, 80);
		add(road);
		
		JLabel squar = new JLabel("dd");
		squar.setBounds(320, 120, 400,400);
		add(squar);
		
		JButton join = new JButton("회원가입");
		join.setBounds(220, 400, 100, 100 );
		add(join);
		
		JButton log_in = new JButton("로그인");
		log_in.setBounds(340, 400, 100, 100);
		add(log_in);
		
		
		
		setVisible(true);
	}

	
	public static void main(String[] args) {
		
		JFrame custom = new JFrame();
		custom.add(new CustomServicePanel());
		custom.setBounds(100, 100, 700, 600);
		custom.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		custom.setVisible(true);
	}
}
