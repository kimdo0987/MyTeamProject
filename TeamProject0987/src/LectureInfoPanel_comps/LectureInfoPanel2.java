package LectureInfoPanel_comps;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.SoftBevelBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.border.BevelBorder;
import java.awt.Component;

// 수강평 Panel 이 될 JPanel 입니다.

public class LectureInfoPanel2 extends JPanel {
	public LectureInfoPanel2() {
		setBounds(199, 371, 786, 390);
		setLayout(null);
		
		String[] headings = {"id", "uploadDate", "comments", "star(rate)"};
		Object[][] data = {
				{"kevinj0695", "22-06-10", "별 만점 강의입니다. 좋아요", "★★★★★"},
				{"kimdo0987", "22-06-17", "도움이 많이 되었습니다. 감사합니다.", "★★★★★"},
				{"intacka", "22-06-13", "맘에 드는 강의 오랜만이네요", "★★★★☆"},
				{"a9347", "22-06-20", "잘봤습니다. 감사합니다", "★★★★☆"},
				{"kimkt1002", "22-06-18", "도움이 되는 강의입니다.", "★★★★★"}
		};
				
		JTable commentsTable = new JTable(data, headings);
		JScrollPane scrollPane = new JScrollPane(commentsTable);
		scrollPane.setSize(786, 390);
		add(scrollPane);
		
		commentsTable.setSize(786, 390);
		commentsTable.setRowHeight(30);
		commentsTable.setFillsViewportHeight(true);
		commentsTable.setCellSelectionEnabled(true);
		commentsTable.getTableHeader().setBackground(Color.lightGray);
		commentsTable.getTableHeader().setReorderingAllowed(false);
		
		// 셀 너비 수정을 할 땐 모델을 얻어와야한다.
		commentsTable.getColumnModel().getColumn(0).setMaxWidth(90);
		commentsTable.getColumnModel().getColumn(0).setMinWidth(90);
		commentsTable.getColumnModel().getColumn(1).setMaxWidth(100);
		commentsTable.getColumnModel().getColumn(1).setMinWidth(100);
		commentsTable.getColumnModel().getColumn(3).setMaxWidth(90);
		commentsTable.getColumnModel().getColumn(3).setMinWidth(90);
		
		// 셀 수정 불가
		DefaultTableModel mod = new DefaultTableModel(data, headings) {
			public boolean isCellEditable(int rowIndex, int mColIndex) {
				return false;
			}
		};
		
		// 셀 데이터 가운데 정렬
		DefaultTableCellRenderer tableCell = new DefaultTableCellRenderer();
		tableCell.setHorizontalAlignment(SwingConstants.CENTER);
		TableColumnModel CellModel = commentsTable.getColumnModel();
		for(int i = 0;i < CellModel.getColumnCount(); i++) {
			CellModel.getColumn(i).setCellRenderer(tableCell);			
		}
		
		
	}
	
}
