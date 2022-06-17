package panels;




import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import buttons.GoToButton;
import labels.TopLabel;

public class IdSearchPanel extends JPanel{

	public IdSearchPanel() {
	
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
		
		
		GoToButton firstPageBtn = new GoToButton("메인");
		firstPageBtn.setBounds(105, 36, 70, 44);
		add(firstPageBtn);		
			
		TopLabel toplabel = new TopLabel("아이디 찾기");
		add(toplabel);
		
		JTextField nameInput = new JTextField("이름 입력");
		add(nameInput);
		nameInput.setBounds(398, 227, 361, 44);
		
		JTextField pwInput = new JTextField("주민등록번호 입력");
		add(pwInput);
		pwInput.setBounds(398, 286, 361, 44);
		
		JButton idSearchBtn = new JButton("아이디 조회");
		add(idSearchBtn);
		idSearchBtn.setBounds(478, 378, 200, 50);
		
	}
//	public static void main(String[] args) {
//		JFrame frame = new JFrame();
//		frame.add(new IdSearchPanel());
//		
//		
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setBounds(0, 0, 1200, 800);
//		frame.setVisible(true);
//	}
//
}
	
	
