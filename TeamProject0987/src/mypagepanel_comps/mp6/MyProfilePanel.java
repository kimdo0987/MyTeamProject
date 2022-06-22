package mypagepanel_comps.mp6;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MyProfilePanel extends JPanel {
	public MyProfilePanel() {
		setLayout(null);

		setBounds(0, 58, 730, 511);
		
		JLabel nameLabel = new JLabel("이름");
		nameLabel.setBounds(110, 100, 50, 50);
		add(nameLabel);
		
		JLabel idLabel = new JLabel("ID");
		idLabel.setBounds(120, 140, 50, 50);
		add(idLabel);
		
		JLabel birthLabel = new JLabel("생년월일");
		birthLabel.setBounds(100, 180, 50, 50);
		add(birthLabel);
		
		JLabel phoneNumberLabel = new JLabel("전화번호");
		phoneNumberLabel.setBounds(100, 220, 50, 50);
		add(phoneNumberLabel);
		
		JLabel emailLabel = new JLabel("이메일");
		emailLabel.setBounds(105, 260, 50, 50);
		add(emailLabel);
		
		JButton modifyBtn = new JButton("내 정보 수정하기");
		modifyBtn.setBounds(276, 349, 145, 50);
		modifyBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MpChangePanel.mpLayout.show(MpChangePanel.mpPanel, "password");
				
			}
		});
		add(modifyBtn);
		
	}

//	public static void main(String[] args) {
//		JFrame frame = new JFrame();
//		JPanel panel = new JPanel();
//		frame.add(panel);
//		panel.setBounds(100, 100, 1200, 800);
//		panel.setBackground(Color.white);
//		panel.setLayout(null);
//
//		panel.add(new MyProfilePanel());
//
//		frame.setBounds(100, 100, 1200, 800);
//		frame.setLocationRelativeTo(null);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setVisible(true);
//	}
}
