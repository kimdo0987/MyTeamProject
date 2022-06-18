package mypagepanel_comps;

import java.awt.Color;

import javax.swing.JPanel;

import labels.TopLabel;

//쿠폰함 Panel이 될 JPanel입니다

public class MyPageMainPanel4 extends JPanel {
	public MyPageMainPanel4() {
		setBackground(new Color(204, 255, 204));
		setBounds(118, 0, 1093, 800);
		setLayout(null);
		
		TopLabel toplabel = new TopLabel("쿠폰함");
		toplabel.setLocation(335, 31);
		add(toplabel);
	}
}
