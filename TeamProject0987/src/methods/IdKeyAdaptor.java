package methods;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.regex.Pattern;

public class IdKeyAdaptor implements KeyListener {

	@Override
	public void keyTyped(KeyEvent e) { // 복붙등 커맨드 방지용
		
		if((!Pattern.matches("\\w", ""+e.getKeyChar())||e.getKeyChar()=='_')){
			e.consume(); // 이벤트 소멸(무시)하기
		}  
	}

	@Override
	public void keyPressed(KeyEvent e) {
//		if((!Pattern.matches("\\w", ""+e.getKeyChar())||e.getKeyChar()=='_')
//				&&(e.getKeyChar() != KeyEvent.VK_BACK_SPACE)
//				&&(e.getKeyChar() != KeyEvent.VK_DELETE)
//				&&(e.getKeyCode() != 36) //END키 허용
//				&&(e.getKeyCode() != 35) //HOME키 허용
//				&&(e.getKeyCode() != 37) //왼쪽 방향키 허용
//				&&(e.getKeyCode() != 39) //오른쪽방향키 허용 //영문과 숫자만 허용하고 다막아놔서 따로 허용해 주어야한다
//				) {
//			e.consume(); // 이벤트 소멸(무시)하기
//		}  
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
