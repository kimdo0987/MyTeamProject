package panels;




import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import buttons.GoToButton;
import database.OjdbcConnection;
import labels.TopLabel;
import methods.NameKeyAdaptor;
import methods.OnlyNumKeyAdaptor;
import methods.RestrictTextLength;
import popups.IdFindPopup;

public class IdSearchPanel extends JPanel{

	private static String nameText = "";
	private static String jNumText = "";
	private static String searchJNum;
	private static String searchId;
	
	public IdSearchPanel() {
	
		setBounds(0, 0, 1200, 800);
		setLayout(null);
		
		JButton lastPageBtn = new JButton("이전");
		lastPageBtn.setBounds(23, 36, 70, 44);
		add(lastPageBtn);
		lastPageBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MainPanel.currPanel.setVisible(false);
				MainPanel.loginPanel.setVisible(true);
				MainPanel.currPanel = MainPanel.loginPanel;		
			}
		});
		
		
		GoToButton firstPageBtn = new GoToButton("메인");
		firstPageBtn.setBounds(105, 36, 70, 44);
		add(firstPageBtn);		
			
		TopLabel toplabel = new TopLabel("아이디 찾기");
		add(toplabel);
		
		//
		HintTextField nameInput = new HintTextField("이름를 입력하세요.");
		add(nameInput);
		nameInput.setBounds(398, 227, 361, 44);
		nameInput.addKeyListener(new RestrictTextLength(nameInput, 14)); //글자수제한
		nameInput.addKeyListener(new NameKeyAdaptor()); // 제약사항 적용

		nameInput.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				nameText = nameInput.getText().toString();
			}	
		});
		
		HintTextField jNumInput = new HintTextField("주민등록번호를 입력하세요. ('-' 제외 후 입력)");
		add(jNumInput);
		jNumInput.setBounds(398, 286, 361, 44);
		jNumInput.addKeyListener(new RestrictTextLength(jNumInput, 13)); //글자수제한
		jNumInput.addKeyListener(new OnlyNumKeyAdaptor()); // 제약사항 적용

		jNumInput.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				jNumText = jNumInput.getText().toString();
			}	
		});

		JButton idSearchBtn = new JButton("아이디 조회");
		idSearchBtn.setBounds(478, 378, 200, 50);
		idSearchBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try (Connection conn = OjdbcConnection.getConnection();
						PreparedStatement pstmt1 = conn
								.prepareStatement("SELECT j_number FROM members " + "WHERE member_name = ?");) {
					pstmt1.setString(1, nameText);
					ResultSet rs1 = pstmt1.executeQuery();

					while (rs1.next()) {
						searchJNum = rs1.getString("j_number");
					}

					PreparedStatement pstmt2 = conn
							.prepareStatement("SELECT member_id FROM members " + "WHERE j_number = ?");
					pstmt2.setString(1, searchJNum);
					ResultSet rs2 = pstmt2.executeQuery();

					while (rs2.next()) {
						searchId = rs2.getString(1);
					}

				} catch (SQLException e1) {
					e1.printStackTrace();
				}

				if (searchJNum == null) {
					searchJNum = "";
				}
				
				if(searchJNum.equals(jNumText)) {		
					JOptionPane.showMessageDialog(MainPanel.thisFrame, "조회된 아이디 : " + searchId);
					
					// 다시 비워놓기
					nameInput.setText("이름를 입력하세요.");
					nameInput.setFont(new Font("맑은고딕", Font.PLAIN, 14));  
					nameInput.setForeground(Color.GRAY);
					nameText = "";
					

					jNumInput.setText("주민등록번호를 입력하세요. ('-' 제외 후 입력)");

					jNumInput.setFont(new Font("맑은고딕", Font.PLAIN, 14));  
					jNumInput.setForeground(Color.GRAY);
					jNumText = "";
					//
					
				} else {
					JOptionPane.showMessageDialog(MainPanel.thisFrame, "이름 또는 주민등록번호를 잘못 입력했습니다.\r\n"
							+ "입력하신 내용을 다시 확인해주세요.");
				}
			}
		});
		add(idSearchBtn);
		
	}
}
	
	
