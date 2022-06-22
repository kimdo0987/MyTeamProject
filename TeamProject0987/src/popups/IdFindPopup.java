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
 
public class IdFindPopup extends JDialog{
	
	public IdFindPopup(Window parent, String name, String Jnum) {
		
		super(parent, "아이디 찾기", ModalityType.APPLICATION_MODAL);
		
		setSize(211, 154);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setLayout(null);
		
		String foundId = "asd123" ; // name과 Jnum으로 DB조회후 foundId에 조회한 회원 아이디 넣기
		
		String msg = "조회된 아이디 : " + foundId;
		// if DB에 없는 name과 Jnum이면 >> msg = "등록된 아이디가 없습니다" 기능추가
		
		
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
				dispose();				
			}
		});
		add(confirmBtn);
		
		
		setVisible(true);
		
		
	}
}
