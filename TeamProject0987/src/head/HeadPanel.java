package head;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;

public class HeadPanel extends JPanel {
	HeadMainButton mainButton = new HeadMainButton("Main");
	HeadStateLabel currentState = new HeadStateLabel();
	
	public HeadPanel() {
		setLayout(new BorderLayout());
		setBounds(0, 0, 600, 200);
		setBackground(Color.white);
		add(mainButton, "West");
		add(currentState, "Center");
	}
}
