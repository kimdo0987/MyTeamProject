package popups;

import java.awt.Font;
import java.awt.Window;
import java.awt.Dialog.ModalityType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
 
public class DeleteChkPopup extends JDialog{
	public DeleteChkPopup(Window parent, String lecture_name) {
		
		super(parent, "안내 메시지", ModalityType.APPLICATION_MODAL);
		
		setSize(254, 176);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel msgLabel = new JLabel("장바구니에서 삭제하시겠습니까?");
		msgLabel.setFont(new Font("굴림", Font.PLAIN, 13));
		msgLabel.setBounds(12, 38, 214, 31);
		msgLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		getContentPane().add(msgLabel);
		
		JButton confirmBtn = new JButton("확인");
		confirmBtn.setBounds(38, 91, 64, 23);
		getContentPane().add(confirmBtn);
		
		String sql = "delete table wish_lists from ";
		
		confirmBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("//장바구니 Table에서 해당 강의를 추가한 데이터 삭제 필요함"); 
				
				dispose();	
			}
		});
		
		JButton cancelBtn = new JButton("취소");
		cancelBtn.setBounds(125, 91, 64, 23);
		getContentPane().add(cancelBtn);
		cancelBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();				
			}
		});
		
		
		setVisible(true);
		
		
	}
}
