package copy;




import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import mainpackage.MainPanel;

public class Id_search extends JPanel{

	public Id_search() {
	
		setBounds(0,0,600,800);
		setLayout(null);
		
//		JButton mainBtn = new JButton("메인");
//		add(mainBtn);
//		mainBtn.setBounds(30, 30, 100, 50);
		
		JButton lastPageBtn = new JButton("이전");
		lastPageBtn.setBounds(12, 9, 70, 44);
		add(lastPageBtn);
		lastPageBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MainPanel.currPanel.setVisible(false);
				MainPanel.logInPanel.setVisible(true);
				MainPanel.currPanel = MainPanel.logInPanel;		
			}
		});
		
		
		JButton firstPageBtn = new JButton("홈");
		firstPageBtn.setBounds(97, 9, 64, 44);
		add(firstPageBtn);
		firstPageBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MainPanel.currPanel.setVisible(false);
				MainPanel.mainPanel.setVisible(true);
				MainPanel.currPanel = MainPanel.mainPanel;				
			}

		});
		
		
		JLabel Id_search_Label = new JLabel("아이디 찾기");
		Id_search_Label.setOpaque(true);
		Id_search_Label.setBackground(Color.WHITE);
		Id_search_Label.setHorizontalAlignment(JLabel.CENTER);
		Id_search_Label.setFont(new Font("맑은고딕", Font.PLAIN, 20));
		add(Id_search_Label);
		Id_search_Label.setBounds(160, 30, 400, 50);
		
		JTextField nameInput = new JTextField("이름 입력");
		add(nameInput);
		nameInput.setBounds(100, 250, 300, 30);
		
		JTextField passwordInput = new JTextField("주민등록번호 입력");
		add(passwordInput);
		passwordInput.setBounds(100, 280, 300, 30);
		
		JButton Id_search_Btn = new JButton("아이디 조회");
		add(Id_search_Btn);
		Id_search_Btn.setBounds(150, 350, 200, 50);
		
	}
	
	
	public static void main(String[] args) {
		JFrame myclass = new JFrame();
		myclass.add(new Id_search());
		
		
		myclass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myclass.setBounds(100, 30, 600, 800);
		myclass.setVisible(true);
	}
}
