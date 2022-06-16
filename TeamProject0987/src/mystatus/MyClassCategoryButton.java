package mystatus;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;

public class MyClassCategoryButton extends JButton {
	public MyClassCategoryButton(String title) {
		super(title);
		setBackground(Color.white);
		setSize(new Dimension(400, 400));
	}
}
