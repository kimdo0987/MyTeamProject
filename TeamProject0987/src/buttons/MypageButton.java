package buttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import panels.IdSearchPanel;
import panels.LectureSearchPanel;
import panels.MainPanel;
import panels.PwSearchPanel;
import panels.SignupPanel;
 
// 마이페이지 Panel로 갈 수 있는 버튼입니다

public class MypageButton extends JButton {

		public static HashMap<String,JPanel> PanelHash = new HashMap<>();
		
		private static ActionListener eventListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (MainPanel.currUserId.equals("logout")) {
					JOptionPane.showMessageDialog(MainPanel.thisFrame, "회원만 이용 가능합니다\n로그인해 주세요");
					MainPanel.currPanel.setVisible(false);
					MainPanel.loginPanel.setVisible(true);
					MainPanel.lastPanel = MainPanel.currPanel;
					MainPanel.currPanel = MainPanel.loginPanel;
				} else {
					MainPanel.currPanel.setVisible(false);
					MainPanel.myPagePanel.setVisible(true);
					MainPanel.lastPanel = MainPanel.currPanel;
					MainPanel.currPanel = MainPanel.myPagePanel;
				}
			}
		};

		public MypageButton(String name) {
			setText(name);
			addActionListener(eventListener);
			
		}	
}

