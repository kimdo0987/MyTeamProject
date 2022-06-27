package buttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import panels.IdSearchPanel;
import panels.LectureSearchPanel;
import panels.LoginPanel;
import panels.MainPanel;
import panels.MyPagePanel;
import panels.PwSearchPanel;
import panels.SignupPanel;
 
// 마이페이지 Panel로 갈 수 있는 버튼입니다

public class MypageButton extends JButton {

			
		private static ActionListener eventListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (MainPanel.currUserId.equals("logout")) {
					JOptionPane.showMessageDialog(MainPanel.thisFrame, "회원만 이용 가능합니다\n로그인해 주세요");
					MainPanel.currPanel.setVisible(false);
					MainPanel.thisFrame.remove(MainPanel.loginPanel);
					LoginPanel newLoginPanel = new LoginPanel();
					MainPanel.thisFrame.add(newLoginPanel);
					MainPanel.loginPanel = newLoginPanel;
					MainPanel.loginPanel.setVisible(true);
					
					MainPanel.lastPanel = MainPanel.currPanel;
					MainPanel.currPanel = MainPanel.loginPanel;	

				} else {
					MainPanel.currPanel.setVisible(false);
					MainPanel.thisFrame.remove(MainPanel.myPagePanel);
					MyPagePanel newMyPagePanel = new MyPagePanel();
					MainPanel.thisFrame.add(newMyPagePanel);
					MainPanel.myPagePanel = newMyPagePanel;
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

