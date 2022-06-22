package mypagepanel_comps.mp6;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MpPwChangePanel extends JPanel {

	public MpPwChangePanel() {

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

		JTextField newPwField = new JTextField();
		newPwField.setBounds(196, 212, 469, 51);
		add(newPwField);

		JTextField newPwField2 = new JTextField();
		newPwField2.setColumns(10);
		newPwField2.setBounds(196, 273, 469, 51);
		add(newPwField2);

		JLabel newPwLabel = new JLabel("새 비밀번호");
		newPwLabel.setBounds(56, 212, 124, 51);
		add(newPwLabel);

		JLabel newPwLabel2 = new JLabel("새 비밀번호 확인");
		newPwLabel2.setBounds(56, 273, 124, 51);
		add(newPwLabel2);

		JLabel nameLabel = new JLabel("이름");
		nameLabel.setBounds(56, 151, 124, 51);
		add(nameLabel);

		JLabel nameLabel2 = new JLabel("사용자이름");
		nameLabel2.setBounds(197, 151, 207, 51);
		add(nameLabel2);

		JButton pwChangeOkBtn = new JButton("변경 하기");
		pwChangeOkBtn.setBounds(260, 346, 202, 78);
		add(pwChangeOkBtn);

		pwChangeOkBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});
		
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
