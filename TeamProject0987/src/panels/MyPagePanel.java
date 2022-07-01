package panels;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import buttons.GoToButton;
import mypagepanel_comps.MyPageMainPanel1;
import mypagepanel_comps.MyPageMainPanel2;
import mypagepanel_comps.MyPageMainPanel3;
import mypagepanel_comps.MyPageMainPanel4;
import mypagepanel_comps.MyPageMainPanel5;
import mypagepanel_comps.MyPageMainPanel6;
import mypagepanel_comps.MyPageMainPanel7;
import mypagepanel_comps.MyPageTabButton;
import mypagepanel_comps.PaymentPanel;

public class MyPagePanel extends ImagePanel {
	
	public static CardLayout cardLayout1 = new CardLayout();
	public static JPanel cardLayoutPanel;
	
	public static MyPageMainPanel1 mainPanel1;
	public static MyPageMainPanel2 mainPanel2;
	public static MyPageMainPanel3 mainPanel3;
	public static MyPageMainPanel4 mainPanel4;	
	public static MyPageMainPanel5 mainPanel5;
	public static MyPageMainPanel6 mainPanel6;
	public static MyPageMainPanel7 mainPanel7;
	public static PaymentPanel payPanel;

	public MyPagePanel() {				
		
		setBounds(0, 0, 1200, 800);
		setLayout(null);		
		
		ImageIcon mybtn1icon1 = new ImageIcon("images/mypage카테고리/나의수강조회.png");
		Image mybtn1img1 = mybtn1icon1.getImage();
		Image mybtn1img = mybtn1img1.getScaledInstance(200, 46, Image.SCALE_SMOOTH);
		ImageIcon mybtn1icon2 = new ImageIcon("images/mypage카테고리/나의수강조회롤.png");
		Image mybtn1img2 = mybtn1icon2.getImage();
		Image mybtn1rol = mybtn1img2.getScaledInstance(200, 46, Image.SCALE_SMOOTH);
		ImageIcon mybtn1icon3 = new ImageIcon("images/mypage카테고리/나의수강조회선택.png");
		Image mybtn1img3 = mybtn1icon3.getImage();
		Image mybtn1sel = mybtn1img3.getScaledInstance(200, 46, Image.SCALE_SMOOTH);
		
		MyPageTabButton btn1 = new MyPageTabButton("나의 수강조회", new ImageIcon(mybtn1sel));
		btn1.setFont(new Font("HY중고딕", Font.PLAIN, 0));
		btn1.setBounds(10, 172, 194, 44);
		btn1.setBorder(BorderFactory.createEmptyBorder());
		btn1.setRolloverIcon(new ImageIcon(mybtn1rol));
		btn1.setRolloverEnabled(false);
		add(btn1);
		
		ImageIcon mybtn2icon1 = new ImageIcon("images/mypage카테고리/출결현황조회.png");
		Image mybtn2img1 = mybtn2icon1.getImage();
		Image mybtn2img = mybtn2img1.getScaledInstance(200, 46, Image.SCALE_SMOOTH);
		ImageIcon mybtn2icon2 = new ImageIcon("images/mypage카테고리/출결현황조회롤.png");
		Image mybtn2img2 = mybtn2icon2.getImage();
		Image mybtn2rol = mybtn2img2.getScaledInstance(200, 46, Image.SCALE_SMOOTH);
		ImageIcon mybtn2icon3 = new ImageIcon("images/mypage카테고리/출결현황조회선택.png");
		Image mybtn2img3 = mybtn2icon3.getImage();
		Image mybtn2sel = mybtn2img3.getScaledInstance(200, 46, Image.SCALE_SMOOTH);
		
		MyPageTabButton btn2 = new MyPageTabButton("출결 현황 조회", new ImageIcon(mybtn2img));
		btn2.setFont(new Font("HY중고딕", Font.PLAIN, 0));
		btn2.setBounds(10, 231, 194, 44);
		btn2.setBorder(BorderFactory.createEmptyBorder());
		btn2.setRolloverIcon(new ImageIcon(mybtn2rol));
		add(btn2);
		
		ImageIcon mybtn3icon1 = new ImageIcon("images/mypage카테고리/나의장바구니.png");
		Image mybtn3img1 = mybtn3icon1.getImage();
		Image mybtn3img = mybtn3img1.getScaledInstance(200, 46, Image.SCALE_SMOOTH);
		ImageIcon mybtn3icon2 = new ImageIcon("images/mypage카테고리/나의장바구니롤.png");
		Image mybtn3img2 = mybtn3icon2.getImage();
		Image mybtn3rol = mybtn3img2.getScaledInstance(200, 46, Image.SCALE_SMOOTH);
		ImageIcon mybtn3icon3 = new ImageIcon("images/mypage카테고리/나의장바구니선택.png");
		Image mybtn3img3 = mybtn3icon3.getImage();
		Image mybtn3sel = mybtn3img3.getScaledInstance(200, 46, Image.SCALE_SMOOTH);
		
		MyPageTabButton btn3 = new MyPageTabButton("나의 장바구니", new ImageIcon(mybtn3img));
		btn3.setFont(new Font("HY중고딕", Font.PLAIN, 0));
		btn3.setBounds(10, 380, 194, 44);
		btn3.setBorder(BorderFactory.createEmptyBorder());
		btn3.setRolloverIcon(new ImageIcon(mybtn3rol));
		add(btn3);
		
		ImageIcon mybtn4icon1 = new ImageIcon("images/mypage카테고리/쿠폰함.png");
		Image mybtn4img1 = mybtn4icon1.getImage();
		Image mybtn4img = mybtn4img1.getScaledInstance(200, 46, Image.SCALE_SMOOTH);
		ImageIcon mybtn4icon2 = new ImageIcon("images/mypage카테고리/쿠폰함롤.png");
		Image mybtn4img2 = mybtn4icon2.getImage();
		Image mybtn4rol = mybtn4img2.getScaledInstance(200, 46, Image.SCALE_SMOOTH);
		ImageIcon mybtn4icon3 = new ImageIcon("images/mypage카테고리/쿠폰함선택.png");
		Image mybtn4img3 = mybtn4icon3.getImage();
		Image mybtn4sel = mybtn4img3.getScaledInstance(200, 46, Image.SCALE_SMOOTH);
		
		MyPageTabButton btn4 = new MyPageTabButton("쿠폰함", new ImageIcon(mybtn4img));
		btn4.setFont(new Font("HY중고딕", Font.PLAIN, 0));
		btn4.setBounds(10, 440, 194, 44);
		btn4.setBorder(BorderFactory.createEmptyBorder());
		btn4.setRolloverIcon(new ImageIcon(mybtn4rol));
		add(btn4);
		
		ImageIcon mybtn5icon1 = new ImageIcon("images/mypage카테고리/구매내역.png");
		Image mybtn5img1 = mybtn5icon1.getImage();
		Image mybtn5img = mybtn5img1.getScaledInstance(200, 46, Image.SCALE_SMOOTH);
		ImageIcon mybtn5icon2 = new ImageIcon("images/mypage카테고리/구매내역롤.png");
		Image mybtn5img2 = mybtn5icon2.getImage();
		Image mybtn5rol = mybtn5img2.getScaledInstance(200, 46, Image.SCALE_SMOOTH);
		ImageIcon mybtn5icon3 = new ImageIcon("images/mypage카테고리/구매내역선택.png");
		Image mybtn5img3 = mybtn5icon3.getImage();
		Image mybtn5sel = mybtn5img3.getScaledInstance(200, 46, Image.SCALE_SMOOTH);
		
		MyPageTabButton btn5 = new MyPageTabButton("구매 내역", new ImageIcon(mybtn5img));
		btn5.setFont(new Font("HY중고딕", Font.PLAIN, 0));
		btn5.setBounds(10, 500, 194, 44);
		btn5.setBorder(BorderFactory.createEmptyBorder());
		btn5.setRolloverIcon(new ImageIcon(mybtn5rol));
		add(btn5);
		
		btn5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout1.show(cardLayoutPanel,"구매내역");
			}
		});
		
		ImageIcon mybtn6icon1 = new ImageIcon("images/mypage카테고리/계정관리.png");
		Image mybtn6img1 = mybtn6icon1.getImage();
		Image mybtn6img = mybtn6img1.getScaledInstance(200, 46, Image.SCALE_SMOOTH);
		ImageIcon mybtn6icon2 = new ImageIcon("images/mypage카테고리/계정관리롤.png");
		Image mybtn6img2 = mybtn6icon2.getImage();
		Image mybtn6rol = mybtn6img2.getScaledInstance(200, 46, Image.SCALE_SMOOTH);
		ImageIcon mybtn6icon3 = new ImageIcon("images/mypage카테고리/계정관리선택.png");
		Image mybtn6img3 = mybtn6icon3.getImage();
		Image mybtn6sel = mybtn6img3.getScaledInstance(200, 46, Image.SCALE_SMOOTH);
		
		MyPageTabButton btn6 = new MyPageTabButton("계정 관리", new ImageIcon(mybtn6img));
		btn6.setFont(new Font("HY중고딕", Font.PLAIN, 0));
		btn6.setBounds(10, 640, 194, 44);
		btn6.setBorder(BorderFactory.createEmptyBorder());
		btn6.setRolloverIcon(new ImageIcon(mybtn6rol));
		add(btn6);
		
		ImageIcon mybtn7icon1 = new ImageIcon("images/mypage카테고리/회원탈퇴.png");
		Image mybtn7img1 = mybtn7icon1.getImage();
		Image mybtn7img = mybtn7img1.getScaledInstance(200, 46, Image.SCALE_SMOOTH);
		ImageIcon mybtn7icon2 = new ImageIcon("images/mypage카테고리/회원탈퇴롤.png");
		Image mybtn7img2 = mybtn7icon2.getImage();
		Image mybtn7rol = mybtn7img2.getScaledInstance(200, 46, Image.SCALE_SMOOTH);
		ImageIcon mybtn7icon3 = new ImageIcon("images/mypage카테고리/회원탈퇴선택.png");
		Image mybtn7img3 = mybtn7icon3.getImage();
		Image mybtn7sel = mybtn7img3.getScaledInstance(200, 46, Image.SCALE_SMOOTH);
		
		MyPageTabButton btn7 = new MyPageTabButton("회원 탈퇴", new ImageIcon(mybtn7img));
		btn7.setFont(new Font("HY중고딕", Font.PLAIN, 0));
		btn7.setBounds(10, 700, 194, 44);
		btn7.setBorder(BorderFactory.createEmptyBorder());
		btn7.setRolloverIcon(new ImageIcon(mybtn7rol));
		add(btn7);
		
		/////////////////////////////////////////////////////////////////////////
		////////////////////////////// 리스너모음 //////////////////////////////////
		btn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				btn1.setIcon(new ImageIcon(mybtn1sel));
				btn2.setIcon(new ImageIcon(mybtn2img));
				btn3.setIcon(new ImageIcon(mybtn3img));
				btn4.setIcon(new ImageIcon(mybtn4img));
				btn5.setIcon(new ImageIcon(mybtn5img));
				btn6.setIcon(new ImageIcon(mybtn6img));
				btn7.setIcon(new ImageIcon(mybtn7img));
				
				btn1.setRolloverEnabled(true);
			}
		});
		
		btn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				btn1.setIcon(new ImageIcon(mybtn1img));
				btn2.setIcon(new ImageIcon(mybtn2sel));
				btn3.setIcon(new ImageIcon(mybtn3img));
				btn4.setIcon(new ImageIcon(mybtn4img));
				btn5.setIcon(new ImageIcon(mybtn5img));
				btn6.setIcon(new ImageIcon(mybtn6img));
				btn7.setIcon(new ImageIcon(mybtn7img));
				
				btn1.setRolloverEnabled(true);
			}
		});
		
		btn3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				btn1.setIcon(new ImageIcon(mybtn1img));
				btn2.setIcon(new ImageIcon(mybtn2img));
				btn3.setIcon(new ImageIcon(mybtn3sel));
				btn4.setIcon(new ImageIcon(mybtn4img));
				btn5.setIcon(new ImageIcon(mybtn5img));
				btn6.setIcon(new ImageIcon(mybtn6img));
				btn7.setIcon(new ImageIcon(mybtn7img));
				
				btn1.setRolloverEnabled(true);
			}
		});
		
		btn4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				btn1.setIcon(new ImageIcon(mybtn1img));
				btn2.setIcon(new ImageIcon(mybtn2img));
				btn3.setIcon(new ImageIcon(mybtn3img));
				btn4.setIcon(new ImageIcon(mybtn4sel));
				btn5.setIcon(new ImageIcon(mybtn5img));
				btn6.setIcon(new ImageIcon(mybtn6img));
				btn7.setIcon(new ImageIcon(mybtn7img));
				
				btn1.setRolloverEnabled(true);
			}
		});
		
		btn5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				btn1.setIcon(new ImageIcon(mybtn1img));
				btn2.setIcon(new ImageIcon(mybtn2img));
				btn3.setIcon(new ImageIcon(mybtn3img));
				btn4.setIcon(new ImageIcon(mybtn4img));
				btn5.setIcon(new ImageIcon(mybtn5sel));
				btn6.setIcon(new ImageIcon(mybtn6img));
				btn7.setIcon(new ImageIcon(mybtn7img));
				
				btn1.setRolloverEnabled(true);
			}
		});
		
		btn6.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				btn1.setIcon(new ImageIcon(mybtn1img));
				btn2.setIcon(new ImageIcon(mybtn2img));
				btn3.setIcon(new ImageIcon(mybtn3img));
				btn4.setIcon(new ImageIcon(mybtn4img));
				btn5.setIcon(new ImageIcon(mybtn5img));
				btn6.setIcon(new ImageIcon(mybtn6sel));
				btn7.setIcon(new ImageIcon(mybtn7img));
				
				btn1.setRolloverEnabled(true);
			}
		});
		
		btn7.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				btn1.setIcon(new ImageIcon(mybtn1img));
				btn2.setIcon(new ImageIcon(mybtn2img));
				btn3.setIcon(new ImageIcon(mybtn3img));
				btn4.setIcon(new ImageIcon(mybtn4img));
				btn5.setIcon(new ImageIcon(mybtn5img));
				btn6.setIcon(new ImageIcon(mybtn6img));
				btn7.setIcon(new ImageIcon(mybtn7sel));
				
				btn1.setRolloverEnabled(true);
			}
		});
		
		/////////////////////////////////////////////////////////////////////////
		/////////////////////////////////////////////////////////////////////////
		ImageIcon icon = new ImageIcon("images/homeButton.png");
		Image img = icon.getImage();
		// 창의 사이즈인 500,500에 맞춰서 이미지를 변경
		Image changeImg = img.getScaledInstance(80, 80, Image.SCALE_SMOOTH);
		ImageIcon changeIcon = new ImageIcon(changeImg);
		
		ImageIcon icon2 = new ImageIcon("images/homeButton2.png");
		Image img2 = icon2.getImage();
		Image changeImg2 = img2.getScaledInstance(80, 80, Image.SCALE_SMOOTH);
		ImageIcon changeIcon2 = new ImageIcon(changeImg2);
		
		GoToButton mainBtn = new GoToButton("메인");
		mainBtn.setFont(new Font("굴림", Font.PLAIN, 0));
		mainBtn.setIcon(changeIcon);
		mainBtn.setBorderPainted(false);
		mainBtn.setBounds(10, 10, 75, 75);
		mainBtn.setBackground(Color.WHITE);
		mainBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MainPanel.myPagePanel.setVisible(false);
			}
		});
		
		mainBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mainBtn.setIcon(changeIcon2);
			}
			
			@Override
			public void mouseReleased(MouseEvent e) {
				mainBtn.setIcon(changeIcon);
			}
		});
		add(mainBtn);		
		
		JLabel lbl1 = new JLabel("내 수강");
		lbl1.setForeground(Color.WHITE);
		lbl1.setFont(new Font("배달의민족 도현", Font.PLAIN, 14));
		lbl1.setHorizontalAlignment(JLabel.CENTER);
		lbl1.setLocation(0, 143);
		lbl1.setBackground(Color.GRAY);
		lbl1.setSize(new Dimension(80, 30));
		add(lbl1);
		
		JLabel lbl2 = new JLabel("나의 수강관리");
		lbl2.setForeground(Color.WHITE);
		lbl2.setFont(new Font("배달의민족 도현", Font.PLAIN, 14));
		lbl2.setHorizontalAlignment(JLabel.CENTER);
		lbl2.setSize(new Dimension(104, 69));
		lbl2.setBackground(Color.GRAY);
		lbl2.setBounds(0, 350, 111, 30);
		add(lbl2);
		
		JLabel lbl3 = new JLabel("회원 관리");
		lbl3.setForeground(Color.WHITE);
		lbl3.setFont(new Font("배달의민족 도현", Font.PLAIN, 14));
		lbl3.setHorizontalAlignment(JLabel.CENTER);
		lbl3.setSize(new Dimension(104, 69));
		lbl3.setBackground(Color.GRAY);
		lbl3.setBounds(0, 610, 80, 30);
		add(lbl3);
		
		
		mainPanel1 = new MyPageMainPanel1();
		mainPanel2 = new MyPageMainPanel2();
		mainPanel3 = new MyPageMainPanel3();
		mainPanel4 = new MyPageMainPanel4();	
		mainPanel5 = new MyPageMainPanel5();
		mainPanel6 = new MyPageMainPanel6();
		mainPanel7 = new MyPageMainPanel7();
		payPanel = new PaymentPanel();
		//////////////////////////////////////////////////
		cardLayoutPanel = new JPanel();
		cardLayoutPanel.setBounds(200, 0, 1011, 800);
		add(cardLayoutPanel);
		
		cardLayoutPanel.setLayout(cardLayout1);
		
		
		cardLayoutPanel.add(mainPanel1, "나의 수강조회");
		cardLayoutPanel.add(mainPanel2, "출결 현황 조회");
		cardLayoutPanel.add(mainPanel3, "나의 장바구니");
		cardLayoutPanel.add(mainPanel4, "쿠폰함");
		cardLayoutPanel.add(mainPanel5, "구매 내역");
		cardLayoutPanel.add(mainPanel6, "계정 관리");
		cardLayoutPanel.add(mainPanel7, "회원 탈퇴");
		cardLayoutPanel.add(payPanel, "결제하기");
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setBounds(80, 156, 120, 3);
		add(lblNewLabel_1_1);
		lblNewLabel_1_1.setOpaque(true);
		lblNewLabel_1_1.setBackground(Color.WHITE);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("");
		lblNewLabel_1_1_1.setOpaque(true);
		lblNewLabel_1_1_1.setBackground(Color.WHITE);
		lblNewLabel_1_1_1.setBounds(80, 622, 120, 3);
		add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("");
		lblNewLabel_1_1_2.setOpaque(true);
		lblNewLabel_1_1_2.setBackground(Color.WHITE);
		lblNewLabel_1_1_2.setBounds(110, 364, 90, 3);
		add(lblNewLabel_1_1_2);
		
		
	}
	
//	public static void main(String[] args) {
//		JFrame frame = new JFrame();
//		frame.getContentPane().add(new MyPagePanel());
//		frame.setBounds(100, 100,1200,800);
//		frame.setLocationRelativeTo(null);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setVisible(true);
//	}
}
