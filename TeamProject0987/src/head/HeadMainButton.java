package head;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import mainpackage.MainPanel;

public class HeadMainButton extends JButton {
	
	public HeadMainButton(String title) {
		super(title);
		setBackground(Color.WHITE);
		setSize(100, 100);
		addActionListener(mainBtnActionListener);
	}
	
	
	ActionListener mainBtnActionListener = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			MainPanel.currPanel.setVisible(false);
			MainPanel.mainPanel.setVisible(true);
			MainPanel.currPanel = MainPanel.mainPanel;
		}
	}; 
	
}
