package panels;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import LectureInfoPanel_comps.LectureInfoPanel1;
import LectureInfoPanel_comps.LectureInfoPanel2;
import LectureInfoPanel_comps.LectureInfoPanel3;
import LectureInfoPanel_comps.LectureInfoTabButton;
import buttons.GoToButton;

public class LectureInfoPanel extends JPanel {
	
	public static JLabel lectureNameLabel = new JLabel();
	public static JLabel lectureImageLabel = new JLabel(LectureSearchPanel.lectureImageCategory);
	public static CardLayout cardLayout1 = new CardLayout();
	public static JPanel cardLayoutPanel = new JPanel();
	
	public static LectureInfoPanel1 lectureInfoPanel1 = new LectureInfoPanel1();
	public static LectureInfoPanel2 lectureInfoPanel2 = new LectureInfoPanel2(99);
	public static LectureInfoPanel3 lectureInfoPanel3 = new LectureInfoPanel3();
	
	public LectureInfoPanel() {
		setBounds(0, 0, 1200, 800);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(199, 117, 785, 170);
		add(panel);
		panel.setLayout(null);
		
		JButton enrolmentBtn = new JButton("장바구니 담기");
		enrolmentBtn.setBackground(Color.ORANGE);
		enrolmentBtn.setBounds(226, 101, 508, 50);
		panel.add(enrolmentBtn);
		
		lectureNameLabel.setOpaque(true);
		lectureNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lectureNameLabel.setBackground(Color.WHITE);
		lectureNameLabel.setBounds(226, 21, 508, 70);
		panel.add(lectureNameLabel);
		
		
		lectureImageLabel.setOpaque(true);
		lectureImageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lectureImageLabel.setBackground(Color.PINK);
		lectureImageLabel.setBounds(46, 21, 168, 130);
		panel.add(lectureImageLabel);
		
		GoToButton mainBtn = new GoToButton("메인");
		mainBtn.setFont(new Font("굴림", Font.PLAIN, 15));
		mainBtn.setBackground(Color.WHITE);
		mainBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MainPanel.lectureInfoPanel.setVisible(false);
				
			}
		});
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
		
		////////////////////////////////////////////////
		
		cardLayoutPanel.setBounds(199, 371, 786, 390);
		add(cardLayoutPanel);
		
		cardLayoutPanel.setLayout(cardLayout1);
		
		cardLayoutPanel.add(lectureInfoPanel1, "상세정보");
		cardLayoutPanel.add(lectureInfoPanel2, "수강평");///////////////////
		cardLayoutPanel.add(lectureInfoPanel3, "강의 시간표");
		
		//////////////////////////////////////////////////
		
		LectureInfoTabButton detailInfoBtn = new LectureInfoTabButton("상세정보");
		detailInfoBtn.setBounds(199, 297, 261, 62);
		add(detailInfoBtn);
		
		LectureInfoTabButton commentsBtn = new LectureInfoTabButton("수강평");
		commentsBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lectureInfoPanel2 = new LectureInfoPanel2(LectureSearchPanel.currLectureId); ///////////	
				cardLayoutPanel.add(lectureInfoPanel2, "수강평");
				}
		});
		commentsBtn.setBounds(460, 297, 261, 62);
		add(commentsBtn);
		
		LectureInfoTabButton scheduleBtn = new LectureInfoTabButton("강의 시간표");
		scheduleBtn.setBounds(723, 297, 261, 62);
		add(scheduleBtn);
		setVisible(false);
	}
	
//	public static void main(String[] args) {
//		JFrame frame = new JFrame();
//		frame.getContentPane().add(new LectureInfoPanel());
//		frame.setBounds(100, 100, 1200, 800);
//		frame.setLocationRelativeTo(null);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setVisible(true);
//	}
}
