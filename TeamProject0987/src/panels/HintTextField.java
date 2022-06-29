package panels;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JTextField;

public class HintTextField extends JTextField {
	Font gainFont = new Font("맑은고딕", Font.PLAIN, 20); // 사용자가 입력할때의 폰트
	Font lostFont = new Font("맑은고딕", Font.PLAIN, 14); // 필드에 표시되는 메시지의 폰트

	public HintTextField(String hint) {  

		setText(hint);  
		setFont(lostFont);  
		setForeground(Color.GRAY);  	
				
		
		this.addFocusListener(new FocusAdapter() {  

	    	@Override
	    	public void focusGained(FocusEvent e) {  
	    		if (getText().equals(hint)) {
		        	setText("");
		    		setForeground(Color.BLACK);
		        	setFont(gainFont);
	    		} else {
		          setText(getText());		          
		          setFont(gainFont);
	    		}
	    	}
		    @Override
		    public void focusLost(FocusEvent e) {  
		    	if (getText().equals(hint)|| getText().length()==0) {  
		    		setText(hint);  
		    		setFont(lostFont);  
		    		setForeground(Color.GRAY);  
		    	} else {  
		    		setText(getText());  
		    		setFont(gainFont);  
		    		setForeground(Color.BLACK);  
		    	}
		    }  
		});
	}
}