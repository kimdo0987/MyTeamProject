package panels;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import buttons.GoToButton;
import buttons.LoginButton;
import buttons.LogoutButton;
import buttons.SignupButton;

public class CustomerServicePanel extends ImagePanel {

	public static GoToButton loginBtn;
	public static LogoutButton logoutBtn;

	public CustomerServicePanel() {
		CardLayout customerLmg = new CardLayout();

		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 153, 204));
		panel.setBounds(203, 361, 802, 370);
		add(panel);
		panel.setLayout(customerLmg);

		setBounds(0, 0, 1200, 800);
		setLayout(null);

		JLabel lblNewLabel = new JLabel("개인정보처리방침");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("배달의민족 도현", Font.BOLD, 54));
		lblNewLabel.setBounds(203, 57, 573, 80);
		add(lblNewLabel);

		ImageIcon icon = new ImageIcon("images/homeButton.png");
		Image img = icon.getImage();
		// 창의 사이즈인 500,500에 맞춰서 이미지를 변경
		Image changeImg = img.getScaledInstance(80, 80, Image.SCALE_SMOOTH);
		ImageIcon changeIcon = new ImageIcon(changeImg);
		
		GoToButton mainBtn = new GoToButton("메인");
		mainBtn.setFont(new Font("굴림", Font.PLAIN, 0));
		mainBtn.setIcon(changeIcon);
		mainBtn.setBorderPainted(false);
		mainBtn.setBounds(20, 31, 75, 75);
		mainBtn.setBackground(Color.WHITE);
		mainBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MainPanel.myPagePanel.setVisible(false);
			}
		});
		
		add(mainBtn);		
		
		String useStr ="<html><body style='text-align:left;'>서비스의 원활한 제공을 위하여 회원이 동의한 목적과 범위 내에서만 개인정보를 수집하며,"
				+ "<br/>\r\n개인정보 보호 관련 법령에 따라 안전하게 관리합니다.</body></html>"; 
		String privacyStr = "<html><body style='text-align:left;'>이용자 여러분의 프라이버시를 소중하게 생각합니다. <br/>\r\n이용자 프라이버시 보호를 위한 다양한 활동과 유용한  정보들을 확인하실 수 있습니다</body></html>";
		String roadStr = "<html><body style='text-align:left;'>센터를 찾아오실 수 있는 교통수단별 안내와 다양한 편의시설 안내입니다.";
		JLabel explainLabel = new JLabel(privacyStr);
		explainLabel.setForeground(Color.WHITE);
		explainLabel.setFont(new Font("배달의민족 도현", Font.BOLD, 20));
		explainLabel.setBounds(203, 259, 802, 80);
		add(explainLabel);
		
		
		JButton privacy = new JButton("개인정보처리방침");
		privacy.setBackground(Color.WHITE);
		privacy.setFont(new Font("배달의민족 도현", Font.BOLD, 19));
		privacy.setBounds(203, 169, 192, 80);
		privacy.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				customerLmg.show(panel, "개인정보");
				explainLabel.setText(privacyStr);
				lblNewLabel.setText("개인정보처리방침");
			}
		});
		add(privacy);
	
		
		
		JButton use = new JButton("이용약관");
		use.setBackground(Color.WHITE);
		use.setFont(new Font("배달의민족 도현", Font.BOLD, 19));
		use.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				customerLmg.show(panel, "이용약관");
				explainLabel.setText(useStr);
				lblNewLabel.setText("이용약관");
			}
		});
		use.setBounds(407, 169, 192, 80);
		add(use);

		JButton road = new JButton("찾아오시는 길");
		road.setBackground(Color.WHITE);
		road.setFont(new Font("배달의민족 도현", Font.BOLD, 19));

		road.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				customerLmg.show(panel, "오시는길");
				explainLabel.setText(roadStr);
				lblNewLabel.setText("찾아오시는길");
			}
		});
		road.setBounds(611, 169, 192, 80);
		add(road);

		SignupButton join = new SignupButton("");
		join.setBounds(1050, 31, 115, 115);
		add(join);

		LoginButton loginBtn = new LoginButton("");
		loginBtn.setBounds(1050, 181, 115, 115);
		add(loginBtn);

		logoutBtn = new LogoutButton("로그아웃");
		logoutBtn.setBounds(1050, 331, 115, 115);
		add(logoutBtn);

		JLabel privacyLabel = new JLabel();

		privacyLabel.setIcon(new ImageIcon("images/개인정보처리방침.png"));

		panel.add(privacyLabel, "개인정보");

		JLabel useLabel = new JLabel();
		useLabel.setIcon(new ImageIcon("images/이용약관.png"));
		panel.add(useLabel, "이용약관");

		JLabel roadLabel = new JLabel();
		roadLabel.setIcon(new ImageIcon("images/약도.png"));
		panel.add(roadLabel, "오시는길");
		
		
		
		JLabel lblNewLabel_1 = new JLabel("───────────────────────────────────");
		lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 35));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(203, 144, 802, 15);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("메인");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("배달의민족 도현", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(37, 112, 38, 25);
		add(lblNewLabel_2);
		
		
	

		setVisible(true);
	}
}
