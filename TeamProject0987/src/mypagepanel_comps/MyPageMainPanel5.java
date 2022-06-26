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
		
		String[] headings = new String[] {"주문번호", "주문날짜", "강의명", "쿠폰명", "정가", "결제금액", "결제수단"};
		String[][] data = database.MyPaymentLog.getMyPaymentLog();

		// 테이블의 셀 내용 수정 불가 시작 //
		DefaultTableModel mod = new DefaultTableModel(data, headings) {
			public boolean isCellEditable(int rowIndex, int mColIndex) {
				return false;
			}
		};
		
		
		
		JTable table = new JTable(mod); // 수정불가능한 테이블로 생성
		table.setEnabled(false); //테이블 클릭 안되도록 지정
		
		table.setPreferredScrollableViewportSize(new Dimension(700,600));
		
		table.getColumnModel().getColumn(0).setMinWidth(60);//셀 너비 조정
		table.getColumnModel().getColumn(0).setMaxWidth(60);

		table.getColumnModel().getColumn(1).setMinWidth(60);
		table.getColumnModel().getColumn(1).setMaxWidth(60);
		
		table.getColumnModel().getColumn(2).setMinWidth(300);
		table.getColumnModel().getColumn(2).setMaxWidth(300);
		
		table.getColumnModel().getColumn(3).setMinWidth(120);
		table.getColumnModel().getColumn(3).setMaxWidth(120);
		
		table.getColumnModel().getColumn(4).setMinWidth(60);
		table.getColumnModel().getColumn(4).setMaxWidth(60);
		
		table.getColumnModel().getColumn(5).setMinWidth(60);
		table.getColumnModel().getColumn(5).setMaxWidth(60);
		
		table.getColumnModel().getColumn(6).setMinWidth(70);
		table.getColumnModel().getColumn(6).setMaxWidth(70);
		
		table.setRowHeight(30); // 셀 높이 조정		
		table.getTableHeader().setReorderingAllowed(false); //컬럼 헤더 고정 (이동 불가)
		table.getTableHeader().setResizingAllowed(false); // 컬럼 크기 고정 (변경 불가)

		
		
		//테이블 생성에 관한 내용
		table.setFillsViewportHeight(true);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 0, 730, 500);
		tablePanel.add(scrollPane);
		
		panel.add(tablePanel);
		
		add(panel);
		
		
	}
}
