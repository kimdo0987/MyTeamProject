package panels;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import buttons.GoToButton;
import database.OjdbcConnection;
import labels.TopLabel;

public class LoginPanel extends JPanel {
	
	//버튼,라벨,텍스트필드 생성완료

	static public String pwText;
	static public String idText = "";
	
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
		
		idInput.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				idText = idInput.getText().toString();
			}	
		});
		
		
		JPasswordField pwInput = new JPasswordField("비밀번호 입력");
		add(pwInput);
		pwInput.setBounds(400, 300, 300, 30);
		
		pwInput.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				char[] a = pwInput.getPassword();
				pwText = String.valueOf(a);				
			}	
		});
		
//		char[] pwChar = pwInput.getPassword();
//		for(char cha : pwChar){         
//	         Character.toString(cha);       //cha 에 저장된 값 string으로 변환
//	       //pwText 에 저장하기, pwText 에 값이 비어있으면 저장, 값이 있으면 이어서 저장하는 삼항연산자
//	         pwText += (pwText.equals("")) ? ""+cha+"" : ""+cha+"";   
//	     }
		
		JButton loginBtn = new JButton("로그인");
		add(loginBtn);
		loginBtn.setBounds(450, 350, 200, 50);

		
		try (
				Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement("SELECT member_password FROM members "
						+ "WHERE member_id = ?");
				) {
			pstmt.setString(1, idText);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		loginBtn.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				if(idText == "46") { // id,pw가 DB데이터와 일치한다면
					MainPanel.currPanel.setVisible(true);
					MainPanel.loginPanel.setVisible(false);
				} else if (pwText == "2") {
					JOptionPane.showMessageDialog(MainPanel.thisFrame, "확인");
				} else  {
					System.out.println(idText);
					System.out.println(pwText);
					JOptionPane.showMessageDialog(MainPanel.thisFrame, "아이디(로그인 전용 아이디) 또는 비밀번호를 잘못 입력했습니다.\r\n"
							+ "입력하신 내용을 다시 확인해주세요.");
				}
			}
		});
		
		
		
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
