
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

	public static SignupButton join;
	public static LoginButton loginBtn;
	public static LogoutButton logoutBtn;

	public CustomerServicePanel() {
		CardLayout customerLmg = new CardLayout();

		ImagePanel panel = new ImagePanel();
		panel.setBounds(203, 369, 802, 360);
		add(panel);
		panel.setLayout(customerLmg);
		
		setBounds(0, 0, 1200, 800);
		setLayout(null);

		JLabel lblNewLabel = new JLabel("개인정보처리방침");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("배달의민족 도현", Font.BOLD | Font.ITALIC, 54));
		lblNewLabel.setBounds(203, 57, 573, 80);
		add(lblNewLabel);

		
		GoToButton mainBtn = new GoToButton("메인");
		mainBtn.setFont(new Font("굴림", Font.PLAIN, 0));
		mainBtn.setIcon(new ImageIcon("images/homeBtn.png"));
		mainBtn.setRolloverIcon(new ImageIcon("images/homeBtn2.png"));
		mainBtn.setBorderPainted(false);
		mainBtn.setBounds(20, 31, 95, 95);
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
		String roadStr = "<html><body style='text-align:left;'>센터를 찾아오실 수 있는 교통수단별 안내와 다양한 편의시설 안내입니다. <br> "
				+ "주소: 서울특별시 강남구 신사동 도산대로 173 / 연락처: 02-549-1500 <br> 고객센터 영업시간: 월-토 오전 09:00 ~ 06:30";
		JLabel explainLabel = new JLabel(privacyStr);
		explainLabel.setForeground(Color.WHITE);
		explainLabel.setFont(new Font("배달의민족 도현", Font.BOLD, 20));
		explainLabel.setBounds(203, 301, 840, 80);
		add(explainLabel);
		
		String privacyStr1 = "<html><body style='text-align:left;'>개인정보 보호원칙<br/>"
				+ "임직원은 이용자의 개인정보 및 프라이버시 보호를 위하여 다음의 원칙을 준수합니다. <br/>\r\n"
				+ "\r\n\r\n"
				+ "첫째, 개인정보 보호에 관한 모든 관련 법령과 국제 기준을 준수합니다. <br/>\r\n"
				+ "서비스 기획부터 종료까지 개인정보 보호법, 정보통신망 이용촉진 및 정보보호 등에 관한 법률, 위치정보의 보호 및 이용 등에 관한 법률 등 "
				+ "국내의 개인정보 보호 법령을 철저히 준수합니다. <br/>\r\n또한 OECD의 개인정보 보호 가이드라인 등 국제 기준을 준수하여 서비스를 제공합니다. <br/>\r\n\r\n\r\n"
				+ "둘째, 회원 개인정보의 처리를 항상 투명하게 공개합니다. <br/>\r\n"
				+ "서비스 제공을 위해 수집한 개인정보가 어떤 목적으로 활용되며, 어떻게 관리되고, 언제 파기 되는지 투명하게 공개합니다. <br/>\r\n"
				+ "프라이버시 센터, 개인정보 보호 블로그 · SNS 등을 통해 항상 네이버 이용자와 적극 소통합니다. <br/>\r\n"
				+ "\r\n"
				+ "";
		
		
		String useStr1 = "<html><body style='text-align:left;'> 여러분의 개인정보를 소중히 보호합니다. <br/>\r\n"
				+ "서비스의 원활한 제공을 위하여 회원이 동의한 목적과 범위 내에서만 개인정보를 수집.이용하며, <br/>\r\n"
				+ "개인정보 보호 관련 법령에 따라 안전하게 관리합니다. <br/>\r\n"
				+ "이용자 및 회원에 대해 관련 개인정보를 안전하게 처리하기 위하여 기울이는 노력이나 기타 상세한 사항은 개인정보 처리방침에서 확인하실 수 있습니다. <br/>\r\n"
				+ "여러분이 서비스를 이용하기 위해 일정 기간 동안 로그인 혹은 접속한 기록이 없는 경우, <br/>\r\n"
				+ "전자메일, 서비스 내 알림 또는 기타 적절한 전자적 수단을 통해 사전에 안내해 드린 후<br/>\r\n"
				+ "여러분의 정보를 파기하거나 분리 보관할 수 있으며, 만약 이로 인해 서비스 제공을 위해 필수적인 정보가 부족해질 경우 부득이 관련 서비스 이용계약을 해지할 수 있습니다. <br/>\r\n"
				+ "\r\n"
				+ "";
		JButton privacy = new JButton("개인정보처리방침");
		privacy.setBackground(Color.WHITE);
		privacy.setFont(new Font("배달의민족 도현", Font.BOLD, 19));
		privacy.setBounds(203, 169, 192, 80);
		privacy.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				customerLmg.show(panel, "개인정보");
				explainLabel.setText(privacyStr);
				explainLabel.setBounds(203, 301, 802, 80);
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
				explainLabel.setBounds(203, 301, 840, 80);
				lblNewLabel.setText("이용약관");
			}
		});
		use.setBounds(510, 169, 192, 80);
		add(use);

		JButton road = new JButton("찾아오시는 길");
		road.setBackground(Color.WHITE);
		road.setFont(new Font("배달의민족 도현", Font.BOLD, 19));

		road.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				customerLmg.show(panel, "오시는길");
				explainLabel.setText(roadStr);
				explainLabel.setBounds(203, 260, 802, 130);
				lblNewLabel.setText("찾아오시는길");
			}
		});
		road.setBounds(813, 169, 192, 80);
		add(road);

		join = new SignupButton("회원가입");
		join.setBounds(1050, 31, 115, 115);
		add(join);

		loginBtn = new LoginButton("로그인");
		loginBtn.setBounds(1050, 181, 115, 115);
		add(loginBtn);

		logoutBtn = new LogoutButton("로그아웃");
		logoutBtn.setBounds(1050, 181, 115, 115);
		add(logoutBtn);
		logoutBtn.setVisible(false);

		JLabel privacyLabel = new JLabel();
		privacyLabel.setText(privacyStr1);
		privacyLabel.setForeground(Color.WHITE);
		privacyLabel.setFont(new Font("배달의민족 도현", Font.PLAIN, 18));
		
//		privacyLabel.setIcon(new ImageIcon("images/개인정보처리방침.png"));

		panel.add(privacyLabel, "개인정보");

		JLabel useLabel = new JLabel();
		
//		useLabel.setIcon(new ImageIcon("images/이용약관.png"));
		panel.add(useLabel, "이용약관");
		useLabel.setText(useStr1);
		useLabel.setForeground(Color.WHITE);
		useLabel.setFont(new Font("배달의민족 도현", Font.PLAIN, 18));

		JLabel roadLabel = new JLabel();
		roadLabel.setIcon(new ImageIcon("images/약도.png"));
		panel.add(roadLabel, "오시는길");
		
		JLabel whiteLabel_1 = new JLabel("");
		whiteLabel_1.setOpaque(true);
		whiteLabel_1.setBackground(Color.WHITE);
		whiteLabel_1.setBounds(203, 134, 802, 3);
		add(whiteLabel_1);
		
		
	

		setVisible(true);
	}
}