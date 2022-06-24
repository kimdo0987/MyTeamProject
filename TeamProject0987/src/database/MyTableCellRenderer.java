package database;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class MyTableCellRenderer extends DefaultTableCellRenderer {
	

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
		
		table.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseEntered(MouseEvent e) {
				int row = table.rowAtPoint(e.getPoint());
		        int col = table.columnAtPoint(e.getPoint());
		       
		        cell.setBackground(Color.BLACK);
		        cell.setForeground(Color.WHITE);
		      
			}
		});
		
		return cell;
	}
}
