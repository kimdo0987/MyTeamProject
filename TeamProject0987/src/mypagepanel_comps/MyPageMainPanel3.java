package mypagepanel_comps;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import labels.TopLabel;
import panels.MainPanel;
import popups.DeleteChkPopup;

//나의 장바구니 Panel이 될 JPanel입니다

public class MyPageMainPanel3 extends JPanel {
	public MyPageMainPanel3() {
		setBackground(new Color(255, 153, 204));
		setBounds(118, 0, 1093, 800);
		setLayout(null);
		
		TopLabel toplabel = new TopLabel("나의 장바구니");
		toplabel.setLocation(335, 31);
		add(toplabel);	
		
		JPanel panel = new JPanel(); //장바구니List 테이블과 label이 들어가는 패널 (장바구니 panel)
		panel.setBounds(162, 155, 730, 569);
		panel.setLayout(null);
		add(panel);
		
		JLabel tableNameLabel = new JLabel("장바구니 리스트");
		tableNameLabel.setFont(new Font("", Font.PLAIN, 18));
		tableNameLabel.setBounds(12, 9, 148, 40);
		panel.add(tableNameLabel);
		
		JPanel tablePanel = new JPanel();
		tablePanel.setBounds(0, 58, 730, 511);		
		tablePanel.setLayout(null);
		panel.add(tablePanel);
		
		String[] headings = new String[] {"강의명","강사명","수강 기간","수강료","장바구니에서 삭제"};
		String[][] data = database.MyWishLists.getMyWishLists();
		
		// 테이블의 셀 내용 수정 불가 시작 //
		DefaultTableModel mod = new DefaultTableModel(data, headings) {
			public boolean isCellEditable(int rowIndex, int mColIndex) {
				return false;
			}
		};

		JTable table = new JTable(mod); // 수정불가능한 테이블로 생성
		table.setPreferredScrollableViewportSize(new Dimension(700,600));
		
		
		table.getColumnModel().getColumn(0).setMinWidth(310);//셀 너비 조정
		table.getColumnModel().getColumn(0).setMaxWidth(310);
		table.getColumnModel().getColumn(1).setMinWidth(80);
		table.getColumnModel().getColumn(1).setMaxWidth(80);
		
		table.getColumnModel().getColumn(2).setMinWidth(140);
		table.getColumnModel().getColumn(2).setMaxWidth(140);
		table.getColumnModel().getColumn(3).setMinWidth(90);
		table.getColumnModel().getColumn(3).setMaxWidth(90);
		table.getColumnModel().getColumn(4).setMinWidth(110);
		table.getColumnModel().getColumn(4).setMaxWidth(110);
		
		table.setEnabled(false); //셀이 선택될 때 파란색으로 뜨는게 없어집니다.
		
		table.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		    	// getPoint 는 좌표를 뽑아오는건데 rowAtPoint, columnAtPoint 는 
		    	// 행과 열의 범위를 좌표화해서 뽑아옵니다.
		    	/*
		    	
					int javax.swing.JTable.rowAtPoint(Point point)
					
					Returns the index of the row that point lies in,or -1 
					if the result is not in the range[0, getRowCount()-1].
					
					Parameters:point the location of interestReturns:
					the index of the row that point lies in,or -1 
					if the result is not in the range[0, getRowCount()-1]
					
					See Also:columnAtPoint 
					
		    	*/
		        int row = table.rowAtPoint(e.getPoint());
		        int col = table.columnAtPoint(e.getPoint());
		        System.out.println(row + "and" + col);
		        if (row >= 0 && col >= 0) {
		            if (col == 4) {
		            	new DeleteChkPopup(MainPanel.thisFrame);
		            }
		        }
		    }
		    
		});
		
		// 이전 코드의 문제점 : 셀이 선택될 때 따른 테이블 범위를 클릭하면 이벤트가 발생하게 됨
//		table.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				
//				int row = table.getSelectedRow();
//				int col = table.getSelectedColumn();		
//				
//				if (col == 4) {
//					new DeleteChkPopup(MainPanel.thisFrame);
//				} 
//				
//			}
//		});
		
		table.setRowHeight(30); // 셀 높이 조정		
		table.setCellSelectionEnabled(true); // 한셀만 선택가능
		table.getTableHeader().setReorderingAllowed(false); //컬럼 헤더 고정 (이동 불가)
		table.getTableHeader().setResizingAllowed(false); // 컬럼 크기 고정 (변경 불가)
		
		
		ListSelectionModel selectionModel = table.getSelectionModel(); //한 행만 선택가능
		selectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); 	
		
		table.setFillsViewportHeight(true);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 0, 730, 500);		
		tablePanel.add(scrollPane);		
		panel.add(tablePanel);
		
		
	}
}
