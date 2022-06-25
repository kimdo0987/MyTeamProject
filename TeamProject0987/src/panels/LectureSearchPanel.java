package panels;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import buttons.GoToButton;
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

			GoToButton mainBtn = new GoToButton("메인");
			mainBtn.setBounds(12, 10, 106, 55);
			mainBtn.setBackground(Color.WHITE);
			add(mainBtn);

			TopLabel toplabel = new TopLabel("강의 찾기");
			add(toplabel);

			JButton infoBtn = new JButton("내정보");
			infoBtn.setBackground(Color.white);
			infoBtn.setBounds(1046, 10, 106, 55);
			add(infoBtn);

			HintTextField searchField = new HintTextField("검색어를 입력해주세요");
			searchField.setColumns(10);
			searchField.setBounds(180, 114, 590, 55);
			
			add(searchField);

			JPanel categoryPanel = new JPanel();
			categoryPanel.setBounds(180, 178, 710, 153);
			add(categoryPanel);
			categoryPanel.setLayout(new GridLayout(2, 9));

			
			add(lectureCntLabel);
			lectureCntLabel.setBounds(180,295,500,100);
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

			setVisible(false);

	}
//	public static void main(String[] args) {
//		
//		JFrame frame = new JFrame();
//		frame.add(new LectureSearchPanel());
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setBounds(0, 0, 1200, 800);
//		frame.setLocationRelativeTo(null);
//		frame.setVisible(true);
//	}

}
