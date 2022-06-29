package mypagepanel_comps.mp6;

import java.awt.CardLayout;

import javax.swing.JPanel;
import java.awt.Color;
     
public class MpChangePanel extends JPanel {
	public static CardLayout mpLayout = new CardLayout();
	public static JPanel mpPanel = new JPanel();
	public static MpPwChangePanel mpPanel1 = new MpPwChangePanel();
	public static MpPhoneNumChangePanel mpPanel2 = new MpPhoneNumChangePanel();
	public static MpEmailChangePanel mpPanel3 = new MpEmailChangePanel();
	public static MyProfilePanel mpPanel0 = new MyProfilePanel();

	public MpChangePanel() {
		setOpaque(false);
		setBackground(Color.DARK_GRAY);

		setBounds(0, 58, 730, 511);
		setLayout(null);
		mpPanel.setBackground(Color.DARK_GRAY);
		mpPanel.setOpaque(false);
		mpPanel.setBounds(0, 0, 800, 560);
		mpPanel.setLayout(mpLayout);
		mpPanel0.setOpaque(false);

		mpPanel.add(mpPanel0,"profile");
		mpPanel1.setOpaque(false);
		mpPanel.add(mpPanel1, "password");
		mpPanel2.setOpaque(false);
		mpPanel.add(mpPanel2, "phoneNum");
		mpPanel3.setOpaque(false);
		mpPanel.add(mpPanel3, "email");

		add(mpPanel);

	}
}
