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
	
		this.length = length - 1;
		this.textField = textField;
	}	
	

	@Override
	public void keyTyped(KeyEvent e) {
		String msg = textField.getText();
		
		
        if ( msg.length() > length) {  //글자수 이상 입력방지
        	e.consume();
        } else if (msg.length() > 16) {
        	textField.setText(msg.substring(0, length));// 복사 붙여넣기 방지
        }
	}
	
	
	
}
