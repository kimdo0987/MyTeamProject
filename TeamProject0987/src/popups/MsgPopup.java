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
  
public class MsgPopup extends JDialog{
	
	public MsgPopup(Window parent, String msg) {
		
		super(parent, "안내 메시지", ModalityType.APPLICATION_MODAL);
		
		setSize(211, 154);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setLayout(null);
		
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
