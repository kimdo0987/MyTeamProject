package panels;




import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

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
import buttons.LogoutButton;
import database.OjdbcConnection;
import labels.TopLabel;
import methods.IdKeyAdaptor;
import methods.OnlyNumKeyAdaptor;
import methods.PwKeyAdaptor;
import methods.RestrictTextLength;
import tempPassword.TempPassword;

public class LoginPanel extends JPanel {
	
	//버튼,라벨,텍스트필드 생성완료

	static public String pwText;
	static public String idText = "";
	static public String searchPw;
	private HintPasswordField pwInput;
	
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
		
		HintTextField idInput = new HintTextField("아이디를 입력하세요.");
		add(idInput);
		idInput.setBounds(400, 250, 300, 30);
		idInput.addKeyListener(new RestrictTextLength(idInput, 16)); //글자수제한
		idInput.addKeyListener(new IdKeyAdaptor()); // 제약사항 적용
		idInput.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				idText = idInput.getText().toString();
			}	
		});
		
		pwInput = new HintPasswordField("비밀번호를 입력하세요.");
		pwInput.setFont(new Font("굴림", Font.PLAIN, 16));
		pwInput.setBounds(400, 300, 300, 30);
		pwInput.addKeyListener(new RestrictTextLength(pwInput, 12)); //글자수제한
		pwInput.addKeyListener(new PwKeyAdaptor()); // 제약사항 적용
		
		add(pwInput);
	    
		pwInput.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				char[] a = pwInput.getPassword();
				pwText = String.valueOf(a);				
			}	
		});
		

		JButton loginBtn = new JButton("로그인");
		add(loginBtn);
		loginBtn.setBounds(450, 350, 200, 50);
		
		
		
		loginBtn.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try (
						Connection conn = OjdbcConnection.getConnection();
						PreparedStatement pstmt = conn.prepareStatement("SELECT member_password FROM members "
								+ "WHERE member_id = ?");
				) {
					pstmt.setString(1, idText);
					ResultSet rs = pstmt.executeQuery();
					
					while(rs.next()) {
						searchPw = rs.getString("member_password");
					}
					
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				

				if (searchPw == null) {
					searchPw = "";
				}
				
				// 로그인 성공상황
				if(searchPw.equals(pwText)) {
					MainPanel.currPanel.setVisible(false);
					MainPanel.mainPanel.setVisible(true);
					MainPanel.lastPanel = MainPanel.currPanel;
					MainPanel.currPanel = MainPanel.mainPanel;
					MainPanel.currUserId = idText;
					System.out.println("로그인시 DB에서 찾은 pw : " + searchPw);
					System.out.println("로그인시 내가 써놓은 pw : " + pwText);

					MainPanel.loginBtn.setVisible(false);
					MainPanel.logoutBtn.setVisible(true);
					
					CustomerServicePanel.loginBtn.setVisible(false);
					CustomerServicePanel.logoutBtn.setVisible(true);
					
					// 다시 비워진 상태로 돌려놓기
					idInput.setText("아이디를 입력하세요.");
					idInput.setFont(new Font("맑은고딕", Font.PLAIN, 14));  
					idInput.setForeground(Color.GRAY);
					
					pwInput.setText("비밀번호를 입력하세요.");
					pwInput.setFont(new Font("맑은고딕", Font.PLAIN, 14));  
					pwInput.setForeground(Color.GRAY);
					pwText = "";
					pwInput.setEchoChar((char) 0);
					
					searchPw = "";
					
					// 로그인 실패상황

				} else {
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
