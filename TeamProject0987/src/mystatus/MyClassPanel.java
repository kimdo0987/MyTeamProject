package mystatus;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyClassPanel extends JPanel {
	
	head.HeadPanel headPanel = new head.HeadPanel();
	MyClassCategoryPanel categoryPanel = new MyClassCategoryPanel();
	
	static MyClassMainPanel mainPanel = new MyClassMainPanel();
	static MyClassMainPanel2 mainPanel2 = new MyClassMainPanel2();
	static MyClassMainPanel3 mainPanel3 = new MyClassMainPanel3();
	static MyClassMainPanel4 mainPanel4 = new MyClassMainPanel4();
	
	public static JPanel currPanel;
	
	
	public MyClassPanel() {
		setLayout(new BorderLayout());
		add(headPanel, "North");
		add(categoryPanel, "West");
		add(mainPanel, "Center");
		add(mainPanel2, "Center");
		add(mainPanel3, "Center");
		add(mainPanel4, "Center");
		
		currPanel = mainPanel;
		
		mainPanel.setVisible(true);
		mainPanel2.setVisible(false);
		mainPanel3.setVisible(false);
		mainPanel4.setVisible(false);
		
		setBounds(1000, 100, 600, 800);
		
		
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.add(new MyClassPanel());
		frame.setBounds(1000, 100, 600, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
