package panels;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import buttons.GoToButton;
import labels.TopLabel;

public class SignupPanel extends JPanel {
	
		
	private JTextField createIdField;
	private JPasswordField createPwField;
	private JComponent rePwField;
	private JTextField insertNameField;
	private JComponent insertJNum1Field;
	private JComponent insertJNum2Field;
	private JComponent insertPhoneNumField;


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
		
		JLabel idMsgLabel = new JLabel("아이디(6~12 이내 영문숫자조합)");
		idMsgLabel.setFont(new Font("굴림", Font.PLAIN, 16));
		idMsgLabel.setBounds(420, 104, 254, 32);
		add(idMsgLabel);
		
		createIdField = new JTextField();
		createIdField.setFont(new Font("굴림", Font.PLAIN, 16));
		createIdField.setBounds(420, 99, 276, 44);
		add(createIdField);
		createIdField.setColumns(10);
		
		JLabel pwMsgLabel= new JLabel("비밀번호(8~12 이내 영문숫자특문조합");
		pwMsgLabel.setFont(new Font("굴림", Font.PLAIN, 16));
		pwMsgLabel.setBounds(420, 152, 254, 49);
		add(pwMsgLabel);
		
		createPwField = new JPasswordField();
		createPwField.setFont(new Font("굴림", Font.PLAIN, 16));
		
		createPwField.setBounds(420, 152, 276, 49);
		add(createPwField);
		
		JLabel rePwLabel = new JLabel("비밀번호 재입력");
		rePwLabel.setFont(new Font("굴림", Font.PLAIN, 16));
		rePwLabel.setBounds(420, 215, 254, 38);
		add(rePwLabel);
		
		rePwField = new JPasswordField();
		rePwField.setFont(new Font("굴림", Font.PLAIN, 16));
		rePwField.setBounds(420, 210, 276, 49);
		add(rePwField);
		
		JLabel insertNameLabel = new JLabel("이름");
		insertNameLabel.setFont(new Font("굴림", Font.PLAIN, 16));
		insertNameLabel.setBounds(420, 290, 254, 44);
		add(insertNameLabel);
		
		insertNameField = new JTextField();
		insertNameField.setFont(new Font("굴림", Font.PLAIN, 16));
		insertNameField.setColumns(10);
		insertNameField.setBounds(420, 291, 276, 44);
		add(insertNameField);
		
		JLabel insertJNum1Label = new JLabel("주민번호 앞자리");
		insertJNum1Label.setFont(new Font("굴림", Font.PLAIN, 16));
		insertJNum1Label.setBounds(420, 347, 121, 44);
		add(insertJNum1Label);
		
		insertJNum1Field = new JTextField();
		insertJNum1Field.setFont(new Font("굴림", Font.PLAIN, 16));
		insertJNum1Field.setBounds(420, 348, 121, 44);
		add(insertJNum1Field);
		
		JLabel insertJNum2Label = new JLabel("주민번호 뒷자리");
		insertJNum2Label.setFont(new Font("굴림", Font.PLAIN, 16));
		insertJNum2Label.setBounds(569, 347, 121, 44);
		add(insertJNum2Label);
		
		insertJNum2Field = new JTextField();
		insertJNum2Field.setFont(new Font("굴림", Font.PLAIN, 16));
		insertJNum2Field.setBounds(569, 347, 127, 44);
		add(insertJNum2Field);
		
		JLabel hyphenLabel = new JLabel("-");
		hyphenLabel.setFont(new Font("굴림", Font.PLAIN, 16));
		hyphenLabel.setBounds(548, 347, 30, 44);
		add(hyphenLabel);
		
		JLabel insertPhoneNumLabel = new JLabel("전화번호");
		insertPhoneNumLabel.setFont(new Font("굴림", Font.PLAIN, 16));
		insertPhoneNumLabel.setBounds(420, 400, 276, 44);
		add(insertPhoneNumLabel);
		
		insertPhoneNumField = new JTextField();
		insertPhoneNumField.setFont(new Font("굴림", Font.PLAIN, 16));
		insertPhoneNumField.setBounds(420, 403, 276, 44);
		add(insertPhoneNumField);
		
		JPanel cateBtnPanel = new JPanel();
		cateBtnPanel.setBounds(97, 453, 926, 121);
		add(cateBtnPanel);
		cateBtnPanel.setLayout(new GridLayout(2,13));
		
		JButton createBtn = new JButton("회원 가입 완료");
		createBtn.setBounds(473, 598, 185, 38);
		add(createBtn);
		
		for(int i = 0; i < 26; i++) {
		cateBtnPanel.add(new JButton("cate"+i));
		}			
	}


	
}
