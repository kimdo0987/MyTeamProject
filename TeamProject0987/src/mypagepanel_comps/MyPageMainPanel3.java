package mypagepanel_comps;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.font.TextAttribute;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
	
	static JTable table;
	
	public MyPageMainPanel3() {
		setBackground(new Color(255, 153, 204));
		setBounds(118, 0, 1093, 800);
		setLayout(null);
		
		TopLabel toplabel = new TopLabel("나의 장바구니");
		toplabel.setLocation(335, 31);
		add(toplabel);	
		
		JPanel panel = new JPanel(); //장바구니List 테이블과 label이 들어가는 패널 (장바구니 panel)
		panel.setBounds(162, 155, 730, 488);
		panel.setLayout(null);
		add(panel);
		
		JLabel tableNameLabel = new JLabel("장바구니 리스트");
		tableNameLabel.setFont(new Font("", Font.PLAIN, 18));
		tableNameLabel.setBounds(12, 9, 148, 40);
		panel.add(tableNameLabel);
		
		JPanel tablePanel = new JPanel();
		tablePanel.setBounds(0, 58, 730, 430);		
		tablePanel.setLayout(null);
		panel.add(tablePanel);
		
		JTable table = new JTable(); // 수정불가능한 테이블로 생성
		
		DefaultTableModel model = new DefaultTableModel() {
			public Class<?> getColumnClass(int column) {
				switch(column) {
				case 0:
					return Boolean.class;
				default:
					return String.class;
				}
			}
		};

		table.setModel(model);
//		table.setPreferredScrollableViewportSize(new Dimension(700,600));
		
		//headings 설정
		model.addColumn("선택");
		model.addColumn("강의명");
		model.addColumn("강사명");
		model.addColumn("수강 기간");
		model.addColumn("수강료");
		model.addColumn("장바구니에서 삭제");
		
		//row 넣을 data
		String[][] data = database.MyWishLists.getMyWishLists();
		
		//the row
		for (int i = 0; i < data.length; i++) {
			model.addRow(new Object[0]); 
			model.setValueAt(false, i, 0); // checkbox 의 boolean type 이 되는데, true - 체크됨, false - 체크안됨
			//data
			model.setValueAt(data[i][0], i, 1); // (data[row][column], 위치 row번째 행, 위치 column)
			model.setValueAt(data[i][1], i, 2);
			model.setValueAt(data[i][2], i, 3);
			model.setValueAt(data[i][3], i, 4);
			model.setValueAt("삭제하기", i, 5);
		}
		
		//obtain selected row
//		JButton btn = new JButton("Get Selected");
////		add(btn);
//		table.add(btn);
//		btn.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				// TODO Auto-generated method stub
//				for (int i = 0; i < table.getRowCount(); i++) {
//					Boolean checked = Boolean.valueOf(table.getValueAt(i, 0).toString());
//					String col = table.getValueAt(i, 1).toString();
//					
//					//display
//					if (checked) {
//						JOptionPane.showMessageDialog(null, col);
//					}
//				}
//			}
//		});
		
//		table.getColumnModel().getColumn(0).setMinWidth(40);
//		table.getColumnModel().getColumn(0).setMaxWidth(40);
		table.getColumnModel().getColumn(1).setMinWidth(300);//셀 너비 조정
		table.getColumnModel().getColumn(1).setMaxWidth(300);
		table.getColumnModel().getColumn(2).setMinWidth(80);
		table.getColumnModel().getColumn(2).setMaxWidth(80);
		
		table.getColumnModel().getColumn(3).setMinWidth(130);
		table.getColumnModel().getColumn(3).setMaxWidth(130);
		table.getColumnModel().getColumn(4).setMinWidth(90);
		table.getColumnModel().getColumn(4).setMaxWidth(90);
		table.getColumnModel().getColumn(5).setMinWidth(100);
		table.getColumnModel().getColumn(5).setMaxWidth(100);
		
		///////////////////////////////////////////////////////
		
		MyRenderer cellRenderer = new MyRenderer();
		
//		table.getColumnModel().getColumn(0).setCellRenderer(cellRenderer);
		table.getColumnModel().getColumn(1).setCellRenderer(cellRenderer);
		table.getColumnModel().getColumn(2).setCellRenderer(cellRenderer);
		table.getColumnModel().getColumn(3).setCellRenderer(cellRenderer);
		table.getColumnModel().getColumn(4).setCellRenderer(cellRenderer);
		table.getColumnModel().getColumn(5).setCellRenderer(cellRenderer);
		
		table.setEnabled(true); //셀이 선택될 때 파란색으로 뜨는게 없어집니다.
		table.setSelectionBackground(Color.WHITE);
		
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
		        
		        String cell = ""; 
		        
		        if (row >= 0 && col >= 0) {
		            if (col == 5) {
		            	// 셀을 선택하면 이 테이블의 좌표가 (row, 0)인 값을 String 으로 cell 에 값을 저장함
		            	// -> 이렇게 cell 을 여기다 추가하면 삭제하기 버튼을 누를때 그 행의 강의명을 얻을 수 있음
		            	cell = table.getModel().getValueAt(row, 0).toString();

		            	new DeleteChkPopup(MainPanel.thisFrame, cell);
		            }
		        }
		    }
		    
		    @Override
		    public void mouseExited(MouseEvent e) {
		    	setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		    	table.setFont(new Font("Serif", Font.PLAIN, 13));
		    	cellRenderer.colAtMouse = -1;
		    }
		});
		
		// 테이블에서 마우스 커서 적용 먹이려면 모션리스너 -> Moved 이벤트로 해야 먹일 수 있습니다 
		// (다른 리스너,이벤트론 안됨)
		table.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				int row = table.rowAtPoint(e.getPoint());
		        int col = table.columnAtPoint(e.getPoint());
		        if (row >= 0 && col >= 0) {
		        	cellRenderer.rowAtMouse = row;
		        	cellRenderer.color = new Color(246,246,246);
		        	table.repaint();
		        	
		        	Font font = table.getFont();
					Map attributes = font.getAttributes();
					attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
		        	
		        	if(col == 5) {
		        		setCursor(new Cursor(Cursor.HAND_CURSOR));
		        		cellRenderer.colAtMouse = col;
		        		cellRenderer.fontunderLine = font.deriveFont(attributes);
		        	} else {
		        		setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		        		table.setFont(new Font("Serif", Font.PLAIN, 13));
		        		cellRenderer.colAtMouse = -1;
		        	}		        	
		        } else {
		        	setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		        	table.setFont(new Font("Serif", Font.PLAIN, 13));
		        	cellRenderer.colAtMouse = -1;
		        }
		        
		        if (col == 0) {
		        	table.setEnabled(true);
		        } else {
		        	table.setEnabled(false);
		        }
			}
		});
		
		MyPageTabButton paymentBtn = new MyPageTabButton("결제하기");
		paymentBtn.setBackground(new Color(255, 127, 80));
		paymentBtn.setBounds(604, 653, 287, 60);
		add(paymentBtn);
		
		table.setRowHeight(30); // 셀 높이 조정		
		table.setCellSelectionEnabled(true); // 한셀만 선택가능
		table.getTableHeader().setReorderingAllowed(false); //컬럼 헤더 고정 (이동 불가)
		table.getTableHeader().setResizingAllowed(false); // 컬럼 크기 고정 (변경 불가)
		
		
		ListSelectionModel selectionModel = table.getSelectionModel(); //한 행만 선택가능
		selectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); 	
		
		table.setFillsViewportHeight(true);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 0, 730, 430);		
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