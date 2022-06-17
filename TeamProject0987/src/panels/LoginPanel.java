package panels;



import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import buttons.GoToButton;
import labels.TopLabel;

public class LoginPanel extends JPanel {
	
	//버튼,라벨,텍스트필드 생성완료
	
	public LoginPanel() {
		setBounds(0, 0, 1200, 800);
		setLayout(null);
		
		//////////////// 여기서부터 클래스화 할수있을거같음 //////////////////////////
		JButton lastPageBtn = new JButton("이전");
		lastPageBtn.setBounds(12, 9, 70, 44);
		add(lastPageBtn);
		lastPageBtn.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				MainPanel.currPanel.setVisible(false);
				MainPanel.lastPanel.setVisible(true);
				MainPanel.tempPanel = MainPanel.lastPanel; //일시적으로 담아둠
				MainPanel.lastPanel = MainPanel.currPanel;
				MainPanel.currPanel = MainPanel.tempPanel;
			}
		});
		
		
		GoToButton mainBtn = new GoToButton("메인");
		mainBtn.setBounds(97, 9, 64, 44);
		add(mainBtn);
		mainBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MainPanel.currPanel.setVisible(false);
				MainPanel.mainPanel.setVisible(true);
				MainPanel.currPanel=MainPanel.mainPanel;
				
				
			}
		});
		
		//////////////////////////////////////////////////////////////////
		
		TopLabel toplabel = new TopLabel("로그인");
		add(toplabel);
		
		JLabel loginCenter = new JLabel("로그인");
		add(loginCenter);
		loginCenter.setBounds(400, 200, 100, 50);
		
		JTextField idInput = new JTextField("아이디 입력");
		add(idInput);
		idInput.setBounds(400, 250, 300, 30);
		
		JTextField pwInput = new JTextField("비밀번호 입력");
		add(pwInput);
		pwInput.setBounds(400, 300, 300, 30);
		
		JButton loginBtn = new JButton("로그인 버튼");
		add(loginBtn);
		loginBtn.setBounds(450, 350, 200, 50);
		
		JButton findId = new JButton("아이디찾기");
		add(findId);
		findId.setBounds(339, 430, 150, 35);
		findId.addActionListener(new ActionListener() {		
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MainPanel.currPanel.setVisible(false);
				MainPanel.idSearchPanel.setVisible(true);
				MainPanel.currPanel=MainPanel.idSearchPanel;
			}
		});
		
		
		GoToButton findPwBtn = new GoToButton("비밀번호찾기");
		add(findPwBtn);
		findPwBtn.setBounds(500, 430, 150, 35);		
		
		GoToButton signUp = new GoToButton("회원가입");
		add(signUp);
		signUp.setBounds(661, 430, 150, 35);
		
		
		
		
	}
	

}
