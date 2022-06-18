package panels;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LectureInfoPanel extends JPanel {
	public LectureInfoPanel() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(199, 117, 785, 170);
		add(panel);
		panel.setLayout(null);
		
		JButton enrolmentBtn = new JButton("수강 신청하기");
		enrolmentBtn.setBackground(Color.ORANGE);
		enrolmentBtn.setBounds(226, 101, 433, 50);
		panel.add(enrolmentBtn);
		
		JButton heartBtn = new JButton("♡");
		heartBtn.setBounds(671, 101, 63, 49);
		panel.add(heartBtn);
		
		JLabel lectureNameLabel = new JLabel("강의명");
		lectureNameLabel.setOpaque(true);
		lectureNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lectureNameLabel.setBackground(Color.WHITE);
		lectureNameLabel.setBounds(226, 21, 508, 70);
		panel.add(lectureNameLabel);
		
		JLabel lectureImageLabel = new JLabel("이미지");
		lectureImageLabel.setOpaque(true);
		lectureImageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lectureImageLabel.setBackground(Color.PINK);
		lectureImageLabel.setBounds(46, 21, 168, 130);
		panel.add(lectureImageLabel);
		
		JButton mainBtn = new JButton("메인");
		mainBtn.setFont(new Font("굴림", Font.PLAIN, 15));
		mainBtn.setBackground(Color.WHITE);
		mainBtn.setBounds(199, 39, 111, 68);
		add(mainBtn);
		
		JLabel stateLabel = new JLabel("강의 검색");
		stateLabel.setFont(new Font("굴림", Font.PLAIN, 15));
		stateLabel.setOpaque(true);
		stateLabel.setHorizontalAlignment(SwingConstants.CENTER);
		stateLabel.setBackground(Color.WHITE);
		stateLabel.setBounds(323, 39, 554, 68);
		add(stateLabel);
		
		JButton myInfoBtn = new JButton("내 정보");
		myInfoBtn.setFont(new Font("굴림", Font.PLAIN, 15));
		myInfoBtn.setBackground(Color.WHITE);
		myInfoBtn.setBounds(889, 39, 97, 68);
		add(myInfoBtn);
		
		JPanel cardLayoutPanel = new JPanel();
		cardLayoutPanel.setBounds(199, 371, 786, 390);
		add(cardLayoutPanel);
		cardLayoutPanel.setLayout(new CardLayout(0, 0));
		
		JPanel lectureInfoPanel1 = new JPanel();
		cardLayoutPanel.add(lectureInfoPanel1, "name_35558420985300");
		lectureInfoPanel1.setLayout(null);
		
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
		lectureInfoPanel1.add(detailInfoLabel);
		
		JPanel lectureInfoPanel2 = new JPanel();
		lectureInfoPanel2.setBackground(Color.PINK);
		cardLayoutPanel.add(lectureInfoPanel2, "name_35579400515800");
		lectureInfoPanel2.setLayout(null);
		
		JPanel lectureInfoPanel3 = new JPanel();
		lectureInfoPanel3.setBackground(Color.ORANGE);
		cardLayoutPanel.add(lectureInfoPanel3, "name_35581204671200");
		lectureInfoPanel3.setLayout(null);
		
		JButton detailInfoBtn = new JButton("상세정보");
		detailInfoBtn.setBounds(199, 297, 261, 62);
		add(detailInfoBtn);
		
		JButton commentsBtn = new JButton("수강평");
		commentsBtn.setBounds(460, 297, 261, 62);
		add(commentsBtn);
		
		JButton scheduleBtn = new JButton("강의 시간표");
		scheduleBtn.setBounds(723, 297, 261, 62);
		add(scheduleBtn);
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.getContentPane().add(new LectureInfoPanel());
		frame.setBounds(100, 100, 1200, 800);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
