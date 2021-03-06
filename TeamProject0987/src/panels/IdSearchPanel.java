package panels;




import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import buttons.GoToButton;
import database.OjdbcConnection;
import labels.TopLabel;
import methods.NameKeyAdaptor;
import methods.OnlyNumKeyAdaptor;
import methods.RestrictTextLength;
import popups.IdFindPopup;

public class IdSearchPanel extends ImagePanel {

	private static String nameText = "";
	private static String jNumText = "";
	private static String searchJNum;
	private static String searchId;
	private static String frontJNum;
	private static String backJNum;
	private Icon changemainIcon;
	
	public IdSearchPanel() {
	
		setBounds(0, 0, 1200, 800);
		setLayout(null);
		
		ImageIcon mainIcon = new ImageIcon("images/homebutton.png");

		ImageIcon idSearchIcon = new ImageIcon("images/intackBtn/아이디조회버튼.png");
		
		ImageIcon yIdSearchIcon = new ImageIcon("images/intackYellowBtn/노란아이디조회.png");
		
		Image img33 = yIdSearchIcon.getImage();
		Image changeImg33 = img33.getScaledInstance(155, 35, Image.SCALE_SMOOTH);
		ImageIcon changeYIdSearchIcon = new ImageIcon(changeImg33);

		
		Image img1 = mainIcon.getImage();
		Image changeImg1 = img1.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		ImageIcon changemainIcon = new ImageIcon(changeImg1);
		
		Image img3 = idSearchIcon.getImage();
		Image changeImg3 = img3.getScaledInstance(155, 35, Image.SCALE_SMOOTH);
		ImageIcon changeidSearchIcon = new ImageIcon(changeImg3);
		
		Image img4 = yIdSearchIcon.getImage();
		Image changeImg4 = img4.getScaledInstance(155, 35, Image.SCALE_SMOOTH);
		ImageIcon changeidSearchIcon2 = new ImageIcon(changeImg4);
		
		JButton lastPageBtn = new JButton("이전");
		
		lastPageBtn.setBounds(135, 29, 95, 95);
		lastPageBtn.setBorderPainted(false);
		lastPageBtn.setFont(new Font("굴림", Font.PLAIN, 0));
		lastPageBtn.setIcon(new ImageIcon("images/backBtn.png"));
		lastPageBtn.setRolloverIcon(new ImageIcon("images/backBtn2.png"));
		
		add(lastPageBtn);
		lastPageBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MainPanel.currPanel.setVisible(false);
				MainPanel.loginPanel.setVisible(true);
				MainPanel.currPanel = MainPanel.loginPanel;		
			}
		});
		
		
		GoToButton mainBtn = new GoToButton("메인");
		mainBtn.setFont(new Font("굴림", Font.PLAIN, 0));
		mainBtn.setIcon(new ImageIcon("images/homeBtn.png"));
		mainBtn.setRolloverIcon(new ImageIcon("images/homeBtn2.png"));
		mainBtn.setBorderPainted(false);
		mainBtn.setBounds(40, 29, 95, 95);
		add(mainBtn);
		
		mainBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MainPanel.currPanel.setVisible(false);
				MainPanel.mainPanel.setVisible(true);
				MainPanel.currPanel=MainPanel.mainPanel;
				
			}
		});
		
		//
		HintTextField nameInput = new HintTextField("이름을 입력하세요.");
		add(nameInput);
		nameInput.setFont(new Font("배달의민족 도현", Font.PLAIN, 19));
		nameInput.setBounds(429, 309, 361, 44);
		nameInput.addKeyListener(new RestrictTextLength(nameInput, 14)); // 글자수제한
		nameInput.addKeyListener(new NameKeyAdaptor()); // 제약사항 적용

		nameInput.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				nameInput.setFont(new Font("배달의민족 도현", Font.PLAIN, 19));
			}

			@Override
			public void focusGained(FocusEvent e) {
				nameInput.setFont(new Font("배달의민족 도현", Font.PLAIN, 19));
			}
		});

		nameInput.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				nameInput.setFont(new Font("배달의민족 도현", Font.PLAIN, 19));
			}

			@Override
			public void keyReleased(KeyEvent e) {
				nameText = nameInput.getText().toString();
			}
		});

