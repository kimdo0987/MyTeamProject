package mypagepanel_comps;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;

import labels.TopLabel;
import panels.ImagePanel;

public class PaymentPanel extends ImagePanel {
	public PaymentPanel() {
		setBackground(new Color(245, 222, 179));
		setBounds(118, 0, 1093, 800);	
		setLayout(null);
		
		//헤딩
		JLabel tableNameLabel = new JLabel("결제확인");
		tableNameLabel.setForeground(Color.WHITE);
		tableNameLabel.setBounds(80, 60, 460, 60);
		add(tableNameLabel);
		tableNameLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 58));
		
		//구분선
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBounds(80, 124, 800, 3);
		add(lblNewLabel);
		
		ImageIcon payChkBtnicon1 = new ImageIcon("images/mp3/paypanel/결제확인버튼.png");
		Image payChkBtnimg1 = payChkBtnicon1.getImage();
		Image payChkBtn1 = payChkBtnimg1.getScaledInstance(300, 75, Image.SCALE_SMOOTH);
		ImageIcon payChkBtnicon2 = new ImageIcon("images/mp3/paypanel/노란결제확인버튼.png");
		Image payChkBtnimg2 = payChkBtnicon2.getImage();
		Image payChkBtn2 = payChkBtnimg2.getScaledInstance(300, 75, Image.SCALE_SMOOTH);
		MyPageTabButton payCheckButton = new MyPageTabButton(new ImageIcon(payChkBtn1));
		payCheckButton.setFont(new Font("굴림", Font.PLAIN, 0));
		payCheckButton.setBounds(586, 675, 294, 75);
		payCheckButton.setBorder(BorderFactory.createEmptyBorder());
		payCheckButton.setRolloverIcon(new ImageIcon(payChkBtn2));
		add(payCheckButton);
		
		JPanel panel = new JPanel(); //탈퇴시 안내사항label, 비밀번호작성 textField,버튼 이 들어가는 패널 (장바구니 panel)
		panel.setBounds(80, 154, 800, 510);
		panel.setLayout(null);
		add(panel);
		
		JPanel tablePanel = new JPanel();
		tablePanel.setBounds(0, 0, 800, 510);		
		tablePanel.setLayout(null);
		panel.add(tablePanel);
		
		JScrollPane scrollPane = new JScrollPane(MyPageMainPanel3.table2);
		scrollPane.setBounds(0, 0, 800, 510);		
		tablePanel.add(scrollPane);		
		panel.add(tablePanel);
		
		
	}
}
