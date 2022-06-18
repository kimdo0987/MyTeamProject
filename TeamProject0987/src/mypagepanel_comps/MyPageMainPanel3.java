package mypagepanel_comps;

import java.awt.Color;

import javax.swing.JPanel;

import labels.TopLabel;

//나의 장바구니 Panel이 될 JPanel입니다

public class MyPageMainPanel3 extends JPanel {
	public MyPageMainPanel3() {
		setBackground(new Color(255, 153, 204));
		setBounds(118, 0, 1093, 800);
		setLayout(null);
		
		TopLabel toplabel = new TopLabel("나의 장바구니");
		toplabel.setLocation(335, 31);
		add(toplabel);	
		
	}
}
