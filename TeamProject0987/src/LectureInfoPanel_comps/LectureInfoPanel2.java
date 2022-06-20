package LectureInfoPanel_comps;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;

// 수강평 Panel 이 될 JPanel 입니다.

public class LectureInfoPanel2 extends JPanel {
	public LectureInfoPanel2() {
		setBounds(199, 371, 786, 390);
		setLayout(null);
		
		String[] headings = {"id", "uploadDate", "comments"};
		Object[][] data = {
				{"kevinj0695", "22-06-10", "별 만점 강의입니다. 좋아요"},
				{"kimdo0987", "22-06-17", "도움이 많이 되었습니다. 감사합니다."},
				{"intacka", "22-06-13", "맘에 드는 강의 오랜만이네요"},
				{"a9347", "22-06-20", "잘봤습니다. 감사합니다"},
				{"kimkt1002", "22-06-18", "도움이 되는 강의입니다."}
		};
				
		JTable commentsTable = new JTable(data, headings);
		JScrollPane scrollPane = new JScrollPane(commentsTable);
		scrollPane.setSize(786, 390);
		add(scrollPane);
		
		commentsTable.setSize(786, 390);
	}
	
}
