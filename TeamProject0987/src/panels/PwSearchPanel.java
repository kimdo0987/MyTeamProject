package panels;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import buttons.GoToButton;
import database.OjdbcConnection;
import labels.TopLabel;

import methods.IdKeyAdaptor;
import methods.NameKeyAdaptor;

import methods.OnlyNumKeyAdaptor;
import methods.RestrictTextLength;
import tempPassword.TempPassword;

public class PwSearchPanel extends ImagePanel {
	private static String nameText = "";
	private static String idText = "";
	private static String jNumText = "";
	private static String searchName;
	private static String searchJNum;
	private static String frontJNum;
	private static String backJNum;
	
	public PwSearchPanel() { 
		ImageIcon mainIcon = new ImageIcon("images/homebutton.png");
		ImageIcon pwIcon = new ImageIcon("images/intackBtn/임시비밀번호로변경버튼.png");
		
		ImageIcon yMainIcon = new ImageIcon("images/homebutton3.png");
		ImageIcon yPwCreateIcon = new ImageIcon("images/intackYellowBtn/노란임시비밀번호생성.png");
		
		
		//크기조정
		Image img1 = mainIcon.getImage();
		Image changeImg1 = img1.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		ImageIcon changemainIcon = new ImageIcon(changeImg1);
		
		Image img2 = pwIcon.getImage();
		Image changeImg2 = img2.getScaledInstance(210, 50, Image.SCALE_SMOOTH);
		ImageIcon changePwIcon = new ImageIcon(changeImg2);
		
		//노란거 크기조정
		Image img11 = yMainIcon.getImage();
		Image changeImg11 = img11.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		ImageIcon changeYMainIcon = new ImageIcon(changeImg11);

		Image img22 = yPwCreateIcon.getImage();
		Image changeImg22 = img22.getScaledInstance(210, 50, Image.SCALE_SMOOTH);
		ImageIcon changeYLoginIcon = new ImageIcon(changeImg22);
		
		
		
		
		setBounds(0, 0, 1200, 800);
		setLayout(null);
		
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
		
		
		HintTextField idInput = new HintTextField("아이디를 입력하세요.");
		add(idInput);
		idInput.setBounds(435, 260, 361, 44);
		idInput.setFont(new Font("배달의민족 도현", Font.PLAIN, 19));
		idInput.addKeyListener(new RestrictTextLength(idInput, 16)); //글자수제한
		idInput.addKeyListener(new IdKeyAdaptor()); // 제약사항 적용
		
		idInput.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				idInput.setFont(new Font("배달의민족 도현", Font.PLAIN, 19));
			}
			@Override
			public void keyReleased(KeyEvent e) {
				idText = idInput.getText().toString();
			}	
		});
		idInput.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				idInput.setFont(new Font("배달의민족 도현", Font.PLAIN, 19));				
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				idInput.setFont(new Font("배달의민족 도현", Font.PLAIN, 19));				
			}
		});
		
		
		
		HintTextField nameInput = new HintTextField("이름을 입력하세요.");
		add(nameInput);
		nameInput.setBounds(435, 358, 361, 44);
		nameInput.setFont(new Font("배달의민족 도현", Font.PLAIN, 19));
		nameInput.addKeyListener(new RestrictTextLength(nameInput, 14)); //글자수제한
		nameInput.addKeyListener(new NameKeyAdaptor()); // 제약사항 적용

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
		
		
		HintTextField jNumInput = new HintTextField("주민등록번호 앞 6자리");
		add(jNumInput);
		jNumInput.setBounds(435, 441, 170, 44);
		jNumInput.setFont(new Font("배달의민족 도현", Font.PLAIN, 16));
		jNumInput.addKeyListener(new RestrictTextLength(jNumInput, 6)); //글자수제한
		jNumInput.addKeyListener(new OnlyNumKeyAdaptor()); // 제약사항 적용
		
		jNumInput.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				jNumInput.setFont(new Font("배달의민족 도현", Font.PLAIN, 16));
			}
			@Override
			public void keyReleased(KeyEvent e) {
				frontJNum = jNumInput.getText().toString();
			}	
		});		
		
		jNumInput.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				jNumInput.setFont(new Font("배달의민족 도현", Font.PLAIN, 16));				
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				jNumInput.setFont(new Font("배달의민족 도현", Font.PLAIN, 16));				
			}
		});
		
		JLabel pwMsgLabel = new JLabel("-");
		pwMsgLabel.setFont(new Font("굴림", Font.PLAIN, 20));
		pwMsgLabel.setBounds(609, 439, 20, 44);
		pwMsgLabel.setForeground(Color.WHITE);
		
		add(pwMsgLabel);
		
		HintPasswordField jNumInput2 = new HintPasswordField("주민등록번호 뒤 7자리");
		add(jNumInput2);
		jNumInput2.setFont(new Font("배달의민족 도현", Font.PLAIN, 16));
		
		jNumInput2.setBounds(625, 441, 170, 44);
		jNumInput2.addKeyListener(new RestrictTextLength(jNumInput2, 7)); //글자수제한
		jNumInput2.addKeyListener(new OnlyNumKeyAdaptor()); // 제약사항 적용

		jNumInput2.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				jNumInput2.setFont(new Font("배달의민족 도현", Font.PLAIN, 16));
				jNumInput2.setEchoChar('*');
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
		
		JButton pwSearchBtn = new JButton("임시 비밀번호로 변경");
		
		pwSearchBtn.setFont(new Font("굴림", Font.PLAIN, 0));
		pwSearchBtn.setIcon(changePwIcon);
		pwSearchBtn.setBorderPainted(false);
		pwSearchBtn.setBackground(Color.WHITE);
		pwSearchBtn.setRolloverIcon(changeYLoginIcon); //마우스 올렸을때 이미지 추가
		
		pwSearchBtn.setBounds(525, 513, 200, 50);
		pwSearchBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//frontJNum 이랑 backJNum 합쳐서 text로 보내놓기
				jNumText = frontJNum + backJNum;
				try (
						Connection conn = OjdbcConnection.getConnection();
						PreparedStatement pstmt1 = conn.prepareStatement("SELECT member_name FROM members "
								+ "WHERE member_id = ?");
						PreparedStatement pstmt2 = conn.prepareStatement("SELECT j_number FROM members "
								+ "WHERE member_name = ?");
						) {
					pstmt1.setString(1, idText);
					ResultSet rs1 = pstmt1.executeQuery();
					
					while(rs1.next()) {
						searchName = rs1.getString("member_name");
					}
					
					pstmt2.setString(1, searchName);
					ResultSet rs2 = pstmt2.executeQuery();
					
					while(rs2.next()) {
						searchJNum = rs2.getString("j_number");
					}
					
					pstmt2.close();
					
				} catch (SQLException e1) {
					e1.printStackTrace();
				}

				if (searchJNum == null) {
					searchJNum = "";
				}
				if (searchName == null) {
					searchName = "";
				}
				if (jNumText == null) {
					jNumText = "";
				}
				if (nameText == null) {
					nameText = "";
				}
				if (idText == null) {
					idText = "";
				}
				
				if(searchJNum.equals(jNumText) && searchName.equals(nameText) && 
						jNumText != "" && nameText != "" && idText != "") {		
					// 임시비번 생성
					TempPassword tpw = new TempPassword();
					
					// 확인창
					JOptionPane.showMessageDialog(MainPanel.thisFrame, "임시 비밀번호 : " + tpw.temp_password + "\r\n"
													+ "(임시 비밀번호가 클립보드에 복사되었습니다.)");
					
					// 클립보드에 복사해놓기
					StringSelection data = new StringSelection(tpw.temp_password);
					Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
					clipboard.setContents(data, data);
					
					// idText에 맞는  member_password (member_id)를 temp_password 로 UPDATE 해야한다
					String sql = "UPDATE members SET member_password = ? WHERE member_id = ?";
					try (
							Connection conn = OjdbcConnection.getConnection();
							PreparedStatement pstmt3 = conn.prepareStatement(sql);
					){
						conn.setAutoCommit(false);
						pstmt3.setString(1, tpw.temp_password);
						pstmt3.setString(2, idText);
						pstmt3.executeUpdate();
						conn.commit();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					
					
					
					// 다시 비워놓기
					idInput.setText("아이디를 입력하세요.");  
					idInput.setFont(new Font("맑은고딕", Font.PLAIN, 14));  
					idInput.setForeground(Color.GRAY);
					
					nameInput.setText("이름을 입력하세요.");
					nameInput.setFont(new Font("맑은고딕", Font.PLAIN, 14));  
					nameInput.setForeground(Color.GRAY);
					nameText = "";
					
					jNumInput.setText("주민등록번호를 입력하세요. ('-' 제외 후 입력)");
					jNumInput.setFont(new Font("맑은고딕", Font.PLAIN, 14));  
					jNumInput.setForeground(Color.GRAY);
					jNumText = "";
					
					
					
					
					
					MainPanel.currPanel.setVisible(false);
					MainPanel.loginPanel.setVisible(true);			
					//이전 페이지 설정안하는이유 : 로그인으로 나와서 이전 눌렀을때 다시 임시패스워드로 가는것이 어색한 상황이다.
					MainPanel.currPanel = MainPanel.loginPanel;
				} else {
					JOptionPane.showMessageDialog(MainPanel.thisFrame, "입력정보를 잘못 입력했습니다.\r\n"
							+ "입력하신 내용을 다시 확인해주세요.");
				}
			}
		});
		add(pwSearchBtn);
		
		JLabel lblNewLabel = new JLabel("비밀번호 찾기");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("배달의민족 도현", Font.BOLD, 40));
		lblNewLabel.setBounds(490, 29, 261, 93);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("아이디");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("배달의민족 도현", Font.PLAIN, 19));
		lblNewLabel_1.setBounds(435, 220, 86, 30);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("이름");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("배달의민족 도현", Font.PLAIN, 19));
		lblNewLabel_1_1.setBounds(435, 318, 86, 30);
		add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("주민등록번호");
		lblNewLabel_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1.setFont(new Font("배달의민족 도현", Font.PLAIN, 19));
		lblNewLabel_1_1_1.setBounds(435, 408, 217, 30);
		add(lblNewLabel_1_1_1);
	}
	
}
