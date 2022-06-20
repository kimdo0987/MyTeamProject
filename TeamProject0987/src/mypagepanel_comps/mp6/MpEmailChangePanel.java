package mypagepanel_comps.mp6;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MpEmailChangePanel extends JPanel {
	public MpEmailChangePanel() {
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

		/////////////////////////////////////////////////////////////////////////

		JButton emailChangeBtn = new JButton("이메일 변경");
		emailChangeBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MpChangePanel.mpLayout.show(MpChangePanel.mpPanel, "email");

			}

		});
		emailChangeBtn.setBounds(260, 50, 202, 78);
		add(emailChangeBtn);

		/////////////////////////////////////////////////////////////////////////////////

		JButton pwChangeBtn = new JButton("비밀번호 변경");
		pwChangeBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MpChangePanel.mpLayout.show(MpChangePanel.mpPanel, "password");

			}

		});
		pwChangeBtn.setBounds(56, 50, 202, 78);
		add(pwChangeBtn);

		JLabel emailLabel = new JLabel("abcde@naver.com");
		emailLabel.setBounds(196, 162, 469, 51);
		add(emailLabel);

		JTextField newEmailField = new JTextField();
		newEmailField.setBounds(196, 223, 469, 51);
		add(newEmailField);

		JLabel emailLabel2 = new JLabel("기존 이메일");
		emailLabel2.setBounds(56, 162, 124, 51);
		add(emailLabel2);

		JLabel newEmailLabel = new JLabel("새 이메일");
		newEmailLabel.setBounds(56, 223, 124, 51);
		add(newEmailLabel);

		JButton ChangeOkBtn = new JButton("변경 하기");
		ChangeOkBtn.setBounds(260, 346, 202, 78);
		add(ChangeOkBtn);

	}
}
