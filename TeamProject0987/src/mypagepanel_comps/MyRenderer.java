package mypagepanel_comps;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class MyRenderer extends DefaultTableCellRenderer {
	Color color;
	int rowAtMouse;

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
		if (!table.isRowSelected(row)) // 현재 선택된 행의 색상은 변경하지 않고 선택 해제된 경우에만 배경색상을 변경한다
		{
			if (row == rowAtMouse) {
				c.setBackground(color);					
			} else {
				c.setBackground(Color.WHITE);
				c.setFont(new Font("Serif", Font.PLAIN, 13));					
			}
		}
		return c;
	}
}