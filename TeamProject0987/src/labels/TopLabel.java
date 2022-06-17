package labels;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

// Panel 상단에 나타나는 페이지명 Label입니다
public class TopLabel extends JLabel {
	
	public TopLabel(String name) {
		setText(name);
		setOpaque(true);
		setBackground(Color.WHITE);
		setHorizontalAlignment(JLabel.CENTER);
		setFont(new Font("맑은고딕", Font.PLAIN, 20));		
		setBounds(366, 30, 400, 50);
		
	}

}
