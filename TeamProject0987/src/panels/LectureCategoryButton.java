package panels;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;


public class LectureCategoryButton extends JButton {
	
	private String cateName;
	private int num;

	
	private static String[] category = 
		{"개발도구", "게임개발", "프론트엔드", "데브옵스/인프라", "데스크톱 앱 개발", "데이터베이스", "모바일 앱 개발"
				, "백엔드", "알고리즘/자료구조", "임베디드/IOT", "교양,기타"};
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
	
	public LectureCategoryButton (int num) {
		this.num = num;
		setText(category[num]);
		setSize(80,80);
		setIcon(new ImageIcon("images/"+imagePath[num]));
		setRolloverIcon(new ImageIcon("images/"+imagePath2[num]));

//		setBorderPainted(false);
		setFont(new Font("", Font.BOLD, 0));
		
	}
	
	

}














