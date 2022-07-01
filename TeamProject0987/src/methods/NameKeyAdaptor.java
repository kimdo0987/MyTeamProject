package methods;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.regex.Pattern;

public class NameKeyAdaptor implements KeyListener{
	@Override
	public void keyTyped(KeyEvent e) {
		
			if(!(Pattern.matches("[A-Za-z]", ""+e.getKeyChar())|| 
					('가'<= e.getKeyChar())&&(e.getKeyChar()<='힣')) ||e.getKeyChar()=='_') {
				e.consume(); // 이벤트 소멸(무시)하기
			}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
