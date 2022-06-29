package panels;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import buttons.GoToButton;
import buttons.MypageButton;
import database.LectureTable;
import database.LectureTable2;
import database.LectureTable3;

public class LectureSearchPanel extends ImagePanel {

	public static String lectureImageCategory;
	public static int currLectureId; //////////
	public static int lectureCnt;
	public static JLabel lectureCntLabel = new JLabel("총 100개가 검색되었습니다");
	public LectureSearchPanel() {
		
		ImageIcon icon = new ImageIcon("images/homeBtn.png");
		
		Image img = icon.getImage();
		// 창의 사이즈인 500,500에 맞춰서 이미지를 변경
		Image changeImg = img.getScaledInstance(80, 80, Image.SCALE_SMOOTH);
		ImageIcon changeIcon = new ImageIcon(changeImg);
			
			setBounds(0, 0, 1200, 800);
			setLayout(null);

			int cnt = 0;

			GoToButton mainBtn = new GoToButton("메인");
			mainBtn.setFont(new Font("굴림", Font.PLAIN, 0));
			mainBtn.setIcon(new ImageIcon("images/homeBtn.png"));
			mainBtn.setBorderPainted(false);
			mainBtn.setBounds(1037, 38, 46, 44);
			mainBtn.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					MainPanel.lectureInfoPanel.setVisible(false);
					
				}
			});
			mainBtn.setBackground(Color.WHITE);
			add(mainBtn);

			MypageButton myInfoBtn = new MypageButton("마이페이지");
			myInfoBtn.setFont(new Font("굴림", Font.PLAIN, 0));
			myInfoBtn.setIcon(new ImageIcon("images/infoBtn.png"));
			myInfoBtn.setBorderPainted(false);
			myInfoBtn.setBackground(Color.WHITE);
			
