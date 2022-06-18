package mypagepanel_comps;

import java.awt.Color;

import javax.swing.JPanel;

import labels.TopLabel;

//출결 현황 조회 Panel이 될 JPanel입니다

public class MyPageMainPanel2 extends JPanel {
	public MyPageMainPanel2() {
		setBackground(new Color(102, 153, 204));
		setBounds(118, 0, 1093, 800);
		setLayout(null);
		
		TopLabel toplabel = new TopLabel("출결 현황 조회");
		toplabel.setLocation(335, 31);
		add(toplabel);	
	}
}
