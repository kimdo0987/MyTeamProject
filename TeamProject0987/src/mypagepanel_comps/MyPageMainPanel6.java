package mypagepanel_comps;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import labels.TopLabel;
import mypagepanel_comps.mp6.MpChangePanel;

//계정 관리 Panel이 될 JPanel입니다

public class MyPageMainPanel6 extends JPanel {
	MpChangePanel mpPanel = new MpChangePanel();
	
	public MyPageMainPanel6() {
		setBackground(new Color(204, 235, 204));
		setBounds(118, 0, 1093, 800);	
		setLayout(null);
		CardLayout mpLayout = new CardLayout();
		
		TopLabel toplabel = new TopLabel("계정 관리");
		toplabel.setLocation(335, 31);
		add(toplabel);
		
		JPanel panel = new JPanel(); 
		panel.setBounds(162, 155, 730, 569);
		panel.setLayout(mpLayout);
		
		add(panel);
		JLabel tableNameLabel = new JLabel("계정 관리");
		tableNameLabel.setFont(new Font("", Font.PLAIN, 18));
		tableNameLabel.setBounds(12, 9, 148, 40);
		
		
		JPanel tablePanel = new JPanel();
		tablePanel.setBounds(0, 58, 730, 511);
		
		tablePanel.setLayout(null);

		panel.add(tablePanel);
		panel.add(mpPanel);

		JLabel pwChangeLabel = new JLabel("비밀번호를 입력해주세요");
		pwChangeLabel.setFont(new Font("굴림", Font.PLAIN, 14));
		pwChangeLabel.setBounds(203, 50, 195, 39);
		tablePanel.add(pwChangeLabel);

		JTextField pwInputField = new JTextField();
		pwInputField.setBounds(203, 100, 418, 73);		
		tablePanel.add(pwInputField);
		
		JLabel pwLabel = new JLabel("비밀번호");
		pwLabel.setFont(new Font("굴림", Font.PLAIN, 18));
		pwLabel.setBounds(72, 110, 108, 73);
		tablePanel.add(pwLabel);
		
		
		JButton okBtn = new JButton("확인");
		okBtn.setBounds(250, 270, 260, 83);
		tablePanel.add(okBtn);
		
		okBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				tablePanel.setVisible(false);
				mpPanel.setVisible(true);
				
			}
		});
	}
}
