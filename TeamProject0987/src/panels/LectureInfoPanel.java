package panels;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import LectureInfoPanel_comps.LectureInfoPanel1;
import LectureInfoPanel_comps.LectureInfoPanel2;
import LectureInfoPanel_comps.LectureInfoPanel3;
import LectureInfoPanel_comps.LectureInfoTabButton;
import buttons.GoToButton;
import buttons.MypageButton;
import buttons.WishButton;

public class LectureInfoPanel extends ImagePanel {
	
	public static JLabel lectureNameLabel = new JLabel();
	public static CardLayout cardLayout1 = new CardLayout();
	public static JPanel cardLayoutPanel = new ImagePanel();
	public static JLabel rateAvgLabel = new JLabel();
	public static String lectureTime = "";
	public static String lectureCategory = "";
	public static ImagePanel imagePanel = new ImagePanel();
	
	public static LectureInfoPanel1 lectureInfoPanel1 = new LectureInfoPanel1();
	public static LectureInfoPanel2 lectureInfoPanel2 = new LectureInfoPanel2(99);
	public static LectureInfoPanel3 lectureInfoPanel3 = new LectureInfoPanel3(lectureTime);
	public static JLabel lectureImageLabel = new JLabel();
	
	public LectureInfoPanel() {
		setBounds(0, 0, 1200, 800);
		setLayout(null);
		GoToButton mainBtn = new GoToButton("메인"); ///////////////

		mainBtn.setFont(new Font("굴림", Font.PLAIN, 0));
		mainBtn.setIcon(new ImageIcon("images/homeBtn.png"));
		mainBtn.setRolloverIcon(new ImageIcon("images/homeBtn2.png"));
		mainBtn.setBorderPainted(false);
		mainBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MainPanel.lectureInfoPanel.setVisible(false);
				imagePanel.removeAll();
				
			}
		});
		mainBtn.setBackground(Color.WHITE);
		mainBtn.setBounds(40, 29, 95, 95);
		add(mainBtn);
		
		rateAvgLabel.setFont(new Font("배달의민족 도현", Font.PLAIN, 30));
		rateAvgLabel.setForeground(Color.WHITE);
		rateAvgLabel.setHorizontalAlignment(SwingConstants.CENTER);
		rateAvgLabel.setBounds(478, 366, 226, 30);
		add(rateAvgLabel);
		
		MypageButton myInfoBtn = new MypageButton("마이페이지");
		myInfoBtn.setFont(new Font("굴림", Font.PLAIN, 0));
		myInfoBtn.setIcon(new ImageIcon("images/infoBtn.png"));
		myInfoBtn.setRolloverIcon(new ImageIcon("images/infoBtn2.png"));
		myInfoBtn.setBorderPainted(false);
		myInfoBtn.setBackground(Color.WHITE);
		myInfoBtn.setBounds(160, 29, 95, 95);
		add(myInfoBtn);
//		myInfoBtn.addActionListener(new ActionListener() { /////////////////////   
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				MainPanel.lectureInfoPanel.setVisible(false);
//				
//			}
//		});
		
		
		////////////////////////////////////////////////
		
		cardLayoutPanel.setBounds(199, 406, 786, 337);
		add(cardLayoutPanel);
		
		cardLayoutPanel.setLayout(cardLayout1);
		lectureInfoPanel1.detailInfoLabel.setLocation(0, 0);
		lectureInfoPanel1.detailInfoLabel.setSize(786, 372);
		
		cardLayoutPanel.add(lectureInfoPanel1, "상세정보");
		cardLayoutPanel.add(lectureInfoPanel2, "수강평");///////////////////
		cardLayoutPanel.add(lectureInfoPanel3, "강의 시간표");
		
		//////////////////////////////////////////////////
		
		LectureInfoTabButton detailInfoBtn = new LectureInfoTabButton("상세정보");
		detailInfoBtn.setFont(new Font("굴림", Font.PLAIN, 0));
		detailInfoBtn.setIcon(new ImageIcon("images/상세정보.png"));
		detailInfoBtn.setRolloverIcon(new ImageIcon("images/상세정보2.png"));
		detailInfoBtn.setBorderPainted(false);
		detailInfoBtn.setBounds(199, 276, 226, 62);
		detailInfoBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				rateAvgLabel.setText("");
			}
		});
		add(detailInfoBtn);
		
		LectureInfoTabButton commentsBtn = new LectureInfoTabButton("수강평");
		commentsBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lectureInfoPanel2 = new LectureInfoPanel2(LectureSearchPanel.currLectureId); ///////////	
				cardLayoutPanel.add(lectureInfoPanel2, "수강평");
				}
		});
		
		commentsBtn.setFont(new Font("굴림", Font.PLAIN, 0));
		commentsBtn.setIcon(new ImageIcon("images/강의수강평.png"));
		commentsBtn.setRolloverIcon(new ImageIcon("images/강의수강평2.png"));
		commentsBtn.setBorderPainted(false);
		commentsBtn.setBounds(478, 276, 226, 62);
		add(commentsBtn);
		
		LectureInfoTabButton scheduleBtn = new LectureInfoTabButton("강의 시간표");
		scheduleBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout1.show(cardLayoutPanel, "상세정보");
				lectureInfoPanel3 = new LectureInfoPanel3(lectureTime); ///////////	
				cardLayoutPanel.add(lectureInfoPanel3, "강의 시간표");
				rateAvgLabel.setText("");
				System.out.println(lectureCategory);
			}
		});
		scheduleBtn.setBounds(756, 276, 226, 62);
		scheduleBtn.setFont(new Font("굴림", Font.PLAIN, 0));
		scheduleBtn.setIcon(new ImageIcon("images/강의시간표.png"));
		scheduleBtn.setRolloverIcon(new ImageIcon("images/강의시간표2.png"));
		scheduleBtn.setBorderPainted(false);
		
		add(scheduleBtn);
		
		
		imagePanel.setBounds(275,140,95,95);
		add(imagePanel);
		
		
		
//		lectureImageLabel.setOpaque(true);
//		lectureImageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		lectureNameLabel.setForeground(Color.WHITE);
		lectureNameLabel.setFont(new Font("배달의민족 도현", Font.PLAIN, 20));
		lectureNameLabel.setBounds(412, 140, 498, 42);
		add(lectureNameLabel);
		
//		lectureNameLabel.setOpaque(true);
//		lectureNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		WishButton enrolmentBtn = new WishButton();
		enrolmentBtn.setFont(new Font("굴림", Font.PLAIN, 0));
		enrolmentBtn.setIcon(new ImageIcon("images/wishBtn.png"));
		enrolmentBtn.setRolloverIcon(new ImageIcon("images/wishBtn2.png"));
		enrolmentBtn.setBorderPainted(false);
		enrolmentBtn.setBounds(383, 191, 498, 50);
		add(enrolmentBtn);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBackground(Color.WHITE);
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setBounds(199, 254, 786, 3);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("강의정보");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("배달의민족 도현", Font.BOLD, 36));
		lblNewLabel.setBounds(523, 28, 154, 70);
		add(lblNewLabel);
	
	}
}
