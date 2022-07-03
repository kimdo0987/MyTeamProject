package mypagepanel_comps;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import database.OjdbcConnection;
import panels.ImagePanel;
import panels.MainPanel;
import panels.MyPagePanel;

public class PaymentPanel extends ImagePanel {
	public JLabel totalPricelbl;
	
	public PaymentPanel() {
		setBackground(new Color(245, 222, 179));
		setBounds(118, 0, 1093, 800);	
		setLayout(null);
		
		//헤딩
		JLabel tableNameLabel = new JLabel("결제확인");
		tableNameLabel.setForeground(Color.WHITE);
		tableNameLabel.setBounds(80, 40, 460, 90);
		add(tableNameLabel);
		tableNameLabel.setFont(new Font("배달의민족 도현", Font.PLAIN, 58));
		
		//구분선
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBounds(80, 124, 800, 3);
		add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("배달의민족 도현", Font.PLAIN, 18));
		comboBox.addItem("--결제수단선택--");
		comboBox.addItem("카드결제");
		comboBox.addItem("계좌이체");
		comboBox.setBounds(365, 687, 184, 51);
		add(comboBox);
		
		ImageIcon payChkBtnicon1 = new ImageIcon("images/mp3/paypanel/결제확인버튼.png");
		Image payChkBtnimg1 = payChkBtnicon1.getImage();
		Image payChkBtn1 = payChkBtnimg1.getScaledInstance(300, 75, Image.SCALE_SMOOTH);
		ImageIcon payChkBtnicon2 = new ImageIcon("images/mp3/paypanel/노란결제확인버튼.png");
		Image payChkBtnimg2 = payChkBtnicon2.getImage();
		Image payChkBtn2 = payChkBtnimg2.getScaledInstance(300, 75, Image.SCALE_SMOOTH);
		
		JLabel tableNameLabel_1 = new JLabel("총 결제 금액");
		tableNameLabel_1.setForeground(Color.WHITE);
		tableNameLabel_1.setFont(new Font("배달의민족 도현", Font.PLAIN, 36));
		tableNameLabel_1.setBounds(355, 576, 235, 90);
		add(tableNameLabel_1);
		DecimalFormat df = new DecimalFormat(",###");
		totalPricelbl = new JLabel((df.format(MainPanel.mypageMainPanel3.total_price) + "원"));
		totalPricelbl.setForeground(Color.WHITE);
		totalPricelbl.setFont(new Font("배달의민족 도현", Font.PLAIN, 36));
		totalPricelbl.setBounds(586, 576, 294, 90);
		add(totalPricelbl);
		
