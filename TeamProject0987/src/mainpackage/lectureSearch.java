package mainpackage;


import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class lectureSearch {

	public lectureSearch() {
		JFrame frame = new JFrame();
		frame.setBounds(100, 100, 699, 662);

		JPanel mainPanel = new JPanel();
		mainPanel.setBounds(0, 0, 671, 613);
		frame.getContentPane().add(mainPanel);
		mainPanel.setLayout(null);

		JButton mainBtn = new JButton("메인");
		mainBtn.setBounds(12, 10, 106, 55);
		mainBtn.setBackground(Color.WHITE);
		mainPanel.add(mainBtn);

		JLabel stateLabel = new JLabel("현재상태");
		stateLabel.setBounds(132, 10, 409, 55);
		stateLabel.setHorizontalAlignment(JLabel.CENTER);
		mainPanel.add(stateLabel);

		JButton infoBtn = new JButton("내정보");
		infoBtn.setBackground(Color.white);
		infoBtn.setBounds(553, 10, 106, 55);
		mainPanel.add(infoBtn);

		JButton searchBtn = new JButton("검색");
		searchBtn.setBounds(553, 75, 106, 55);
		searchBtn.setBackground(Color.WHITE);
		mainPanel.add(searchBtn);

		JTextField textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(12, 75, 529, 55);
		mainPanel.add(textField);

		JPanel panel1 = new JPanel();
		panel1.setBounds(12, 140, 647, 153);
		mainPanel.add(panel1);
		panel1.setLayout(new GridLayout(2, 9));

		JPanel panel2 = new JPanel();
		panel2.setBounds(12, 303, 584, 300);
		mainPanel.add(panel2);
		panel2.setLayout(new GridLayout(8, 1));

		JPanel panel3 = new JPanel();
		panel3.setBounds(608, 303, 51, 300);
		mainPanel.add(panel3);
		panel3.setLayout(new GridLayout(8, 1));

		JButton allCategoryBtn = new JButton("ALL");
		allCategoryBtn.setBackground(Color.WHITE);
		panel1.add(allCategoryBtn);
		
		for (int i = 0; i < 17; ++i) {
			JButton categoryBtn = new JButton("카테" + (i + 1));
			categoryBtn.setBackground(Color.white);
			categoryBtn.setFont(new Font("", Font.BOLD, 8));
			panel1.add(categoryBtn);
			categoryBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
		}

		for (int i = 0; i < 8; ++i) {
			JButton lectureBtn = new JButton("<강좌명> <강사명> <수강기간> <별점>");
			lectureBtn.setBackground(Color.white);
			panel2.add(lectureBtn);
			JButton heartBtn = new JButton("♡");
			heartBtn.setBackground(Color.WHITE);
			lectureBtn.setFont(new Font("", Font.PLAIN, 12));
			lectureBtn.setBackground(Color.WHITE);
			panel3.add(heartBtn);
			lectureBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

				}
			});

		
		}
	
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setVisible(true);
	}
	public static void main(String[] args) {
		new lectureSearch();
	}
	
	
}
