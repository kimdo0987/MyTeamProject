package panels;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.regex.Pattern;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import buttons.GoToButton;
import database.OjdbcConnection;
import labels.TopLabel;
import methods.OnlyNumKeyAdaptor;
import methods.RestrictTextLength;
import popups.MsgPopup;

public class SignupPanel extends ImagePanel {
		 	
	private JTextField createIdField;
	private HintPasswordField createPwField;
	private HintPasswordField rePwField;
	private JTextField insertNameField;
	private JTextField insertJNum1Field;
	private JPasswordField insertJNum2Field;
	private JTextField insertPhoneNumField1;
	private JTextField insertPhoneNumField2;
	private JTextField insertPhoneNumField3;
	public static HashSet<String> favCategories;
	


	public SignupPanel() {
		setBounds(0, 0, 1200, 800);
		setLayout(null);
		
		//////////////// 여기서부터 클래스화 할수있을거같음 //////////////////////////
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
				MainPanel.lastPanel.setVisible(true);			
				
				MainPanel.currPanel = MainPanel.lastPanel;
			}
		});
		
		//////////////////////////////////////////////////////////////////
		
		GoToButton mainBtn = new GoToButton("메인");
		mainBtn.setFont(new Font("굴림", Font.PLAIN, 0));
		mainBtn.setIcon(new ImageIcon("images/homeBtn.png"));
		mainBtn.setRolloverIcon(new ImageIcon("images/homeBtn2.png"));
		mainBtn.setBorderPainted(false);
		mainBtn.setBounds(40, 29, 95, 95);
		add(mainBtn);
		
		
		JLabel lblTeamname = new JLabel("회원 가입");
		lblTeamname.setFont(new Font("배달의민족 도현", Font.BOLD, 39));
		lblTeamname.setForeground(Color.WHITE);
		lblTeamname.setBounds(475, 28, 180, 62);
		add(lblTeamname);
		
		
		
		////////////////////아이디 생성조건 ///////////////////////////////////
		JLabel idMsgLabel = new JLabel("");
		idMsgLabel.setVisible(true);
		idMsgLabel.setFont(new Font("굴림", Font.PLAIN, 11));
		idMsgLabel.setBounds(431, 143, 276, 32);
		add(idMsgLabel);

		createIdField = new HintTextField("4~16 이내 영문숫자조합");
		createIdField.setFont(new Font("배달의민족 도현", Font.PLAIN, 17));
		createIdField.setBounds(431, 99, 253, 44);
		createIdField.addKeyListener(new RestrictTextLength(createIdField, 16)); // 글자수제한
		createIdField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) { // keyTyped에서 한글입력 막기
				createIdField.setFont(new Font("배달의민족 도현", Font.PLAIN, 18));
				if ((!Pattern.matches("\\w", "" + e.getKeyChar()) || e.getKeyChar() == '_')) {
					e.consume(); // 이벤트 소멸(무시)하기
				}
			}

			@Override
			public void keyPressed(KeyEvent e) { //keyPressed에서 복사붙여넣기등 이상한 행동막기
				String msg = createIdField.getText();			
				
				if ((e.getKeyChar() != KeyEvent.VK_BACK_SPACE) && (e.getKeyChar() != KeyEvent.VK_DELETE)
						&& (e.getKeyCode() != 36) // END키 허용
						&& (e.getKeyCode() != 35) // HOME키 허용
						&& (e.getKeyCode() != 37) // 왼쪽 방향키 허용
						&& (e.getKeyCode() != 39) // 오른쪽방향키 허용 //영문과 숫자만 허용하고 다막아놔서 따로 허용해 주어야한다
				) {
					e.consume(); // 이벤트 소멸(무시)하기
				}

//				 if (msg.length() > 16) { 
//					createIdField.setText(msg.substring(0, 16)); //긴 글 복붙으로 삽입 방지
//				} else 
				if (!Pattern.matches("\\w*", msg)) {
					idMsgLabel.setForeground(Color.red);
					idMsgLabel.setText("사용 불가능한 문자가 포함되어 있습니다");
				}

			}

			@Override
			public void keyReleased(KeyEvent e) {
				String msg = createIdField.getText();
				if (msg.length() < 4) {
					idMsgLabel.setForeground(Color.red);
					idMsgLabel.setText("아이디는 4글자 이상이여야 합니다");
				} else if (Pattern.matches("\\w*", msg) && msg.length() < 17 && msg.length() > 3) {
					if (!idMsgLabel.getText().equals("중복확인완료")) { // 완료된상태에서는 안바뀌게
						idMsgLabel.setForeground(new Color(153, 255, 153)); // 초록색
						idMsgLabel.setText("사용가능한 형식입니다 (중복확인을 해주세요)");
					}
				}
			}

		});
		
		
		createIdField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				createIdField.setFont(new Font("배달의민족 도현", Font.PLAIN, 18));
				if (createIdField.getText().equals("4~16 이내 영문숫자조합")) {
					createIdField.setFont(new Font("배달의민족 도현", Font.PLAIN, 17));
					idMsgLabel.setForeground(Color.red);
					idMsgLabel.setText("필수 정보입니다");
				} else {

				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				createIdField.setFont(new Font("배달의민족 도현", Font.PLAIN, 18));
				
			}
		});

		add(createIdField);
		
		/////////////////// 중복 확인 /////////////////////////////
		JButton idCheckBtn = new JButton("중복확인");
		
		idCheckBtn.setFont(new Font("",Font.PLAIN,0));
		
		Image img3= (new ImageIcon("images/changeButton/중복확인버튼.png").getImage());
		Image changeImg3 = img3.getScaledInstance(110, 50, Image.SCALE_SMOOTH);
		ImageIcon idCheckIcon = new ImageIcon(changeImg3);
		idCheckBtn.setIcon(idCheckIcon );
		
		Image img4= (new ImageIcon("images/changeButton/노란중복확인버튼.png").getImage());
		Image changeImg4 = img4.getScaledInstance(110, 50, Image.SCALE_SMOOTH);
		ImageIcon idCheckIcon2 = new ImageIcon(changeImg4);
		idCheckBtn.setRolloverIcon(idCheckIcon2);
		
		idCheckBtn.setBorderPainted(false);	
		
		idCheckBtn.setBounds(699, 96, 105, 50);
		idCheckBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (!createIdField.getText().equals("4~16 이내 영문숫자조합")
						&& idMsgLabel.getText().equals("사용가능한 형식입니다 (중복확인을 해주세요)")) {
					//기존에있던 아이디인지 확인.
					String memberid = null;
					try (
							Connection conn = OjdbcConnection.getConnection();
							PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM members "
									+ "WHERE member_id = ?");							
							) {
						pstmt.setString(1, createIdField.getText());
						ResultSet rs = pstmt.executeQuery();
						while(rs.next()) {
							//System.out.println(createIdField.getText());
							memberid = rs.getString("member_id");
						}				
						
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					if(memberid == null) {
						if(JOptionPane.showConfirmDialog(MainPanel.thisFrame, "사용가능한 아이디입니다\n사용하시겠습니까?", "아이디 중복확인", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE) == 0) {
							
							createIdField.setEditable(false);
							idMsgLabel.setText("중복확인완료");
							createIdField.removeKeyListener(null);
						} else {
							
						}				
					} else {
						JOptionPane.showMessageDialog(MainPanel.thisFrame, "이미 사용중인 아이디입니다");
						idMsgLabel.setForeground(Color.red);
						idMsgLabel.setText("다른 아이디를 입력해주세요");
					}
				}
			}
		});
		add(idCheckBtn);

		////////////////////비밀번호 생성조건 ///////////////////////////////////
		JLabel pwMsgLabel = new JLabel("");
		pwMsgLabel.setFont(new Font("굴림", Font.PLAIN, 11));
		pwMsgLabel.setBounds(431, 235, 276, 43);
		add(pwMsgLabel);
		
		JLabel rePwMsgLabel = new JLabel("");
		rePwMsgLabel.setFont(new Font("굴림", Font.PLAIN, 11));
		rePwMsgLabel.setBounds(431, 325, 276, 43);
		add(rePwMsgLabel);
		
		createPwField = new HintPasswordField("8~12 이내 영문숫자특문조합");
		createPwField.setFont(new Font("배달의민족 도현", Font.PLAIN, 17));
		createPwField.setBounds(431, 190, 253, 44);
		createPwField.addKeyListener(new RestrictTextLength(createPwField, 12)); //글자수제한
		
		
		rePwField = new HintPasswordField("8~12 이내 영문숫자특문조합");
		rePwField.setFont(new Font("배달의민족 도현", Font.PLAIN, 17));
		rePwField.setBounds(431, 280, 253, 44);
		rePwField.addKeyListener(new RestrictTextLength(rePwField, 12)); //글자수제한
		
		createPwField.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyPressed(KeyEvent e) {
				createPwField.setEchoChar('*');
				super.keyPressed(e);
			}			

			public void keyReleased(KeyEvent e) {     
				
				String msg = String.valueOf(createPwField.getPassword());
				createPwField.setFont(new Font("배달의민족 도현", Font.PLAIN, 20));
				if (!Pattern.matches("[!-~]", "" + e.getKeyChar())) { // 특수문자,영어,숫자 이외의 문자는 입력안됨
					e.consume(); // 이벤트 소멸(무시)하기
				}
				if (msg.length() < 8) {
					pwMsgLabel.setForeground(Color.red);
					pwMsgLabel.setText("비밀번호는 8글자 이상이여야 합니다");
				} else if (msg.length() > 12) {
					createPwField.setText(msg.substring(0, 12)); // 긴 글 복붙으로 삽입 방지
				} else if (!Pattern.matches("[!-~]*", msg)) {
					pwMsgLabel.setForeground(Color.red);
					pwMsgLabel.setText("사용 불가능한 문자가 포함되어 있습니다");
				} else if (Pattern.matches("[!-~]*", msg) && msg.length() < 13 && msg.length() > 7) {
					pwMsgLabel.setForeground(new Color(153, 255, 153)); // 초록색
					pwMsgLabel.setText("사용가능한 비밀번호입니다");
				}
				if (!msg.equals(String.valueOf(rePwField.getPassword()))) {
					rePwMsgLabel.setForeground(Color.red);
					rePwMsgLabel.setText("비밀번호가 일치하지 않습니다");
				} else {
					rePwMsgLabel.setForeground(new Color(153, 255, 153));
					rePwMsgLabel.setText("비밀번호가 같게 입력되었습니다");
				}
			}
		});

		createPwField.addFocusListener(new FocusAdapter() {
			
			@Override
			public void focusGained(FocusEvent e) {
				createPwField.setFont(new Font("배달의민족 도현", Font.PLAIN, 20));
				super.focusGained(e);
			}
			
			@Override
			public void focusLost(FocusEvent e) {
				createPwField.setFont(new Font("배달의민족 도현", Font.PLAIN, 20));
				if ((String.valueOf(createPwField.getPassword())).equals("8~12 이내 영문숫자특문조합")) {
					createPwField.setFont(new Font("배달의민족 도현", Font.PLAIN, 17));
					pwMsgLabel.setForeground(Color.red);
					pwMsgLabel.setText("필수 정보입니다");
				} else {

				}
			}

		});
		
		add(createPwField);
		
		////////////////////비밀번호 재입력 조건 ///////////////////////////////////
		
		

		
		rePwField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				rePwField.setEchoChar('*');
				super.keyPressed(e);
			}
			
			public void keyReleased(KeyEvent e) {   
				
				String msg = String.valueOf(rePwField.getPassword());

				if (!Pattern.matches("[!-~]", "" + e.getKeyChar())) { // 특수문자,영어,숫자 이외의 문자는 입력안됨
					e.consume(); // 이벤트 소멸(무시)하기
				}
				if (msg.length() > 12) {
					rePwField.setText(msg.substring(0, 12)); // 긴 글 복붙으로 삽입 방지
				} else if (!Pattern.matches("[!-~]*", msg)) {
					rePwMsgLabel.setForeground(Color.red);
					rePwMsgLabel.setText("사용 불가능한 문자가 포함되어 있습니다");
				} else if ((Pattern.matches("[!-~]*", msg)) && msg.equals(String.valueOf(createPwField.getPassword()))
						&& msg.length() < 13 && msg.length() > 7) {
					rePwMsgLabel.setForeground(new Color(153, 255, 153)); // 초록색
					rePwMsgLabel.setText("비밀번호가 같게 입력되었습니다");
				} else if (!msg.equals(String.valueOf(createPwField.getPassword()))) {
					rePwMsgLabel.setForeground(Color.red);
					rePwMsgLabel.setText("비밀번호가 일치하지 않습니다");
				} else {
					rePwMsgLabel.setText(pwMsgLabel.getText());
				}
			}
		});

		rePwField.addFocusListener(new FocusAdapter() {

			@Override
			public void focusGained(FocusEvent e) {
				rePwField.setFont(new Font("배달의민족 도현", Font.PLAIN, 20));
			}

			@Override
			public void focusLost(FocusEvent e) {
				rePwField.setFont(new Font("배달의민족 도현", Font.PLAIN, 20));
				String msg = String.valueOf(rePwField.getPassword());
				if (!msg.equals(String.valueOf(createPwField.getPassword()))) {
					rePwMsgLabel.setForeground(Color.red);
					rePwMsgLabel.setText("비밀번호가 일치하지 않습니다");
				} else if(msg.equals("8~12 이내 영문숫자특문조합")){
					rePwField.setFont(new Font("배달의민족 도현", Font.PLAIN, 17));

				}
			}

		});
		
		add(rePwField);
		
		//////////////////////// 이름 입력 조건 ///////////////////////////////////
		JLabel insertNameLabel = new JLabel("이름");
		insertNameLabel.setForeground(Color.WHITE);
		insertNameLabel.setFont(new Font("배달의민족 도현", Font.PLAIN, 18));
		insertNameLabel.setBounds(376, 365, 46, 44);
		add(insertNameLabel);
		
		JLabel nameMsgLabel = new JLabel();
		nameMsgLabel.setFont(new Font("굴림", Font.PLAIN, 11));
		nameMsgLabel.setBounds(430, 404, 276, 32);
		add(nameMsgLabel);
		
		insertNameField = new JTextField();
		insertNameField.setFont(new Font("굴림", Font.PLAIN, 16));
		insertNameField.setBounds(431, 365, 253, 44);

		insertNameField.addKeyListener(new RestrictTextLength(insertNameField, 14));
		insertNameField.addKeyListener(new KeyAdapter() {

			@Override
			public void keyTyped(KeyEvent e) {
				insertNameField.setFont(new Font("배달의민족 도현", Font.PLAIN, 20));
				String msg = insertNameField.getText();
				if (!(Pattern.matches("[A-Za-z]", "" + e.getKeyChar())
						|| ('가' <= e.getKeyChar()) && (e.getKeyChar() <= '힣')) || e.getKeyChar() == '_') {
					e.consume(); // 이벤트 소멸(무시)하기
				}
				if (msg.length() > 14) {
					insertNameField.setText(msg.substring(0, 14)); // 긴 글 복붙으로 삽입 방지
				}
			}

		});

		insertNameField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				insertNameField.setFont(new Font("배달의민족 도현", Font.PLAIN, 20));			
			}
			
			@Override
			public void focusLost(FocusEvent e) {
				insertNameField.setFont(new Font("배달의민족 도현", Font.PLAIN, 20));
				if (insertNameField.getText().equals("")) {
					nameMsgLabel.setForeground(Color.red);
					nameMsgLabel.setText("필수 정보입니다");
				} else {
					nameMsgLabel.setForeground(new Color(153, 255, 153));
					nameMsgLabel.setText("입력완료");
				}
			}
		});
		add(insertNameField);
		
		////////////////////////주민번호 앞자리 입력 조건 ///////////////////////////////////
		
		JLabel insertJNum1Label = new JLabel("주민번호");
		insertJNum1Label.setForeground(Color.WHITE);
		insertJNum1Label.setFont(new Font("배달의민족 도현", Font.PLAIN, 18));
		insertJNum1Label.setBounds(345, 522, 75, 44);
		add(insertJNum1Label);
		
		JLabel JNumMsgLabel = new JLabel();
		JNumMsgLabel.setFont(new Font("굴림", Font.PLAIN, 11));
		JNumMsgLabel.setBounds(431, 561, 276, 32);
		add(JNumMsgLabel);
		
		insertJNum1Field = new JTextField();
		insertJNum1Field.setFont(new Font("굴림", Font.PLAIN, 16));
		insertJNum1Field.setBounds(431, 522, 105, 44);
		insertJNum1Field.addKeyListener(new RestrictTextLength(insertJNum1Field, 6)); //글자수제한
		insertJNum1Field.addKeyListener(new OnlyNumKeyAdaptor());
		insertJNum1Field.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				
				insertJNum1Field.setFont(new Font("배달의민족 도현", Font.PLAIN, 20));			
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				if ((insertJNum1Field.getText() + insertJNum2Field.getText()).length() == 13) {
					JNumMsgLabel.setForeground(new Color(153, 255, 153));
					JNumMsgLabel.setText("입력완료");
				} else {
					JNumMsgLabel.setForeground(Color.red);
					JNumMsgLabel.setText("주민번호를 올바르게 입력해 주세요");
					
				}
			}
		});
		
		add(insertJNum1Field);
		
		////////////////////////주민번호 뒷자리 입력 조건 ///////////////////////////////////
		
		insertJNum2Field = new JPasswordField();
		insertJNum2Field.setFont(new Font("굴림", Font.PLAIN, 16));
		insertJNum2Field.setBounds(569, 522, 115, 44);
		insertJNum2Field.addKeyListener(new RestrictTextLength(insertJNum2Field, 7)); //글자수제한
		insertJNum2Field.addKeyListener(new OnlyNumKeyAdaptor());
		insertJNum2Field.addKeyListener(new KeyAdapter() {
			
			
			@Override
			public void keyTyped(KeyEvent e) {
				insertJNum2Field.setEchoChar('*');
				insertJNum2Field.setFont(new Font("배달의민족 도현", Font.PLAIN, 20));			
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				if ((insertJNum1Field.getText() + insertJNum2Field.getText()).length() == 13) {
					JNumMsgLabel.setForeground(new Color(153, 255, 153));
					JNumMsgLabel.setText("입력완료");
				} else {
					JNumMsgLabel.setForeground(Color.red);
					JNumMsgLabel.setText("주민번호를 올바르게 입력해 주세요");
					
				}
			}			
			
		});
		
		add(insertJNum2Field);
		
		insertJNum1Field.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				insertJNum1Field.setFont(new Font("배달의민족 도현", Font.PLAIN, 20));
			}
			@Override
			public void focusLost(FocusEvent e) {
				insertJNum1Field.setFont(new Font("배달의민족 도현", Font.PLAIN, 20));
				if ((insertJNum1Field.getText().length() + (insertJNum2Field.getPassword().length))!= 13) {
					JNumMsgLabel.setForeground(Color.red);
					JNumMsgLabel.setText("주민번호를 올바르게 입력해 주세요");
				} else {
					JNumMsgLabel.setForeground(new Color(153, 255, 153));
					JNumMsgLabel.setText("입력완료");
				}

			}

		});
		
		
		insertJNum2Field.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				insertJNum2Field.setFont(new Font("배달의민족 도현", Font.PLAIN, 20));
			
			}
			@Override
			public void focusLost(FocusEvent e) {
				insertJNum2Field.setFont(new Font("배달의민족 도현", Font.PLAIN, 20));
				if ((insertJNum1Field.getText() + insertJNum2Field.getText()).length() != 13) {
					JNumMsgLabel.setForeground(Color.red);
					JNumMsgLabel.setText("주민번호를 올바르게 입력해 주세요");
				} else {
					JNumMsgLabel.setForeground(new Color(153, 255, 153));
					JNumMsgLabel.setText("입력완료");
				}

			}

		});
		
		////////////////////////전화번호 입력조건 ///////////////////////////////////
		
		JLabel insertPhoneNumLabel = new JLabel("전화번호");
		insertPhoneNumLabel.setForeground(Color.WHITE);
		insertPhoneNumLabel.setFont(new Font("배달의민족 도현", Font.PLAIN, 18));
		insertPhoneNumLabel.setBounds(345, 439, 75, 44);
		add(insertPhoneNumLabel);
		
		JLabel hyphenLabel = new JLabel("-");
		hyphenLabel.setForeground(new Color(255, 255, 255));
		hyphenLabel.setFont(new Font("굴림", Font.PLAIN, 16));
		hyphenLabel.setBounds(548, 522, 30, 44);
		add(hyphenLabel);
		
		JLabel phoneMsgLabel = new JLabel();
		phoneMsgLabel.setFont(new Font("굴림", Font.PLAIN, 11));
		phoneMsgLabel.setBounds(430, 474, 276, 43);
		add(phoneMsgLabel);
		
		insertPhoneNumField1 = new JTextField();		
		insertPhoneNumField1.setBounds(431, 439, 47, 44);
		insertPhoneNumField1.addKeyListener(new RestrictTextLength(insertPhoneNumField1, 3));//글자수 3자로 제한
		insertPhoneNumField1.addKeyListener(new OnlyNumKeyAdaptor()); //숫자만 입력가능, 복붙차단
		
		
		add(insertPhoneNumField1);
		
		insertPhoneNumField2 = new JTextField();
		insertPhoneNumField2.setFont(new Font("굴림", Font.PLAIN, 16));
		insertPhoneNumField2.setBounds(505, 439, 70, 44);
		insertPhoneNumField2.addKeyListener(new RestrictTextLength(insertPhoneNumField2, 4));//글자수 4자로제한
		insertPhoneNumField2.addKeyListener(new OnlyNumKeyAdaptor()); //숫자만 입력가능, 복붙차단
		add(insertPhoneNumField2);
		
		insertPhoneNumField3 = new JTextField();
		insertPhoneNumField3.setFont(new Font("굴림", Font.PLAIN, 16));
		insertPhoneNumField3.setBounds(598, 439, 70, 44);
		insertPhoneNumField3.addKeyListener(new RestrictTextLength(insertPhoneNumField3, 4));//글자수 4자로제한
		insertPhoneNumField3.addKeyListener(new OnlyNumKeyAdaptor()); //숫자만 입력가능, 복붙차단
		add(insertPhoneNumField3);
		
		KeyListener phoneNumKeyAdapter = new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				insertPhoneNumField1.setFont(new Font("배달의민족 도현", Font.PLAIN, 20));
				insertPhoneNumField2.setFont(new Font("배달의민족 도현", Font.PLAIN, 20));
				insertPhoneNumField3.setFont(new Font("배달의민족 도현", Font.PLAIN, 20));
			}

			@Override
			public void keyReleased(KeyEvent e) {
				if (insertPhoneNumField1.getText().equals("") || insertPhoneNumField2.getText().equals("")
						|| insertPhoneNumField3.getText().equals("")) {
					phoneMsgLabel.setForeground(Color.red);
					phoneMsgLabel.setText("전화번호를 정확히 입력해 주세요");
				} else {
					phoneMsgLabel.setForeground(new Color(153, 255, 153));
					phoneMsgLabel.setText("입력완료");
				}
			}
		};
		insertPhoneNumField1.addKeyListener(phoneNumKeyAdapter);		
		insertPhoneNumField2.addKeyListener(phoneNumKeyAdapter);
		insertPhoneNumField3.addKeyListener(phoneNumKeyAdapter);
		
		FocusListener phoneFocusAdapter = new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (insertPhoneNumField1.getText().equals("")
						&& insertPhoneNumField2.getText().equals("")
						&& insertPhoneNumField3.getText().equals("")) {
					phoneMsgLabel.setForeground(Color.red);
					phoneMsgLabel.setText("필수 정보입니다");
				} else {

				}
			}

		};
		
		insertPhoneNumField1.addFocusListener(phoneFocusAdapter);
		insertPhoneNumField2.addFocusListener(phoneFocusAdapter);
		insertPhoneNumField3.addFocusListener(phoneFocusAdapter);
		
		////////////////////////메일 입력조건 ///////////////////////////////////
		
		JLabel mailMsgLabel = new JLabel("example@gmail.com 형식으로 입력해주세요");
		mailMsgLabel.setForeground(Color.WHITE);
		mailMsgLabel.setBounds(431, 631, 325, 43);
		mailMsgLabel.setFont(new Font("굴림", Font.PLAIN, 11));
		add(mailMsgLabel);
		
		JTextField insertMailField = new JTextField("");
		insertMailField.setFont(new Font("굴림", Font.PLAIN, 16));
		insertMailField.setBounds(431, 595, 114, 44);
		
		JTextField domainField = new JTextField("");
		domainField.setFont(new Font("굴림", Font.PLAIN, 16));
		domainField.setBounds(579, 595, 105, 44);
		add(domainField);
		
		insertMailField.addKeyListener(new RestrictTextLength(insertMailField, 20));
		insertMailField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				if ((e.getKeyChar() != KeyEvent.VK_BACK_SPACE) && (e.getKeyChar() != KeyEvent.VK_DELETE)
						&& (e.getKeyCode() != 36) // END키 허용
						&& (e.getKeyCode() != 35) // HOME키 허용
						&& (e.getKeyCode() != 37) // 왼쪽 방향키 허용
						&& (e.getKeyCode() != 39) // 오른쪽방향키 허용
				) {
					e.consume();
				}
			}
			@Override
			public void keyTyped(KeyEvent e) { // 타자칠때 숫자이외 방지용
				insertMailField.setFont(new Font("배달의민족 도현", Font.PLAIN, 20));
				if (!((e.getKeyChar() >= '0' && e.getKeyChar() <= '9')
						|| (e.getKeyChar() >= 'a' && e.getKeyChar() <= 'z') || e.getKeyChar() == '_'
						|| e.getKeyChar() == '-')) {
					e.consume();

				}
			}
			@Override
			public void keyReleased(KeyEvent e) {
				String email = insertMailField.getText()+"@"+domainField.getText();
				if(Pattern.matches("\\w+@\\w+\\.[a-zA-Z]+(\\.[a-zA-Z]+)*", email)) {
					mailMsgLabel.setForeground(new Color(153, 255, 153));
					mailMsgLabel.setText("입력완료");
				} else {
					mailMsgLabel.setForeground(Color.RED);
					mailMsgLabel.setText("example@gmail.com 형식으로 입력해주세요");
				}
				super.keyReleased(e);
			}

		});
		
		add(insertMailField);
		
		domainField.addKeyListener(new RestrictTextLength(domainField, 20));
		domainField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {

				if ((e.getKeyChar() != KeyEvent.VK_BACK_SPACE) && (e.getKeyChar() != KeyEvent.VK_DELETE)
						&& (e.getKeyCode() != 36) // END키 허용
						&& (e.getKeyCode() != 35) // HOME키 허용
						&& (e.getKeyCode() != 37) // 왼쪽 방향키 허용
						&& (e.getKeyCode() != 39) // 오른쪽방향키 허용
				) {
					e.consume();
				}

			}

			@Override
			public void keyTyped(KeyEvent e) { // 타자칠때 영소문자 숫자 . 이외차단 
				domainField.setFont(new Font("배달의민족 도현", Font.PLAIN, 20));
				if (!((e.getKeyChar() >= '0' && e.getKeyChar() <= '9')
						|| (e.getKeyChar() >= 'a' && e.getKeyChar() <= 'z') 
						|| e.getKeyChar() == '.')) {
					e.consume();

				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				String email = insertMailField.getText()+"@"+domainField.getText();
				if(Pattern.matches("\\w+@\\w+\\.[a-zA-Z]+(\\.[a-zA-Z]+)*", email)) {
					mailMsgLabel.setForeground(new Color(153, 255, 153));
					mailMsgLabel.setText("입력완료");
				} else {
					mailMsgLabel.setForeground( Color.RED);
					mailMsgLabel.setText("example@gmail.com 형식으로 입력해주세요");
				}
				super.keyReleased(e);
			}
		});

		FocusListener mailFocusAdapter = new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (insertMailField.getText().equals("") 
					&& domainField.getText().equals("")) {
					mailMsgLabel.setForeground(Color.red);
					mailMsgLabel.setText("필수 정보입니다");
				} else {

				}
			}

		};
		
		insertMailField.addFocusListener(mailFocusAdapter);
		domainField.addFocusListener(mailFocusAdapter);
		
		JPanel cateBtnPanel = new JPanel();
		cateBtnPanel.setBounds(888, 113, 160, 480);
		cateBtnPanel.setOpaque(false);
		add(cateBtnPanel);
		cateBtnPanel.setLayout(new GridLayout(6,2));
		
		favCategories = new HashSet<>();		
		
		cateBtnPanel.add(new CateButton("개발도구"));		
		cateBtnPanel.add(new CateButton("게임개발"));
		cateBtnPanel.add(new CateButton("교양"));
		cateBtnPanel.add(new CateButton("데브옵스"));
		cateBtnPanel.add(new CateButton("데스크톱"));
		cateBtnPanel.add(new CateButton("데이터베이스"));
		cateBtnPanel.add(new CateButton("모바일"));
		cateBtnPanel.add(new CateButton("백엔드"));
		cateBtnPanel.add(new CateButton("알고리즘"));
		cateBtnPanel.add(new CateButton("임베디드"));
		cateBtnPanel.add(new CateButton("프론트엔드"));
		
		
		/////////////// 회원가입 완료 조건 /////////////////////////////////
		JButton createBtn = new JButton("회원 가입");
		createBtn.setFont(new Font("",Font.PLAIN,0));
		
		Image img1= (new ImageIcon("images/changeButton/회원가입버튼.png").getImage());
		Image changeImg1 = img1.getScaledInstance(210, 50, Image.SCALE_SMOOTH);
		ImageIcon changeSignupIcon = new ImageIcon(changeImg1);
		createBtn.setIcon(changeSignupIcon);
		
		Image img2= (new ImageIcon("images/changeButton/노란회원가입버튼.png").getImage());
		Image changeImg2 = img2.getScaledInstance(210, 50, Image.SCALE_SMOOTH);
		ImageIcon changeSignupIcon2 = new ImageIcon(changeImg2);
		createBtn.setRolloverIcon(changeSignupIcon2);
		
		createBtn.setBorderPainted(false);
		createBtn.setBounds(449, 675, 202, 50);
		
		createBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String Jnum = insertJNum1Field.getText() + insertJNum2Field.getText();
				ArrayList <String> nameArr = new ArrayList<>();
				if(idMsgLabel.getText().equals("중복확인완료")) {
					if(pwMsgLabel.getText().equals("사용가능한 비밀번호입니다")) {
						if(rePwMsgLabel.getText().equals("비밀번호가 같게 입력되었습니다")) {
							if(nameMsgLabel.getText().equals("입력완료")) {
								if(JNumMsgLabel.getText().equals("입력완료")) {
									int age = (LocalDateTime.now().getYear()-1900+1-(Integer.parseInt(insertJNum1Field.getText().substring(0, 2))));
									try (
											Connection conn = OjdbcConnection.getConnection();
											PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM members "
													+ "WHERE j_number = ?");							
											) {
										pstmt.setString(1, Jnum);
										ResultSet rs = pstmt.executeQuery();
										while(rs.next()) {															
											nameArr.add(rs.getString("member_name"));
										}	
										//System.out.println(nameArr);
										
									} catch (SQLException e1) {
										e1.printStackTrace();
									}
									if(phoneMsgLabel.getText().equals("입력완료")) {
										if(mailMsgLabel.getText().equals("입력완료")) {
											if(!nameArr.contains(insertNameField.getText())
													
													) { 											
												//DB에 저장 members, 관심 카테고리 저장.
												String sql = "INSERT INTO members VALUES (?,?,?,?,?,?,?)";
														
 												//해쉬셋해서 하나씩 꺼내서 갯수만큼 insert반복
												String sql2 = "INSERT INTO favorite_category VALUES "
														+ "(favorite_category_seq.NEXTVAL,'" 
														+ createIdField.getText() 
														+ "', ?  )";
												
												try (Connection conn = OjdbcConnection.getConnection();
														PreparedStatement pstmt = conn.prepareStatement(sql);	
														PreparedStatement pstmt2 = conn.prepareStatement(sql2);	
													) {
													conn.setAutoCommit(false);
														pstmt.setString(1, createIdField.getText());
														pstmt.setString(2, String.valueOf(createPwField.getPassword()));
														pstmt.setString(3, insertNameField.getText());
														pstmt.setInt(4, age);
														pstmt.setString(5, insertPhoneNumField1.getText()+"-"+insertPhoneNumField2.getText()+"-"+ insertPhoneNumField3.getText());
														pstmt.setString(6, insertMailField.getText()+"@"+domainField.getText());
														pstmt.setString(7, insertJNum1Field.getText()+insertJNum2Field.getText());
														pstmt.executeUpdate();
														conn.commit();
														
														for(String cate : favCategories) {
														pstmt2.setString(1, cate);
														pstmt2.executeUpdate();
														}
														conn.commit();
																												
													} catch (SQLException e1) {
														e1.printStackTrace();

													}
												
												JOptionPane.showMessageDialog(MainPanel.thisFrame, "회원가입완료!");
												MainPanel.currPanel.setVisible(false);
												MainPanel.loginPanel.setVisible(true);
												MainPanel.currPanel = MainPanel.loginPanel;
											}else {
												JOptionPane.showMessageDialog(MainPanel.thisFrame, "이미 회원으로 등록된 회원정보입니다","회원조회",JOptionPane.ERROR_MESSAGE);
											}
										}else {
											JOptionPane.showMessageDialog(MainPanel.thisFrame, "이메일을 올바르게 입력해 주세요");
										}
									}else {
										JOptionPane.showMessageDialog(MainPanel.thisFrame, "전화번호를 올바르게 입력해 주세요");
									}
								}else {
									JOptionPane.showMessageDialog(MainPanel.thisFrame, "주민번호를 올바르게 입력해 주세요");
								}
							}else {
								JOptionPane.showMessageDialog(MainPanel.thisFrame, "이름을 올바르게 입력해 주세요");
							}
						}else {
							JOptionPane.showMessageDialog(MainPanel.thisFrame, "비밀번호를 재입력을 확인해 주세요");
						}						
					} else {
						JOptionPane.showMessageDialog(MainPanel.thisFrame, "비밀번호를 올바르게 입력해 주세요");
					}					
				}else {
					JOptionPane.showMessageDialog(MainPanel.thisFrame, "아이디 중복확인을 해주세요.");
				}
				
			}
		});
		
		
		add(createBtn);			
		
		
		
		
		
		
		/////////////// 항목 표시해주는 라벨 /////////////////////////////////
		JLabel lblNewLabel = new JLabel("아이디");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("배달의민족 도현", Font.PLAIN, 18));
		lblNewLabel.setBounds(356, 100, 63 , 43);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("비밀번호");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("배달의민족 도현", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(345, 194, 80, 43);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("비밀번호 재입력");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("배달의민족 도현", Font.PLAIN, 18));
		lblNewLabel_1_1.setBounds(286, 284, 141, 43);
		add(lblNewLabel_1_1);
				
		JLabel insertPhoneNumLabel_1 = new JLabel("이메일");
		insertPhoneNumLabel_1.setForeground(Color.WHITE);
		insertPhoneNumLabel_1.setFont(new Font("배달의민족 도현", Font.PLAIN, 18));
		insertPhoneNumLabel_1.setBounds(356, 596, 64, 44);
		add(insertPhoneNumLabel_1);
		
		JLabel hyphenLabel_1 = new JLabel("-");
		hyphenLabel_1.setForeground(new Color(255, 255, 255));
		hyphenLabel_1.setFont(new Font("굴림", Font.PLAIN, 16));
		hyphenLabel_1.setBounds(490, 439, 30, 44);
		add(hyphenLabel_1);
		
		JLabel hyphenLabel_2 = new JLabel("-");
		hyphenLabel_2.setForeground(new Color(255, 255, 255));
		hyphenLabel_2.setFont(new Font("굴림", Font.PLAIN, 16));
		hyphenLabel_2.setBounds(580, 439, 16, 44);
		add(hyphenLabel_2);
		
		JLabel atLabel_3 = new JLabel("@");
		atLabel_3.setForeground(new Color(255, 255, 255));
		atLabel_3.setFont(new Font("굴림", Font.PLAIN, 16));
		atLabel_3.setBounds(553, 596, 30, 44);
		add(atLabel_3);
		
		JLabel lblNewLabel_2 = new JLabel("관심 분야를 골라 주세요 (선택사항)");
		lblNewLabel_2.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(862, 604, 235, 24);
		add(lblNewLabel_2);
		
		
	}
}

//눌렀을때 카테고리 이름을 HashSet에 저장하고 색깔이 바뀌는 버튼
class CateButton extends JButton {

	public CateButton(String name) {
		super.setText(name);
		setBackground(new Color(153, 153, 153));
		setSize(80, 80);

		// 버튼에 맞는이미지 받아오기
		setIcon(new ImageIcon("images/" + name + ".png"));
		//setPressedIcon(new ImageIcon("images/" + name + 2 + ".png"));
		setFont(new Font("", Font.BOLD, 0));//버튼에 보여지는 글자크기 0 
		
		addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				if (getBackground().equals(new Color(153, 153, 153))) {// 무색
					setBackground(new Color(204, 255, 204));// 초록
					SignupPanel.favCategories.add(name);
					setIcon(new ImageIcon("images/" + name +2+ ".png"));

				} else if (getBackground().equals(new Color(204, 255, 204))) {// 초록
					setBackground(new Color(153, 153, 153));// 무색
					SignupPanel.favCategories.remove(name);
					setIcon(new ImageIcon("images/" + name + ".png"));
				}
				// System.out.println(SignupPanel.favCategories);

			}
		});
		 
	}
	
}
	
	
	