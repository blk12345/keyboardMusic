package SearchBox;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;

import java.awt.Graphics;
import java.awt.Graphics2D;

import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import java.awt.geom.RoundRectangle2D;
import java.io.File;
import java.io.IOException;


import javax.swing.DefaultListModel;
import javax.swing.JButton;

import javax.swing.JList;
import javax.swing.JPanel;

import javax.swing.JScrollPane;

import javax.swing.border.EtchedBorder;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import keyboardMusic.ShapedPane;

@SuppressWarnings("serial")
public class ShapedPane2 extends JPanel{
	
	 /**
	 * 
	 */
	
	int MouseX;
	int MouseY;
	
	int barY = 4;
	
	int listWidth = getWidth()+240;
	int listHeight = getHeight()+240;
	
	int exitX = getWidth()+50;
	
	int minX = getWidth()+100;
	
	String[] list= new String[2];
	
@SuppressWarnings("rawtypes")
public ShapedPane2() {
	list[0]="sound File";	
	list[1]="Record";
		setLayout(null);
		
		
		
		
		 JButton min = new JButton("_");
		 min.setBounds(minX, barY, 50, 21);	
		 min.setFocusable(false);
			add(min);
			min.setForeground(Color.BLACK);
			min.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Search.minWindow();
				}
			});
			
			
	      
		
				JButton exit = new JButton("X");
				exit.setBounds(exitX, barY, 50, 21);
				exit.setFocusable(false);
				add(exit);
				exit.setForeground(Color.red);
				exit.setBackground(Color.LIGHT_GRAY);
				exit.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Search.frame.dispose();
						ShapedPane.openned=false;
					}
				});
				
				
				addMouseMotionListener(new MouseMotionAdapter() {
					@Override
					public void mouseDragged(MouseEvent e) {
						Search.dragWindow(MouseX, MouseY, e);
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
						Search.ExtendWindow(MouseX, MouseY, e);
						
						
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
							Search.frame.dispose();
							ShapedPane.openned=false;
						}
					}
				}); 
				
				
				 final JButton upload = new JButton("rsrc File");
					upload.setForeground(Color.DARK_GRAY);
					upload.setFocusable(false);
					upload.setFont(new Font("Sitka Heading", Font.BOLD, 10));
					upload.setBackground(new Color(65, 105, 225));
					upload.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(70, 130, 180), new Color(51, 0, 153)));
					
					upload.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
							//Search.runner();
							//while(f.isClosed()) {
								
								
						//	}
							
						}
					});
					upload.setBounds(10, 157, 169, 25);
					upload.setFocusable(false);
					
					
					
					//JTextField textField = new JTextField();
					//textField.setBounds(105, 41, 285, 19);
					//add(textField);
					//textField.setColumns(10);
					
					
					
					DefaultListModel d = new DefaultListModel();
					
					if(list!=null) {
						for (int i=0; i< list.length;i++) {
					
						d.addElement(list[i]);
					}
					}
					//add(upload);
					
					JList list = new JList(d);
					list.setBackground(getBackground());
					list.setFixedCellHeight(30);
					list.setFixedCellWidth(50);
					
					list.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(70, 130, 180), new Color(51, 0, 153)));
					
					list.addListSelectionListener(new ListSelectionListener() {
						public void valueChanged(ListSelectionEvent e) {
							//timer.stop();
							//filename = list[list.getSelectedIndex()].toString();
							if(list.getSelectedIndex()==0) {
								 ClassLoader classLoader = this.getClass().getClassLoader();
								 File directory = new File(classLoader.getResource("sound").getFile());
								  try {
									Desktop.getDesktop().open(directory);
								} catch (IOException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								
							}
							
						}

						private String getResourceFiles(String string) {
							// TODO Auto-generated method stub
							return null;
						}
					});
					list.setBounds(105, 20, 285, 164);
					add(list);
					
					JScrollPane scrollBar = new JScrollPane(list);
					
					scrollBar.setBounds(30, 30, listWidth, listHeight);
				add(scrollBar);
					
					
					
					
					
					
					
					
   }

    public Dimension getPreferredSize() {
        return new Dimension(Search.frame.getWidth(), Search.frame.getHeight());
    }

    protected void paintComponent(Graphics g) {
        super.getComponents(); //To change body of generated methods, choose Tools | Templates.
        Graphics2D g2d = (Graphics2D) g.create();
        RenderingHints hints = new RenderingHints(
                RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHints(hints);
        Graphics2D gd = (Graphics2D) g.create();
        RenderingHints hints2 = new RenderingHints(
                RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        gd.setRenderingHints(hints2);
        gd.setColor(Color.black);
        gd.fill(new RoundRectangle2D.Float(0, 0, (getWidth()), (getHeight()),55,55));
        g2d.setColor(Color.lightGray);
        g2d.fill(new RoundRectangle2D.Float(1, 1, getWidth()-2, getHeight()-2,55,55));
       
        g2d.dispose();
    }

	

}
