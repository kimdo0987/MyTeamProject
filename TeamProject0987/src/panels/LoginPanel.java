package panels;




import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import buttons.GoToButton;
import buttons.SignupButton;
import database.OjdbcConnection;
import labels.TopLabel;
import methods.IdKeyAdaptor;
import methods.PwKeyAdaptor;
import methods.RestrictTextLength;

public class LoginPanel extends ImagePanel {
	
	//버튼,라벨,텍스트필드 생성완료

	static public String idText = "";
	static public String searchPw;
	private HintPasswordField pwInput;
	
	public LoginPanel() {
		setBounds(0, 0, 1200, 800);
		setLayout(null);
		
		
		ImageIcon mainIcon = new ImageIcon("images/homebutton.png");
		ImageIcon loginIcon = new ImageIcon("images/intackBtn/로그인.png");
		ImageIcon idSearchIcon = new ImageIcon("images/intackBtn/아이디조회버튼.png");
		ImageIcon pwSearchIcon = new ImageIcon("images/intackBtn/비밀번호찾기버튼.png");
		ImageIcon signInIcon = new ImageIcon("images/intackBtn/회원가입버튼.png");
		
		ImageIcon yLoginIcon = new ImageIcon("images/intackYellowBtn/노란로그인.png");
		ImageIcon yIdSearchIcon = new ImageIcon("images/intackYellowBtn/노란아이디조회.png");
		ImageIcon yPwSearchIcon = new ImageIcon("images/intackYellowBtn/노란비밀번호찾기.png");
		ImageIcon ySignInIcon = new ImageIcon("images/intackYellowBtn/노란회원가입.png");
		
		
		// 크기조정
		Image img1 = mainIcon.getImage();
		Image changeImg1 = img1.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		ImageIcon changemainIcon = new ImageIcon(changeImg1);

		Image img2 = loginIcon.getImage();
		Image changeImg2 = img2.getScaledInstance(210, 50, Image.SCALE_SMOOTH);
		ImageIcon changeloginIcon = new ImageIcon(changeImg2);
		
		Image img3 = idSearchIcon.getImage();
		Image changeImg3 = img3.getScaledInstance(155, 35, Image.SCALE_SMOOTH);
		ImageIcon changeidSearchIcon = new ImageIcon(changeImg3);
		
		Image img4 = pwSearchIcon.getImage();
		Image changeImg4 = img4.getScaledInstance(153, 35, Image.SCALE_SMOOTH);
		ImageIcon changepwSearchIcon = new ImageIcon(changeImg4);
		
		Image img5 = signInIcon.getImage();
		Image changeImg5 = img5.getScaledInstance(153, 35, Image.SCALE_SMOOTH);
		ImageIcon changesignInIcon = new ImageIcon(changeImg5);
		///////////////////////////////////////////////////////////////////////////
		
		
		
		// 노란이미지 크기조정중
		Image img22 = loginIcon.getImage();
		Image changeImg22 = img22.getScaledInstance(210, 50, Image.SCALE_SMOOTH);
		ImageIcon changeYLoginIcon = new ImageIcon(changeImg22);
		
		Image img33 = idSearchIcon.getImage();
		Image changeImg33 = img33.getScaledInstance(155, 35, Image.SCALE_SMOOTH);
		ImageIcon changeYIdSearchIcon = new ImageIcon(changeImg33);
		
		Image img44 = pwSearchIcon.getImage();
		Image changeImg44 = img44.getScaledInstance(153, 35, Image.SCALE_SMOOTH);
		ImageIcon changeYPwSearchIcon = new ImageIcon(changeImg44);
		
		Image img55 = signInIcon.getImage();
		Image changeImg55 = img55.getScaledInstance(153, 35, Image.SCALE_SMOOTH);
		ImageIcon changeYSignInIcon = new ImageIcon(changeImg55);
		
		
		
//		loginCenter.setBounds(400, 200, 100, 50);
		//////////////// 여기서부터 클래스화 할수있을거같음 //////////////////////////
		JButton lastPageBtn = new JButton("이전");
		lastPageBtn.setBounds(23, 36, 70, 44);
		add(lastPageBtn);
		lastPageBtn.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(MainPanel.lastPanel == MainPanel.loginPanel) {
					MainPanel.currPanel.setVisible(false);
					MainPanel.mainPanel.setVisible(true);					
					MainPanel.lastPanel = MainPanel.currPanel;
					MainPanel.currPanel = MainPanel.mainPanel;
				} else {
				MainPanel.currPanel.setVisible(false);
				MainPanel.lastPanel.setVisible(true);
				
				MainPanel.currPanel = MainPanel.lastPanel;
				MainPanel.lastPanel = MainPanel.loginPanel;
				}
			}
		});
		
		
		GoToButton mainBtn = new GoToButton("메인");
		mainBtn.setFont(new Font("굴림", Font.PLAIN, 0));
		mainBtn.setIcon(changemainIcon);
		mainBtn.setBorderPainted(false);
		mainBtn.setBounds(105, 36, 40, 50);
		
		mainBtn.setBackground(Color.WHITE);
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
		loginCenter.setFont(new Font("배달의민족 도현", Font.PLAIN, 14));
		loginCenter.setForeground(Color.WHITE);
		loginCenter.setBounds(400, 200, 100, 50);
		
		HintTextField idInput = new HintTextField("아이디를 입력하세요.");
		add(idInput);
		idInput.setBounds(400, 250, 300, 30);
		idInput.addKeyListener(new RestrictTextLength(idInput, 16)); //글자수제한
		idInput.addKeyListener(new IdKeyAdaptor()); // 제약사항 적용
