package mypagepanel_comps;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import labels.TopLabel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

//쿠폰함 Panel이 될 JPanel입니다

public class MyPageMainPanel4 extends JPanel {
	private JTextField textField;
	public MyPageMainPanel4() {
		setBackground(new Color(204, 255, 204));
		setBounds(118, 0, 1093, 800);
		setLayout(null);
		
		TopLabel toplabel = new TopLabel("쿠폰함");
		toplabel.setLocation(335, 31);
		add(toplabel);
		
		JPanel panel = new JPanel(); //쿠폰 등록 textField와 내 쿠폰함 List 테이블이 들어갈 Label
		panel.setBounds(162, 155, 730, 569);
		panel.setLayout(null);
		add(panel);
		
		JPanel tablePanel = new JPanel();
		tablePanel.setBounds(0, 90, 730, 479);
		panel.add(tablePanel);
		
		textField = new JTextField();
		textField.setBounds(424, 13, 176, 35);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel tableNameLabel = new JLabel("나의 쿠폰 리스트");
		tableNameLabel.setFont(new Font("", Font.PLAIN, 18));
		tableNameLabel.setBounds(12, 13, 148, 40);
		panel.add(tableNameLabel);
		
		JLabel tableNameLabel_1 = new JLabel("쿠폰 등록하기");
		tableNameLabel_1.setFont(new Font("", Font.PLAIN, 12));
		tableNameLabel_1.setBounds(336, 10, 84, 40);
		panel.add(tableNameLabel_1);
		
		JButton btnNewButton = new JButton("등록");
		btnNewButton.setBounds(612, 16, 93, 29);
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("등록하려는 쿠폰번호: " + textField.getText());
				
			}
		});
		panel.add(btnNewButton);
		
		
		///////////////////TABLE 생성 //////////////////////////
		
		String[] headings = new String[] {"no.","쿠폰이름","쿠폰번호","할인율","유효기간","사용유무"};
		Object[][] data = new Object[][] {
			{"","회원가입 환영 쿠폰", "A23ZTEQV2", 10 + "%", "22.06.20 ~ 22.07.20", "사용가능"},
			{"","생일 축하 쿠폰", "B23QTEQV2", 25 + "%", "22.06.20 ~ 22.07.20", "사용완료"},
			{"","7월 이벤트 쿠폰", "A23ZTEQV2", 10 + "%", "22.06.20 ~ 22.07.20", "사용가능"},
			{"","여름방학 맞이 쿠폰", "B23QTEQV2", 5 + "%", "22.06.20 ~ 22.07.20", "사용완료"},
		};
		
		// 테이블의 셀 내용 수정 불가 시작 //
		DefaultTableModel mod = new DefaultTableModel(data, headings) {
			public boolean isCellEditable(int rowIndex, int mColIndex) {
				return false;
			}
		};

		JTable table = new JTable(mod); // 수정불가능한 테이블로 생성
		table.setPreferredScrollableViewportSize(new Dimension(730,450));
		
		table.getColumnModel().getColumn(0).setMinWidth(50);
		table.getColumnModel().getColumn(0).setMaxWidth(50);
		table.getColumnModel().getColumn(1).setMinWidth(320);//셀 너비 조정
		table.getColumnModel().getColumn(1).setMaxWidth(320);
		table.getColumnModel().getColumn(2).setMinWidth(80);
		table.getColumnModel().getColumn(2).setMaxWidth(80);
		
		table.getColumnModel().getColumn(3).setMinWidth(50);
		table.getColumnModel().getColumn(3).setMaxWidth(50);
		table.getColumnModel().getColumn(4).setMinWidth(140);
		table.getColumnModel().getColumn(4).setMaxWidth(140);		
		
		table.setEnabled(false); //테이블 클릭 안되도록 지정

		table.setRowHeight(30); // 셀 높이 조정		
		table.setCellSelectionEnabled(true); // 한셀만 선택가능
		table.getTableHeader().setReorderingAllowed(false); //컬럼 헤더 고정 (이동 불가)
		table.getTableHeader().setResizingAllowed(false); // 컬럼 크기 고정 (변경 불가)
		
		
		ListSelectionModel selectionModel = table.getSelectionModel(); //한 행만 선택가능
		selectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); 	
		
		
		
		table.setFillsViewportHeight(true);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 0, 730, 450);		
		tablePanel.add(scrollPane);		
		panel.add(tablePanel);
		
		
		
		
		
	}
}
