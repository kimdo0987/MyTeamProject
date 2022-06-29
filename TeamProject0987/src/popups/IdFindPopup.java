package popups;
import java.awt.Window;
import java.awt.Dialog.ModalityType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JDialog;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;

import database.OjdbcConnection;
import panels.IdSearchPanel;
import panels.MainPanel;
 
public class IdFindPopup extends JDialog{
	
	private static String foundId = "" ;
	
	public IdFindPopup(Window parent, String name, String Jnum) {
		
		 
		
		
		super(parent, "아이디 찾기", ModalityType.APPLICATION_MODAL);
		
		setSize(211, 154);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setLayout(null);
		
		
		// name과 Jnum으로 DB조회후 foundId에 조회한 회원 아이디 넣기
//		String msg;
//		
//		if (foundId == "") {
//			msg = "이름 또는 주민등록번호를 잘못 입력했습니다.\r\n"
//					+ "입력하신 내용을 다시 확인해주세요.";
//		} else {
//			msg = "조회된 아이디 : " + foundId;
//		}
//		
//		JLabel msgLabel = new JLabel(msg);
//		msgLabel.setFont(new Font("굴림", Font.PLAIN, 13));
//		msgLabel.setBounds(12, 28, 171, 31);
//		msgLabel.setHorizontalTextPosition(SwingConstants.CENTER);
//		add(msgLabel);
//		
//		JButton confirmBtn = new JButton("확인");
//		confirmBtn.setBounds(33, 78, 122, 23);
//		confirmBtn.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				dispose();				
//			}
//		});
//		add(confirmBtn);
//		
//		
//		setVisible(true);
		
		
	}
}
