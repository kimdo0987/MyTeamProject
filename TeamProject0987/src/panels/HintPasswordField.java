package panels;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class HintPasswordField extends JPasswordField {
	Font gainFont = new Font("맑은고딕", Font.PLAIN, 20); // 사용자가 입력할때의 폰트
	Font lostFont = new Font("맑은고딕", Font.PLAIN, 14); // 필드에 표시되는 메시지의 폰트

	public HintPasswordField(String hint) {  

		setEchoChar((char) 0);		
		setText(hint);  
		setFont(lostFont);  
		setForeground(Color.GRAY);
		
		
		this.addFocusListener(new FocusAdapter() {  

	    	@Override
	    	public void focusGained(FocusEvent e) {  
	    		String password = String.valueOf(getPassword()) ;
	    		if (password.equals(hint)) {
		        	setText("");
		        	setEchoChar('•');
		    		setForeground(Color.BLACK);
		        	setFont(gainFont);
	    		} else {
		          setText(password);		          
		          setFont(gainFont);
	    		}
	    	}
		    @Override
		    public void focusLost(FocusEvent e) {
		    	String password = String.valueOf(getPassword()) ;
		    	if (password.equals(hint)|| password.length()==0) {  
		    		setEchoChar((char) 0);
		    		setText(hint);  
		    		setFont(lostFont);  
		    		setForeground(Color.GRAY);  
		    	} else {  
		    		setText(password);  
		    		setFont(gainFont);  
		    		setForeground(Color.BLACK);  
		    	}
		    }  
		});
	}
}