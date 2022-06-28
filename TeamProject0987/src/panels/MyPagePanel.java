package panels;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
import java.awt.Font;

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
		
		MyPageTabButton btn5 = new MyPageTabButton("구매 내역");
		btn5.setFont(new Font("HY중고딕", Font.PLAIN, 16));
		btn5.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout1.show(cardLayoutPanel,"구매내역");
				
			}
		});
		
		MyPageTabButton btn7 = new MyPageTabButton("회원 탈퇴");		
		btn7.setFont(new Font("HY중고딕", Font.PLAIN, 16));
		btn7.setBounds(0, 700, 200, 60);
		add(btn7);
		
		MyPageTabButton btn6 = new MyPageTabButton("계정 관리");		
		btn6.setFont(new Font("HY중고딕", Font.PLAIN, 16));
		btn6.setBounds(0, 640, 200, 60);
		add(btn6);
		btn5.setBounds(0, 500, 200, 60);
		add(btn5);
		
		MyPageTabButton btn4 = new MyPageTabButton("쿠폰함");		
		btn4.setFont(new Font("HY중고딕", Font.PLAIN, 16));
		btn4.setBounds(0, 440, 200, 60);
		add(btn4);
		
		MyPageTabButton btn3 = new MyPageTabButton("나의 장바구니");		
		btn3.setFont(new Font("HY중고딕", Font.PLAIN, 16));
		btn3.setBounds(0, 380, 200, 60);
		add(btn3);
		
		MyPageTabButton btn2 = new MyPageTabButton("출결 현황 조회");		
		btn2.setFont(new Font("HY중고딕", Font.PLAIN, 16));
		btn2.setBounds(0, 231, 200, 60);
		add(btn2);
		
		
		MyPageTabButton btn1 = new MyPageTabButton("나의 수강조회");
		btn1.setFont(new Font("HY중고딕", Font.PLAIN, 16));
		btn1.setBounds(0, 172, 200, 60);
		add(btn1);
		
		GoToButton mainBtn = new GoToButton("메인");
		mainBtn.setBounds(12, 10, 106, 55);
		mainBtn.setBackground(Color.WHITE);
		add(mainBtn);		
		
		JLabel lbl1 = new JLabel("내 수강");
		lbl1.setForeground(Color.WHITE);
		lbl1.setHorizontalAlignment(JLabel.CENTER);
		lbl1.setLocation(0, 143);
		lbl1.setBackground(Color.GRAY);
		lbl1.setSize(new Dimension(80, 30));
		add(lbl1);
		
		JLabel lbl2 = new JLabel("나의 수강관리");
		lbl2.setForeground(Color.WHITE);
		lbl2.setHorizontalAlignment(JLabel.CENTER);
		lbl2.setSize(new Dimension(104, 69));
		lbl2.setBackground(Color.GRAY);
		lbl2.setBounds(0, 350, 111, 30);
		add(lbl2);
		
		JLabel lbl3 = new JLabel("회원 관리");
		lbl3.setForeground(Color.WHITE);
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
