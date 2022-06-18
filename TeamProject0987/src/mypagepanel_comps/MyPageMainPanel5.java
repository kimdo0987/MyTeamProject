package mypagepanel_comps;

import java.awt.Color;

import javax.swing.JPanel;

import labels.TopLabel;

//구매 내역 Panel이 될 JPanel입니다

public class MyPageMainPanel5 extends JPanel {
	public MyPageMainPanel5() {
		setBackground(new Color(204, 255, 102));
		setBounds(118, 0, 1093, 800);	
		setLayout(null);
		
		TopLabel toplabel = new TopLabel("구매 내역");
		toplabel.setLocation(335, 31);
		add(toplabel);
	}
}
