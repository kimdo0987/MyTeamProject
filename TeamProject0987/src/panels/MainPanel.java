package panels;

import java.awt.Font;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import buttons.GoToButton;
import buttons.LectureSearchButton;
import buttons.LoginButton;
import buttons.LogoutButton;
import buttons.MypageButton;
import buttons.SignupButton;
import labels.TopLabel;
import java.awt.Color;

// 첫화면

public class MainPanel extends ImagePanel {

	
	private MypageButton myPageBtn;
	private SignupButton signUpBtn;
	public static LoginButton loginBtn;
	public static LogoutButton logoutBtn;

	public static JFrame thisFrame;

	public static String currUserId = "hansm1119";
	public static MainPanel mainPanel = new MainPanel();
	public static LectureSearchPanel lectureSearchPanel = new LectureSearchPanel();
	public static MyPagePanel myPagePanel = new MyPagePanel();
	public static LectureInfoPanel lectureInfoPanel = new LectureInfoPanel();
	public static CustomerServicePanel customerServicePanel = new CustomerServicePanel();
	public static SignupPanel signUpPanel = new SignupPanel();
	public static LoginPanel loginPanel = new LoginPanel();
	public static IdSearchPanel idSearchPanel = new IdSearchPanel();
	public static PwSearchPanel pwSerachPanel = new PwSearchPanel();

	public static JPanel currPanel; // 이전 버튼 구현하는데 사용되는 패널들.
	public static JPanel lastPanel;
	public static JPanel tempPanel;

	public MainPanel() {
		
		ImageIcon lectureSearchBtn_img = new ImageIcon("images/dohyun1.png");
		ImageIcon lectureSearchBtn1_img = new ImageIcon("images/dohyun1-1.png");
		ImageIcon myPageBtn_img = new ImageIcon("images/dohyun2.png");
		ImageIcon myPageBtn1_img = new ImageIcon("images/dohyun2-1.png");
		ImageIcon customerServiceBtn_img = new ImageIcon("images/dohyun3.png");
		ImageIcon customerServiceBtn1_img = new ImageIcon("images/dohyun3-1.png");
		
		getMainPanel();
		currPanel = mainPanel;
		setBounds(0, 0, 1200, 800); // 패널크기는 JFrame 크기와 같게 (0,0, 1200, 800)로 만들어주세요
		setLayout(null); // LayOut설정은 null로 해주셔야 버튼이 자유로운 위치에 생성돼요

			
		LectureSearchButton lectureSearchBtn = new LectureSearchButton("강의찾기", lectureSearchBtn_img); // 버튼생성
		lectureSearchBtn.setBounds(227, 530, 190, 190); // 버튼 생성 위치, 버튼 크기 정해줌
		lectureSearchBtn.setBorderPainted(false);//테두리 안보이게하기
		lectureSearchBtn.setRolloverIcon(lectureSearchBtn1_img); //마우스 올렸을때 이미지 추가
		add(lectureSearchBtn); // Panel에 버튼을 추가함

		myPageBtn = new MypageButton("마이페이지", myPageBtn_img);
		myPageBtn.setBounds(487, 530, 190, 190);
		myPageBtn.setBorderPainted(false);//테두리 안보이게하기
		myPageBtn.setRolloverIcon(myPageBtn1_img);
		add(myPageBtn);

		GoToButton customerServiceBtn = new GoToButton("고객문의", customerServiceBtn_img);
		customerServiceBtn.setBounds(744, 530, 190, 190);
		customerServiceBtn.setBorderPainted(false);//테두리 안보이게하기
		customerServiceBtn.setRolloverIcon(customerServiceBtn1_img);
		add(customerServiceBtn);


		signUpBtn = new SignupButton("회원가입");
		signUpBtn.setBounds(930, 57, 115, 115);
		add(signUpBtn);

		loginBtn = new LoginButton("로그인");
		loginBtn.setBounds(1054, 57, 115, 115);
		add(loginBtn);

		logoutBtn = new LogoutButton("로그아웃");
		logoutBtn.setBounds(1054, 57, 115, 115);
		add(logoutBtn);
		logoutBtn.setVisible(false);
		
		JLabel lblNewLabel = new JLabel("<html><body style='text-align:center;'>Developer <br/>lecture <br/>program</body></html>", JLabel.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Libre Baskerville", Font.PLAIN, 100));
		lblNewLabel.setBounds(130, 20, 904, 399);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBackground(Color.WHITE);
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setBounds(70, 20, 1065, 3);
		add(lblNewLabel_1);
	}

	public void getMainPanel() {
		this.mainPanel = this;
	}

	public static void main(String[] args) {
		JFrame frm = new JFrame();
		thisFrame = frm;
		frm.getContentPane().add(new MainPanel());
		frm.setBounds(0, 0, 1200, 800);
		frm.setLocationRelativeTo(null);
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm.setVisible(true);

		frm.add(lectureSearchPanel);
		lectureSearchPanel.setVisible(false);

		frm.add(myPagePanel);
		myPagePanel.setVisible(false);

		frm.add(customerServicePanel);
		customerServicePanel.setVisible(false);

		frm.add(signUpPanel);
		signUpPanel.setVisible(false);

		frm.add(loginPanel);
		loginPanel.setVisible(false);

		frm.add(idSearchPanel);
		idSearchPanel.setVisible(false);

		frm.add(pwSerachPanel);
		pwSerachPanel.setVisible(false);

		frm.add(lectureInfoPanel);
		lectureInfoPanel.setVisible(false);

	}
}
