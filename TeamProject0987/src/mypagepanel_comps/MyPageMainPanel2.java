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
import panels.ImagePanel;

//출결 현황 조회 Panel이 될 JPanel입니다

public class MyPageMainPanel2 extends ImagePanel {
	public MyPageMainPanel2() {
		setBackground(new Color(102, 153, 204));
		setBounds(118, 0, 1093, 800);
		setLayout(null);
		
		JPanel panel = new JPanel(); //출석List 테이블과 label이 들어가는 패널 (출석현황 panel)
		panel.setBounds(80, 154, 800, 560);
		panel.setLayout(null);
		add(panel);
		
		JLabel tableNameLabel = new JLabel("출결 리스트");
		tableNameLabel.setForeground(Color.WHITE);
		tableNameLabel.setBounds(80, 60, 321, 60);
		add(tableNameLabel);
		tableNameLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 58));
		
		JPanel tablePanel = new JPanel();
		tablePanel.setBounds(0, 0, 800, 560);		
		tablePanel.setLayout(null);
		panel.add(tablePanel);
		
		String[] headings = new String[] {"날짜", "강의명", "강사명", "결과"};
		String[][] data = database.MyAttendanceLog.getMyAttendanceLog();
		
		// 테이블의 셀 내용 수정 불가 시작 //
		DefaultTableModel mod = new DefaultTableModel(data, headings) {
			public boolean isCellEditable(int rowIndex, int mColIndex) {
				return false;
			}
		};

		JTable table = new JTable(mod); // 수정불가능한 테이블로 생성
		table.setPreferredScrollableViewportSize(new Dimension(800,600));
		
		table.getColumnModel().getColumn(0).setMinWidth(110);
		table.getColumnModel().getColumn(0).setMaxWidth(110);
		table.getColumnModel().getColumn(1).setMinWidth(400);//셀 너비 조정
		table.getColumnModel().getColumn(1).setMaxWidth(400);
		table.getColumnModel().getColumn(2).setMinWidth(180);
		table.getColumnModel().getColumn(2).setMaxWidth(180);
		
		table.getColumnModel().getColumn(3).setMinWidth(110);
		table.getColumnModel().getColumn(3).setMaxWidth(110);
		
		table.setRowHeight(30); // 셀 높이 조정		
		table.setCellSelectionEnabled(true); // 한셀만 선택가능
		table.getTableHeader().setReorderingAllowed(false); //컬럼 헤더 고정 (이동 불가)
		table.getTableHeader().setResizingAllowed(false); // 컬럼 크기 고정 (변경 불가)
		
		ListSelectionModel selectionModel = table.getSelectionModel(); //한 행만 선택가능
		selectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); 	
		
		table.setEnabled(false); // 버튼 선택 색상 X
		table.setFillsViewportHeight(true);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 0, 800, 560);		
		tablePanel.add(scrollPane);		
		panel.add(tablePanel);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBounds(80, 124, 800, 3);
		add(lblNewLabel);
	}
}
