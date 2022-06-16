package mainpackage;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class CreateIdPanel extends JPanel{
	
		
	private JTextField createIdField;
	private JPasswordField createPasswordField;
	private JComponent passwordField;
	private JTextField insertNameField;
	private JComponent insertJNum1Field;
	private JComponent insertJNum2Field;
	private JComponent insertPhoneNumField;


	public CreateIdPanel() {
		setBounds(0, 0, 715, 647);
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
				MainPanel.currPanel = MainPanel.lastPanel;
			}
		});
		
		
		JButton firstPageBtn = new JButton("홈");
		firstPageBtn.setBounds(97, 9, 64, 44);
		add(firstPageBtn);
		firstPageBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MainPanel.currPanel.setVisible(false);
				MainPanel.mainPanel.setVisible(true);
				MainPanel.currPanel=MainPanel.mainPanel;
				
				
			}
		});
		
		//////////////////////////////////////////////////////////////////
		
		JLabel pageNameLabel = new JLabel("회원가입");
		
		pageNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		pageNameLabel.setFont(new Font("굴림", Font.PLAIN, 22));
		pageNameLabel.setBounds(153, 9, 385, 44);
		add(pageNameLabel);
		
		JLabel idMsgLabel = new JLabel("아이디(6~12 이내 영문숫자조합)");
		idMsgLabel.setFont(new Font("굴림", Font.PLAIN, 16));
		idMsgLabel.setBounds(207, 104, 254, 32);
		add(idMsgLabel);
		
		createIdField = new JTextField();
		createIdField.setFont(new Font("굴림", Font.PLAIN, 16));
		createIdField.setBounds(197, 99, 276, 44);
		add(createIdField);
		createIdField.setColumns(10);
		
		JLabel passwordMsgLabel = new JLabel("비밀번호(8~12 이내 영문숫자특문조합");
		passwordMsgLabel.setFont(new Font("굴림", Font.PLAIN, 16));
		passwordMsgLabel.setBounds(207, 152, 254, 49);
		add(passwordMsgLabel);
		
		createPasswordField = new JPasswordField();
		createPasswordField.setFont(new Font("굴림", Font.PLAIN, 16));
		
		createPasswordField.setBounds(197, 152, 276, 49);
		add(createPasswordField);
		
		JLabel password2Label = new JLabel("비밀번호 재입력");
		password2Label.setFont(new Font("굴림", Font.PLAIN, 16));
		password2Label.setBounds(207, 215, 254, 38);
		add(password2Label);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("굴림", Font.PLAIN, 16));
		passwordField.setBounds(197, 210, 276, 49);
		add(passwordField);
		
		JLabel insertNameLabel = new JLabel("이름");
		insertNameLabel.setFont(new Font("굴림", Font.PLAIN, 16));
		insertNameLabel.setBounds(207, 290, 254, 44);
		add(insertNameLabel);
		
		insertNameField = new JTextField();
		insertNameField.setFont(new Font("굴림", Font.PLAIN, 16));
		insertNameField.setColumns(10);
		insertNameField.setBounds(197, 291, 276, 44);
		add(insertNameField);
		
		JLabel insertJNum1Label = new JLabel("주민번호 앞자리");
		insertJNum1Label.setFont(new Font("굴림", Font.PLAIN, 16));
		insertJNum1Label.setBounds(197, 347, 121, 44);
		add(insertJNum1Label);
		
		insertJNum1Field = new JTextField();
		insertJNum1Field.setFont(new Font("굴림", Font.PLAIN, 16));
		//insertJNum1Field.setColumns(10);
		insertJNum1Field.setBounds(197, 348, 121, 44);
		add(insertJNum1Field);
		
		JLabel insertJNum2Label = new JLabel("주민번호 뒷자리");
		insertJNum2Label.setFont(new Font("굴림", Font.PLAIN, 16));
		insertJNum2Label.setBounds(346, 347, 121, 44);
		add(insertJNum2Label);
		
		insertJNum2Field = new JTextField();
		insertJNum2Field.setFont(new Font("굴림", Font.PLAIN, 16));
		//insertJNum2Field.setColumns(10);
		insertJNum2Field.setBounds(346, 347, 127, 44);
		add(insertJNum2Field);
		
		JLabel hyphenLabel = new JLabel("-");
		hyphenLabel.setFont(new Font("굴림", Font.PLAIN, 16));
		hyphenLabel.setBounds(325, 347, 30, 44);
		add(hyphenLabel);
		
		JLabel insertPhoneNumLabel = new JLabel("전화번호");
		insertPhoneNumLabel.setFont(new Font("굴림", Font.PLAIN, 16));
		insertPhoneNumLabel.setBounds(197, 400, 276, 44);
		add(insertPhoneNumLabel);
		
		insertPhoneNumField = new JTextField();
		insertPhoneNumField.setFont(new Font("굴림", Font.PLAIN, 16));
		//insertPhoneNumField.setColumns(10);
		insertPhoneNumField.setBounds(197, 403, 276, 44);
		add(insertPhoneNumField);
		
		JPanel cateBtnPanel = new JPanel();
		cateBtnPanel.setBounds(97, 468, 486, 98);
		add(cateBtnPanel);
		cateBtnPanel.setLayout(new GridLayout(2,13));
		
		JButton createButton = new JButton("회원 가입 완료");
		createButton.setBounds(250, 598, 185, 38);
		add(createButton);
		
		for(int i = 0; i < 26; i++) {
		cateBtnPanel.add(new JButton("New button"));
		}			
	}


	
}
