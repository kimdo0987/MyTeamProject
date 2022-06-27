package buttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

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
			PanelHash.put("메인", MainPanel.mainPanel);
//			PanelHash.put("강의상세정보", MainPanel.lectureInfoPanel);
//			PanelHash.put("강의찾기", MainPanel.lectureSearchPanel);
//			PanelHash.put("마이페이지", MainPanel.myPagePanel);
			PanelHash.put("고객문의", MainPanel.customerServicePanel);
//			PanelHash.put("회원가입", MainPanel.signUpPanel);
//			PanelHash.put("로그인", MainPanel.loginPanel);
//			PanelHash.put("아이디찾기", MainPanel.idSearchPanel);
//			PanelHash.put("비밀번호찾기", MainPanel.pwSerachPanel);
			PanelHash.put("이전", MainPanel.lastPanel);
		}	
}

