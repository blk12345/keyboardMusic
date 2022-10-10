package keyboardMusic;

import java.awt.BorderLayout;
import java.awt.Color;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.MouseEvent;

import javax.sound.sampled.AudioInputStream;
import javax.swing.*;


import java.awt.Frame;

import javax.swing.border.EmptyBorder;

import Handlers.KeyHandler;
import Handlers.Sound;



public class main extends JFrame {

	
	public static main frame;
	
	
	
	public static Long current;
	 
	
	
	 public static String status;
	 public static String lastAudio = "";
	 public static AudioInputStream stream = null;
	 public static boolean playing = false;
	 public static int songplays = 0;
	 public static boolean albumfinished= true;
	 public static String file = "";
	 public static int songnum = 0;
	 public static int num = 0;
	 public static int length = 1;
	 public static String filename = "";
	 public static boolean stopped = false;
	
	 public static boolean permaLoop = false;
	 public static int keynum = 101;
	
	
//		private JLabel DLabel = new JLabel("D");
	
		public static JDesktopPane contentPane;
		//private JLabel label[]= new JLabel[109];
		
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					frame = new main();
					frame.setLocationRelativeTo(null);
					frame.setResizable(true);
					
					
					frame.setUndecorated(true);
					
					frame.getContentPane().setLayout(new BorderLayout());
					
					frame.setContentPane(new ShapedPane());
					
					
					frame.pack();
					frame.setVisible(true);
					frame.setBackground(new Color(1.0f,1.0f,1.0f,0f));
										
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	public Timer timer = new Timer(1, new ActionListener() {
        public void actionPerformed(ActionEvent a) {
        	updateKeys();
        	
        }    });
	

	
	KeyHandler key = new KeyHandler();
	
	
	 Sound sound[]= new Sound[main.keynum];
	public static JLabel KeyLabel = new JLabel("(key)");
	public static ImageIcon b = new ImageIcon("keyboard.jpg");
	
	
	public static JLabel l = new JLabel("Box",b,JLabel.CENTER);
	
	
	
	
	public void soundEffect(boolean key, int musicIndex, Sound sound) {
		if(key) {
	
			sound.playThread(musicIndex);

			}else {
			
			sound.stopThread();
		
			}
	}
	public void Label(JLabel label,int x, int y) {
	}

	public void updateKeys(){
		
		for(int i=0;i<main.keynum;i++) {
			soundEffect(key.Pressed[i],i,sound[i]);
		}
	}
	

	public main() {
		
		
timer.start();
		
		for(int i=0;i<main.keynum;i++) {
			sound[i]=new Sound();
		}
		contentPane = new JDesktopPane();
		contentPane.setBackground(new Color(100, 149, 237));
		
		//Label(DLabel,20, 0);
		this.addKeyListener(key);
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 775, 523);
		contentPane = new JDesktopPane();
		contentPane.setBackground(new Color(100, 149, 237));
		
		//Label(DLabel,20, 0);
		
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JRadioButton isLoop = new JRadioButton("Loop");
		isLoop.setForeground(new Color(255, 255, 255));
		isLoop.setBackground(new Color(100, 149, 237));
		
		isLoop.setBounds(177, 31, 103, 21);
		getContentPane().add(isLoop);
		isLoop.setFocusable(false);
		
	
		
		
        contentPane.setOpaque(false);
        //setLayout(new GridBagLayout());

       
		
		
	
		
		
	}
	
	
	
	
	public static void minWindow() {
		frame.setState(Frame.ICONIFIED);
	}
	public static void dragWindow(int MouseX, int MouseY, MouseEvent e) {
		frame.setLocation(frame.getX()+e.getX()-MouseX,frame.getY()+e.getY()-MouseY);
	}
	public static void ExtendWindow(int MouseX, int MouseY, MouseEvent e) {
		frame.setSize(frame.getX()+e.getX()-MouseX,frame.getY()+e.getY()-MouseY);
	}
}
