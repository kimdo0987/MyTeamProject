package mypagepanel_comps;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import labels.TopLabel;
import mypagepanel_comps.frames.CancelLectureFrame;
import mypagepanel_comps.frames.CommentsFrame;
import panels.MainPanel;
import popups.DeleteChkPopup;

//나의 수강 조회 Panel이 될 JPanel입니다

public class MyPageMainPanel1 extends JPanel {
	
	public MyPageMainPanel1() {
		setBackground(new Color(153, 204, 204));
		setBounds(118, 0, 1093, 800);
		setLayout(null);
		
		
		TopLabel toplabel = new TopLabel("나의 수강 조회");
		toplabel.setLocation(335, 31);
		add(toplabel);	
		
		JPanel panel = new JPanel(); //테이블과 label이 들어가는 패널 (나의수강목록 panel)
		panel.setBounds(162, 155, 730, 569);
		panel.setLayout(null);
		

		JLabel tableNameLabel = new JLabel("수강 목록");
		tableNameLabel.setFont(new Font("", Font.PLAIN, 18));
		tableNameLabel.setBounds(12, 9, 148, 40);
		panel.add(tableNameLabel);
		
		
		JPanel tablePanel = new JPanel();
		tablePanel.setBounds(0, 58, 730, 511);	
		
		String[] headings = new String[] {"강의명","강사명","수강시작일", "수강평작성", "수강포기"};
		String[][] data = database.MyLectureLists.getMyLectureLists();
		tablePanel.setLayout(null);
		
		
		// 테이블의 셀 내용 수정 불가 시작 //
		DefaultTableModel mod = new DefaultTableModel(data, headings) {
			public boolean isCellEditable(int rowIndex, int mColIndex) {
				return false;
			}
		};

		JTable table = new JTable(mod); // 수정불가능한 테이블로 생성
		table.setPreferredScrollableViewportSize(new Dimension(700,600));
		
		table.getColumnModel().getColumn(0).setMinWidth(300);//셀 너비 조정
		table.getColumnModel().getColumn(0).setMaxWidth(300);
		table.getColumnModel().getColumn(1).setMinWidth(100);
		table.getColumnModel().getColumn(1).setMaxWidth(100);
		table.getColumnModel().getColumn(2).setMinWidth(150);
		table.getColumnModel().getColumn(2).setMaxWidth(150);		
		table.getColumnModel().getColumn(3).setMinWidth(80);
		table.getColumnModel().getColumn(3).setMaxWidth(80);
		table.getColumnModel().getColumn(4).setMinWidth(100);
		table.getColumnModel().getColumn(4).setMaxWidth(100);
		
		table.setRowHeight(30); // 셀 높이 조정		
		table.setCellSelectionEnabled(true); // 한셀만 선택가능
		table.getTableHeader().setReorderingAllowed(false); //컬럼 헤더 고정 (이동 불가)
		table.getTableHeader().setResizingAllowed(false); // 컬럼 크기 고정 (변경 불가)
		
		
		ListSelectionModel selectionModel = table.getSelectionModel(); //한 행만 선택가능
		selectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); 
		
		// 한 컬럼만 선택가능 넣어야함  
		
		
		// 수강평 쓴 아이디는 다시 접근할 수 없게 만들어야함
		
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
		        //System.out.println(row + "and" + col);
		        if (row >= 0 && col >= 0) {
		        	if (col == 3) {
						new CommentsFrame(""+table.getValueAt(row, 0),""+table.getValueAt(row, 1));
					} else if (col == 4) {
						new CancelLectureFrame(""+table.getValueAt(row, 0),""+table.getValueAt(row, 1));
					} else {
						
					}
		        }
		    }
		    
		    @Override
		    public void mouseExited(MouseEvent e) {
		    	setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		    }
		});
		
		table.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				int row = table.rowAtPoint(e.getPoint());
		        int col = table.columnAtPoint(e.getPoint());
		        if (row >= 0 && col >= 0) {
		        	if(col == 3 || col == 4) {
		        		setCursor(new Cursor(Cursor.HAND_CURSOR));
		        	} else {
		        		setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		        	}	
		        } else {
		        	setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		        }
			}
			
		});
		
		//테이블 생성에 관한 내용
		table.setFillsViewportHeight(true);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 0, 730, 500);
		scrollPane.setSize(getSize());
		tablePanel.add(scrollPane);
		panel.add(tablePanel);

		add(panel);
		
		
		
		
		

		
	}
}
