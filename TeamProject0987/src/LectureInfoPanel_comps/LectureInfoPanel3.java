package LectureInfoPanel_comps;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

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
		
		JTable scheduleTable = new JTable(data, headings);
		JScrollPane scrollPane = new JScrollPane(scheduleTable);
		scrollPane.setSize(786, 390);
		add(scrollPane);
		
		scheduleTable.setFillsViewportHeight(true);
		scheduleTable.setSize(786, 390);
		
	}
}
