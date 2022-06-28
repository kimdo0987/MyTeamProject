package buttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import panels.LectureSearchPanel;
import panels.MainPanel;
import panels.SignupPanel;

public class LectureSearchButton extends JButton{

	private static ActionListener eventListener = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
								
			MainPanel.currPanel.setVisible(false);
			MainPanel.thisFrame.remove(MainPanel.lectureSearchPanel); 
			LectureSearchPanel newLectureSearchPanel = new LectureSearchPanel();
			MainPanel.thisFrame.add(newLectureSearchPanel);
			MainPanel.lectureSearchPanel = newLectureSearchPanel;
			MainPanel.lectureSearchPanel.setVisible(true);
			
			MainPanel.lastPanel = MainPanel.currPanel;
			MainPanel.currPanel = MainPanel.lectureSearchPanel;				
		}
	};
	
	public LectureSearchButton(String name) {
		super(name);
		addActionListener(eventListener);
		
	}

	public LectureSearchButton(String name, ImageIcon icon) {
		super(name, icon);
		addActionListener(eventListener);
		
	}

}
