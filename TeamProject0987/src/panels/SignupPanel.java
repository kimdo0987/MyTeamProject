package panels;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import buttons.GoToButton;
import database.OjdbcConnection;
import labels.TopLabel;
import methods.RestrictTextLength;

public class SignupPanel extends JPanel {
		 	
	private JTextField createIdField;
	private HintPasswordField createPwField;
	private HintPasswordField rePwField;
	private JTextField insertNameField;
	private JComponent insertJNum1Field;
	private JComponent insertJNum2Field;
	private JComponent insertPhoneNumField;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;


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
				MainPanel.tempPanel = MainPanel.lastPanel; //일시적으로 담아둠
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
		JLabel idMsgLabel = new JLabel("4~16 이내 영문숫자조합");
		idMsgLabel.setVisible(true);
		idMsgLabel.setFont(new Font("굴림", Font.PLAIN, 11));
		idMsgLabel.setBounds(420, 143, 254, 32);
		add(idMsgLabel);
		
		createIdField = new HintTextField("4~16 이내 영문숫자조합");
		createIdField.setBounds(420, 99, 276, 44);
		createIdField.addKeyListener(new RestrictTextLength(createIdField, 16)); //글자수제한
		createIdField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				String msg = createIdField.getText();
				
				if(!Pattern.matches("\\w", ""+e.getKeyChar())||e.getKeyChar()=='_') {
					e.consume(); // 이벤트 소멸(무시)하기
				}  
				if(msg.length() != 0 && msg.length() < 4) {
					idMsgLabel.setForeground(Color.red);
					idMsgLabel.setText("아이디는 4글자 이상이여야 합니다");				
				} else if (!Pattern.matches("\\w*", msg)){
					idMsgLabel.setForeground(Color.red);
					idMsgLabel.setText("사용 불가능한 문자가 포함되어 있습니다");
				} else if (Pattern.matches("\\w*", msg) 
						&& msg.length() < 17 && msg.length() > 3
						//중복확인한뒤 true 판단
						){
					idMsgLabel.setForeground(new Color(0, 128, 0)); //초록색
					idMsgLabel.setText("사용가능한 아이디입니다");		
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
		
		//////////////////// 비밀번호 생성조건 ///////////////////////////////////
		
		JLabel pwMsgLabel= new JLabel("");
		pwMsgLabel.setFont(new Font("굴림", Font.PLAIN, 16));
		pwMsgLabel.setBounds(425, 190, 254, 49);
		add(pwMsgLabel);
		
		createPwField = new HintPasswordField("8~12 이내 영문숫자특문조합");
		createPwField.setFont(new Font("굴림", Font.PLAIN, 16));
		createPwField.setBounds(420, 190, 276, 49);
		createPwField.addKeyListener(new RestrictTextLength(createPwField, 12)); //글자수제한
		
		add(createPwField);
		
		rePwField = new HintPasswordField("8~12 이내 영문숫자특문조합");
		rePwField.setFont(new Font("굴림", Font.PLAIN, 16));
		rePwField.setBounds(420, 280, 276, 49);
		rePwField.addKeyListener(new RestrictTextLength(rePwField, 12)); //글자수제한
		
		
		
		add(rePwField);
		
		JLabel insertNameLabel = new JLabel("이름");
		insertNameLabel.setFont(new Font("굴림", Font.PLAIN, 16));
		insertNameLabel.setBounds(175, 400, 45, 44);
		add(insertNameLabel);
		
		insertNameField = new JTextField();
		insertNameField.setFont(new Font("굴림", Font.PLAIN, 16));
		insertNameField.setColumns(10);
		insertNameField.setBounds(220, 400, 276, 44);
		add(insertNameField);
		
		JLabel insertJNum1Label = new JLabel("주민번호");
		insertJNum1Label.setFont(new Font("굴림", Font.PLAIN, 16));
		insertJNum1Label.setBounds(524, 400, 64, 44);
		add(insertJNum1Label);
		
		insertJNum1Field = new JTextField();
		insertJNum1Field.setFont(new Font("굴림", Font.PLAIN, 16));
		insertJNum1Field.setBounds(590, 400, 121, 44);
		add(insertJNum1Field);
		
		insertJNum2Field = new JTextField();
		insertJNum2Field.setFont(new Font("굴림", Font.PLAIN, 16));
		insertJNum2Field.setBounds(747, 400, 127, 44);
		add(insertJNum2Field);
		
		JLabel hyphenLabel = new JLabel("-");
		hyphenLabel.setFont(new Font("굴림", Font.PLAIN, 16));
		hyphenLabel.setBounds(726, 400, 30, 44);
		add(hyphenLabel);
		
		JLabel insertPhoneNumLabel = new JLabel("전화번호");
		insertPhoneNumLabel.setFont(new Font("굴림", Font.PLAIN, 16));
		insertPhoneNumLabel.setBounds(148, 460, 64, 44);
		add(insertPhoneNumLabel);
		
		insertPhoneNumField = new JTextField();
		insertPhoneNumField.setFont(new Font("굴림", Font.PLAIN, 16));
		insertPhoneNumField.setBounds(220, 460, 39, 44);
		add(insertPhoneNumField);
		
		JPanel cateBtnPanel = new JPanel();
		cateBtnPanel.setBounds(97, 550, 926, 121);
		add(cateBtnPanel);
		cateBtnPanel.setLayout(new GridLayout(2,13));
		
		JButton createBtn = new JButton("회원 가입 완료");
		createBtn.setBounds(473, 700, 185, 38);
		add(createBtn);
		
		
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
		
		JLabel lblNewLabel_1_2 = new JLabel("8~12 이내 영문숫자특문조합");
		lblNewLabel_1_2.setFont(new Font("굴림", Font.PLAIN, 11));
		lblNewLabel_1_2.setBounds(420, 235, 276, 43);
		add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("비밀번호가 일치하지 않습니다");
		lblNewLabel_1_2_1.setFont(new Font("굴림", Font.PLAIN, 11));
		lblNewLabel_1_2_1.setBounds(420, 325, 276, 43);
		add(lblNewLabel_1_2_1);
		
		JLabel insertPhoneNumLabel_1 = new JLabel("이메일");
		insertPhoneNumLabel_1.setFont(new Font("굴림", Font.PLAIN, 16));
		insertPhoneNumLabel_1.setBounds(524, 460, 64, 44);
		add(insertPhoneNumLabel_1);
		
		textField = new JTextField();
		textField.setFont(new Font("굴림", Font.PLAIN, 16));
		textField.setBounds(590, 460, 284, 44);
		add(textField);
		
		JLabel hyphenLabel_1 = new JLabel("-");
		hyphenLabel_1.setFont(new Font("굴림", Font.PLAIN, 16));
		hyphenLabel_1.setBounds(265, 460, 30, 44);
		add(hyphenLabel_1);
		
		JLabel hyphenLabel_2 = new JLabel("-");
		hyphenLabel_2.setFont(new Font("굴림", Font.PLAIN, 16));
		hyphenLabel_2.setBounds(337, 460, 16, 44);
		add(hyphenLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("굴림", Font.PLAIN, 16));
		textField_1.setBounds(280, 460, 52, 44);
		add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("굴림", Font.PLAIN, 16));
		textField_2.setBounds(355, 460, 52, 44);
		add(textField_2);
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("example@gmail.com 형식으로 입력해주세요");
		lblNewLabel_1_2_1_1.setFont(new Font("굴림", Font.PLAIN, 11));
		lblNewLabel_1_2_1_1.setBounds(590, 495, 325, 43);
		add(lblNewLabel_1_2_1_1);
		
		for(int i = 0; i < 26; i++) {
		cateBtnPanel.add(new JButton("cate"+i));
		}			
	}
	

	
	
	
}
