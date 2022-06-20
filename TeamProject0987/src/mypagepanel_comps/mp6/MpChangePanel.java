package mypagepanel_comps.mp6;

import java.awt.CardLayout;

import javax.swing.JPanel;

public class MpChangePanel extends JPanel {
	public static CardLayout mpLayout = new CardLayout();
	public static JPanel mpPanel = new JPanel();
	public static MpPwChangePanel mpPanel1 = new MpPwChangePanel();
	public static MpPhoneNumChangePanel mpPanel2 = new MpPhoneNumChangePanel();
	public static MpEmailChangePanel mpPanel3 = new MpEmailChangePanel();

	public MpChangePanel() {

		setBounds(0, 58, 730, 511);
		setLayout(null);
		mpPanel.setBounds(0, 58, 730, 511);
		mpPanel.setLayout(mpLayout);

		mpPanel.add(mpPanel1, "password");
		mpPanel.add(mpPanel2, "phoneNum");
		mpPanel.add(mpPanel3, "email");

		add(mpPanel);

	}
}
