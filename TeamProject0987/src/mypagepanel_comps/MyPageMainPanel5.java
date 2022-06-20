package mypagepanel_comps;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import labels.TopLabel;

//구매 내역 Panel이 될 JPanel입니다

public class MyPageMainPanel5 extends JPanel {
	public MyPageMainPanel5() {
		setBackground(new Color(204, 255, 102));
		setBounds(118, 0, 1093, 800);	
		setLayout(null);
		
		
		TopLabel toplabel = new TopLabel("구매 내역");
		toplabel.setLocation(335, 31);
		add(toplabel);
		
		JPanel panel = new JPanel(); 
		panel.setBounds(162, 155, 730, 569);
		panel.setLayout(null);
		add(panel);
		
		JLabel tableNameLabel = new JLabel("구매 내역");
		tableNameLabel.setFont(new Font("", Font.PLAIN, 18));
		tableNameLabel.setBounds(12, 9, 148, 40);
		panel.add(tableNameLabel);
		
		JPanel tablePanel = new JPanel();
		tablePanel.setBounds(0, 58, 730, 511);	
		tablePanel.setLayout(null);
		
		String[] headings = new String[] {"주문번호","주문날짜","상태","주문명","금액"};
		Object[][] data = new Object[][] {
			{"1","22.06.20","결제완료", "스프링 핵심 원리 - 기본편", "￦26,500"},
			{"2","22.06.20","결제완료", "Java TPC(생각하고, 표현하고, 코딩하고)", "￦88,000"},
			{"3","22.06.17","결제완료", "스프링 핵심 원리 - 심화편", "￦33,500"},
			{"4","22.06.16","결제대기", "예제로 공부하는 Java 100 문제풀이 Part.1", "￦16,500"},			
		};
		
		// 테이블의 셀 내용 수정 불가 시작 //
		DefaultTableModel mod = new DefaultTableModel(data, headings) {
			public boolean isCellEditable(int rowIndex, int mColIndex) {
				return false;
			}
		};
		
		JTable table = new JTable(mod); // 수정불가능한 테이블로 생성
		table.setPreferredScrollableViewportSize(new Dimension(700,600));
		
		table.getColumnModel().getColumn(0).setMinWidth(60);//셀 너비 조정
		table.getColumnModel().getColumn(0).setMaxWidth(60);
		table.getColumnModel().getColumn(1).setMinWidth(100);
		table.getColumnModel().getColumn(1).setMaxWidth(100);
		table.getColumnModel().getColumn(2).setMinWidth(60);
		table.getColumnModel().getColumn(2).setMaxWidth(60);
		table.getColumnModel().getColumn(3).setMinWidth(400);
		table.getColumnModel().getColumn(3).setMaxWidth(400);
		
		table.setRowHeight(30); // 셀 높이 조정		
		table.getTableHeader().setReorderingAllowed(true); //컬럼 헤더 이동 가능 설정
		
		table.setEnabled(false); //테이블 클릭 안되도록 지정
		
		
		//테이블 생성에 관한 내용
		table.setFillsViewportHeight(true);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 0, 730, 500);
		tablePanel.add(scrollPane);
		
		panel.add(tablePanel);
		
		add(panel);
		
		
	}
}
