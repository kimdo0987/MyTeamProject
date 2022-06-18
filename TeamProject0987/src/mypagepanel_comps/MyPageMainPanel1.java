package mypagepanel_comps;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import labels.TopLabel;

//나의 수강 조회 Panel이 될 JPanel입니다

public class MyPageMainPanel1 extends JPanel {
	private JTable table;
	private JTable table_1;
	public MyPageMainPanel1() {
		setBackground(new Color(153, 204, 204));
		setBounds(118, 0, 1093, 800);
		setLayout(null);
		
		TopLabel toplabel = new TopLabel("나의 수강 조회");
		toplabel.setLocation(335, 31);
		add(toplabel);	
		
		JPanel panel = new JPanel();
		panel.setBounds(162, 155, 730, 569);
		add(panel);
		panel.setLayout(null);
		
				
		JLabel lblNewLabel = new JLabel("수강중인 과정");
		lblNewLabel.setBounds(53, 29, 97, 43);
		panel.add(lblNewLabel);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
					"강의명","수강기간","출석률"
			}
		));
		table_1.setBounds(49, 81, 610, 434);
		panel.add(table_1);
	}
}
