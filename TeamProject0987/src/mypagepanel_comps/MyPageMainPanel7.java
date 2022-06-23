package mypagepanel_comps;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import labels.TopLabel;
import panels.MainPanel;

//회원 탈퇴 Panel이 될 JPanel입니다

public class MyPageMainPanel7 extends JPanel {
	
	public MyPageMainPanel7() {
		setBackground(new Color(204, 200, 204));
		setBounds(118, 0, 1093, 800);	
		setLayout(null);
		
		TopLabel toplabel = new TopLabel("회원 탈퇴");
		toplabel.setLocation(335, 31);
		add(toplabel);
		
		JPanel panel = new JPanel(); //탈퇴시 안내사항label, 비밀번호작성 textField,버튼 이 들어가는 패널 (장바구니 panel)
		panel.setBounds(162, 155, 730, 569);
		panel.setLayout(null);
		add(panel);
		
		JLabel report = new JLabel("탈퇴시 안내사항");
		report.setBounds(320,80,200,200);
		panel.add(report);
		
		JLabel  explain = new JLabel("비밀번호를 입력해주세요");
		explain.setBounds(220,300,200,60);
		panel.add(explain);
		
		JPasswordField pwInput = new JPasswordField();
		add(pwInput);
		pwInput.setBounds(380, 500, 300, 30);
		
		JButton leaveBtn = new JButton("탈퇴하기");
		leaveBtn.setBounds(260, 500, 200,40);
		panel.add(leaveBtn);
		
		leaveBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "정말 탈퇴하시겠습니까?", "WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
			}
		});
	}
}