//		jNumText - 최종 받는 텍스트
		HintTextField jNumInput1 = new HintTextField("주민등록번호 앞 6자리");
		jNumInput1.setFont(new Font("배달의민족 도현", Font.PLAIN, 16));
		add(jNumInput1);
		jNumInput1.setBounds(430, 404, 170, 44);
		jNumInput1.addKeyListener(new RestrictTextLength(jNumInput1, 6)); //글자수제한
		jNumInput1.addKeyListener(new OnlyNumKeyAdaptor()); // 제약사항 적용

		jNumInput1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				jNumInput1.setFont(new Font("배달의민족 도현", Font.PLAIN, 16));
			}
			@Override
			public void keyReleased(KeyEvent e) {
				frontJNum = jNumInput1.getText().toString();
			}	
		});
		jNumInput1.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				jNumInput1.setFont(new Font("배달의민족 도현", Font.PLAIN, 16));				
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				jNumInput1.setFont(new Font("배달의민족 도현", Font.PLAIN, 16));				
			}
		});

		HintPasswordField jNumInput2 = new HintPasswordField("주민등록번호 뒤 7자리");
		add(jNumInput2);
		jNumInput2.setFont(new Font("배달의민족 도현", Font.PLAIN, 16));
		jNumInput2.setBounds(620, 404, 170, 44);
		jNumInput2.addKeyListener(new RestrictTextLength(jNumInput2, 7)); //글자수제한
		jNumInput2.addKeyListener(new OnlyNumKeyAdaptor()); // 제약사항 적용

		jNumInput2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				jNumInput2.setEchoChar('*');
				super.keyTyped(e);
			}
			@Override
			public void keyReleased(KeyEvent e) {
				backJNum = jNumInput2.getText().toString();
			}	
		});
		
		jNumInput2.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				jNumInput2.setFont(new Font("배달의민족 도현", Font.PLAIN, 16));				
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				jNumInput2.setFont(new Font("배달의민족 도현", Font.PLAIN, 16));				
			}
		});

		JButton idSearchBtn = new JButton("아이디 조회");
		add(idSearchBtn);
		idSearchBtn.setBounds(525, 513, 150, 30);
		idSearchBtn.setFont(new Font("굴림", Font.PLAIN, 0));
		idSearchBtn.setIcon(changeidSearchIcon);
		idSearchBtn.setBorderPainted(false);

		idSearchBtn.setRolloverIcon(changeYIdSearchIcon);
		

		idSearchBtn.setBackground(Color.white);
		idSearchBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// 주민번호 두개로 된거 합치고 시작하자
				jNumText = frontJNum + backJNum;
				try (Connection conn = OjdbcConnection.getConnection();
						PreparedStatement pstmt1 = conn
								.prepareStatement("SELECT j_number FROM members " + "WHERE member_name = ?");) {
					pstmt1.setString(1, nameText);
					ResultSet rs1 = pstmt1.executeQuery();

					while (rs1.next()) {
						searchJNum = rs1.getString("j_number");
					}

					PreparedStatement pstmt2 = conn
							.prepareStatement("SELECT member_id FROM members " + "WHERE j_number = ?");
					pstmt2.setString(1, searchJNum);
					ResultSet rs2 = pstmt2.executeQuery();

					while (rs2.next()) {
						searchId = rs2.getString(1);
					}

				} catch (SQLException e1) {
					e1.printStackTrace();
				}

				if (searchJNum == null) {
					searchJNum = "";
				}
				
				if(searchJNum.equals(jNumText)) {		
					JOptionPane.showMessageDialog(MainPanel.thisFrame, "조회된 아이디 : " + searchId);
					
					// 다시 비워놓기
					nameInput.setText("이름을 입력하세요.");				
					nameInput.setFont(new Font("배달의민족 도현", Font.PLAIN, 19));
					nameInput.setForeground(Color.GRAY);
					nameText = "";
					

					jNumInput1.setText("주민등록번호 앞 6자리");
					jNumInput1.setFont(new Font("배달의민족 도현", Font.PLAIN, 16));  
					jNumInput1.setForeground(Color.GRAY);
					
					jNumInput2.setText("주민등록번호 뒤 7자리");
					jNumInput2.setFont(new Font("배달의민족 도현", Font.PLAIN, 16));  
					jNumInput2.setForeground(Color.GRAY);
					jNumText = "";
					//
					
				} else {
					JOptionPane.showMessageDialog(MainPanel.thisFrame, "이름 또는 주민등록번호를 잘못 입력했습니다.\r\n"
							+ "입력하신 내용을 다시 확인해주세요.");
				}
			}
		});
		add(idSearchBtn);
		
		JLabel lblNewLabel = new JLabel("아이디찾기");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("배달의민족 도현", Font.BOLD, 40));
		lblNewLabel.setBounds(490, 29, 219, 70);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("이름");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("배달의민족 도현", Font.PLAIN, 19));
		lblNewLabel_1.setBounds(429, 269, 86, 30);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("주민등록번호");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("배달의민족 도현", Font.PLAIN, 19));
		lblNewLabel_1_1.setBounds(429, 364, 191, 30);
		add(lblNewLabel_1_1);
		
		JLabel pwMsgLabel = new JLabel("-");
		pwMsgLabel.setForeground(Color.WHITE);
		pwMsgLabel.setFont(new Font("굴림", Font.PLAIN, 20));
		pwMsgLabel.setBounds(604, 404, 20, 44);
		add(pwMsgLabel);
		
	}
}
	
	
