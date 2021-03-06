package LectureInfoPanel_comps;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.util.HashMap;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;


// 강의 시간표 Panel 이 될 JPanel 입니다

public class LectureInfoPanel3 extends JPanel {

	HashMap<String,Object[][]>timeTableMap = new HashMap<>();
	
		Object[][]dataA ={
				{"시간표", "A형", "", "", "종일반", "", "", ""},
				{"09:00", "", "강의", "강의", "강의", "강의", "강의", ""},
				{"10:00", "", "강의", "강의", "강의", "강의", "강의", ""},
				{"11:00", "", "강의", "강의", "강의", "강의", "강의", ""},
				{"12:00", "", "강의", "강의", "강의", "강의", "강의", ""},
				{"13:00", "", "점심", "점심", "점심", "점심", "점심", ""},
				{"14:00", "", "강의", "강의", "강의", "강의", "강의", ""},
				{"15:00", "", "강의", "강의", "강의", "강의", "강의", ""},
				{"16:00", "", "강의", "강의", "강의", "강의", "강의", ""},
				{"17:00", "", "강의", "강의", "강의", "강의", "강의", ""}
				};

	
		Object[][]dataB = {
				{"시간표", "B형", "", "", "오전반", "", "", ""},
				{"09:00", "", "강의", "강의", "강의", "강의", "강의", ""},
				{"10:00", "", "강의", "강의", "강의", "강의", "강의", ""},
				{"11:00", "", "강의", "강의", "강의", "강의", "강의", ""},
				{"12:00", "", "강의", "강의", "강의", "강의", "강의", ""},
				{"13:00", "", "점심", "점심", "점심", "점심", "점심", ""},
				{"14:00", "", "", "", "", "", "", ""},
				{"15:00", "", "", "", "", "", "", ""},
				{"16:00", "", "", "", "", "", "", ""},
				{"17:00", "", "", "", "", "", "", ""}
				};


		Object[][]dataC =  {
				{"시간표", "C형", "", "", "오후반", "", "", ""},
				{"09:00", "", "", "", "", "", "", ""},
				{"10:00", "", "", "", "", "", "", ""},
				{"11:00", "", "", "", "", "", "", ""},
				{"12:00", "", "강의", "강의", "강의", "강의", "강의", ""},
				{"13:00", "", "점심", "점심", "점심", "점심", "점심", ""},
				{"14:00", "", "강의", "강의", "강의", "강의", "강의", ""},
				{"15:00", "", "강의", "강의", "강의", "강의", "강의", ""},
				{"16:00", "", "강의", "강의", "강의", "강의", "강의", ""},
				{"17:00", "", "강의", "강의", "강의", "강의", "강의", ""}
				};


		Object[][]dataD = {
				{"시간표", "D형", "", "", "월수금반", "", "", ""},
				{"09:00", " ", "강의", " ", "강의", " ", "강의", " "},
				{"10:00", " ", "강의", " ", "강의", " ", "강의", " "},
				{"11:00", " ", "강의", " ", "강의", " ", "강의", " "},
				{"12:00", " ", "강의", " ", "강의", " ", "강의", " "},
				{"13:00", " ", "점심", " ", "점심", " ", "점심", " "},
				{"14:00", " ", "강의", " ", "강의", " ", "강의", " "},
				{"15:00", " ", "강의", " ", "강의", " ", "강의", " "},
				{"16:00", " ", "강의", " ", "강의", " ", "강의", " "},
				{"17:00", " ", "강의", " ", "강의", " ", "강의", " "},
				};

		Object[][]dataE = {
				{"시간표", "E형", "", "", "화목반", "", "", ""},
				{"09:00", " ", "", "강의", "", "강의", "", " "},
				{"10:00", " ", "", "강의", "", "강의", "", " "},
				{"11:00", " ", "", "강의", "", "강의", "", " "},
				{"12:00", " ", "", "강의", "", "강의", "", " "},
				{"13:00", " ", "", "점심", "", "점심", "", " "},
				{"14:00", " ", "", "강의", "", "강의", "", " "},
				{"15:00", " ", "", "강의", "", "강의", "", " "},
				{"16:00", " ", "", "강의", "", "강의", "", " "},
				{"17:00", " ", "", "강의", "", "강의", "", " "},
				};

		
	
	public LectureInfoPanel3(String lectureTime) {
		timeTableMap.put("A", dataA);
		timeTableMap.put("B", dataB);
		timeTableMap.put("C", dataC);
		timeTableMap.put("D", dataD);
		timeTableMap.put("E", dataE);
		timeTableMap.put("", dataA);
		setBounds(199, 371, 786, 390);
		setLayout(null);
		
		String[] headings = {" ", "일", "월", "화", "수", "목", "금", "토"};
		
		

		JTable scheduleTable = new JTable(timeTableMap.get(lectureTime), headings) {
			// 익명내부클래스로 특정 row에서 색깔 바꿈
			public Component prepareRenderer(
					TableCellRenderer renderer, int row, int column) 
			{
				Component c = super.prepareRenderer(renderer, row, column);
				if(!c.getBackground().equals(getSelectionBackground())) {
					if (row == 5) {
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
		
		
		//테이블 폰트 설정
		scheduleTable.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
		
		//컬럼명 폰트 설정
		JTableHeader tableHeader = scheduleTable.getTableHeader();
		Font headerFont = new Font("맑은 고딕", Font.PLAIN, 17);
		tableHeader.setFont(headerFont);
		
		
		
		
		JScrollPane scrollPane = new JScrollPane(scheduleTable);
		scrollPane.setSize(786, 390);
		add(scrollPane);
		
		scheduleTable.setEnabled(false);
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
