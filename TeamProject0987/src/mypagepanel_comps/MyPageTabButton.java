package mypagepanel_comps;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import panels.MainPanel;
import panels.MyPagePanel;

public class MyPageTabButton extends JButton {
	
	private String name;
	
	private ActionListener eventListener = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (name.equals("결제하기")) {
				MyPagePanel.cardLayoutPanel.remove(MyPagePanel.payPanel);
				MyPagePanel.payPanel = new PaymentPanel();
				MyPagePanel.cardLayoutPanel.add(MyPagePanel.payPanel, "결제하기");
				MyPagePanel.cardLayout1.show(MyPagePanel.cardLayoutPanel, "결제하기");
			} else if (name.equals("나의 장바구니")) {
					MyPagePanel.cardLayoutPanel.remove(MyPagePanel.mainPanel3);
					MyPagePanel.mainPanel3 = new MyPageMainPanel3();
					MyPagePanel.cardLayoutPanel.add(MyPagePanel.mainPanel3, "나의 장바구니");
					MyPagePanel.cardLayout1.show(MyPagePanel.cardLayoutPanel, "나의 장바구니");
			} else {
			// System.out.println(name); cardLayout에서 어떤 panel 꺼내오는지 확인
			MyPagePanel.cardLayout1.show(MyPagePanel.cardLayoutPanel, name);
			}
		}		
	};
	
	
	public MyPageTabButton(String name) {
		setText(name);
		this.name = name;
		addActionListener(eventListener);
		setBackground(Color.WHITE);
		
		
	}

}
