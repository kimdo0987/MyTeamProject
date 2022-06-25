package panels;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import buttons.GoToButton;
import labels.TopLabel;
import methods.OnlyNumKeyAdaptor;
import methods.RestrictTextLength;
import popups.MsgPopup;

public class SignupPanel extends JPanel {
		 	
	private JTextField createIdField;
	private HintPasswordField createPwField;
	private HintPasswordField rePwField;
	private JTextField insertNameField;
	private JTextField insertJNum1Field;
	private JTextField insertJNum2Field;
	private JTextField insertPhoneNumField1;
	private JTextField insertPhoneNumField2;
	private JTextField insertPhoneNumField3;
	public static HashSet<String> favCategories;
	


	public SignupPanel() {
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
				MainPanel.tempPanel = MainPanel.lastPanel; // 일시적으로 담아둠
				MainPanel.lastPanel = MainPanel.currPanel;
				MainPanel.currPanel = MainPanel.tempPanel;
			}
		});
		
		//////////////////////////////////////////////////////////////////
		
		GoToButton mainBtn = new GoToButton("메인");
		mainBtn.setBounds(97, 9, 64, 44);
		add(mainBtn);		
		
		TopLabel toplabel = new TopLabel("회원 가입");
		add(toplabel);		
		
		
		
		////////////////////아이디 생성조건 ///////////////////////////////////
		JLabel idMsgLabel = new JLabel("");
		idMsgLabel.setVisible(true);
		idMsgLabel.setFont(new Font("굴림", Font.PLAIN, 11));
		idMsgLabel.setBounds(420, 143, 276, 32);
		add(idMsgLabel);

		createIdField = new HintTextField("4~16 이내 영문숫자조합");
		createIdField.setBounds(420, 99, 276, 44);
		createIdField.addKeyListener(new RestrictTextLength(createIdField, 16)); // 글자수제한
		createIdField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) { // keyTyped에서 한글입력 막기
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
						idMsgLabel.setForeground(new Color(0, 128, 0)); // 초록색
						idMsgLabel.setText("사용가능한 형식입니다 (중복확인을 해주세요)");
					}
				}
			}

		});
		
		
		createIdField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (createIdField.getText().equals("4~16 이내 영문숫자조합")) {
					idMsgLabel.setForeground(Color.red);
					idMsgLabel.setText("필수 정보입니다");
				} else {

				}
			}

		});

		add(createIdField);
		
		/////////////////// 중복 확인 /////////////////////////////
		JButton idCheckBtn = new JButton("중복확인");
		idCheckBtn.setBounds(708, 99, 87, 44);
		idCheckBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (!createIdField.getText().equals("4~16 이내 영문숫자조합")
						&& idMsgLabel.getText().equals("사용가능한 형식입니다 (중복확인을 해주세요)")) {
					System.out.println(createIdField.getText());
					createIdField.setEditable(false);
					idMsgLabel.setText("중복확인완료");
					createIdField.removeKeyListener(null);

				}
			}
		});
		add(idCheckBtn);

		////////////////////비밀번호 생성조건 ///////////////////////////////////
		JLabel pwMsgLabel = new JLabel("");
		pwMsgLabel.setFont(new Font("굴림", Font.PLAIN, 11));
		pwMsgLabel.setBounds(420, 235, 276, 43);
		add(pwMsgLabel);
		
		JLabel rePwMsgLabel = new JLabel("");
		rePwMsgLabel.setFont(new Font("굴림", Font.PLAIN, 11));
		rePwMsgLabel.setBounds(420, 325, 276, 43);
		add(rePwMsgLabel);
		
		createPwField = new HintPasswordField("8~12 이내 영문숫자특문조합");
		createPwField.setFont(new Font("굴림", Font.PLAIN, 16));
		createPwField.setBounds(420, 190, 276, 49);
		createPwField.addKeyListener(new RestrictTextLength(createPwField, 12)); //글자수제한
		
		rePwField = new HintPasswordField("8~12 이내 영문숫자특문조합");
		rePwField.setFont(new Font("굴림", Font.PLAIN, 16));
		rePwField.setBounds(420, 280, 276, 49);
		rePwField.addKeyListener(new RestrictTextLength(rePwField, 12)); //글자수제한
		
		createPwField.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {     
				
				String msg = String.valueOf(createPwField.getPassword());
				
				if (!Pattern.matches("[!-~]", "" + e.getKeyChar())) { // 특수문자,영어,숫자 이외의 문자는 입력안됨
					e.consume(); // 이벤트 소멸(무시)하기
				}
				if (msg.length() < 8) {
					pwMsgLabel.setForeground(Color.red);
					pwMsgLabel.setText("비밀번호는 8글자 이상이여야 합니다");
				} else if (msg.length() > 12) {
					createPwField.setText(msg.substring(0, 12)); // 긴 글 복붙으로 삽입 방지
				} else if (!Pattern.matches("\\w*", msg)) {
					pwMsgLabel.setForeground(Color.red);
					pwMsgLabel.setText("사용 불가능한 문자가 포함되어 있습니다");
				} else if (Pattern.matches("[!-~]*", msg) && msg.length() < 13 && msg.length() > 7) {
					pwMsgLabel.setForeground(new Color(0, 128, 0)); // 초록색
					pwMsgLabel.setText("사용가능한 비밀번호입니다");
				}
				if (!msg.equals(String.valueOf(rePwField.getPassword()))) {
					rePwMsgLabel.setForeground(Color.red);
					rePwMsgLabel.setText("비밀번호가 일치하지 않습니다");
				} else {
					rePwMsgLabel.setForeground(new Color(0, 128, 0));
					rePwMsgLabel.setText("비밀번호가 같게 입력되었습니다");
				}
			}
		});

		createPwField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if ((String.valueOf(createPwField.getPassword())).equals("8~12 이내 영문숫자특문조합")) {
					pwMsgLabel.setForeground(Color.red);
					pwMsgLabel.setText("필수 정보입니다");
				} else {

				}
			}

		});
		
		add(createPwField);
		
		////////////////////비밀번호 재입력 조건 ///////////////////////////////////
		
		

		
		rePwField.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {   
				
				String msg = String.valueOf(rePwField.getPassword());

				if (!Pattern.matches("[!-~]", "" + e.getKeyChar())) { // 특수문자,영어,숫자 이외의 문자는 입력안됨
					e.consume(); // 이벤트 소멸(무시)하기
				}
				if (msg.length() > 12) {
					rePwField.setText(msg.substring(0, 12)); // 긴 글 복붙으로 삽입 방지
				} else if (!Pattern.matches("\\w*", msg)) {
					rePwMsgLabel.setForeground(Color.red);
					rePwMsgLabel.setText("사용 불가능한 문자가 포함되어 있습니다");
				} else if ((Pattern.matches("[!-~]*", msg)) && msg.equals(String.valueOf(createPwField.getPassword()))
						&& msg.length() < 13 && msg.length() > 7) {
					rePwMsgLabel.setForeground(new Color(0, 128, 0)); // 초록색
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
			public void focusLost(FocusEvent e) {
				String msg = String.valueOf(rePwField.getPassword());
				if (!msg.equals(String.valueOf(createPwField.getPassword()))) {
					rePwMsgLabel.setForeground(Color.red);
					rePwMsgLabel.setText("비밀번호가 일치하지 않습니다");
				} else {

				}
			}

		});
		
		add(rePwField);
		
		//////////////////////// 이름 입력 조건 ///////////////////////////////////
		JLabel insertNameLabel = new JLabel("이름");
		insertNameLabel.setFont(new Font("굴림", Font.PLAIN, 16));
		insertNameLabel.setBounds(175, 366, 37, 44);
		add(insertNameLabel);
		
		JLabel nameMsgLabel = new JLabel();
		nameMsgLabel.setFont(new Font("굴림", Font.PLAIN, 11));
		nameMsgLabel.setBounds(220, 405, 276, 32);
		add(nameMsgLabel);
		
		insertNameField = new JTextField();
		insertNameField.setFont(new Font("굴림", Font.PLAIN, 16));
		insertNameField.setBounds(220, 366, 276, 44);

		insertNameField.addKeyListener(new RestrictTextLength(insertNameField, 14));
		insertNameField.addKeyListener(new KeyAdapter() {

			@Override
			public void keyTyped(KeyEvent e) {
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
			public void focusLost(FocusEvent e) {
				if (insertNameField.getText().equals("")) {
					nameMsgLabel.setForeground(Color.red);
					nameMsgLabel.setText("필수 정보입니다");
				} else {
					nameMsgLabel.setForeground(new Color(0, 128, 0));
					nameMsgLabel.setText("입력완료");
				}

			}

		});
		add(insertNameField);
		
		////////////////////////주민번호 앞자리 입력 조건 ///////////////////////////////////
		
		JLabel insertJNum1Label = new JLabel("주민번호");
		insertJNum1Label.setFont(new Font("굴림", Font.PLAIN, 16));
		insertJNum1Label.setBounds(524, 366, 64, 44);
		add(insertJNum1Label);
		
		JLabel JNumMsgLabel = new JLabel();
		JNumMsgLabel.setFont(new Font("굴림", Font.PLAIN, 11));
		JNumMsgLabel.setBounds(590, 405, 276, 32);
		add(JNumMsgLabel);
		
		insertJNum1Field = new JTextField();
		insertJNum1Field.setFont(new Font("굴림", Font.PLAIN, 16));
		insertJNum1Field.setBounds(590, 366, 121, 44);
		insertJNum1Field.addKeyListener(new RestrictTextLength(insertJNum1Field, 6)); //글자수제한
		insertJNum1Field.addKeyListener(new OnlyNumKeyAdaptor());
		insertJNum1Field.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if ((insertJNum1Field.getText() + insertJNum2Field.getText()).length() == 13) {
					JNumMsgLabel.setForeground(new Color(0, 128, 0));
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
		insertJNum2Field.setBounds(747, 366, 127, 44);
		insertJNum2Field.addKeyListener(new RestrictTextLength(insertJNum2Field, 7)); //글자수제한
		insertJNum2Field.addKeyListener(new OnlyNumKeyAdaptor());
		insertJNum2Field.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if ((insertJNum1Field.getText() + insertJNum2Field.getText()).length() == 13) {
					JNumMsgLabel.setForeground(new Color(0, 128, 0));
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
			public void focusLost(FocusEvent e) {
				if ((insertJNum1Field.getText() + insertJNum2Field.getText()).length() != 13) {
					JNumMsgLabel.setForeground(Color.red);
					JNumMsgLabel.setText("주민번호를 올바르게 입력해 주세요");
				} else {
					JNumMsgLabel.setForeground(new Color(0, 128, 0));
					JNumMsgLabel.setText("입력완료");
				}

			}

		});
		
		
		insertJNum2Field.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if ((insertJNum1Field.getText() + insertJNum2Field.getText()).length() != 13) {
					JNumMsgLabel.setForeground(Color.red);
					JNumMsgLabel.setText("주민번호를 올바르게 입력해 주세요");
				} else {
					JNumMsgLabel.setForeground(new Color(0, 128, 0));
					JNumMsgLabel.setText("입력완료");
				}

			}

		});
		
		////////////////////////전화번호 입력조건 ///////////////////////////////////
		
		JLabel insertPhoneNumLabel = new JLabel("전화번호");
		insertPhoneNumLabel.setFont(new Font("굴림", Font.PLAIN, 16));
		insertPhoneNumLabel.setBounds(146, 440, 64, 44);
		add(insertPhoneNumLabel);
		
		JLabel hyphenLabel = new JLabel("-");
		hyphenLabel.setFont(new Font("굴림", Font.PLAIN, 16));
		hyphenLabel.setBounds(726, 366, 30, 44);
		add(hyphenLabel);
		
		JLabel phoneMsgLabel = new JLabel();
		phoneMsgLabel.setFont(new Font("굴림", Font.PLAIN, 11));
		phoneMsgLabel.setBounds(220, 475, 276, 43);
		add(phoneMsgLabel);
		
		insertPhoneNumField1 = new JTextField();
		insertPhoneNumField1.setFont(new Font("굴림", Font.PLAIN, 16));
		insertPhoneNumField1.setBounds(220, 440, 39, 44);
		insertPhoneNumField1.addKeyListener(new RestrictTextLength(insertPhoneNumField1, 3));//글자수 3자로 제한
		insertPhoneNumField1.addKeyListener(new OnlyNumKeyAdaptor()); //숫자만 입력가능, 복붙차단
		
		
		add(insertPhoneNumField1);
		
		insertPhoneNumField2 = new JTextField();
		insertPhoneNumField2.setFont(new Font("굴림", Font.PLAIN, 16));
		insertPhoneNumField2.setBounds(280, 440, 52, 44);
		insertPhoneNumField2.addKeyListener(new RestrictTextLength(insertPhoneNumField2, 4));//글자수 4자로제한
		insertPhoneNumField2.addKeyListener(new OnlyNumKeyAdaptor()); //숫자만 입력가능, 복붙차단
		add(insertPhoneNumField2);
		
		insertPhoneNumField3 = new JTextField();
		insertPhoneNumField3.setFont(new Font("굴림", Font.PLAIN, 16));
		insertPhoneNumField3.setBounds(355, 440, 52, 44);
		insertPhoneNumField3.addKeyListener(new RestrictTextLength(insertPhoneNumField3, 4));//글자수 4자로제한
		insertPhoneNumField3.addKeyListener(new OnlyNumKeyAdaptor()); //숫자만 입력가능, 복붙차단
		add(insertPhoneNumField3);
		
		KeyListener phoneNumKeyAdapter = new KeyAdapter() {

			@Override
			public void keyReleased(KeyEvent e) {
				if (insertPhoneNumField1.getText().equals("") || insertPhoneNumField2.getText().equals("")
						|| insertPhoneNumField3.getText().equals("")) {
					phoneMsgLabel.setForeground(Color.red);
					phoneMsgLabel.setText("전화번호를 정확히 입력해 주세요");
				} else {
					phoneMsgLabel.setForeground(new Color(0, 128, 0));
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
		mailMsgLabel.setBounds(590, 475, 325, 43);
		mailMsgLabel.setFont(new Font("굴림", Font.PLAIN, 11));
		add(mailMsgLabel);
		
		JTextField insertMailField = new JTextField("");
		insertMailField.setFont(new Font("굴림", Font.PLAIN, 16));
		insertMailField.setBounds(590, 440, 132, 44);
		
		JTextField domainField = new JTextField("");
		domainField.setFont(new Font("굴림", Font.PLAIN, 16));
		domainField.setBounds(747, 440, 132, 44);
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
					mailMsgLabel.setForeground(new Color(0, 128, 0));
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
					mailMsgLabel.setForeground(new Color(0, 128, 0));
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
		cateBtnPanel.setBounds(97, 550, 926, 121);
		add(cateBtnPanel);
		cateBtnPanel.setLayout(new GridLayout(2,13));
		
		favCategories = new HashSet<>();		
		
		cateBtnPanel.add(new CateButton("개발도구"));		
		cateBtnPanel.add(new CateButton("게임개발"));
		cateBtnPanel.add(new CateButton("교양,기타"));
		cateBtnPanel.add(new CateButton("데브옵스/인프라"));
		cateBtnPanel.add(new CateButton("데스크톱 앱 개발"));
		cateBtnPanel.add(new CateButton("데이터베이스"));
		cateBtnPanel.add(new CateButton("모바일 앱 개발"));
		cateBtnPanel.add(new CateButton("백엔드"));
		cateBtnPanel.add(new CateButton("알고리즘/자료구조"));
		cateBtnPanel.add(new CateButton("임베디드/IOT"));
		cateBtnPanel.add(new CateButton("프론트엔드"));
		
		
		/////////////// 회원가입 완료 조건 /////////////////////////////////
		JButton createBtn = new JButton("회원 가입 완료");
		createBtn.setBounds(473, 700, 185, 38);
		
		createBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(idMsgLabel.getText().equals("중복확인완료")) {
					if(pwMsgLabel.getText().equals("사용가능한 비밀번호입니다")) {
						if(rePwMsgLabel.getText().equals("비밀번호가 같게 입력되었습니다")) {
							if(nameMsgLabel.getText().equals("입력완료")) {
								if(JNumMsgLabel.getText().equals("입력완료")) {
									if(phoneMsgLabel.getText().equals("입력완료")) {
										if(mailMsgLabel.getText().equals("입력완료")) {
											JOptionPane.showMessageDialog(MainPanel.thisFrame, "회원가입완료!");
											MainPanel.currPanel.setVisible(false);
											MainPanel.loginPanel.setVisible(true);
											MainPanel.currPanel=MainPanel.loginPanel;
											//DB에 저장 members, 관심 카테고리 저장.
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
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 15));
		lblNewLabel.setBounds(356, 100, 52 , 43);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("비밀번호");
		lblNewLabel_1.setFont(new Font("굴림", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(350, 194, 64, 43);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("비밀번호 재입력");
		lblNewLabel_1_1.setFont(new Font("굴림", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(295, 284, 121, 43);
		add(lblNewLabel_1_1);
				
		JLabel insertPhoneNumLabel_1 = new JLabel("이메일");
		insertPhoneNumLabel_1.setFont(new Font("굴림", Font.PLAIN, 16));
		insertPhoneNumLabel_1.setBounds(524, 440, 64, 44);
		add(insertPhoneNumLabel_1);
		
		JLabel hyphenLabel_1 = new JLabel("-");
		hyphenLabel_1.setFont(new Font("굴림", Font.PLAIN, 16));
		hyphenLabel_1.setBounds(265, 440, 30, 44);
		add(hyphenLabel_1);
		
		JLabel hyphenLabel_2 = new JLabel("-");
		hyphenLabel_2.setFont(new Font("굴림", Font.PLAIN, 16));
		hyphenLabel_2.setBounds(337, 440, 16, 44);
		add(hyphenLabel_2);
		
		JLabel atLabel_3 = new JLabel("@");
		atLabel_3.setFont(new Font("굴림", Font.PLAIN, 16));
		atLabel_3.setBounds(726, 440, 30, 44);
		add(atLabel_3);
		
		JLabel lblNewLabel_2 = new JLabel("관심 분야를 골라 주세요 (선택사항)");
		lblNewLabel_2.setBounds(97, 516, 235, 24);
		add(lblNewLabel_2);
		
		
	}
}

//눌렀을때 카테고리 이름을 HashSet에 저장하고 색깔이 바뀌는 버튼
class CateButton extends JButton {
	 public CateButton(String name) {
		 super.setText(name);
		 setBackground(new Color(153, 153, 153));
		 addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				if(getBackground().equals(new Color(153, 153, 153))) {//무색
					setBackground(new Color(204,255,204));//초록
					SignupPanel.favCategories.add(name);
					
				} else if (getBackground().equals(new Color(204,255,204))) {//초록
					setBackground(new Color(153, 153, 153));//무색
					SignupPanel.favCategories.remove(name);
				}
				System.out.println(SignupPanel.favCategories);
				
			}
		});
		 
	}
	
}
	
	
	