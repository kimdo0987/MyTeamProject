package LectureInfoPanel_comps;

import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import database.OjdbcConnection;

// 상세정보 버튼을 누르면 등장하는 패널입니다.

public class LectureInfoPanel1 extends JPanel {
	
	public static JLabel detailInfoLabel = new JLabel();
	public LectureInfoPanel1() {

		setBounds(199, 371, 786, 390);
		setLayout(null);
		
		detailInfoLabel.setBackground(Color.WHITE);
		detailInfoLabel.setOpaque(true);
		detailInfoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		detailInfoLabel.setFont(new Font("굴림", Font.PLAIN, 24));
		detailInfoLabel.setBounds(0, 0, 786, 390);
		add(detailInfoLabel);


	}

}
