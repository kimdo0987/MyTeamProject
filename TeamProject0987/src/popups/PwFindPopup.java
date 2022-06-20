package popups;
import java.awt.Window;
import java.awt.Dialog.ModalityType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import panels.MainPanel;

public class PwFindPopup extends JDialog{
	
	public PwFindPopup(Window parent, String id) {
		
		super(parent, "임시 비밀번호 생성", ModalityType.APPLICATION_MODAL);
		
		setSize(211, 154);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setLayout(null);
		
		String newPw = "asd123" ; //랜덤 문자열 생성 (임시 비밀번호)
		
		String msg = "임시 비밀번호 : " + newPw;
		//  DB에서 id를 찾아서 비밀번호를 newPw로 재설정하기 
		
		
		JLabel msgLabel = new JLabel(msg);
		msgLabel.setFont(new Font("굴림", Font.PLAIN, 13));
		msgLabel.setBounds(12, 28, 171, 31);
		msgLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		add(msgLabel);
		
		JButton confirmBtn = new JButton("확인");
		confirmBtn.setBounds(33, 78, 122, 23);
		confirmBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MainPanel.currPanel.setVisible(false);
				MainPanel.loginPanel.setVisible(true);			
				//이전 페이지 설정안하는이유 : 로그인으로 나와서 이전 눌렀을때 다시 임시패스워드로 가는것이 어색한 상황이다.
				MainPanel.currPanel = MainPanel.loginPanel;
				dispose();				
			}
		});
		add(confirmBtn);
		
		
		setVisible(true);
		
		
	}
}
