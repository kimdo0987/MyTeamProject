package copy;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Pw_search extends JPanel {

	public Pw_search() {
		setBounds(0,0,600,800);
		setLayout(null);
		
		JButton mainBtn = new JButton("메인");
		add(mainBtn);
		mainBtn.setBounds(30, 30, 100, 50);
		
		JLabel Pw_search_Label = new JLabel("비밀번호 찾기");
		Pw_search_Label.setOpaque(true);
		Pw_search_Label.setBackground(Color.WHITE);
		Pw_search_Label.setHorizontalAlignment(JLabel.CENTER);
		Pw_search_Label.setFont(new Font("맑은고딕", Font.PLAIN, 20));
		add(Pw_search_Label);
		Pw_search_Label.setBounds(160, 30, 400, 50);
		
		JTextField idInput = new JTextField("아이디 입력");
		add(idInput);
		idInput.setBounds(100, 220, 300, 30);
		idInput.setHorizontalAlignment(JTextField.CENTER);
		
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
		myclass.add(new Pw_search());
		
		
		myclass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myclass.setBounds(100, 30, 600, 800);
		myclass.setVisible(true);
	}
	
}
