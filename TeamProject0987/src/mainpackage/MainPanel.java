package mainpackage;


import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import copy.Id_search;
import mystatus.MyClassPanel;

public class MainPanel extends JPanel {
	
	private JButton myInfoBtn;
	private JButton customServiceBtn;
	private JButton createIdBtn;
	private JButton logInBtn;
	
	public static CreateIdPanel createIdPanel = new CreateIdPanel() ;
	public static Login logInPanel = new Login();
	public static MainPanel mainPanel = new MainPanel();
	public static Id_search id_search = new Id_search(); 
	public static MyClassPanel myClassPanel = new MyClassPanel();
	
	public static JPanel currPanel;
	public static JPanel lastPanel;

	public MainPanel() {
		
		
		getMainPanel();
		currPanel = mainPanel;
		setBounds(0, 0, 677, 574); //패널크기는 JFrame 크기와 같게 만들어주세요
		setLayout(null); //LayOut설정은 null로 해주셔야 버튼이 자유로운 위치에 생성돼요
		
		JButton searchClassBtn = new JButton("강의 찾기"); //버튼생성
		searchClassBtn.setBounds(75, 255, 118, 112); //버튼 생성 위치, 버튼 크기 정해줌
		add(searchClassBtn); // 버튼을 Panel에 추가함 
		
		myInfoBtn = new JButton("나의 현황");
		myInfoBtn.setBounds(266, 255, 118, 112);
		add(myInfoBtn);
		
		myInfoBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {				
				MainPanel.currPanel.setVisible(false);
				MainPanel.myClassPanel.setVisible(true);
				MainPanel.currPanel = MainPanel.myClassPanel;
			}
		});
		
		
		customServiceBtn = new JButton("고객 문의");
		customServiceBtn.setBounds(474, 255, 118, 112);
		add(customServiceBtn);
		
		
		createIdBtn = new JButton("회원 가입");
		createIdBtn.setBounds(181, 432, 118, 54);
		add(createIdBtn);
		
//		CreateIdPanel createIdPanel = new CreateIdPanel(); //createIdPanel 추가
//		this.createIdPanel = createIdPanel;
		
		createIdBtn.addActionListener(new ActionListener() {	
			
			@Override
			public void actionPerformed(ActionEvent e) {
				currPanel.setVisible(false);
				lastPanel = currPanel; // 현재 패널을 이전패널로 저장
				createIdPanel.setVisible(true);
				currPanel = createIdPanel;
			}
		});
		
//		Login logInPanel = new Login(); //Login 패털추가
//		this.logInPanel = logInPanel;
						
		logInBtn = new JButton("로그인");
		logInBtn.setBounds(369, 432, 118, 54);
		add(logInBtn);
		
		logInBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				currPanel.setVisible(false);
				lastPanel = currPanel; // 현재 패널을 이전패널로 저장
				logInPanel.setVisible(true);	
				currPanel = logInPanel;
			}
		});
	}	
	
	
	public void getMainPanel() {
		this.mainPanel = this;		
	}
	
	public MainPanel returnMainPanel() {
		return mainPanel;
	}
	
	
	public static void main(String[] args) {
		JFrame frm = new JFrame();
		frm.add(new MainPanel());	
		frm.setBounds(100, 100, 700, 800);
		frm.setLocationRelativeTo(null);
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm.setVisible(true);
		
		
		frm.add(createIdPanel);
		createIdPanel.setVisible(false);
		
		frm.add(logInPanel);
		logInPanel.setVisible(false);
		
		frm.add(id_search);
		id_search.setVisible(false);
		
		frm.add(myClassPanel);
		myClassPanel.setVisible(false);
	}

	
}
