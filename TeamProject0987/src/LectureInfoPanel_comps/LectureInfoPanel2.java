package LectureInfoPanel_comps;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import database.GetLectureComments;
import panels.LectureSearchPanel;

// 수강평 Panel 이 될 JPanel 입니다.

public class LectureInfoPanel2 extends JPanel {
	
	public LectureInfoPanel2(int num) { /////////
		setBounds(199, 371, 786, 390);
		setLayout(null);
		
		String[] firstRow = new String[] {"작성자", "수강평", "평점"};
		String[][] data = GetLectureComments.getLectureComments(num);/////
		System.out.println("테스트중입니다 "+LectureSearchPanel.currLectureId);
		DefaultTableModel mod = new DefaultTableModel(data, firstRow) {
			public boolean isCellEditable(int rowIndex, int mColIndex) {
				return false;
			}
		};
		
		JTable table = new JTable(mod);
		table.setPreferredScrollableViewportSize(new Dimension(700, 600));
		table.setEnabled(false);
		table.getColumnModel().getColumn(0).setMinWidth(100);// 셀 너비 조정
		table.getColumnModel().getColumn(0).setMaxWidth(100);
		table.getColumnModel().getColumn(1).setMinWidth(600);
		table.getColumnModel().getColumn(1).setMaxWidth(600);
		table.getColumnModel().getColumn(2).setMinWidth(80);
		table.getColumnModel().getColumn(2).setMaxWidth(100);

		table.setRowHeight(30);
		table.setCellSelectionEnabled(true);
		table.getTableHeader().setReorderingAllowed(false);
		table.getTableHeader().setResizingAllowed(false);

		ListSelectionModel selectionModel = table.getSelectionModel();
		selectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setCellSelectionEnabled(false); // 한셀만 선택가능
		table.getTableHeader().setReorderingAllowed(false); // 컬럼 헤더 고정 (이동 불가)
		table.getTableHeader().setResizingAllowed(false);
		add(table);
		
		// 테이블 폰트 설정
		table.setFont(new Font("맑은 고딕", Font.PLAIN, 14));

		// 컬럼명 폰트 설정
		JTableHeader tableHeader = table.getTableHeader();
		Font headerFont = new Font("맑은 고딕", Font.PLAIN, 17);
		tableHeader.setFont(headerFont);

		table.setFillsViewportHeight(true);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 0, 730, 500);
		scrollPane.setSize(getSize());
		add(scrollPane);
	}
	
}
