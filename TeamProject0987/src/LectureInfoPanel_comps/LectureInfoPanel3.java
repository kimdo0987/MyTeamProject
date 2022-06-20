package LectureInfoPanel_comps;

import java.awt.Color;

import java.awt.Component;


import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;


// 강의 시간표 Panel 이 될 JPanel 입니다

public class LectureInfoPanel3 extends JPanel {
	public LectureInfoPanel3() {
		setBounds(199, 371, 786, 390);
		setLayout(null);
		
		String[] headings = {" ", "일", "월", "화", "수", "목", "금", "토"};
		Object[][] data = {
				{"1", " ", "강의", " ", "강의", " ", "강의", " "},
				{"2", " ", "강의", " ", "강의", " ", "강의", " "},
				{"3", " ", "강의", " ", "강의", " ", "강의", " "},
				{"4", " ", "점심", " ", "점심", " ", "점심", " "},
				{"5", " ", "강의", " ", "강의", " ", "강의", " "},
				{"6", " ", "강의", " ", "강의", " ", "강의", " "}
		};
		

		JTable scheduleTable = new JTable(data, headings) {
			// 익명내부클래스로 특정 row에서 색깔 바꿈
			public Component prepareRenderer(
					TableCellRenderer renderer, int row, int column) 
			{
				Component c = super.prepareRenderer(renderer, row, column);
				if(!c.getBackground().equals(getSelectionBackground())) {
					if (row == 3) {
						c.setBackground(Color.ORANGE);
					} else {
						c.setBackground(Color.WHITE);
					}
				}
				return c;
			}
		};
		
		// JscroollPane 의 사이즈와 테이블의 사이즈를 각각 따로 설정해야 하는듯 합니다.
		// 그 중에서도 테이블의 scrollPane 의 사이즈보다 크거나 같아야 합니다.

		JScrollPane scrollPane = new JScrollPane(scheduleTable);
		scrollPane.setSize(786, 390);
		add(scrollPane);
		

		scheduleTable.setSize(786, 390);
		scheduleTable.setRowHeight(30);
		scheduleTable.setFillsViewportHeight(true);
		scheduleTable.setCellSelectionEnabled(true);
		scheduleTable.getTableHeader().setBackground(Color.lightGray);
		scheduleTable.getTableHeader().setReorderingAllowed(false);
		
		// 셀 너비 수정을 할 땐 모델을 얻어와야한다.
		// 너비가 786인데 패널 안에 딱 떨어지는 값으로 컬럼들을 채우기 위함...
		for (int i = 0; i <= 7; i++) {
			scheduleTable.getColumnModel().getColumn(i).setMaxWidth(786/8);
			scheduleTable.getColumnModel().getColumn(i).setMinWidth(786/8);
		}
		
		// 셀 데이터 가운데 정렬
		DefaultTableCellRenderer tableCell = new DefaultTableCellRenderer();
		tableCell.setHorizontalAlignment(SwingConstants.CENTER);
		TableColumnModel CellModel = scheduleTable.getColumnModel();
		for(int i = 0;i < CellModel.getColumnCount(); i++) {
			CellModel.getColumn(i).setCellRenderer(tableCell);			
		}
		

		scheduleTable.setFillsViewportHeight(true);
		scheduleTable.setSize(786, 390);
		
	}
}
