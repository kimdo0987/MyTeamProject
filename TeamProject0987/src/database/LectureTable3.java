package database;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import LectureInfoPanel_comps.LectureInfoPanel1;
import LectureInfoPanel_comps.LectureInfoPanel3;
import buttons.WishButton;
import panels.LectureInfoPanel;
import panels.LectureSearchPanel;
import panels.MainPanel;

public class LectureTable3 extends JPanel {
	public static String lectureName = "";

	public LectureTable3()  {
		setBounds(176, 365, 730, 300);
		setLayout(null);

		JPanel tablePanel = new JPanel();
		tablePanel.setBounds(0, 58, 730, 300);

		String[] firstRow = new String[] { "강의명", "강사명", "카테고리", "강의시작일"};
		String[][] data = GetRecommendLectureLists.getRecommendLists();

		DefaultTableModel mod = new DefaultTableModel(data, firstRow) {
			public boolean isCellEditable(int rowIndex, int mColIndex) {
				return false;
			}
		};

		JTable table = new JTable(mod);
		
		MyRenderer cellRenderer = new MyRenderer();
		table.addMouseMotionListener(new MouseMotionAdapter(){
			public void mouseMoved(MouseEvent e)
			{
				int row = table.rowAtPoint(e.getPoint());
				if (row > -1)
				 {
				    cellRenderer.rowAtMouse = row;
				    cellRenderer.color = new Color(246,246,246);
				    table.repaint();
				 }
			 }
		});
		
		table.getColumnModel().getColumn(0).setCellRenderer(cellRenderer);
		table.getColumnModel().getColumn(1).setCellRenderer(cellRenderer);
		table.getColumnModel().getColumn(2).setCellRenderer(cellRenderer);
		table.getColumnModel().getColumn(3).setCellRenderer(cellRenderer);
		table.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		table.setEnabled(false);
		
		table.setPreferredScrollableViewportSize(new Dimension(700, 600));
		
		table.getColumnModel().getColumn(0).setMinWidth(375);// 셀 너비 조정
		table.getColumnModel().getColumn(0).setMaxWidth(375);
		table.getColumnModel().getColumn(1).setMinWidth(100);
		table.getColumnModel().getColumn(1).setMaxWidth(100);
		table.getColumnModel().getColumn(2).setMinWidth(150);
		table.getColumnModel().getColumn(2).setMaxWidth(150);
		table.getColumnModel().getColumn(3).setMinWidth(80);
		table.getColumnModel().getColumn(3).setMaxWidth(80);
		
		table.setRowHeight(30);
		table.setShowVerticalLines(false);
		
//		
//		MyTableCellRenderer renderer = new MyTableCellRenderer();
//		
//		try {
//			table.setDefaultRenderer(Class.forName("java.lang.Object"), renderer);
//			
//			
//		} catch (ClassNotFoundException e4) {
//			
//		}

		// 테이블 폰트 설정
		table.setFont(new Font("맑은 고딕", Font.PLAIN, 17));

		// 컬럼명 폰트 설정
		JTableHeader tableHeader = table.getTableHeader();
		Font headerFont = new Font("맑은 고딕", Font.PLAIN, 17);
		
		table.setRowHeight(30); // 셀 높이 조정
		table.setCellSelectionEnabled(true); // 한셀만 선택가능
		table.getTableHeader().setReorderingAllowed(false); // 컬럼 헤더 고정 (이동 불가)
		table.getTableHeader().setResizingAllowed(false); // 컬럼 크기 고정 (변경 불가)

		ListSelectionModel selectionModel = table.getSelectionModel(); // 한 행만 선택가능

		selectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int row = table.rowAtPoint(e.getPoint());
		        int col = table.columnAtPoint(e.getPoint());
				
				System.out.println("행index:" + row + ",열index:" + col);
				System.out.println("눌린내용: " + table.getValueAt(row, col));
				System.out.println(table.getValueAt(row, 0));
				
				lectureName = (String) table.getValueAt(row, 0);
				
				MainPanel.lectureSearchPanel.setVisible(false);
				MainPanel.lectureInfoPanel.setVisible(true);
				LectureInfoPanel.cardLayout1.show(LectureInfoPanel.cardLayoutPanel,"상세정보");
				
				


				HashMap<String, String> detailInfoHash = new HashMap<>();

				String sql = "SELECT * FROM lecture_lists WHERE lecture_name = ? ";

				try (
						Connection con = OjdbcConnection.getConnection();
						PreparedStatement pstmt = con.prepareStatement(sql);
					) {
					pstmt.setString(1, lectureName);

					try (ResultSet rs = pstmt.executeQuery()) {
						while (rs.next()) {
							
							detailInfoHash.put(rs.getString("lecture_id"), rs.getString("lecture_info"));

							LectureInfoPanel1.detailInfoLabel.setText("\n"+(detailInfoHash.get(rs.getString("lecture_id"))));

							System.out.println("강의정보 : " + LectureInfoPanel1.detailInfoLabel.getText());
							
							LectureSearchPanel.currLectureId = rs.getInt("lecture_id");//////
							WishButton.currLectureId = rs.getInt("lecture_id");
							LectureInfoPanel.lectureNameLabel.setText(rs.getString("lecture_name"));
							LectureSearchPanel.lectureImageCategory = rs.getString("lecture_category");
							LectureInfoPanel.lectureTime = (rs.getString("timetable"));
							
							
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

	public class MyRenderer extends DefaultTableCellRenderer {
		Color color;
		int rowAtMouse;

		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
			if (!table.isRowSelected(row)) // 현재 선택된 행의 색상은 변경하지 않고 선택 해제된 경우에만 배경색상을 변경한다
			{
				if (row == rowAtMouse)
					c.setBackground(color);
				else
					c.setBackground(Color.WHITE);
			}
			return c;
		}
	}
	
	

}
