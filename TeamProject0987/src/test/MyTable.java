package test;

import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class MyTable extends JFrame {
	
	//constructor
	public MyTable() {
		// the form
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 800, 300);
		setTitle("ProgrammingWizards Channel");
		getContentPane().setLayout(null);
		
		//ADD SCROLLPANE
		JScrollPane scroll = new JScrollPane();
		scroll.setBounds(70, 80, 628, 201);
		getContentPane().add(scroll); // scrollable
		
		//the table
		JTable table = new JTable();
		scroll.setViewportView(table); //이거 해주면 scrollPane에 JTable 담은거임
		
		
		//////////////////////////////////////////////////////////////////////
		
		
		//the model of our table
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
		
		//assign the model to table
		table.setModel(model);
		
		//headings 설정
		model.addColumn("체크박스");
		model.addColumn("강의명");
		model.addColumn("강사명");
		model.addColumn("수강기간");
		model.addColumn("수강료");
		model.addColumn("장바구니에서 삭제");
		
		String[][] data = database.MyWishLists.getMyWishLists();
		
		//the row
		for (int i = 0; i < data.length; i++) {
			model.addRow(new Object[0]); // 어떤 숫자를 넣어도 바뀌지 않음...
			model.setValueAt(false, i, 0); // checkbox 의 boolean type 이 되는데, true - 체크됨, false - 체크안됨
			//data
			model.setValueAt(data[i][0], i, 1); // (data[row][column], 위치 row번째 행, 위치 column)
			model.setValueAt(data[i][1], i, 2);
			model.setValueAt(data[i][2], i, 3);
			model.setValueAt(data[i][3], i, 4);
			model.setValueAt("삭제하기", i, 5);
		}
		
		//obtain selected row
		JButton btn = new JButton("Get Selected");
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				for (int i = 0; i < table.getRowCount(); i++) {
					Boolean checked = Boolean.valueOf(table.getValueAt(i, 0).toString());
					String col = table.getValueAt(i, 1).toString();
					
					//display
					if (checked) {
						JOptionPane.showMessageDialog(null, col);
					}
				}
			}
		});
		
		table.addMouseMotionListener(new MouseAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				int row = table.rowAtPoint(e.getPoint());
		        int col = table.columnAtPoint(e.getPoint());
		        if(col == 5) {
		        	setCursor(new Cursor(Cursor.HAND_CURSOR));
		        } else {
		        	setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		        }
			}
		});
		
		//add button to form
		btn.setBounds(70, 30, 130, 30);
		getContentPane().add(btn);
		
		setVisible(true);
	}
	
	// main method eventqueue 는 뭐하는 건지 모르겠는데 주석처리해도 괜찮은듯
	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				//Initialize JFrame Form
//				MyTable form = new MyTable();
//				form.setVisible(true);
//			}
//		});
		new MyTable();
	}
}
