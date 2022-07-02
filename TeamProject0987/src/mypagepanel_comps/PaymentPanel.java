package mypagepanel_comps;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.table.TableColumn;

import panels.ImagePanel;

public class PaymentPanel extends ImagePanel {
	public PaymentPanel() {
		setBackground(new Color(245, 222, 179));
		setBounds(118, 0, 1093, 800);	
		setLayout(null);
		
		//헤딩
		JLabel tableNameLabel = new JLabel("결제확인");
		tableNameLabel.setForeground(Color.WHITE);
		tableNameLabel.setBounds(80, 40, 460, 90);
		add(tableNameLabel);
		tableNameLabel.setFont(new Font("배달의민족 도현", Font.PLAIN, 58));
		
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
		
		JButton payCheckButton = new JButton(new ImageIcon(payChkBtn1));
		payCheckButton.setFont(new Font("굴림", Font.PLAIN, 0));
		payCheckButton.setBounds(586, 675, 294, 75);
		payCheckButton.setBorder(BorderFactory.createEmptyBorder());
		payCheckButton.setRolloverIcon(new ImageIcon(payChkBtn2));
		add(payCheckButton);
		
		payCheckButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		
		
		JPanel panel = new JPanel(); //탈퇴시 안내사항label, 비밀번호작성 textField,버튼 이 들어가는 패널 (장바구니 panel)
		panel.setBounds(80, 154, 800, 413);
		panel.setLayout(null);
		add(panel);
		
		JPanel tablePanel = new JPanel();
		tablePanel.setBounds(0, 0, 800, 413);		
		tablePanel.setLayout(null);
		panel.add(tablePanel);
		
		JScrollPane scrollPane = new JScrollPane(MyPageMainPanel3.table2);
		scrollPane.setBounds(0, 0, 800, 413);		
		tablePanel.add(scrollPane);		
		panel.add(tablePanel);
		
		
		JLabel tableNameLabel_1 = new JLabel("결제 금액");
		tableNameLabel_1.setForeground(Color.WHITE);
		tableNameLabel_1.setFont(new Font("배달의민족 도현", Font.PLAIN, 36));
		tableNameLabel_1.setBounds(419, 576, 171, 90);
		add(tableNameLabel_1);
		
		JLabel tableNameLabel_1_1 = new JLabel("0원");
		tableNameLabel_1_1.setForeground(Color.WHITE);
		tableNameLabel_1_1.setFont(new Font("배달의민족 도현", Font.PLAIN, 36));
		tableNameLabel_1_1.setBounds(586, 576, 294, 90);
		add(tableNameLabel_1_1);
		
		
	}
}
