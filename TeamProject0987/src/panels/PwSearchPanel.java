package panels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import buttons.GoToButton;
import labels.TopLabel;

public class PwSearchPanel extends JPanel {

	public PwSearchPanel() {
		setBounds(0, 0, 1200, 800);
		setLayout(null);
		
		JButton lastPageBtn = new JButton("이전");
		lastPageBtn.setBounds(23, 36, 70, 44);
		add(lastPageBtn);
		lastPageBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MainPanel.currPanel.setVisible(false);
				MainPanel.loginPanel.setVisible(true);
				MainPanel.currPanel = MainPanel.loginPanel;		
			}
		});
		
		
		GoToButton mainBtn = new GoToButton("메인");
		mainBtn.setBounds(105, 36, 70, 44);
		add(mainBtn);	
		
		TopLabel toplabel = new TopLabel("비밀번호 찾기");
		add(toplabel);
		
		JTextField idInput = new JTextField("아이디 입력");
		add(idInput);
		idInput.setBounds(420, 220, 300, 30);
		idInput.setHorizontalAlignment(JTextField.CENTER);
		
		JTextField nameInput = new JTextField("이름 입력");
		add(nameInput);
		nameInput.setBounds(420, 250, 300, 30);
		
		JTextField pwInput = new JTextField("주민등록번호 입력");
		add(pwInput);
		pwInput.setBounds(420, 280, 300, 30);
		
		
		
		JButton idSearchBtn = new JButton("아이디 조회");
		add(idSearchBtn);
		idSearchBtn.setBounds(470, 350, 200, 50);
	}
	
//	public static void main(String[] args) {
//		JFrame frame = new JFrame();
//		frame.add(new PwSearchPanel());
//		
//		
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setBounds(0, 0, 1200, 800);
//		frame.setVisible(true);
//	}
	
}
