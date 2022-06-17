package panels;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import mypagepanel_comps.MyPageMainPanel;
import mypagepanel_comps.MyPageMainPanel2;
import mypagepanel_comps.MyPageMainPanel3;
import mypagepanel_comps.MyPageMainPanel4;
import javax.swing.SwingConstants;

import buttons.GoToButton;
import labels.TopLabel;

public class MyPagePanel extends JPanel {
	
	
	
	
	public static MyPageMainPanel mainPanel = new MyPageMainPanel();
	public static MyPageMainPanel2 mainPanel2 = new MyPageMainPanel2();
	public static MyPageMainPanel3 mainPanel3 = new MyPageMainPanel3();
	public static MyPageMainPanel4 mainPanel4 = new MyPageMainPanel4();	
	public static JPanel currPanel;	
	
	public MyPagePanel() {				
		
		
		setBounds(0, 0, 1200, 800);
		setLayout(null);
		
		TopLabel toplabel = new TopLabel("마이 페이지");
		add(toplabel);	
		
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
		
		//////////////////////////////////////////////////
		
		
		mainPanel.setBounds(118, 0, 1093, 800);
		add(mainPanel);
		mainPanel2.setBounds(118, 0, 1093, 800);
		add(mainPanel2);
		mainPanel3.setBounds(118, 0, 1093, 800);
		add(mainPanel3);
		mainPanel4.setBounds(118, 0, 1093, 800);
		add(mainPanel4);
		
		currPanel = mainPanel;
		
		mainPanel.setVisible(true);
		mainPanel2.setVisible(false);
		mainPanel3.setVisible(false);
		mainPanel4.setVisible(false);
		
		setBounds(0, 0, 1200, 800);
		
		JButton btn1 = new JButton("나의 수강조회");
		
		btn1.setBackground(Color.WHITE);
		btn1.setBounds(0, 172, 120, 60);
		add(btn1);
		
		JButton btn2 = new JButton("출결 현황조회");		
		btn2.setBackground(Color.WHITE);
		btn2.setBounds(0, 231, 120, 60);
		add(btn2);
					
		JButton btn3 = new JButton("나의 장바구니");		
		btn3.setBackground(Color.WHITE);
		btn3.setBounds(0, 380, 120, 60);
		add(btn3);
		
		JButton btn4 = new JButton("쿠폰함");		
		btn4.setBackground(Color.WHITE);
		btn4.setBounds(0, 440, 120, 60);
		add(btn4);
		
		JButton btn5 = new JButton("구매내역");		
		btn5.setBackground(Color.WHITE);
		btn5.setBounds(0, 500, 120, 60);
		add(btn5);
		

		
		JButton btn6 = new JButton("계정 관리");		
		btn6.setBackground(Color.WHITE);
		btn6.setBounds(0, 640, 120, 60);
		add(btn6);
		
		JButton btn7 = new JButton("회원 탈퇴");		
		btn7.setBackground(Color.WHITE);
		btn7.setBounds(0, 700, 120, 60);
		add(btn7);
		
		
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.getContentPane().add(new MyPagePanel());
		frame.setBounds(100, 100,1200,800);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
