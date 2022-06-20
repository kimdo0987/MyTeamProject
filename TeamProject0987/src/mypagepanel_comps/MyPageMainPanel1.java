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
import mypagepanel_comps.frames.CancelLectureFrame;
import mypagepanel_comps.frames.CommentsFrame;

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
		
		
		String[] headings = new String[] {"강의명","강사명","수강기간","출석률","수강평작성","수강포기"};
		Object[][] data = new Object[][] {
			{"DataBase 입문","김교수","22.06.18 ~ 22.07.18", 7 + "%", "수강평작성", "수강포기"},
			{"JAVA 입문", "이강사","22.06.18 ~ 22.07.18", 7 + "%", "수강평작성", "수강포기"},
			{"SQl 입문","차강사","22.06.18 ~ 22.07.18", 7 + "%", "수강평작성", "수강포기"},
			{"MachineLearing 입문","도강사","22.06.18 ~ 22.07.18", 7 + "%", "수강평작성", "수강포기"}			
		};
		tablePanel.setLayout(null);
		
		
		// 테이블의 셀 내용 수정 불가 시작 //
		DefaultTableModel mod = new DefaultTableModel(data, headings) {
			public boolean isCellEditable(int rowIndex, int mColIndex) {
				return false;
			}
		};

		JTable table = new JTable(mod); // 수정불가능한 테이블로 생성
		table.setPreferredScrollableViewportSize(new Dimension(700,600));
		
		table.getColumnModel().getColumn(1).setMinWidth(50);//셀 너비 조정
		table.getColumnModel().getColumn(1).setMaxWidth(50);
		table.getColumnModel().getColumn(2).setMinWidth(120);
		table.getColumnModel().getColumn(2).setMaxWidth(120);
		table.getColumnModel().getColumn(3).setMinWidth(50);
		table.getColumnModel().getColumn(3).setMaxWidth(50);
		table.getColumnModel().getColumn(4).setMinWidth(70);
		table.getColumnModel().getColumn(4).setMaxWidth(70);
		table.getColumnModel().getColumn(5).setMinWidth(70);
		table.getColumnModel().getColumn(5).setMaxWidth(70);
		
		table.setRowHeight(30); // 셀 높이 조정		
		table.setCellSelectionEnabled(true); // 한셀만 선택가능
		table.getTableHeader().setReorderingAllowed(false); //컬럼 헤더 고정 (이동 불가)
		table.getTableHeader().setResizingAllowed(false); // 컬럼 크기 고정 (변경 불가)
		
		
		ListSelectionModel selectionModel = table.getSelectionModel(); //한 행만 선택가능
		selectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); 
		
		
		// 한 컬럼만 선택가능 넣어야함  
		
		
		// 수강평 쓴 아이디는 다시 접근할 수 없게 만들어야함
		
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int row = table.getSelectedRow();
				int col = table.getSelectedColumn();
				System.out.println("행index:"+row +",열index:"+col );
				System.out.println("눌린내용: " + table.getValueAt(row, col)); 
				
				if (col == 4) {
					new CommentsFrame(""+table.getValueAt(row, 0),""+table.getValueAt(row, 1));
				} else if (col == 5) {
					new CancelLectureFrame(""+table.getValueAt(row, 0),""+table.getValueAt(row, 1));
				} else {
					
				}
				
			}
		});
		
		
		//테이블 생성에 관한 내용
		table.setFillsViewportHeight(true);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 0, 730, 500);
		tablePanel.add(scrollPane);
		
		panel.add(tablePanel);
		
		add(panel);
		
		
		
		
		

		
	}
}
