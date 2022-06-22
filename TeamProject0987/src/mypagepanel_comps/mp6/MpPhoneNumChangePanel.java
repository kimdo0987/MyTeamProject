package mypagepanel_comps.mp6;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MpPhoneNumChangePanel extends JPanel {

	public MpPhoneNumChangePanel() {
		setLayout(null);

		setBounds(0, 58, 730, 511);

		JButton pnChangeBtn = new JButton("전화번호 변경");
		pnChangeBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MpChangePanel.mpLayout.show(MpChangePanel.mpPanel, "phoneNum");

			}

		});
		pnChangeBtn.setBounds(463, 50, 202, 78);
		add(pnChangeBtn);

		/////////////////////////////////////////////////////////////////////////////////////
		JButton emailChangeBtn = new JButton("이메일 변경");
		emailChangeBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MpChangePanel.mpLayout.show(MpChangePanel.mpPanel, "email");

			}

		});
		emailChangeBtn.setBounds(260, 50, 202, 78);
		add(emailChangeBtn);

		/////////////////////////////////////////////////////////////////////////////////////

		JButton pwChangeBtn = new JButton("비밀번호 변경");
		pwChangeBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MpChangePanel.mpLayout.show(MpChangePanel.mpPanel, "password");

			}

		});
		pwChangeBtn.setBounds(56, 50, 202, 78);
		add(pwChangeBtn);

		/////////////////////////////////////////////////////////////////////////////////////

		JLabel pnLabel = new JLabel("010-1234-1234");
		pnLabel.setBounds(196, 162, 469, 51);
		add(pnLabel);

		JTextField newPnField = new JTextField();
		newPnField.setBounds(196, 223, 469, 51);
		add(newPnField);

		JLabel pnLabel2 = new JLabel("기존 전화번호");
		pnLabel2.setBounds(56, 162, 124, 51);
		add(pnLabel2);

		JLabel newPnLabel = new JLabel("새 전화번호");
		newPnLabel.setBounds(56, 223, 124, 51);
		add(newPnLabel);

		JButton phoneNumChangeOkBtn = new JButton("변경 하기");
		phoneNumChangeOkBtn.setBounds(260, 346, 202, 78);
		add(phoneNumChangeOkBtn);

		JButton profileBtn = new JButton("내 정보");
		profileBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MpChangePanel.mpLayout.show(MpChangePanel.mpPanel, "profile");
			}
		});
		profileBtn.setBounds(24, 9, 93, 23);
		add(profileBtn);
	}
}
