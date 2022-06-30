package mypagepanel_comps;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultButtonModel;
import javax.swing.Icon;
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
			} else if(name.equals("계정 관리")){
				MyPagePanel.cardLayoutPanel.remove(MyPagePanel.mainPanel6);
				MyPagePanel.mainPanel6 = new MyPageMainPanel6();
				MyPagePanel.cardLayoutPanel.add(MyPagePanel.mainPanel6, "계정 관리");
				MyPagePanel.cardLayout1.show(MyPagePanel.cardLayoutPanel, "계정 관리");
				
			}else {
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
	
	 /**
     * Creates a button with an icon.
     *
     * @param icon  the Icon image to display on the button
     */
    public MyPageTabButton(Icon icon) {
        this(null, icon);
    }

    /**
     * Creates a button with initial text and an icon.
     *
     * @param text  the text of the button
     * @param icon  the Icon image to display on the button
     */
    public MyPageTabButton(String name, Icon icon) {
        // Create the model
        setModel(new DefaultButtonModel());
        setText(name);
		this.name = name;
		addActionListener(eventListener);
        // initialize
        init(name, icon);
    }
}
