package LectureInfoPanel_comps;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

// 상세정보 버튼을 누르면 등장하는 패널입니다.

public class LectureInfoPanel1 extends JPanel {
	
	public static JTextArea detailInfoLabel = new JTextArea();
	public LectureInfoPanel1() {

		setBounds(199, 371, 786, 390);
		setLayout(null);
		detailInfoLabel.setEditable(false);
		detailInfoLabel.setLineWrap(true);
		detailInfoLabel.setBackground(Color.WHITE);
		detailInfoLabel.setOpaque(true);
		detailInfoLabel.setFont(new Font("굴림", Font.PLAIN, 24));
		detailInfoLabel.setBounds(0, 0, 786, 390);
		add(detailInfoLabel);

		setVisible(false);
	}

}
