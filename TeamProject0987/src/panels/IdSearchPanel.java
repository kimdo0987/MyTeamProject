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
		
		
		JButton lastPageBtn = new JButton("이전");
		lastPageBtn.setBounds(23, 36, 70, 44);
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
			
		TopLabel toplabel = new TopLabel("아이디 찾기");
		add(toplabel);
		
		//
		HintTextField nameInput = new HintTextField("이름를 입력하세요.");
		add(nameInput);
		nameInput.setBounds(398, 227, 361, 44);
		nameInput.addKeyListener(new RestrictTextLength(nameInput, 14)); //글자수제한
		nameInput.addKeyListener(new NameKeyAdaptor()); // 제약사항 적용

		nameInput.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				nameText = nameInput.getText().toString();
			}	
		});
//		jNumText - 최종 받는 텍스트
		HintTextField jNumInput1 = new HintTextField("주민등록번호 앞 6자리");
		add(jNumInput1);
		jNumInput1.setBounds(398, 286, 170, 44);
		jNumInput1.addKeyListener(new RestrictTextLength(jNumInput1, 6)); //글자수제한
		jNumInput1.addKeyListener(new OnlyNumKeyAdaptor()); // 제약사항 적용

		jNumInput1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				frontJNum = jNumInput1.getText().toString();
			}	
		});
		
		JLabel pwMsgLabel = new JLabel("-");
		pwMsgLabel.setFont(new Font("굴림", Font.PLAIN, 20));
		pwMsgLabel.setBounds(572, 286, 20, 44);
		pwMsgLabel.setForeground(Color.white);
		add(pwMsgLabel);
		
		HintPasswordField jNumInput2 = new HintPasswordField("주민등록번호 뒤 7자리");
		add(jNumInput2);
		jNumInput2.setBounds(588, 286, 170, 44);
		jNumInput2.addKeyListener(new RestrictTextLength(jNumInput2, 7)); //글자수제한
		jNumInput2.addKeyListener(new OnlyNumKeyAdaptor()); // 제약사항 적용

		jNumInput2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				backJNum = jNumInput2.getText().toString();
			}	
		});

		JButton idSearchBtn = new JButton("아이디 조회");
		add(idSearchBtn);
		idSearchBtn.setBounds(500, 378, 150, 30);
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
					nameInput.setText("이름를 입력하세요.");
					nameInput.setFont(new Font("맑은고딕", Font.PLAIN, 14));  
					nameInput.setForeground(Color.GRAY);
					nameText = "";
					

					jNumInput1.setText("주민등록번호 앞 6자리");
					jNumInput1.setFont(new Font("맑은고딕", Font.PLAIN, 14));  
					jNumInput1.setForeground(Color.GRAY);
					
					jNumInput2.setText("주민등록번호 뒤 7자리");
					jNumInput2.setFont(new Font("맑은고딕", Font.PLAIN, 14));  
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
		
	}
}
	
	
