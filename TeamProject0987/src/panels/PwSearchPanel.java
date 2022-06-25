package panels;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
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

import methods.IdKeyAdaptor;
import methods.NameKeyAdaptor;

import methods.OnlyNumKeyAdaptor;
import methods.RestrictTextLength;
import tempPassword.TempPassword;

public class PwSearchPanel extends JPanel {
	private static String nameText = "";
	private static String idText = "";
	private static String jNumText = "";
	private static String searchName;
	private static String searchJNum;
	
	
	public PwSearchPanel() { 
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
		
		
		GoToButton mainBtn = new GoToButton("메인");
		mainBtn.setBounds(105, 36, 70, 44);
		add(mainBtn);	
		
		TopLabel toplabel = new TopLabel("비밀번호 찾기");
		add(toplabel);
		
		HintTextField idInput = new HintTextField("아이디를 입력하세요.");
		add(idInput);
		idInput.setBounds(420, 220, 300, 30);
		idInput.addKeyListener(new RestrictTextLength(idInput, 16)); //글자수제한
		idInput.addKeyListener(new IdKeyAdaptor()); // 제약사항 적용
		
		idInput.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				idText = idInput.getText().toString();
			}	
		});
		
		
		HintTextField nameInput = new HintTextField("이름을 입력하세요.");
		add(nameInput);
		nameInput.setBounds(420, 250, 300, 30);
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
		jNumInput.setBounds(420, 280, 300, 30);
		jNumInput.addKeyListener(new RestrictTextLength(jNumInput, 13)); //글자수제한
		jNumInput.addKeyListener(new OnlyNumKeyAdaptor()); // 제약사항 적용
		
		jNumInput.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				jNumText = jNumInput.getText().toString();
			}	
		});		
		
		
		JButton pwSearchBtn = new JButton("임시 비밀번호로 변경하기");
		pwSearchBtn.setBounds(470, 350, 200, 50);
		pwSearchBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try (
						Connection conn = OjdbcConnection.getConnection();
						PreparedStatement pstmt1 = conn.prepareStatement("SELECT member_name FROM members "
								+ "WHERE member_id = ?");
						PreparedStatement pstmt2 = conn.prepareStatement("SELECT j_number FROM members "
								+ "WHERE member_name = ?");
						) {
					pstmt1.setString(1, idText);
					ResultSet rs1 = pstmt1.executeQuery();
					
					while(rs1.next()) {
						searchName = rs1.getString("member_name");
					}
					
					pstmt2.setString(1, searchName);
					ResultSet rs2 = pstmt2.executeQuery();
					
					while(rs2.next()) {
						searchJNum = rs2.getString("j_number");
					}
					
					pstmt2.close();
					
				} catch (SQLException e1) {
					e1.printStackTrace();
				}

				if (searchJNum == null) {
					searchJNum = "";
				}
				if (searchName == null) {
					searchName = "";
				}
				if (jNumText == null) {
					jNumText = "";
				}
				if (nameText == null) {
					nameText = "";
				}
				if (idText == null) {
					idText = "";
				}
				
				if(searchJNum.equals(jNumText) && searchName.equals(nameText) && 
						jNumText != "" && nameText != "" && idText != "") {		
					// 임시비번 생성
					TempPassword tpw = new TempPassword();
					
					// 확인창
					JOptionPane.showMessageDialog(MainPanel.thisFrame, "임시 비밀번호 : " + tpw.temp_password + "\r\n"
													+ "(임시 비밀번호가 클립보드에 복사되었습니다.)");
					
					// 클립보드에 복사해놓기
					StringSelection data = new StringSelection(tpw.temp_password);
					Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
					clipboard.setContents(data, data);
					
					// idText에 맞는  member_password (member_id)를 temp_password 로 UPDATE 해야한다
					String sql = "UPDATE members SET member_password = ? WHERE member_id = ?";
					try (
							Connection conn = OjdbcConnection.getConnection();
							PreparedStatement pstmt3 = conn.prepareStatement(sql);
					){
						pstmt3.setString(1, tpw.temp_password);
						pstmt3.setString(2, idText);
						pstmt3.executeUpdate();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					
					
					
					// 다시 비워놓기
					idInput.setText("아이디를 입력하세요.");  
					idInput.setFont(new Font("맑은고딕", Font.PLAIN, 14));  
					idInput.setForeground(Color.GRAY);
					
					nameInput.setText("이름을 입력하세요.");
					nameInput.setFont(new Font("맑은고딕", Font.PLAIN, 14));  
					nameInput.setForeground(Color.GRAY);
					nameText = "";
					
					jNumInput.setText("주민등록번호를 입력하세요. ('-' 제외 후 입력)");
					jNumInput.setFont(new Font("맑은고딕", Font.PLAIN, 14));  
					jNumInput.setForeground(Color.GRAY);
					jNumText = "";
					
					
					
					
					
					MainPanel.currPanel.setVisible(false);
					MainPanel.loginPanel.setVisible(true);			
					//이전 페이지 설정안하는이유 : 로그인으로 나와서 이전 눌렀을때 다시 임시패스워드로 가는것이 어색한 상황이다.
					MainPanel.currPanel = MainPanel.loginPanel;
				} else {
					JOptionPane.showMessageDialog(MainPanel.thisFrame, "입력정보를 잘못 입력했습니다.\r\n"
							+ "입력하신 내용을 다시 확인해주세요.");
				}
			}
		});
		add(pwSearchBtn);
	}
	
}
