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
import javax.swing.table.JTableHeader;

import labels.TopLabel;
import panels.ImagePanel;

//구매 내역 Panel이 될 JPanel입니다

public class MyPageMainPanel5 extends ImagePanel {
	public MyPageMainPanel5() {
		setBackground(new Color(204, 255, 102));
		setBounds(118, 0, 1093, 800);	
		setLayout(null);
		
		JPanel panel = new JPanel(); 
		panel.setBounds(80, 154, 800, 560);
		panel.setLayout(null);
		add(panel);
		
		JLabel tableNameLabel = new JLabel("구매 내역");
		tableNameLabel.setForeground(Color.WHITE);
		tableNameLabel.setBounds(80, 40, 400, 90);
		add(tableNameLabel);
		tableNameLabel.setFont(new Font("배달의민족 도현", Font.PLAIN, 58));
		
		JPanel tablePanel = new JPanel();
		tablePanel.setBounds(0, 0, 800, 560);	
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
		
		table.setPreferredScrollableViewportSize(new Dimension(800,600));
		
		table.getColumnModel().getColumn(0).setMinWidth(60);//셀 너비 조정
		table.getColumnModel().getColumn(0).setMaxWidth(60);

		table.getColumnModel().getColumn(1).setMinWidth(70);
		table.getColumnModel().getColumn(1).setMaxWidth(70);
		
		table.getColumnModel().getColumn(2).setMinWidth(300);
		table.getColumnModel().getColumn(2).setMaxWidth(300);
		
		table.getColumnModel().getColumn(3).setMinWidth(120);
		table.getColumnModel().getColumn(3).setMaxWidth(120);
		
		table.getColumnModel().getColumn(4).setMinWidth(80);
		table.getColumnModel().getColumn(4).setMaxWidth(80);
		
		table.getColumnModel().getColumn(5).setMinWidth(70);
		table.getColumnModel().getColumn(5).setMaxWidth(70);
		
		table.getColumnModel().getColumn(6).setMinWidth(82);
		table.getColumnModel().getColumn(6).setMaxWidth(82);
		
		table.setRowHeight(30); // 셀 높이 조정		
		table.getTableHeader().setReorderingAllowed(false); //컬럼 헤더 고정 (이동 불가)
		table.getTableHeader().setResizingAllowed(false); // 컬럼 크기 고정 (변경 불가)

		// 테이블 폰트 설정
		table.setFont(new Font("맑은 고딕", Font.PLAIN, 14));

		// 컬럼명 폰트 설정
		JTableHeader tableHeader = table.getTableHeader();
		Font headerFont = new Font("맑은 고딕", Font.PLAIN, 14);
		tableHeader.setFont(headerFont);
		
		//테이블 생성에 관한 내용
		table.setFillsViewportHeight(true);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 0, 800, 560);
		tablePanel.add(scrollPane);
		
		panel.add(tablePanel);
		
		add(panel);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBounds(80, 124, 800, 3);
		add(lblNewLabel);
	}
}
