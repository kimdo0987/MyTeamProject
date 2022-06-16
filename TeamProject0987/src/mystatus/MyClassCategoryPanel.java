package mystatus;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import mainpackage.MainPanel;

public class MyClassCategoryPanel extends JPanel {
	
	private MyClassCategoryButton Btn= new MyClassCategoryButton("");
	private MyClassCategoryButton Btn0= new MyClassCategoryButton("");
	private MyClassCategoryButton Btn1= new MyClassCategoryButton("수강중인 과정");
	private MyClassCategoryButton Btn2= new MyClassCategoryButton("나의 수강조회");
	private MyClassCategoryButton Btn3= new MyClassCategoryButton("출결 현황조회");
	private MyClassCategoryButton Btn4= new MyClassCategoryButton("수강신청 관리");
	private MyClassCategoryButton Btn5= new MyClassCategoryButton("나의 장바구니");
	private MyClassCategoryButton Btn6= new MyClassCategoryButton("쿠폰함");
	private MyClassCategoryButton Btn7= new MyClassCategoryButton("구매내역");
	private MyClassCategoryButton Btn8= new MyClassCategoryButton("회원 관리");
	private MyClassCategoryButton Btn9= new MyClassCategoryButton("계정 관리");
	private MyClassCategoryButton Btn10= new MyClassCategoryButton("회원 탈퇴");
	
	
	
	public MyClassCategoryPanel() {
		add(Btn1);
		Btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MyClassPanel.currPanel.setVisible(false);
				MyClassPanel.mainPanel.setVisible(true);
				MyClassPanel.currPanel = MyClassPanel.mainPanel;
			}
		});
		
		add(Btn2);
		Btn2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MyClassPanel.currPanel.setVisible(false);
				MyClassPanel.mainPanel2.setVisible(true);
				MyClassPanel.currPanel = MyClassPanel.mainPanel2;
			}
		});
		
		add(Btn3);
		Btn3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MyClassPanel.currPanel.setVisible(false);
				MyClassPanel.mainPanel3.setVisible(true);
				MyClassPanel.currPanel = MyClassPanel.mainPanel3;
			}
		});
		
		
		add(Btn0);
		
		add(Btn4);
		Btn4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MyClassPanel.currPanel.setVisible(false);
				MyClassPanel.mainPanel4.setVisible(true);
				MyClassPanel.currPanel = MyClassPanel.mainPanel4;
			}
		});
		
		
		add(Btn5);
		add(Btn6);
		add(Btn7);
		add(Btn);
		add(Btn8);
		add(Btn9);
		add(Btn10);
		
		setBackground(Color.black);
		setBounds(0, 200, 300, 600);
		setLayout(new GridLayout(12, 1));
	}
}
