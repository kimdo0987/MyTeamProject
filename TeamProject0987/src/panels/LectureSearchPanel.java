package panels;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import buttons.GoToButton;
import buttons.MypageButton;
import database.LectureTable;
import database.LectureTable2;
import labels.TopLabel;

public class LectureSearchPanel extends JPanel {

	public static String lectureImageCategory;
	public static int currLectureId; //////////
	public static int lectureCnt;
	public static JLabel lectureCntLabel = new JLabel("총 100개가 검색되었습니다");
	public LectureSearchPanel() {

			
			setBounds(0, 0, 1200, 800);
			setLayout(null);

			int cnt = 0;

			GoToButton mainBtn = new GoToButton("메인"); ////////////////
			mainBtn.setBounds(12, 10, 106, 55);
			
			mainBtn.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					MainPanel.lectureInfoPanel.setVisible(false);
					
				}
			});
			mainBtn.setBackground(Color.WHITE);
			add(mainBtn);

			TopLabel toplabel = new TopLabel("강의 찾기");
			add(toplabel);

			MypageButton myInfoBtn = new MypageButton("마이페이지");	
			myInfoBtn.setBackground(Color.WHITE);
			
//			myInfoBtn.addActionListener(new ActionListener() { /////////////////////
//				
//				@Override
//				public void actionPerformed(ActionEvent e) {
//					MainPanel.lectureInfoPanel.setVisible(false);
//					
//				}
//			});
			myInfoBtn.setBounds(889, 39, 106, 55);
			add(myInfoBtn);
			
			JPanel lectureListPanel = new JPanel();
			lectureListPanel.setBounds(176, 365, 730, 300);
			CardLayout layMng = new CardLayout();
			lectureListPanel.setLayout(layMng);
			lectureListPanel.setBackground(Color.WHITE);
			add(lectureListPanel);
			JButton allCategoryBtn = new JButton("ALL");
			allCategoryBtn.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.println(allCategoryBtn.getText());
					LectureTable lecListPanel = new LectureTable(allCategoryBtn.getText());
					lectureListPanel.add(lecListPanel,allCategoryBtn.getText());
					layMng.show(lectureListPanel,allCategoryBtn.getText());
					
					
				}
			});
			
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
			searchField.setBounds(180, 114, 590, 55);
			add(searchField);

			JPanel categoryPanel = new JPanel();
			categoryPanel.setBounds(180, 178, 710, 153);
			add(categoryPanel);
			categoryPanel.setLayout(new GridLayout(2, 9));

			
			add(lectureCntLabel);
			lectureCntLabel.setBounds(180,295,500,100);
			
			allCategoryBtn.setBackground(Color.WHITE);
			categoryPanel.add(allCategoryBtn);
			
			lectureListPanel.add(new LectureTable("ALL"));
			
			JButton searchBtn = new JButton("검색");
			searchBtn.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					LectureTable2 lecListPanel2 = new LectureTable2(searchField.getText());
					lectureListPanel.add(lecListPanel2,searchField.getText());
					layMng.show(lectureListPanel,searchField.getText());
					searchField.setText("");
				}
			});
			searchBtn.setBounds(780, 114, 110, 55);
			searchBtn.setBackground(Color.WHITE);
			add(searchBtn);
			
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
