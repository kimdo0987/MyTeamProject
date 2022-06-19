package mypagepanel_comps.frames;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.time.LocalDate;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import popups.MsgPopup;

import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Color;
import java.awt.SystemColor;

public class CancelLectureFrame extends JFrame {
	
	private JTextArea textArea;	
	private JFrame thisFrame;

	
	public CancelLectureFrame(String lectureName, String teacherName) {
	
		super("수강 포기");
		
		thisFrame = this;
		setBounds(0, 0, 500, 300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE); //EXIT_ON_CLOSE로 하면 메인프레임도 같이 종료됨.
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 484, 262);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel textLengthLabel = new JLabel("수강포기사유 (0/70자)");
		textLengthLabel.setForeground(SystemColor.windowBorder);
		
		textLengthLabel.setBounds(12, 180, 270, 23);
		panel.add(textLengthLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(12, 80, 117, 29);
		comboBox.addItem("선택");
		comboBox.addItem("생계곤란");
		comboBox.addItem("수강부적응");
		comboBox.addItem("수강과정 부적합");
		comboBox.addItem("출산");
		comboBox.addItem("진학/군입대");
		comboBox.addItem("이사");
		comboBox.addItem("건강상의 문제");
		comboBox.addItem("개인변심");
		comboBox.addItem("기타");
		
		textArea = new JTextArea();
		textArea.setForeground(Color.GRAY);
		textArea.setBounds(12, 118, 340, 64);
		textArea.setText("기타 사유에만 작성할 수 있습니다.");
		textArea.setEditable(false);
		textArea.setLineWrap(true); //자동으로 줄바꿈
		textArea.addKeyListener(new KeyListener() {
			
		// textArea에 입력가능한 글자수 70글자로 제한함
			@Override
			public void keyTyped(KeyEvent e) {
				if (comboBox.getSelectedItem().equals("기타")) {

					String msg = textArea.getText();
					textLengthLabel.setText("수강포기사유 (" + msg.length() + "/70자)");
					if (msg.length() > 70) {
						textArea.setText(msg.substring(0, 70));
					}
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
			}

			@Override
			public void keyPressed(KeyEvent e) {
			}
		});		
		
		
		
		
		panel.add(textArea);
		LocalDate now = LocalDate.now();
		//System.out.println(now); 현재날짜보기
		JLabel lblNewLabel = new JLabel("강좌명 : " + lectureName + "      강사명 : " + teacherName 
				+ "         수강포기날짜 :  " + now);
		lblNewLabel.setBounds(13, 9, 360, 46);
		panel.add(lblNewLabel);
		
		
		
		comboBox.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//System.out.println(comboBox.getSelectedItem());	//선택한 내용 보기
				if(comboBox.getSelectedItem().equals("기타")) {
					textArea.setText("");
					textArea.setForeground(Color.BLACK);
					textArea.setEditable(true);
				} else {
					textArea.setForeground(Color.GRAY);
					textArea.setText("기타 사유에만 작성할 수 있습니다.");
					textLengthLabel.setText("수강포기사유 (0/70자)");
					textArea.setEditable(false);
				}
			}
		});
			
		panel.add(comboBox);
		
		
		JLabel lblNewLabel_1 = new JLabel("포기 사유");
		lblNewLabel_1.setForeground(Color.GRAY);
		lblNewLabel_1.setBounds(12, 53, 84, 23);
		panel.add(lblNewLabel_1);
		
		JButton confirmBtn = new JButton("수강 포기");
		confirmBtn.setBounds(92, 219, 112, 34);
		
		confirmBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (comboBox.getSelectedItem().equals("선택")) {
					// 포기사유를 선택해달라는 팝업창 생성
					new MsgPopup(thisFrame, "포기 사유를 선택해 주세요.");

				} else {
					System.out.println("포기사유: " + comboBox.getSelectedItem());
					if (comboBox.getSelectedItem().equals("기타")) {
						System.out.println("기타포기내용 : " + textArea.getText());
					}
					// DB에 저장하는 기능 추가해야함
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
				dispose(); //창 꺼버리기
			}
		});
		panel.add(cancelBtn);
		
		
		
		setVisible(true);
	}
	
//	public static void main(String[] args) {
//		//시험용
//		
//		CancelLectureFrame CancelLectureFrame = new CancelLectureFrame("자바","김선생");
//		CancelLectureFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
//		
//	}
}
