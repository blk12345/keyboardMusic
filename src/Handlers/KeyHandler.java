package Handlers;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

import keyboardMusic.main;

public class KeyHandler implements KeyListener{
	
	public boolean[] Pressed = new boolean[main.keynum];
	
	
	@Override
	
	public void keyTyped(KeyEvent e) {
	
		// changes display letter
		System.out.println(e.getKeyChar());
		main.KeyLabel.setText(String.valueOf(e.getKeyChar()));
		main.KeyLabel.setForeground(Color.blue);
		
	}
	@Override
	public void keyPressed(KeyEvent e){
		//records key presses
		int code = e.getKeyCode();
		switch(code) {
		
		case KeyEvent.VK_ESCAPE:
		Pressed[0] = true;
		
		break;
		case KeyEvent.VK_F1:
		Pressed[1]=true;
		break;
		case KeyEvent.VK_F2:
		Pressed[2] = true;
		break;
		case KeyEvent.VK_F3:
		Pressed[3] = true;
		break;
		case KeyEvent.VK_F4:
		Pressed[4] = true;
		break;
		case KeyEvent.VK_F5:
		Pressed[5] = true;
		break;
		case KeyEvent.VK_F6:
			Pressed[6] = true;
			break;
		case KeyEvent.VK_F7:
			Pressed[7] = true;
			break;
		case KeyEvent.VK_F8:
			Pressed[8] = true;
			break;
		case KeyEvent.VK_F9:
			Pressed[9] = true;
			break;
		case KeyEvent.VK_F10:
			Pressed[10] = true;
			break;
		case KeyEvent.VK_F11:
			Pressed[11] = true;
			break;
		case KeyEvent.VK_F12:
			Pressed[12] = true;
			break;
		case KeyEvent.VK_INSERT:
			Pressed[13] = true;
			break;
		case KeyEvent.VK_DELETE:
			Pressed[14] = true;
			break;
		case KeyEvent.VK_1:
			Pressed[15] = true;
			break;
		case KeyEvent.VK_2:
			Pressed[16] = true;
			break;
		case KeyEvent.VK_3:
			Pressed[17] = true;
			break;
		case KeyEvent.VK_4:
			Pressed[18] = true;
			break;
		case KeyEvent.VK_5:
			Pressed[19] = true;
			break;
		case KeyEvent.VK_6:
			Pressed[20] = true;
			break;
		case KeyEvent.VK_7:
			Pressed[21] = true;
			break;
		case KeyEvent.VK_8:
			Pressed[22] = true;
			break;
		case KeyEvent.VK_9:
			Pressed[23] = true;
			break;
		case KeyEvent.VK_0:
			Pressed[24] = true;
			break;
		case KeyEvent.VK_SUBTRACT:
			Pressed[25] = true;
			break;
		case KeyEvent.VK_EQUALS:
			Pressed[26] = true;
			break;
		case KeyEvent.VK_BACK_SPACE:
			Pressed[27] = true;
			break;
		case KeyEvent.VK_NUM_LOCK:
			Pressed[28] = true;
			break;
		case KeyEvent.VK_SLASH:
			Pressed[29] = true;
			break;
		case KeyEvent.VK_ASTERISK:
			Pressed[30] = true;
			break;
		case KeyEvent.VK_MINUS:
			Pressed[31] = true;
			break;
		case KeyEvent.VK_TAB:
			Pressed[32] = true;
			break;
		case KeyEvent.VK_Q:
			Pressed[33] = true;
			break;
		case KeyEvent.VK_W:
			Pressed[34] = true;
			break;
		case KeyEvent.VK_E:
			Pressed[35] = true;
			break;
		case KeyEvent.VK_R:
			Pressed[36] = true;
			break;
		case KeyEvent.VK_T:
			Pressed[37] = true;
			break;
		case KeyEvent.VK_Y:
			Pressed[38] = true;
			break;
		case KeyEvent.VK_U:
			Pressed[40] = true;
			break;
		case KeyEvent.VK_I:
			Pressed[41] = true;
			break;
		case KeyEvent.VK_O:
			Pressed[42] = true;
			break;
		case KeyEvent.VK_P:
			Pressed[43] = true;
			break;
		case KeyEvent.VK_OPEN_BRACKET:
			Pressed[44] = true;
			break;
		case KeyEvent.VK_CLOSE_BRACKET:
			Pressed[45] = true;
			break;		
		case KeyEvent.VK_BACK_SLASH:
			Pressed[46] = true;
			break;
		case KeyEvent.VK_NUMPAD7:
			Pressed[47] = true;
			break;
		case KeyEvent.VK_NUMPAD8:
			Pressed[48] = true;
			break;
		case KeyEvent.VK_NUMPAD9:
			Pressed[49] = true;
			break;
		case KeyEvent.VK_PLUS:
			Pressed[50] = true;
			break;
		case KeyEvent.VK_CAPS_LOCK:
			Pressed[51] = true;
			break;
		case KeyEvent.VK_A:
			Pressed[52] = true;
			break;
		case KeyEvent.VK_S:
			Pressed[53] = true;
			break;
		case KeyEvent.VK_D:
			Pressed[54] = true;
			break;
		case KeyEvent.VK_F:
			Pressed[55] = true;
			break;
		case KeyEvent.VK_G:
			Pressed[56] = true;
			break;
		case KeyEvent.VK_H:
			Pressed[57] = true;
			break;
		case KeyEvent.VK_J:
			Pressed[58] = true;
			break;
		case KeyEvent.VK_K:
			Pressed[59] = true;
			break;
		case KeyEvent.VK_L:
			Pressed[60] = true;
			break;
		}
		
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		//records key releases
		main.KeyLabel.setForeground(Color.cyan);
		int code = e.getKeyCode();
		switch(code) {
		case KeyEvent.VK_ESCAPE:
		Pressed[0] = false;
		break;
		case KeyEvent.VK_F1:
		Pressed[1] = false;
		break;
		case KeyEvent.VK_F2:
		Pressed[2] = false;
		break;
		case KeyEvent.VK_F3:
		Pressed[3] = false;
		break;
		case KeyEvent.VK_F4:
		Pressed[4] = false;
		break;
		case KeyEvent.VK_F5:
		Pressed[5] = false;
		break;
		case KeyEvent.VK_F6:
			Pressed[6] = false;
			break;
	case KeyEvent.VK_F7:
		Pressed[7] = false;
		break;
	case KeyEvent.VK_F8:
		Pressed[8] = false;
		break;
	case KeyEvent.VK_F9:
		Pressed[9] = false;
		break;
	case KeyEvent.VK_F10:
		Pressed[10] = false;
		break;
	case KeyEvent.VK_F11:
		Pressed[11] = false;
		break;
	case KeyEvent.VK_F12:
		Pressed[12] = false;
		break;
	case KeyEvent.VK_INSERT:
		Pressed[13] = false;
		break;
	case KeyEvent.VK_DELETE:
		Pressed[14] = false;
		break;
	case KeyEvent.VK_1:
		Pressed[15] = false;
		break;
	case KeyEvent.VK_2:
		Pressed[16] = false;
		break;
	case KeyEvent.VK_3:
		Pressed[17] = false;
		break;
	case KeyEvent.VK_4:
		Pressed[18] = false;
		break;
	case KeyEvent.VK_5:
		Pressed[19] = false;
		break;
	case KeyEvent.VK_6:
		Pressed[20] = false;
		break;
	case KeyEvent.VK_7:
		Pressed[21] = false;
		break;
	case KeyEvent.VK_8:
		Pressed[22] = false;
		break;
	case KeyEvent.VK_9:
		Pressed[23] = false;
		break;
	case KeyEvent.VK_0:
		Pressed[24] = false;
		break;
	case KeyEvent.VK_MINUS:
		Pressed[25] = false;
		break;
	case KeyEvent.VK_EQUALS:
		Pressed[26] = false;
		break;
	case KeyEvent.VK_BACK_SPACE:
		Pressed[27] = false;
		break;
	case KeyEvent.VK_NUM_LOCK:
		Pressed[28] = false;
		break;
	case KeyEvent.VK_SLASH:
		Pressed[29] = false;
		break;
	case KeyEvent.VK_ASTERISK:
		Pressed[30] = false;
		break;		
	case KeyEvent.VK_SUBTRACT:
		Pressed[31] = false;
		break;
	case KeyEvent.VK_TAB:
		Pressed[32] = false;
		break;
	case KeyEvent.VK_Q:
		Pressed[33] = false;
		break;
	case KeyEvent.VK_W:
		Pressed[34] = false;
		break;
	case KeyEvent.VK_E:
		Pressed[35] = false;
		break;
	case KeyEvent.VK_R:
		Pressed[36] = false;
		break;
	case KeyEvent.VK_T:
		Pressed[37] = false;
		break;
	case KeyEvent.VK_Y:
		Pressed[38] = false;
		break;
	case KeyEvent.VK_U:
		Pressed[40] = false;
		break;
	case KeyEvent.VK_I:
		Pressed[41] = false;
		break;
	case KeyEvent.VK_O:
		Pressed[42] = false;
		break;
	case KeyEvent.VK_P:
		Pressed[43] = false;
		break;
	case KeyEvent.VK_OPEN_BRACKET:
		Pressed[44] = false;
		break;
	case KeyEvent.VK_CLOSE_BRACKET:
		Pressed[45] = false;
		break;		
	case KeyEvent.VK_BACK_SLASH:
		Pressed[46] = false;
		break;
	case KeyEvent.VK_NUMPAD7:
		Pressed[47] = false;
		break;
	case KeyEvent.VK_NUMPAD8:
		Pressed[48] = false;
		break;
	case KeyEvent.VK_NUMPAD9:
		Pressed[49] = false;
		break;
	case KeyEvent.VK_PLUS:
		Pressed[50] = false;
		break;
	case KeyEvent.VK_CAPS_LOCK:
		Pressed[51] = false;
		break;
	case KeyEvent.VK_A:
		Pressed[52] = false;
		break;
	case KeyEvent.VK_S:
		Pressed[53] = false;
		break;
	case KeyEvent.VK_D:
		Pressed[54] = false;
		break;
	case KeyEvent.VK_F:
		Pressed[55] = false;
		break;
	case KeyEvent.VK_G:
		Pressed[56] = false;
		break;
	case KeyEvent.VK_H:
		Pressed[57] = false;
		break;
	case KeyEvent.VK_J:
		Pressed[58] = false;
		break;
	case KeyEvent.VK_K:
		Pressed[59] = false;
		break;
	case KeyEvent.VK_L:
		Pressed[60] = false;
		break;
	}
	}
	
}
