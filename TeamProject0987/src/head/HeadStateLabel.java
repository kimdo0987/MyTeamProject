package head;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class HeadStateLabel extends JLabel {
	public HeadStateLabel() {
		setText("나의 강의");
		setBackground(Color.white);
		setFont(new Font("궁서", Font.BOLD, 40));
		setHorizontalAlignment(CENTER);
	}
}
