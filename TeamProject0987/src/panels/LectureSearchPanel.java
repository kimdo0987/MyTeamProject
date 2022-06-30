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
	
	private static String [] imagePath = {
			"개발도구.png","게임개발.png","프론트엔드.png",
			"데브옵스.png","데스크톱.png",
			"데이터베이스.png","모바일.png","백엔드.png",
			"알고리즘.png","임베디드.png","교양.png"
	};
	
	private static String [] imagePath2 = {
			"개발도구2.png","게임개발2.png","프론트엔드2.png",
			"데브옵스2.png","데스크톱2.png",
			"데이터베이스2.png","모바일2.png","백엔드2.png",
			"알고리즘2.png","임베디드2.png","교양2.png"
	};

	public static int currLectureId; //////////
	public static int lectureCnt;
	public static JLabel lectureCntLabel = new JLabel("총 100개가 검색되었습니다");
	public LectureSearchPanel() {
		
		JButton[] buttonArr = new JButton[13];
		// 0~10번-> 카테고리버튼, 11번-> all버튼, 12번-> 추천강의버튼 

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
		mainBtn.setRolloverIcon(new ImageIcon("images/homeBtn2.png"));
		mainBtn.setBorderPainted(false);
		mainBtn.setBounds(40, 29, 95, 95);
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
		myInfoBtn.setRolloverIcon(new ImageIcon("images/infoBtn2.png"));
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
		myInfoBtn.setBounds(160, 29, 95, 95);
		add(myInfoBtn);

		JPanel lectureListPanel = new JPanel();
		lectureListPanel.setBounds(230, 423, 730, 300);
		CardLayout layMng = new CardLayout();
		lectureListPanel.setLayout(layMng);
		add(lectureListPanel);
		JButton allCategoryBtn = new JButton("ALL");
		allCategoryBtn.setRolloverIcon(new ImageIcon("images/all2.png"));
		allCategoryBtn.setFont(new Font("Gulim", Font.PLAIN, 0));
		allCategoryBtn.setSize(75, 80);

		allCategoryBtn.setIcon(new ImageIcon("images/all.png"));
		allCategoryBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(allCategoryBtn.getText());
				LectureTable lecListPanel = new LectureTable(allCategoryBtn.getText());
				lectureListPanel.add(lecListPanel, allCategoryBtn.getText());
				layMng.show(lectureListPanel, allCategoryBtn.getText());

			}
		});
		
		allCategoryBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				allCategoryBtn.setIcon(new ImageIcon("images/all2.png"));
				allCategoryBtn.setFont(new Font("", Font.BOLD, 0));
				
				for (int i = 0; i < buttonArr.length; ++i) {
					if (!buttonArr[i].getText().equals(allCategoryBtn.getText())) {
						buttonArr[i].setFont(new Font("", Font.BOLD, 0));
						if (i < 11) {
							buttonArr[i].setIcon(new ImageIcon("images/" + imagePath[i]));								
						} else if (i == 11) {
							buttonArr[i].setIcon(new ImageIcon("images/all.png"));
						} else if (i == 12) {
							buttonArr[i].setIcon(new ImageIcon("images/recommendBtn.png"));
						}
					}

				}

			}
		});
		
		
		buttonArr[11]= allCategoryBtn;
		
		JButton recommendBtn = new JButton("강의추천");
		recommendBtn.setIcon(new ImageIcon("images/recommendBtn.png"));
		recommendBtn.setRolloverIcon(new ImageIcon("images/recommendBtn2.png"));
		recommendBtn.setFont(new Font("Gulim", Font.PLAIN, 0));
		recommendBtn.setBounds(283, 116, 75, 75);
		recommendBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				LectureTable3 lecListPanel = new LectureTable3();
				lectureListPanel.add(lecListPanel, recommendBtn.getText());
				layMng.show(lectureListPanel, recommendBtn.getText());

			}
		});
		
		recommendBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				recommendBtn.setIcon(new ImageIcon("images/recommendBtn2.png"));
				recommendBtn.setFont(new Font("", Font.BOLD, 0));
				
				for (int i = 0; i < buttonArr.length; ++i) {
					if (!buttonArr[i].getText().equals(recommendBtn.getText())) {
						buttonArr[i].setFont(new Font("", Font.BOLD, 0));
						if (i < 11) {
							buttonArr[i].setIcon(new ImageIcon("images/" + imagePath[i]));								
						} else if (i == 11) {
							buttonArr[i].setIcon(new ImageIcon("images/all.png"));
						} else if (i == 12) {
							buttonArr[i].setIcon(new ImageIcon("images/recommendBtn.png"));
						}
					}

				}

			}
		});
		
		
		recommendBtn.setBackground(Color.WHITE);
		recommendBtn.setBorderPainted(false);
		add(recommendBtn);
		buttonArr[12]= recommendBtn;

		HintTextField searchField = new HintTextField("검색어를 입력해주세요");
		searchField.setFont(new Font("배달의민족 도현", Font.PLAIN, 14));
		searchField.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					LectureTable2 lecListPanel2 = new LectureTable2(searchField.getText());
					lectureListPanel.add(lecListPanel2, searchField.getText());
					layMng.show(lectureListPanel, searchField.getText());
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
		lectureCntLabel.setBounds(230, 384, 475, 29);

		allCategoryBtn.setBackground(new Color(255, 255, 255));
		categoryPanel.add(allCategoryBtn);

		lectureListPanel.add(new LectureTable("ALL"));

		JButton searchBtn = new JButton("검색");
		searchBtn.setFont(new Font("굴림", Font.PLAIN, 0));
		searchBtn.setIcon(new ImageIcon("images/검색.png"));
		searchBtn.setRolloverIcon(new ImageIcon("images/검색2.png"));
		searchBtn.setBorderPainted(false);
		searchBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				LectureTable2 lecListPanel2 = new LectureTable2(searchField.getText());
				lectureListPanel.add(lecListPanel2, searchField.getText());
				layMng.show(lectureListPanel, searchField.getText());
				searchField.setText("");
			}
		});
		searchBtn.setBounds(853, 116, 75, 75);
		searchBtn.setBackground(Color.WHITE);
		add(searchBtn);

		JLabel lblTeamname = new JLabel("강의검색");
		lblTeamname.setFont(new Font("배달의민족 도현", Font.BOLD, 39));
		lblTeamname.setForeground(Color.WHITE);
		lblTeamname.setBounds(523, 29, 170, 62);
		add(lblTeamname);

		for (int i = 0; i < 11; ++i) {

			LectureCategoryButton cateBtn = new LectureCategoryButton(i);
			buttonArr[i] = cateBtn;
			categoryPanel.add(cateBtn);
			cateBtn.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.println(cateBtn.getText());
					LectureTable lecListPanel = new LectureTable(cateBtn.getText());
					lectureListPanel.add(lecListPanel, cateBtn.getText());
					layMng.show(lectureListPanel, cateBtn.getText());

				}

			});
			cateBtn.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					cateBtn.setIcon(new ImageIcon("images/"+imagePath2[cateBtn.num]));
					cateBtn.setFont(new Font("", Font.BOLD, 0));
					
					for (int i = 0; i < buttonArr.length; ++i) {
						if (!buttonArr[i].getText().equals(cateBtn.getText())) {
							buttonArr[i].setFont(new Font("", Font.BOLD, 0));
							if (i < 11) {
								buttonArr[i].setIcon(new ImageIcon("images/" + imagePath[i]));								
							} else if (i == 11) {
								buttonArr[i].setIcon(new ImageIcon("images/all.png"));
							} else if (i == 12) {
								buttonArr[i].setIcon(new ImageIcon("images/recommendBtn.png"));
							}
						}

					}

				}
			});

		}


	}

}