package LectureInfoPanel_comps;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

// 상세정보 버튼을 누르면 등장하는 패널입니다.

public class LectureInfoPanel1 extends JPanel {
	public LectureInfoPanel1() {
		setBounds(199, 371, 786, 390);
		setLayout(null);
		
		JLabel detailInfoLabel = new JLabel("<html><body>멀티미디어 콘텐츠 제작에 필요한 저작도구를 사용하여<br>"
				+ "디지털콘텐츠, 영상콘텐츠, 음향콘텐츠, 프로그래밍 콘텐츠<br>"
				+ "제작 훈련을 실시하여 관련 지식, 기술, 태도를 갖춘<br>"
				+ "창의적인 멀티미디어콘텐츠 제작 전문 인재 양성을<br>"
				+ "목표로 훈련을 한다.<br>"
				+ "- 멀티미디어콘텐츠 제작 분야 구직 희망자를 대상으로<br>"
				+ "훈련하며 수료 후 관련분야로 성공취업을 목표로 한다."
				+ "</body></html>");
		detailInfoLabel.setBackground(Color.WHITE);
		detailInfoLabel.setOpaque(true);
		detailInfoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		detailInfoLabel.setFont(new Font("굴림", Font.PLAIN, 24));
		detailInfoLabel.setBounds(0, 0, 786, 390);
		add(detailInfoLabel);
	}
}
