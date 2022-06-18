package mypagepanel_comps;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import panels.MyPagePanel;

public class MyPageTabButton extends JButton {
	
	String name;
	
	private ActionListener eventListener = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// System.out.println(name); cardLayout에서 어떤 panel 꺼내오는지 확인
			MyPagePanel.cardLayout1.show(MyPagePanel.cardLayoutPanel, name);
		}		
	};
	
	
	public MyPageTabButton(String name) {
		setText(name);
		this.name = name;
		addActionListener(eventListener);
		setBackground(Color.WHITE);
	}

}