//			myInfoBtn.addActionListener(new ActionListener() { /////////////////////
//				
//				@Override
//				public void actionPerformed(ActionEvent e) {
//					MainPanel.lectureInfoPanel.setVisible(false);
//					
//				}
//			});
			myInfoBtn.setBounds(1104, 38, 46, 44);
			add(myInfoBtn);
			
			JPanel lectureListPanel = new JPanel();
			lectureListPanel.setBounds(230, 423, 730, 300);
			CardLayout layMng = new CardLayout();
			lectureListPanel.setLayout(layMng);
			add(lectureListPanel);
			JButton allCategoryBtn = new JButton("ALL");
			allCategoryBtn.setFont(new Font("Gulim", Font.PLAIN, 0));
			allCategoryBtn.setSize(75,80);
			
			allCategoryBtn.setIcon(new ImageIcon("images/all.png"));
			allCategoryBtn.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.println(allCategoryBtn.getText());
					LectureTable lecListPanel = new LectureTable(allCategoryBtn.getText());
					lectureListPanel.add(lecListPanel,allCategoryBtn.getText());
					layMng.show(lectureListPanel,allCategoryBtn.getText());
					
					
				}
			});
			JButton recommendBtn = new JButton("강의추천");
			recommendBtn.setIcon(new ImageIcon("images/recommendBtn.png"));
			recommendBtn.setFont(new Font("Gulim", Font.PLAIN, 0));
			recommendBtn.setBounds(309, 129, 46, 44);
			recommendBtn.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					
					LectureTable3 lecListPanel = new LectureTable3();
					lectureListPanel.add(lecListPanel,recommendBtn.getText());
					layMng.show(lectureListPanel,recommendBtn.getText());

				}
			});
			recommendBtn.setBackground(Color.WHITE);
			recommendBtn.setBorderPainted(false);
			add(recommendBtn);
			
			HintTextField searchField = new HintTextField("검색어를 입력해주세요");
			searchField.addKeyListener(new KeyAdapter() {
				
				
				@Override
				public void keyPressed(KeyEvent e) {
					 if(e.getKeyCode() == KeyEvent.VK_ENTER){
						 LectureTable2 lecListPanel2 = new LectureTable2(searchField.getText());
							lectureListPanel.add(lecListPanel2,searchField.getText());
							layMng.show(lectureListPanel,searchField.getText());
							searchField.setText("");
					 }
				}
			});
			searchField.setColumns(10);
			searchField.setBounds(367, 129, 470, 62);
			add(searchField);

			ImagePanel categoryPanel = new ImagePanel();
			categoryPanel.setBounds(367, 214, 470, 160);
			add(categoryPanel);
			categoryPanel.setLayout(new GridLayout(2, 6));
			lectureCntLabel.setFont(new Font("배달의민족 도현", Font.BOLD, 18));
			
			lectureCntLabel.setForeground(Color.WHITE);
			
			
			add(lectureCntLabel);
			lectureCntLabel.setBounds(230,384,475,29);
			
			allCategoryBtn.setBackground(new Color(255, 255, 255));
			categoryPanel.add(allCategoryBtn);
			
			lectureListPanel.add(new LectureTable("ALL"));
			
			JButton searchBtn = new JButton("검색");
			searchBtn.setFont(new Font("굴림", Font.PLAIN, 0));
			searchBtn.setIcon(new ImageIcon("images/searchBtn.png"));
			searchBtn.setBorderPainted(false);
			searchBtn.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					LectureTable2 lecListPanel2 = new LectureTable2(searchField.getText());
					lectureListPanel.add(lecListPanel2,searchField.getText());
					layMng.show(lectureListPanel,searchField.getText());
					searchField.setText("");
				}
			});
			searchBtn.setBounds(849, 129, 46, 44);
			searchBtn.setBackground(Color.WHITE);
			add(searchBtn);
			
			JLabel lblTeamname = new JLabel("강의검색");
			lblTeamname.setFont(new Font("배달의민족 도현", Font.BOLD, 39));
			lblTeamname.setForeground(Color.WHITE);
			lblTeamname.setBounds(523, 29, 170, 62);
			add(lblTeamname);
			
			JLabel lblNewLabel = new JLabel(" 강의추천");
			lblNewLabel.setForeground(new Color(255, 255, 255));
			lblNewLabel.setFont(new Font("배달의민족 도현", Font.PLAIN, 14));
			lblNewLabel.setBounds(297, 175, 67, 29);
			add(lblNewLabel);
			
			JLabel lblNewLabel_1 = new JLabel("  검색하기");
			lblNewLabel_1.setForeground(Color.WHITE);
			lblNewLabel_1.setFont(new Font("배달의민족 도현", Font.PLAIN, 14));
			lblNewLabel_1.setBounds(840, 175, 67, 29);
			add(lblNewLabel_1);
			
			JLabel lblNewLabel_2 = new JLabel("메인페이지");
			lblNewLabel_2.setForeground(Color.WHITE);
			lblNewLabel_2.setFont(new Font("배달의민족 도현", Font.PLAIN, 14));
			lblNewLabel_2.setBounds(1025, 90, 67, 29);
			add(lblNewLabel_2);
			
			JLabel lblNewLabel_2_1 = new JLabel("내정보");
			lblNewLabel_2_1.setForeground(Color.WHITE);
			lblNewLabel_2_1.setFont(new Font("배달의민족 도현", Font.PLAIN, 14));
			lblNewLabel_2_1.setBounds(1107, 90, 46, 29);
			add(lblNewLabel_2_1);
			
			for (int i = 0; i < 11; ++i) {
				LectureCategoryButton cateBtn = new LectureCategoryButton(i);
				categoryPanel.add(cateBtn);
				cateBtn.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						System.out.println(cateBtn.getText());
						LectureTable lecListPanel = new LectureTable(cateBtn.getText());
						lectureListPanel.add(lecListPanel,cateBtn.getText());
						layMng.show(lectureListPanel,cateBtn.getText());

					}
				});

			}



	}

}
