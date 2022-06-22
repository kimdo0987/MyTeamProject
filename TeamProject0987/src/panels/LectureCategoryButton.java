package panels;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;


public class LectureCategoryButton extends JButton {
	
	private String cateName;
	private int num;
	private static String[] category = 
		{"개발도구", "게임개발", "교양,기타", "데브옵스/인프라", "데스크톱 앱 개발", "데이터베이스", "모바일 앱 개발"
				, "백엔드", "알고리즘/자료구조", "임베디드/IOT", "프론트엔드"};
	
	
	public LectureCategoryButton (int num) {
		this.num = num;
		setText(category[num]);
		setBackground(Color.white);
		setFont(new Font("", Font.BOLD, 10));
		
	}
	
	

}














