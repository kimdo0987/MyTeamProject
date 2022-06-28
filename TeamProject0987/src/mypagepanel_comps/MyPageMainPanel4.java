package mypagepanel_comps;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import labels.TopLabel;
import panels.ImagePanel;
import panels.MainPanel;
import panels.MyPagePanel;

import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import database.OjdbcConnection;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;

//쿠폰함 Panel이 될 JPanel입니다

public class MyPageMainPanel4 extends ImagePanel {
	private JTextField couponCodeField;
	public MyPageMainPanel4() {
		setBackground(new Color(204, 255, 204));
		setBounds(118, 0, 1093, 800);
		setLayout(null);
		
		TopLabel toplabel = new TopLabel("쿠폰함");
		toplabel.setLocation(335, 31);
		add(toplabel);
		
		JPanel panel = new JPanel(); //쿠폰 등록 textField와 내 쿠폰함 List 테이블이 들어갈 Label
		panel.setBounds(162, 155, 730, 569);
		panel.setLayout(null);
		add(panel);
		
		JPanel tablePanel = new JPanel();
		tablePanel.setBounds(0, 90, 730, 479);
		panel.add(tablePanel);
		
		couponCodeField = new JTextField();
		couponCodeField.setBounds(424, 13, 176, 35);
		panel.add(couponCodeField);
		couponCodeField.setColumns(10);
		
		JLabel tableNameLabel = new JLabel("나의 쿠폰 리스트");
		tableNameLabel.setFont(new Font("", Font.PLAIN, 18));
		tableNameLabel.setBounds(12, 13, 148, 40);
		panel.add(tableNameLabel);
		
		JLabel tableNameLabel_1 = new JLabel("쿠폰 등록하기");
		tableNameLabel_1.setFont(new Font("", Font.PLAIN, 12));
		tableNameLabel_1.setBounds(336, 10, 84, 40);
		panel.add(tableNameLabel_1);
		
		JButton btnNewButton = new JButton("등록");
		btnNewButton.setBounds(612, 16, 93, 29);
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String memberId = " ";
				if (couponCodeField.getText().length() != 10) {
					JOptionPane.showMessageDialog(MainPanel.thisFrame, "쿠폰코드를 정확히 입력해주세요");

				} else {
					String sql1 = "SELECT coupon_code, member_id FROM coupon_lists WHERE coupon_code = ? ";
					String sql2 = "UPDATE coupon_lists SET member_id = ? WHERE coupon_code = ?";
					try (
							Connection conn = OjdbcConnection.getConnection();
							PreparedStatement pstmt1 = conn.prepareStatement(sql1);
							PreparedStatement pstmt2 = conn.prepareStatement(sql2);
					) {
						pstmt1.setString(1, couponCodeField.getText());
						pstmt2.setString(1, MainPanel.currUserId);
						pstmt2.setString(2, couponCodeField.getText());
						
						ResultSet rs = pstmt1.executeQuery();
						while(rs.next()) {
							memberId = rs.getString(2);
						}
						if(memberId == null) {
							conn.setAutoCommit(false);
							pstmt2.executeUpdate();
							conn.commit();
							JOptionPane.showMessageDialog(MainPanel.thisFrame, "쿠폰이 등록되었습니다");
							MyPagePanel.mainPanel4.setVisible(false);
							MyPagePanel.mainPanel4 = new MyPageMainPanel4();
							MyPagePanel.cardLayoutPanel.add(MyPagePanel.mainPanel4, "쿠폰함");
							MyPagePanel.mainPanel4.setVisible(true);
						}else {
							JOptionPane.showMessageDialog(MainPanel.thisFrame, "쿠폰코드를 정확히 입력해주세요");
						}

					} catch (SQLException e1) {
						e1.printStackTrace();
					}

				}
			}
		});
		panel.add(btnNewButton);
		
		
		///////////////////TABLE 생성 //////////////////////////
		
		String[] headings = new String[] {"coupon id", "쿠폰이름", "쿠폰번호", "할인율", "사용만료일", "사용유무"};
		String[][] data = database.MyCouponLists.getMyCouponLists();
		
		// 테이블의 셀 내용 수정 불가 시작 //
		DefaultTableModel mod = new DefaultTableModel(data, headings) {
			public boolean isCellEditable(int rowIndex, int mColIndex) {
				return false;
			}
		};

		JTable table = new JTable(mod); // 수정불가능한 테이블로 생성
		table.setPreferredScrollableViewportSize(new Dimension(730,450));
		
		table.getColumnModel().getColumn(0).setMinWidth(50);
		table.getColumnModel().getColumn(0).setMaxWidth(50);
		table.getColumnModel().getColumn(1).setMinWidth(200);//셀 너비 조정
		table.getColumnModel().getColumn(1).setMaxWidth(200);
		table.getColumnModel().getColumn(2).setMinWidth(130);
		table.getColumnModel().getColumn(2).setMaxWidth(130);
		
		table.getColumnModel().getColumn(3).setMinWidth(50);
		table.getColumnModel().getColumn(3).setMaxWidth(50);
		table.getColumnModel().getColumn(4).setMinWidth(150);
		table.getColumnModel().getColumn(4).setMaxWidth(150);
		table.getColumnModel().getColumn(5).setMinWidth(150);
		table.getColumnModel().getColumn(5).setMaxWidth(150);
		
		table.setEnabled(false); //테이블 클릭 안되도록 지정

		table.setRowHeight(30); // 셀 높이 조정		
		table.setCellSelectionEnabled(true); // 한셀만 선택가능
		table.getTableHeader().setReorderingAllowed(false); //컬럼 헤더 고정 (이동 불가)
		table.getTableHeader().setResizingAllowed(false); // 컬럼 크기 고정 (변경 불가)
		
		
		ListSelectionModel selectionModel = table.getSelectionModel(); //한 행만 선택가능
		selectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); 	
		
		
		table.setEnabled(false);
		table.setFillsViewportHeight(true);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 0, 730, 450);		
		tablePanel.add(scrollPane);		
		panel.add(tablePanel);
		
		
		
		
		
	}
}
