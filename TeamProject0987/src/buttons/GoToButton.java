package buttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import panels.IdSearchPanel;
import panels.LectureSearchPanel;
import panels.MainPanel;
import panels.PwSearchPanel;
import panels.SignupPanel;
 
// 특정 Panel로 갈 수 있는 버튼입니다

public class GoToButton extends JButton {

		public static HashMap<String,JPanel> PanelHash = new HashMap<>();
		{
			PanelHash.put("메인", MainPanel.mainPanel);
			PanelHash.put("고객문의", MainPanel.customerServicePanel);
			PanelHash.put("이전", MainPanel.lastPanel);
		}
		private static ActionListener eventListener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				GoToButton sourceBtn = (GoToButton)e.getSource();
				JPanel valuePanel = PanelHash.get(sourceBtn.getText());
				
				MainPanel.currPanel.setVisible(false);
				valuePanel.setVisible(true);
				MainPanel.lastPanel = MainPanel.currPanel;
				MainPanel.currPanel = valuePanel;				
			}
		};
		
		public GoToButton(String name) {
			setText(name);
			addActionListener(eventListener);
		}

		public GoToButton(String name, ImageIcon img) {
			super (name, img);
			addActionListener(eventListener);		
		}	
}

