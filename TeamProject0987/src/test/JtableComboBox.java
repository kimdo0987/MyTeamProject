package test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class JtableComboBox extends JFrame {
	
	//constructor
	public JtableComboBox() {
		
		//set title
		super("JCOMBO IN JTABLE");
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//our table model
		DefaultTableModel dm = new DefaultTableModel();
		
		//our data
		dm.setDataVector(new Object[][] {
					{"1", "Ander Herera", "Choose.."},
					{"2", "Juan Mata", "Choose.."},
					{"3", "David DeGea", "Choose.."},
					{"4", "Eden Hazard", "Choose.."},
					{"5", "Wayne Rooney", "Choose.."},
					{"6", "Romelu Lukaku", "Choose.."},
					{"7", "Phill jones", "Choose.."},
				},
				new Object[] {"No", "Name", "Position"});
		
		//our table
		JTable table = new JTable(dm);
		
		//our combobox
		String[] positions = {"Striker", "Midfielder", "Defender", "Goalkeeper"};
		JComboBox combo = new JComboBox<String>(positions);
		combo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// display nselected stuff
				JOptionPane.showMessageDialog(null, combo.getSelectedItem());
			}
		});
		
		//our combo column
		TableColumn col = table.getColumnModel().getColumn(2);
		col.setCellEditor(new DefaultCellEditor(combo));
		
		//our scrollpane
		JScrollPane pane = new JScrollPane(table);
		getContentPane().add(pane);
		setSize(350, 200);
		setVisible(true);
	}
	
	//main method
	public static void main(String[] args) {
		//call our form
		new JtableComboBox();
	}
}
