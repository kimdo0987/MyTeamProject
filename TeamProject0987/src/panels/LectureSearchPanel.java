package panels;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import buttons.GoToButton;
import labels.TopLabel;

public class LectureSearchPanel extends JPanel{

	
	static LoginPanel login = new LoginPanel(); 
	
	public LectureSearchPanel() {
					
		setBounds(0, 0, 1200, 800);
		setLayout(null);

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

		JButton searchBtn = new JButton("검색");
		searchBtn.setBounds(879, 114, 73, 55);
		searchBtn.setBackground(Color.WHITE);
		add(searchBtn);

		JTextField textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(298, 114, 529, 55);
		add(textField);

		JPanel categoryPanel = new JPanel();
		categoryPanel.setBounds(206, 178, 671, 153);
		add(categoryPanel);
		categoryPanel.setLayout(new GridLayout(2, 9));

		JPanel lectureListPanel = new JPanel();
		lectureListPanel.setBounds(206, 343, 608, 399);
		add(lectureListPanel);
		lectureListPanel.setLayout(new GridLayout(8, 1));

		JPanel heartPanel = new JPanel();
		heartPanel.setBounds(826, 343, 51, 399);
		add(heartPanel);
		heartPanel.setLayout(new GridLayout(8, 1));

		JButton allCategoryBtn = new JButton("ALL");
		allCategoryBtn.setBackground(Color.WHITE);
		categoryPanel.add(allCategoryBtn);
		
		for (int i = 0; i < 17; ++i) {
			JButton categoryBtn = new JButton("카테" + (i + 1));
			categoryBtn.setBackground(Color.white);
			categoryBtn.setFont(new Font("", Font.BOLD, 8));
			categoryPanel.add(categoryBtn);
			categoryBtn.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					
				}
			});
		}

		for (int i = 0; i < 8; ++i) {
			JButton lectureBtn = new JButton("<강좌명> <강사명> <수강기간> <별점>");
			lectureBtn.setBackground(Color.white);
			lectureListPanel.add(lectureBtn);
			JButton heartBtn = new JButton("♡");
			heartBtn.setBackground(Color.WHITE);
			lectureBtn.setFont(new Font("", Font.PLAIN, 12));
			lectureBtn.setBackground(Color.WHITE);
			heartPanel.add(heartBtn);
			lectureBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

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
