package LectureInfoPanel_comps;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import panels.LectureInfoPanel;

public class LectureInfoTabButton extends JButton {

	String name;
	
	private ActionListener eventListener = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// System.out.println(name); cardLayout에서 어떤 panel 꺼내오는지 확인
			LectureInfoPanel.cardLayout1.show(LectureInfoPanel.cardLayoutPanel, name);
		}		
	};
	
	
	public LectureInfoTabButton(String name) {
		setText(name);
		this.name = name;
		addActionListener(eventListener);
		setBackground(Color.WHITE);
	}
}
