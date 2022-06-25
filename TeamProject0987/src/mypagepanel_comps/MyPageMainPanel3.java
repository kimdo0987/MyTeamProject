package mypagepanel_comps;

import java.awt.BorderLayout;
import java.awt.Color;

import java.awt.Component;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.CellEditor;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import labels.TopLabel;
import panels.MainPanel;
import popups.DeleteChkPopup;

//나의 장바구니 Panel이 될 JPanel입니다

public class MyPageMainPanel3 extends JPanel {
	
	static JTable table;
	
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
		
		///////////////////////////////////////////////////////
		DefaultTableCellRenderer renderer = new DefaultTableCellRenderer() {
			@Override
			public Component getTableCellRendererComponent(JTable table, Object value, 
					boolean isSelected, boolean hasFocus, int row, int column) {
				
				Component c = super.getTableCellRendererComponent(
						table, value, isSelected, hasFocus, row, column);
				
				return c;
			}
		};
		
		for (int i = 0; i < 4; i++) {
			table.getColumnModel().getColumn(i).setCellRenderer(renderer);
		}
		//////////////////////////////////////////////////////////
		
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
		        
		        String cell = ""; 
		        
		        if (row >= 0 && col >= 0) {
		            if (col == 4) {
		            	// 셀을 선택하면 이 테이블의 좌표가 (row, 0)인 값을 String 으로 cell 에 값을 저장함
		            	// -> 이렇게 cell 을 여기다 추가하면 삭제하기 버튼을 누를때 그 행의 강의명을 얻을 수 있음
		            	cell = table.getModel().getValueAt(row, 0).toString();

		            	new DeleteChkPopup(MainPanel.thisFrame, cell);
		            }
		        }
		        
		    }
		});
		
		// 테이블에서 마우스 커서 적용 먹이려면 모션리스너 -> Moved 이벤트로 해야 먹일 수 있습니다 
		// (다른 리스너,이벤트론 안됨)
		table.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				int row = table.rowAtPoint(e.getPoint());
		        int col = table.columnAtPoint(e.getPoint());
		        if(col == 4) {
		        	setCursor(new Cursor(Cursor.HAND_CURSOR));
		        } else {
		        	setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		        }
			}

		});
		table.addMouseMotionListener(new MouseMotionAdapter() {
			
			@Override
			public void mouseMoved(MouseEvent e) {
		
				int row = table.rowAtPoint(e.getPoint());
		        int col = table.columnAtPoint(e.getPoint());
		        //System.out.println("마우스위치- 행:" +row +"|열:"+ col);
		        if(col == 4) {
		        	setCursor(new Cursor(Cursor.HAND_CURSOR));
		        } else {
		        	setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
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
		setTable(table);
		
	}
	
	public void setTable(JTable table) {
		this.table = table;
	}
	
	public static JTable getTable() {
		return table;
	}
}