package panels;

import javax.swing.JFrame;
import javax.swing.JPanel;

import buttons.GoToButton;
import buttons.LoginButton;
import buttons.LogoutButton;
import buttons.MypageButton;
import buttons.SignupButton;
import labels.TopLabel;

// 첫화면

public class MainPanel extends JPanel {

	private MypageButton myInfoBtn;
	private SignupButton signUpBtn;
	public static LoginButton loginBtn;
	public static LogoutButton logoutBtn;

	public static JFrame thisFrame;

	public static String currUserId = "logout";

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

		getMainPanel();
		currPanel = mainPanel;
		setBounds(0, 0, 1200, 800); // 패널크기는 JFrame 크기와 같게 (0,0, 1200, 800)로 만들어주세요
		setLayout(null); // LayOut설정은 null로 해주셔야 버튼이 자유로운 위치에 생성돼요

		TopLabel toplabel = new TopLabel("메인 화면");
		add(toplabel);

		GoToButton searchClassBtn = new GoToButton("강의찾기"); // 버튼생성
		searchClassBtn.setBounds(315, 255, 118, 112); // 버튼 생성 위치, 버튼 크기 정해줌
		add(searchClassBtn); // Panel에 버튼을 추가함

		myInfoBtn = new MypageButton("마이페이지");
		myInfoBtn.setBounds(506, 255, 118, 112);
		add(myInfoBtn);

		GoToButton customerServiceBtn = new GoToButton("고객문의");
		customerServiceBtn.setBounds(694, 255, 118, 112);
		add(customerServiceBtn);

		signUpBtn = new SignupButton("회원가입");

		signUpBtn.setBounds(421, 432, 118, 54);
		add(signUpBtn);

		loginBtn = new LoginButton("로그인");
		loginBtn.setBounds(609, 432, 118, 54);
		add(loginBtn);

		logoutBtn = new LogoutButton("로그아웃");
		logoutBtn.setBounds(609, 432, 118, 54);
		add(logoutBtn);
	}

	public void getMainPanel() {
		this.mainPanel = this;
	}

	public static void main(String[] args) {
		JFrame frm = new JFrame();
		thisFrame = frm;
		frm.add(new MainPanel());
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
