package database;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import LectureInfoPanel_comps.LectureInfoPanel1;
import mypagepanel_comps.frames.CancelLectureFrame;
import mypagepanel_comps.frames.CommentsFrame;
import panels.LectureInfoPanel;
import panels.LectureSearchPanel;
import panels.MainPanel;

public class LectureTable2 extends JPanel {
	public static String lectureName = "";

	public LectureTable2(String searchWord) {

		setBounds(176, 365, 730, 300);
		setLayout(null);

		JPanel tablePanel = new JPanel();
		tablePanel.setBounds(0, 58, 730, 300);

		String[] firstRow = new String[] { "강의명", "강사명", "카테고리", "강의시작일", "강의상세보기" };
		String[][] data = GetSearchLectureLists.getSearchList(searchWord);

		DefaultTableModel mod = new DefaultTableModel(data, firstRow) {
			public boolean isCellEditable(int rowIndex, int mColIndex) {
				return false;
			}
		};

		JTable table = new JTable(mod);
		table.setPreferredScrollableViewportSize(new Dimension(700, 600));

		table.setBorder(new BevelBorder(BevelBorder.RAISED));
		table.getColumnModel().getColumn(0).setMinWidth(300);// 셀 너비 조정
		table.getColumnModel().getColumn(0).setMaxWidth(300);
		table.getColumnModel().getColumn(1).setMinWidth(100);
		table.getColumnModel().getColumn(1).setMaxWidth(100);
		table.getColumnModel().getColumn(2).setMinWidth(150);
		table.getColumnModel().getColumn(2).setMaxWidth(150);
		table.getColumnModel().getColumn(3).setMinWidth(80);
		table.getColumnModel().getColumn(3).setMaxWidth(80);
		table.getColumnModel().getColumn(4).setMinWidth(100);
		table.getColumnModel().getColumn(4).setMaxWidth(100);
		table.setRowHeight(30);

		table.setRowHeight(30); // 셀 높이 조정
		table.setCellSelectionEnabled(true); // 한셀만 선택가능
		table.getTableHeader().setReorderingAllowed(false); // 컬럼 헤더 고정 (이동 불가)
		table.getTableHeader().setResizingAllowed(false); // 컬럼 크기 고정 (변경 불가)

		ListSelectionModel selectionModel = table.getSelectionModel(); // 한 행만 선택가능
		selectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		selectionModel.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				
				int row = table.getSelectedRow();
				int col = table.getSelectedColumn();

				System.out.println("행index:" + row + ",열index:" + col);
				System.out.println("눌린내용: " + table.getValueAt(row, col));
				System.out.println(table.getValueAt(row, 0));

				lectureName = (String) table.getValueAt(row, 0);
				
				if(col==4) {
				MainPanel.lectureSearchPanel.setVisible(false);
				MainPanel.lectureInfoPanel.setVisible(true);
				}

				HashMap<String, String> detailInfoHash = new HashMap<>();

				String sql = "SELECT lecture_id, lecture_info FROM lecture_lists WHERE lecture_name = ? ";

				try (
						Connection con = OjdbcConnection.getConnection();
						PreparedStatement pstmt = con.prepareStatement(sql);
					) {
					pstmt.setString(1, lectureName);

					try (ResultSet rs = pstmt.executeQuery()) {
						while (rs.next()) {

							detailInfoHash.put(rs.getString("lecture_id"), rs.getString("lecture_info"));

							LectureInfoPanel1.detailInfoLabel.setText((detailInfoHash.get(rs.getString("lecture_id"))));

							System.out.println("강의정보 : " + LectureInfoPanel1.detailInfoLabel.getText());
							
							LectureSearchPanel.currLectureId = rs.getInt("lecture_id");//////

						}
					} catch (SQLException e1) {
						e1.printStackTrace();
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				} catch (SQLException e3) {
					e3.printStackTrace();
				}

			}
		});

		// 테이블 생성에 관한 내용
		table.setFillsViewportHeight(true);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 0, 730, 500);
		scrollPane.setSize(getSize());
		add(scrollPane);

	}

}
