package panels;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import buttons.GoToButton;
import labels.TopLabel;
import mypagepanel_comps.MyPageMainPanel1;
import mypagepanel_comps.MyPageMainPanel2;
import mypagepanel_comps.MyPageMainPanel3;
import mypagepanel_comps.MyPageMainPanel4;
import mypagepanel_comps.MyPageMainPanel5;
import mypagepanel_comps.MyPageMainPanel6;
import mypagepanel_comps.MyPageMainPanel7;
import mypagepanel_comps.MyPageTabButton;
import mypagepanel_comps.PaymentPanel;

public class MyPagePanel extends JPanel {
	
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
		
		GoToButton mainBtn = new GoToButton("메인");
		mainBtn.setBounds(12, 10, 106, 55);
		mainBtn.setBackground(Color.WHITE);
		add(mainBtn);		
		
		JLabel lbl1 = new JLabel("수강중인 과정");
		lbl1.setHorizontalAlignment(JLabel.CENTER);
		lbl1.setLocation(0, 113);
		lbl1.setBackground(Color.GRAY);
		lbl1.setOpaque(true); 
		lbl1.setSize(new Dimension(120, 60));
		add(lbl1);
		
		JLabel lbl2 = new JLabel("수강신청 관리");
		lbl2.setHorizontalAlignment(JLabel.CENTER);
		lbl2.setSize(new Dimension(104, 69));
		lbl2.setBackground(Color.GRAY);
		lbl2.setOpaque(true); 
		lbl2.setBounds(0, 320, 120, 60);
		add(lbl2);
		
		JLabel lbl3 = new JLabel("회원 관리");
		lbl3.setHorizontalAlignment(JLabel.CENTER);
		lbl3.setSize(new Dimension(104, 69));
		lbl3.setBackground(Color.GRAY);
		lbl3.setOpaque(true); 
		lbl3.setBounds(0, 580, 120, 60);
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
		cardLayoutPanel.setBounds(118, 0, 1093, 800);
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
				
		
		MyPageTabButton btn1 = new MyPageTabButton("나의 수강조회");
		btn1.setBounds(0, 172, 120, 60);
		add(btn1);
		
		MyPageTabButton btn2 = new MyPageTabButton("출결 현황 조회");		
		btn2.setBounds(0, 231, 120, 60);
		add(btn2);
					
		MyPageTabButton btn3 = new MyPageTabButton("나의 장바구니");		
		btn3.setBounds(0, 380, 120, 60);
		add(btn3);
		
		MyPageTabButton btn4 = new MyPageTabButton("쿠폰함");		
		btn4.setBounds(0, 440, 120, 60);
		add(btn4);
		
		MyPageTabButton btn5 = new MyPageTabButton("구매 내역");		
		btn5.setBounds(0, 500, 120, 60);
		add(btn5);
		
		MyPageTabButton btn6 = new MyPageTabButton("계정 관리");		
		btn6.setBounds(0, 640, 120, 60);
		add(btn6);
		
		MyPageTabButton btn7 = new MyPageTabButton("회원 탈퇴");		
		btn7.setBounds(0, 700, 120, 60);
		add(btn7);
		
		
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
