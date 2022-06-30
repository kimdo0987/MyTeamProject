package LectureInfoPanel_comps;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JTextArea;

import panels.ImagePanel;

// 상세정보 버튼을 누르면 등장하는 패널입니다.

public class LectureInfoPanel1 extends ImagePanel {
	
	public static JTextArea detailInfoLabel = new JTextArea();
	public LectureInfoPanel1() {

		setBounds(199, 371, 786, 390);
		setLayout(null);
		detailInfoLabel.setEditable(false);
		detailInfoLabel.setLineWrap(true);
		detailInfoLabel.setOpaque(true);
		detailInfoLabel.setFont(new Font("배달의민족 도현", Font.PLAIN, 30));
		detailInfoLabel.setForeground(Color.WHITE);
		detailInfoLabel.setBounds(0, 0, 786, 390);
		add(detailInfoLabel);

	}

}