		JButton payCheckButton = new JButton(new ImageIcon(payChkBtn1));
		payCheckButton.setFont(new Font("굴림", Font.PLAIN, 0));
		payCheckButton.setBounds(586, 675, 294, 75);
		payCheckButton.setBorder(BorderFactory.createEmptyBorder());
		payCheckButton.setRolloverIcon(new ImageIcon(payChkBtn2));
		payCheckButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				
			}
		});
		
		add(payCheckButton);
		
		payCheckButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBox.getSelectedItem().equals("--결제수단선택--")) {
					JOptionPane.showMessageDialog(MainPanel.thisFrame, "결제수단을 선택해 주세요");
				} else {

					
					String sql = "INSERT INTO members VALUES (?,?,?,?,?,?)";
					
					String sql1 = "DELETE FROM wish_lists w WHERE w.lecture_id = (SELECT w2.lecture_id FROM wish_lists w2, lecture_lists l WHERE w2.lecture_id = l.lecture_id AND user_id = ? AND l.lecture_name = ? ) AND user_id = ?";
					
					String sql2 = "UPDATE coupon_lists SET used_or_unused = ? WHERE member_id = ? AND coupon_name = ?"
							+ " AND expiration_period = (SELECT min(expiration_period) FROM coupon_lists"
							+ " WHERE member_id = ? AND coupon_name = ? AND used_or_unused = ?)";

					String sql3 = "SELECT * FROM lecture_lists WHERE lecture_name = ?";
					String sql4 = "SELECT * FROM coupon_lists a WHERE member_id = ? AND a.expiration_period = (SELECT min(expiration_period) FROM coupon_lists WHERE member_id = ? AND coupon_name = ? AND used_or_unused = ?)";

					String sql5 = "INSERT INTO payment_log VALUES (PAYMENT_SEQ.nextval,PAYMENT_SEQ.nextval,?,?,?,?,to_date(?,'yy_mm_dd'),?,?)";
					
					String sql6 = "INSERT INTO mylecture_lists VALUES (MYLECTURE_SEQ.nextval, ?, ?)";

					try (Connection conn = OjdbcConnection.getConnection();
							PreparedStatement pstmt1 = conn.prepareStatement(sql1);
							
							PreparedStatement pstmt2 = conn.prepareStatement(sql2);

							PreparedStatement pstmt3 = conn.prepareStatement(sql3, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
							PreparedStatement pstmt4 = conn.prepareStatement(sql4, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
							
							PreparedStatement pstmt5 = conn.prepareStatement(sql5);
							
							PreparedStatement pstmt6 = conn.prepareStatement(sql6);
					) {
						conn.setAutoCommit(false);

						//1. 장바구니 List에서 결제한 항목 삭제 //////////
						for (int i = 0; i < MainPanel.mypageMainPanel3.rowSize; i++) {
							pstmt1.setString(1, MainPanel.currUserId);
							pstmt1.setString(2, "" + MyPageMainPanel3.table2.getValueAt(i, 0));
							pstmt1.setString(3, MainPanel.currUserId);
							pstmt1.executeUpdate();
						}
						//2. 사용한쿠폰 사용완료로 수정 (이름 같은것들중에 가장 기간이 짧은것부터 먼저 사용) //////////
						for (int i = 0; i < MainPanel.mypageMainPanel3.rowSize; i++) {
							pstmt2.setString(1, "사용완료");
							pstmt2.setString(2, MainPanel.currUserId);
							pstmt2.setString(3, "" + MyPageMainPanel3.table2.getValueAt(i, 4));
							pstmt2.setString(4, MainPanel.currUserId);
							pstmt2.setString(5, "" + MyPageMainPanel3.table2.getValueAt(i, 4));
							pstmt2.setString(6, "사용가능");
							pstmt2.executeUpdate();
						}
						
						//3. 결제 LOG에 추가	//////////					
						
						for (int i = 0; i < MainPanel.mypageMainPanel3.rowSize; i++) {	
							
							/////////3-1.강의이름으로 강의id 받기///////////////
							pstmt3.setString(1, ""+MyPageMainPanel3.table2.getValueAt(i, 0));
							
							ResultSet rs = pstmt3.executeQuery();							
							
							rs.first();
							
							int code = rs.getInt(1); 							
										
							
							/////////// 3-2.쿠폰이름으로 쿠폰id 받기 ///////////////
							
							// 만약 사용안하는 상태일때는 '사용 안함' 쿠폰 적용 coupon_id -> 0 
							if ((("" + MyPageMainPanel3.table2.getValueAt(i, 4)).equals(""))
									|| (("" + MyPageMainPanel3.table2.getValueAt(i, 4)).equals("---쿠폰선택---"))
									|| (("" + MyPageMainPanel3.table2.getValueAt(i, 4)).equals("선택안함"))
									|| (("" + MyPageMainPanel3.table2.getValueAt(i, 4)).equals("null"))) {
								pstmt4.setString(1, "logout");
								pstmt4.setString(2, "logout");
								pstmt4.setString(3, "사용 안함");
								pstmt4.setString(4, "분류없음");
							} else {
								pstmt4.setString(1, MainPanel.currUserId);
								pstmt4.setString(2, MainPanel.currUserId);
								pstmt4.setString(3, "" + MyPageMainPanel3.table2.getValueAt(i, 4));
								pstmt4.setString(4, "사용가능");
							}							
							
							ResultSet rs2 = pstmt4.executeQuery();
							rs2.first();
							Integer couponid = rs2.getInt(1); 
							
							////////////////// 나머지 데이터는 불러올 수 있으므로 INSERT 실행 ////////////////////////
							pstmt5.setString(1, MainPanel.currUserId);
							pstmt5.setInt(2, code);
							pstmt5.setInt(3, couponid);
							pstmt5.setInt(4, Integer.parseInt(""+MyPageMainPanel3.table2.getValueAt(i, 5)));
							pstmt5.setString(5, ""+LocalDateTime.now().toLocalDate());
							pstmt5.setString(6, ""+ comboBox.getSelectedItem());
							pstmt5.setString(7, "null");
							pstmt5.executeUpdate();
						}
						
						
						//4.수강목록에 강의 추가 //////////
						
						/////////4-1.강의이름으로 강의id 받기///////////////
						
						
						for (int i = 0; i < MainPanel.mypageMainPanel3.rowSize; i++) {
						
							pstmt3.setString(1, ""+MyPageMainPanel3.table2.getValueAt(i, 0));
							
							ResultSet rs = pstmt3.executeQuery();							
							
							rs.first();
							
							int code = rs.getInt(1); 
							//////////////////////// 내 수강목록DB에 INSERT 
							pstmt6.setString(1, MainPanel.currUserId);
							pstmt6.setInt(2, code);
							pstmt6.executeUpdate();
						}	
						

						conn.commit();

						
					} catch (SQLException e1) {
						e1.printStackTrace();

					}

					JOptionPane.showMessageDialog(MainPanel.thisFrame, "결제가 완료되었습니다");
					
					//최신화된 마이페이지를 띄움
					MainPanel.currPanel.setVisible(false);
					MainPanel.thisFrame.remove(MainPanel.myPagePanel);
					MainPanel.myPagePanel = new MyPagePanel();
					MainPanel.thisFrame.add(MainPanel.myPagePanel);
					MainPanel.myPagePanel.setVisible(true);
					MainPanel.currPanel = MainPanel.myPagePanel;
					MainPanel.lastPanel = MainPanel.mainPanel;
				}

			}
		});

		JPanel panel = new JPanel(); // 탈퇴시 안내사항label, 비밀번호작성 textField,버튼 이 들어가는 패널 (장바구니 panel)
		panel.setBounds(80, 154, 800, 413);
		panel.setLayout(null);
		add(panel);

		JPanel tablePanel = new JPanel();
		tablePanel.setBounds(0, 0, 800, 413);		
		tablePanel.setLayout(null);
		panel.add(tablePanel);
		
		JScrollPane scrollPane = new JScrollPane(MyPageMainPanel3.table2);
		scrollPane.setBounds(0, 0, 800, 413);		
		tablePanel.add(scrollPane);		
		panel.add(tablePanel);
		
		

		
		MainPanel.paymentPanel = this;
		
	
		
	}
}
