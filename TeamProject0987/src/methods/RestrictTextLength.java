package methods;

import java.awt.TextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JTextField;

public class RestrictTextLength extends KeyAdapter {

	int length;
	JTextField textField;
	
	public RestrictTextLength(JTextField textField, int length) { 
		//변수 : 길이 제한 할 textField , 최대 글자수 length.
	
		this.length = length ;
		this.textField = textField;
	}	
	

	@Override
	public void keyTyped(KeyEvent e) {
		String msg = textField.getText();	
		
        if ( msg.length() > length - 1 && e.getKeyChar()!= KeyEvent.VK_BACK_SPACE) {  
        	//글자수 이상 입력방지, BackSpace만 가능        	
        	e.consume(); // 입력 무시        	
        }          
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		String msg = textField.getText();
		if (msg.length() > length) {
        	
        	textField.setText(msg.substring(0, length));// 복사 붙여넣기로 긴 글 삽입 방지
        }
	}
	
	
	
}