//		idInput.addKeyListener(new KeyAdapter() {
//			@Override
//			public void keyReleased(KeyEvent e) {
//				idText = idInput.getText().toString();
//			}	
//		});
		
		pwInput = new HintPasswordField("비밀번호를 입력하세요.");
		pwInput.setFont(new Font("굴림", Font.PLAIN, 16));
		pwInput.setBounds(400, 300, 300, 30);
		pwInput.addKeyListener(new RestrictTextLength(pwInput, 12)); //글자수제한
		pwInput.addKeyListener(new PwKeyAdaptor()); // 제약사항 적용
		
		add(pwInput);
	    
//		pwInput.addKeyListener(new KeyAdapter() {
//			@Override
//			public void keyReleased(KeyEvent e) {
//				char[] a = pwInput.getPassword();
//				pwText = String.valueOf(a);				
//			}	
//		});
		

		JButton loginBtn = new JButton("로그인");
		loginBtn.setFont(new Font("굴림", Font.PLAIN, 0));
		loginBtn.setIcon(changeloginIcon);
		loginBtn.setBorderPainted(false);
//		loginBtn.setRolloverIcon(lectureSearchBtn1_img); //마우스 올렸을때 이미지 추가
		
		loginBtn.setBackground(Color.WHITE);
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
					pstmt.setString(1, idInput.getText().toString());
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
				if(searchPw.equals(String.valueOf(pwInput.getPassword()))) {
					MainPanel.currPanel.setVisible(false);
					MainPanel.mainPanel.setVisible(true);
					MainPanel.lastPanel = MainPanel.currPanel;
					MainPanel.currPanel = MainPanel.mainPanel;
					MainPanel.currUserId = idText;

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
		findId.setFont(new Font("굴림", Font.PLAIN, 0));
		findId.setIcon(changeidSearchIcon);
		findId.setBorderPainted(false);
		
		findId.setBackground(Color.WHITE);
		findId.addActionListener(new ActionListener() {		
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MainPanel.currPanel.setVisible(false);
				MainPanel.thisFrame.remove(MainPanel.idSearchPanel);
				MainPanel.idSearchPanel = new IdSearchPanel();
				MainPanel.thisFrame.add(MainPanel.idSearchPanel);
				MainPanel.idSearchPanel.setVisible(true);
				MainPanel.currPanel = MainPanel.idSearchPanel;
			}
		});
		
		
		JButton findPwBtn = new JButton("비밀번호찾기");
		add(findPwBtn);
		findPwBtn.setBounds(500, 430, 150, 35);
		findPwBtn.setFont(new Font("굴림", Font.PLAIN, 0));
		findPwBtn.setIcon(changepwSearchIcon);
		findPwBtn.setBorderPainted(false);
		
		findPwBtn.setBackground(Color.WHITE);
		findPwBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MainPanel.currPanel.setVisible(false);
				MainPanel.thisFrame.remove(MainPanel.pwSerachPanel);
				MainPanel.pwSerachPanel = new PwSearchPanel();
				MainPanel.thisFrame.add(MainPanel.pwSerachPanel);
				MainPanel.pwSerachPanel.setVisible(true);
				MainPanel.currPanel = MainPanel.pwSerachPanel;
				
			}
		});

		SignupButton signUp = new SignupButton("회원가입");
		add(signUp);
		signUp.setBounds(661, 430, 150, 35);
		signUp.setFont(new Font("굴림", Font.PLAIN, 0));
		signUp.setIcon(changesignInIcon);
		signUp.setBorderPainted(false);
		
		signUp.setBackground(Color.WHITE);
	}
}
