package mainpackage;



import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Login extends JPanel {
	
	//버튼,라벨,텍스트필드 생성완료
	
	public Login() {
		setBounds(0,0,600,800);
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
				MainPanel.currPanel = MainPanel.lastPanel;
			}
		});
		
		
		JButton firstPageBtn = new JButton("홈");
		firstPageBtn.setBounds(97, 9, 64, 44);
		add(firstPageBtn);
		firstPageBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MainPanel.currPanel.setVisible(false);
				MainPanel.mainPanel.setVisible(true);
				MainPanel.currPanel=MainPanel.mainPanel;
				
				
			}
		});
		
		//////////////////////////////////////////////////////////////////
		
		JLabel loginTop = new JLabel("로그인");
		loginTop.setOpaque(true);
		loginTop.setBackground(Color.WHITE);
		loginTop.setHorizontalAlignment(JLabel.CENTER);
		loginTop.setFont(new Font("맑은고딕", Font.PLAIN, 20));
		add(loginTop);
		loginTop.setBounds(160, 30, 400, 50);
		
		JLabel loginCenter = new JLabel("로그인");
		add(loginCenter);
		loginCenter.setBounds(100, 200, 100, 50);
		
		JTextField idInput = new JTextField("아이디 입력");
		add(idInput);
		idInput.setBounds(100, 250, 300, 30);
		
		JTextField passwordInput = new JTextField("비밀번호 입력");
		add(passwordInput);
		passwordInput.setBounds(100, 300, 300, 30);
		
		JButton loginBtn = new JButton("로그인 버튼");
		add(loginBtn);
		loginBtn.setBounds(150, 350, 200, 50);
		
		JButton findId = new JButton("아이디찾기");
		add(findId);
		findId.setBounds(50, 430, 150, 35);
		findId.addActionListener(new ActionListener() {		
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MainPanel.currPanel.setVisible(false);
				MainPanel.id_search.setVisible(true);
				MainPanel.currPanel=MainPanel.id_search;
			}
		});
		
		
		JButton findPw = new JButton("비밀번호 찾기");
		add(findPw);
		findPw.setBounds(200, 430, 150, 35);		
		
		JButton signup = new JButton("회원가입");
		add(signup);
		signup.setBounds(350, 430, 150, 35);
		
		
		
		
	}
	

}
