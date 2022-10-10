package SearchBox;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Frame;

import java.awt.event.MouseEvent;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;

import javax.swing.UIManager;


@SuppressWarnings("serial")
public class Search extends JFrame {

	public static JDesktopPane contentPane;
	public static Search frame;

	
	private int frameWidth = 300;
	private int frameHeight = 316;
	
	
	
	/**
	 * Launch the application.
	 */
	public static void runner () {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					frame = new Search();
					frame.setLocationRelativeTo(null);
					frame.setResizable(true);
					
					
					frame.setUndecorated(true);
					
					frame.getContentPane().setLayout(new BorderLayout());
					
					frame.setContentPane(new ShapedPane2());
				
					
					frame.pack();
					frame.setVisible(true);
					frame.setBackground(new Color(1.0f,1.0f,1.0f,0f));
										
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Search() {
setDefaultCloseOperation(JInternalFrame.EXIT_ON_CLOSE);
		
		setBounds(10, 10, frameWidth, frameHeight);
		contentPane = new JDesktopPane();
		contentPane.setBackground(Color.yellow);
		
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
	
		
		
		
		
		
		
		
	}
	public static void minWindow() {
		frame.setState(Frame.ICONIFIED);
	}
	public static void dragWindow(int MouseX, int MouseY, MouseEvent e) {
		frame.setLocation(frame.getX()+e.getX()-MouseX,frame.getY()+e.getY()-MouseY);
	}
	public static void ExtendWindow(int MouseX, int MouseY, MouseEvent e) {
		
		frame.setSize(frame.getX()+e.getX()+MouseX,frame.getY()+e.getY()+MouseY);
	
	}
}
