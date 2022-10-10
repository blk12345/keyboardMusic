package Handlers;




import java.io.File;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import keyboardMusic.main;







public class Sound {

	
	Clip clip;
	URL soundURL[] = new URL[main.keynum];
	
	
	
	String sounds[]= new String[main.keynum];//{"space.wav","sitar.wav","completed.wav","damage.wav","harp.wav","Chord1_G.wav", "Chord2_F#.wav","SSOS_D.wav","CautionPluck_C.wav"};
	
	
	boolean streaming2 = false;
	
	int index=0;
	boolean exit = true;
	Thread a;
	
	public int num =0;
	
	public Sound() {
		
				//names file names
				
			    for (File f : getResourceFolderFiles("sound")) {
			    System.out.println(f.getName());
			    
			    //puts file names in Array
			    sounds[num]=f.getName();
			    num++;
			   }
		//makes all the files into urls
		for(int i=0;i<sounds.length;i++) {
			makeSoundURL(i,sounds[i]);
		}
		
		
		
	}
	
	private void makeSoundURL(int i, String s) {
		//loads files into url
		soundURL[i]=getClass().getResource("/sound/"+s);
	}
	public void setFile(int i) {
		//loads clip from file
		try {
			AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[i]);
			clip = AudioSystem.getClip();
		clip.open(ais);
			
			
		}catch(Exception e) {
			
		}
	}
	public void play() {
		//plays clip
		clip.setFramePosition(0);
		clip.start();
		
	}
	public void loop() {
		//loops clip
		clip.loop(Clip.LOOP_CONTINUOUSLY);
		
	}
	public void stop() {
		//stops clip
		clip.stop();
		clip.close();
		clip.flush();
	}
	
	@SuppressWarnings("static-access")
	public void playThread(final int i) {
		//starts clip in thread
		a = new Thread((new Runnable() {
			public void run() {
				if(!a.interrupted()){
				try {
					exit = false;
					
					setFile(i);
				play();
				if(main.permaLoop==true) {
				loop();
				}
				
				}catch(Exception e) {
					System.out.println(e);
				}
				}
			}
			
		}));
		if(exit==true) {
		a.start();
		}
			
		
		
	}
	
	public void stopThread() {
		//stops thread running clip
		exit=true;
		if(clip!=null) {
			clip.stop();
		}
		
		}
	
	private static File[] getResourceFolderFiles (String folder) {
	   //lists files in folder
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
	    URL url = loader.getResource(folder);
	    String path = url.getPath();
	    return new File(path).listFiles();
	  }
	}
	
		
		
		
		
	


