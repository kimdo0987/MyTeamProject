package mypagepanel_comps.frames;

import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import popups.MsgPopup;
  
public class CommentsFrame extends JFrame {
	private JTextArea textArea;	
	JFrame thisFrame;
	
	public CommentsFrame(String lectureName, String teacherName) {
		
		super("수강평 등록");
		
		thisFrame = this;
		setBounds(0, 0, 500, 300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE); //EXIT_ON_CLOSE로 하면 메인프레임도 같이 종료됨.
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 484, 262);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel textLengthLabel = new JLabel("수강평 (0/70자)");
		textLengthLabel.setForeground(SystemColor.windowBorder);
		textLengthLabel.setBounds(12, 185, 270, 23);
		
		panel.add(textLengthLabel);
		
		textArea = new JTextArea(3,3);
		textArea.setBounds(12, 80, 449, 108);
		textArea.setLineWrap(true); //자동으로 줄바꿈
		
		
		textArea.addKeyListener(new KeyAdapter() {
			// textArea에 입력가능한 글자수 70글자로 제한함
			
			@Override
			public void keyTyped(KeyEvent e) {
				String msg = textArea.getText();
				
				textLengthLabel.setText("수강평 (" + msg.length() + "/70자)");
                if ( msg.length() >70) { 
                    textArea.setText(msg.substring(0, 70));
                    textLengthLabel.setText("수강평 (70/70자)");//복붙했을때 글자counting 수 넘어가는거 방지
                }             
			}
		});
		
		
		panel.add(textArea);
		
		
		JLabel lblNewLabel = new JLabel("강좌명 : " + lectureName + "      강사명 : " + teacherName);
		lblNewLabel.setBounds(13, 9, 360, 46);
		panel.add(lblNewLabel);
		
		JComboBox ratingBox = new JComboBox();
		ratingBox.setBounds(385, 25, 63, 38);
		ratingBox.addItem("평점");
		
		ratingBox.addItem("1.0");
		ratingBox.addItem("2.0");
		ratingBox.addItem("3.0");
		ratingBox.addItem("4.0");
		ratingBox.addItem("5.0");
		
		panel.add(ratingBox);
		
		
		JButton confirmBtn = new JButton("등록");
		confirmBtn.setBounds(92, 219, 112, 34);
		confirmBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(ratingBox.getSelectedItem().equals("평점")) {
					//평점고르지않으면 뜨는 팝업창생성
					new MsgPopup(thisFrame, "평점을 골라주세요.");
													
				} else {
				
				System.out.println("평점"+ratingBox.getSelectedItem()); 
				System.out.println(textArea.getText());
				//DB에 저장하는 기능 추가 필요함
				dispose();
				}		
			}
		});
		panel.add(confirmBtn);
		
		
		
		JButton cancelBtn = new JButton("취소");
		cancelBtn.setBounds(260, 219, 112, 34);
		cancelBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		panel.add(cancelBtn);
		
		JLabel infoLabel = new JLabel("수강평은 최대 70글자 입력 가능합니다");
		infoLabel.setForeground(new Color(102, 102, 102));
		infoLabel.setBounds(12, 48, 270, 23);
		panel.add(infoLabel);
		
		
		setVisible(true);
		
	}	
	
	public static void main(String[] args) {
		//시험용
		CommentsFrame frame = new CommentsFrame("자바","김선생");
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
