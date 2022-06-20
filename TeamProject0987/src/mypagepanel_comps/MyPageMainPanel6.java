package mypagepanel_comps;

import java.awt.Color;

import javax.swing.JPanel;

import labels.TopLabel;

//계정 관리 Panel이 될 JPanel입니다

public class MyPageMainPanel6 extends JPanel {
	public MyPageMainPanel6() {
		setBackground(new Color(204, 235, 204));
		setBounds(118, 0, 1093, 800);	
		setLayout(null);
		
		TopLabel toplabel = new TopLabel("계정 관리");
		toplabel.setLocation(335, 31);
		add(toplabel);
	}
}
