package mypagepanel_comps;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.font.TextAttribute;
import java.util.Map;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import labels.TopLabel;
import mypagepanel_comps.frames.CancelLectureFrame;
import mypagepanel_comps.frames.CommentsFrame;
import panels.ImagePanel;
import panels.MainPanel;
import popups.DeleteChkPopup;
import mypagepanel_comps.MyRenderer;

//나의 수강 조회 Panel이 될 JPanel입니다

public class MyPageMainPanel1 extends ImagePanel {
	public MyPageMainPanel1() {
		setBackground(new Color(153, 204, 204));
		setBounds(118, 0, 1093, 800);
		setLayout(null);
		
		JPanel panel = new JPanel(); //테이블과 label이 들어가는 패널 (나의수강목록 panel)
		panel.setBounds(80, 154, 800, 560);
		panel.setLayout(null);
		
		
		JPanel tablePanel = new JPanel();
		tablePanel.setBounds(0, 0, 800, 568);	
		
		String[] headings = new String[] {"강의명","강사명","수강기간", "수강평작성", "수강포기", "출석률"};
		String[][] data = database.MyLectureLists.getMyLectureLists();
		tablePanel.setLayout(null);
		
		
		// 테이블의 셀 내용 수정 불가 시작 //
		DefaultTableModel mod = new DefaultTableModel(data, headings) {
			public boolean isCellEditable(int rowIndex, int mColIndex) {
				return false;
			}
		};

		JTable table = new JTable(mod); // 수정불가능한 테이블로 생성
//		table.setPreferredScrollableViewportSize(new Dimension(700,600));
		
		table.getColumnModel().getColumn(0).setMinWidth(360);//셀 너비 조정
		table.getColumnModel().getColumn(0).setMaxWidth(360);
		table.getColumnModel().getColumn(1).setMinWidth(100);
		table.getColumnModel().getColumn(1).setMaxWidth(100);
		table.getColumnModel().getColumn(2).setMinWidth(140);
		table.getColumnModel().getColumn(2).setMaxWidth(140);		
		table.getColumnModel().getColumn(3).setMinWidth(75);
		table.getColumnModel().getColumn(3).setMaxWidth(75);
		table.getColumnModel().getColumn(4).setMinWidth(70);
		table.getColumnModel().getColumn(4).setMaxWidth(70);
		table.getColumnModel().getColumn(5).setMinWidth(55);
		table.getColumnModel().getColumn(5).setMaxWidth(55);
		
		
		table.setRowHeight(30); // 셀 높이 조정		
		table.setCellSelectionEnabled(true); // 한셀만 선택가능
		table.getTableHeader().setReorderingAllowed(false); //컬럼 헤더 고정 (이동 불가)
		table.getTableHeader().setResizingAllowed(false); // 컬럼 크기 고정 (변경 불가)
		
		
		ListSelectionModel selectionModel = table.getSelectionModel(); //한 행만 선택가능
		selectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); 
		
		// 한 컬럼만 선택가능 넣어야함  
		
		
		MyRenderer cellRenderer = new MyRenderer();
		
		table.getColumnModel().getColumn(0).setCellRenderer(cellRenderer);
		table.getColumnModel().getColumn(1).setCellRenderer(cellRenderer);
		table.getColumnModel().getColumn(2).setCellRenderer(cellRenderer);
		table.getColumnModel().getColumn(3).setCellRenderer(cellRenderer);
		table.getColumnModel().getColumn(4).setCellRenderer(cellRenderer);

		
		
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
		        	String a = table.getValueAt(row, 5).toString().substring(0, 2);
		        	if (col == 3) {
		        		if(Integer.parseInt(a)<19) {/////////////////////////////////////////////////////////////////
		        			JOptionPane.showMessageDialog(MainPanel.thisFrame, "수강률이 50% 이상만 작성할 수 있습니다",
									"비밀번호 확인", 1);
		        		}else {
						new CommentsFrame(""+table.getValueAt(row, 0),""+table.getValueAt(row, 1));
		        		}
					} else if (col == 4) {

						new CancelLectureFrame(""+table.getValueAt(row, 0),""+table.getValueAt(row, 1));
					} else {
						
					}
		        }
		    }
		    
		    @Override
		    public void mouseExited(MouseEvent e) {
		    	// 테이블 폰트 설정
				table.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		    	setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		    	//table.setFont(new Font("Serif", Font.PLAIN, 13));
		    	cellRenderer.colAtMouse = -1;
		    }
		});
		
		table.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				// 테이블 폰트 설정
				table.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
				
				int row = table.rowAtPoint(e.getPoint());
		        int col = table.columnAtPoint(e.getPoint());
		        if (row >= 0 && col >= 0) {
		        	// 폰트 밑줄 넣는 코드
		        	cellRenderer.rowAtMouse = row;
		        	cellRenderer.colAtMouse = col;
		        	cellRenderer.color = new Color(246,246,246);
		        	table.repaint();
		        	
		        	// 폰트 밑줄 넣는 코드
		        	Font font = table.getFont();
		        	Map attributes = font.getAttributes();
		        	attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
		        	
		        	if(col == 3 || col == 4) {
		        		setCursor(new Cursor(Cursor.HAND_CURSOR));
		        		cellRenderer.colAtMouse = col;
		        		cellRenderer.fontunderLine = font.deriveFont(attributes);
		        	} else {
		        		setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		        		//table.setFont(new Font("Serif", Font.PLAIN, 13));
		        		cellRenderer.colAtMouse = -1;
		        	}	
		        } else {
		        	setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		        	//table.setFont(new Font("Serif", Font.PLAIN, 13));
		        	cellRenderer.colAtMouse = -1;
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
		
		// 테이블 폰트 설정
		table.setFont(new Font("맑은 고딕", Font.PLAIN, 14));

		// 컬럼명 폰트 설정
		JTableHeader tableHeader = table.getTableHeader();
		Font headerFont = new Font("맑은 고딕", Font.PLAIN, 14);
		tableHeader.setFont(headerFont);

		
		JLabel tableNameLabel = new JLabel("수강 목록");
		tableNameLabel.setForeground(Color.WHITE);
		tableNameLabel.setBounds(80, 40, 280, 90);
		add(tableNameLabel);
		tableNameLabel.setFont(new Font("배달의민족 도현", Font.PLAIN, 58));
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBounds(80, 124, 800, 3);
		add(lblNewLabel);
		
		
		
		
		

		
	}
}
