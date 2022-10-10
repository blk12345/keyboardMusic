package keyboardMusic;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import java.awt.geom.RoundRectangle2D;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javax.swing.border.EtchedBorder;

import Handlers.Record;
import Handlers.SaveAsWav;
import SearchBox.Search;


@SuppressWarnings("serial")
public class ShapedPane extends JPanel{
	
	
	 int MouseX;
 int MouseY;
 int exitX = getWidth()+50;
 boolean recording = false;
	int minX = getWidth()+100;
	public static boolean openned = false;
	
	Record record = new Record();
	SaveAsWav wav = new SaveAsWav();
	
public ShapedPane() {
		
		setLayout(null);
		

		main.b.setImage(main.b.getImage().getScaledInstance(100, 100, 100));
		add(main.l);
		
		
		if(openned==false) {
			Search.runner();
			openned = true;
			}
		
		 JButton min = new JButton("_");
		 min.setBounds(minX, 4, 50, 21);	
		 min.setFocusable(false);
			add(min);
			min.setForeground(Color.BLACK);
			min.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					main.minWindow();
				}
			});
			
			
	      
		
				JButton exit = new JButton("X");
				exit.setBounds(exitX, 4, 50, 21);
				exit.setFocusable(false);
				add(exit);
				exit.setForeground(Color.red);
				exit.setBackground(Color.LIGHT_GRAY);
				
				exit.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						System.exit(0);
					}
				});
				addMouseMotionListener(new MouseMotionAdapter() {
					@Override
					public void mouseDragged(MouseEvent e) {
						main.dragWindow(MouseX, MouseY, e);
					}
				});
				addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent e) {
						MouseX = e.getX();
						MouseY = e.getY();
					}
				});
				
				 
				final JButton extender = new JButton();
				extender.setFocusable(false);
				extender.setBounds(getWidth(), 0, 50, 21);
				extender.setBackground(Color.black);
				add(extender);
				extender.addMouseMotionListener(new MouseMotionAdapter() {
					@Override
					public void mouseDragged(MouseEvent e) {
				
						main.ExtendWindow(MouseX, MouseY, e);
						
					}
				});
				extender.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent e) {
						MouseX = e.getX();
						MouseY = e.getY();
					}
				}); 
				extender.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseReleased(MouseEvent e) {
						if(MouseX<20 && MouseY<20) {
							System.exit(0);
							
						}
					}
				}); 
				 final JButton upload = new JButton("Menu");
					upload.setForeground(Color.DARK_GRAY);
					upload.setFocusable(false);
					upload.setFont(new Font("Sitka Heading", Font.BOLD, 10));
					upload.setBackground(new Color(65, 105, 225));
					upload.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(70, 130, 180), new Color(51, 0, 153)));
					
					upload.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
							if(openned==false) {
							Search.runner();
							openned = true;
							}
							
						}
					});
					upload.setBounds(30, 30, 169, 25);
					upload.setFocusable(false);
					
					add(upload);
					 final JButton recorder = new JButton("record");
						recorder.setForeground(Color.DARK_GRAY);
						recorder.setFocusable(false);
						recorder.setFont(new Font("Sitka Heading", Font.BOLD, 10));
						recorder.setBackground(new Color(65, 105, 225));
						recorder.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(70, 130, 180), new Color(51, 0, 153)));
						
						
						recorder.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								if(recording ==false) {
									recorder.setForeground(Color.red);
									recording = true;
									
									record.start();
									
								}else {
									recorder.setForeground(Color.darkGray);
									recording = false;
									
									record.stop();
									wav.save();
								}
								
								
							}
						});
						recorder.setBounds(30, 60, 169, 25);
						recorder.setFocusable(false);
						
						add(recorder);
						
						
					
					
					
					
					main.KeyLabel.setForeground(new Color(255, 255, 255));
					main.KeyLabel.setFont(new Font("Arial", Font.BOLD, 30));
					main.KeyLabel.setBounds(497, 35, 102, 49);
					add(main.KeyLabel);
					
					
					
					
   }

    public Dimension getPreferredSize() {
        return new Dimension(main.frame.getWidth(), main.frame.getHeight());
    }

    protected void paintComponent(Graphics g) {
        super.getComponents(); //To change body of generated methods, choose Tools | Templates.
        Graphics2D g2d = (Graphics2D) g.create();
        RenderingHints hints = new RenderingHints(
                RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHints(hints);
        g2d.setColor(getBackground());
        g2d.fill(new RoundRectangle2D.Float(0, 0, getWidth(), getHeight(),55,55));
        
        
        Image img1 = Toolkit.getDefaultToolkit().getImage("keyboard.jpg");
        
       
        g2d.drawImage(img1, 0, 30, null);
        g2d.dispose();
    }

}
