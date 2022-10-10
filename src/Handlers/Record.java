package Handlers;

import java.io.*;
import javax.sound.sampled.*;

public class Record implements Runnable{
	 double duration, seconds;
	  File file;
	  AudioInputStream audioInputStream;
	  SourceDataLine line;
	  Thread thread;
	  String errStr;
	  
	  private void shutDown(String message) {
	      if ((errStr = message) != null) {
	        System.err.println(errStr);
	      }
	      if (thread != null) {
	        thread = null;
	      }
	  }
	    public void start() {
	        errStr = null;
	        thread = new Thread(this);
	        thread.setName("Capture");
	        thread.start();
	      }

	      public void stop() {
	        thread = null;
	      }
	      
	@Override
	public void run() {
		// TODO Auto-generated method stub
		duration = 0;
	      audioInputStream = null;

	      // define the required attributes for our line,
	      // and make sure a compatible line is supported.

	      AudioFormat.Encoding encoding = AudioFormat.Encoding.PCM_SIGNED;
	      float rate = 44100.0f;
	      int channels = 2;
	      int frameSize = 4;
	      int sampleSize = 16;
	      boolean bigEndian = true;


	      AudioFormat format = new AudioFormat(encoding, rate, sampleSize, channels, (sampleSize / 8)
	          * channels, rate, bigEndian);

	      DataLine.Info info = new DataLine.Info(TargetDataLine.class, format);

	      if (!AudioSystem.isLineSupported(info)) {
	        shutDown("Line matching " + info + " not supported.");
	        return;
	      }

	      // get and open the target data line for capture.

	      try {
	        line = (SourceDataLine) AudioSystem.getLine(info);
	        line.open(format, line.getBufferSize());
	      } catch (LineUnavailableException ex) {
	        shutDown("Unable to open the line: " + ex);
	        return;
	      } catch (SecurityException ex) {
	        shutDown(ex.toString());
	        //JavaSound.showInfoDialog();
	        return;
	      } catch (Exception ex) {
	        shutDown(ex.toString());
	        return;
	      }

	      // play back the captured audio data
	      ByteArrayOutputStream out = new ByteArrayOutputStream();
	      int frameSizeInBytes = format.getFrameSize();
	      int bufferLengthInFrames = line.getBufferSize() / 8;
	      int bufferLengthInBytes = bufferLengthInFrames * frameSizeInBytes;
	      byte[] data = new byte[bufferLengthInBytes];
	      int numBytesRead;

	      line.start();

	      while (thread != null) {
	        if ((numBytesRead = ((ByteArrayInputStream) line).read(data, 0, bufferLengthInBytes)) == -1) {
	          break;
	        }
	        out.write(data, 0, numBytesRead);
	      }

	      // we reached the end of the stream.
	      // stop and close the line.
	      line.stop();
	      line.close();
	      line = null;

	      // stop and close the output stream
	      try {
	        out.flush();
	        out.close();
	      } catch (IOException ex) {
	        ex.printStackTrace();
	      }

	      // load bytes into the audio input stream for playback

	      byte audioBytes[] = out.toByteArray();
	      SaveAsWav.myData = audioBytes;
	      
	      ByteArrayInputStream bais = new ByteArrayInputStream(audioBytes);
	      audioInputStream = new AudioInputStream(bais, format, audioBytes.length / frameSizeInBytes);

	      long milliseconds = (long) ((audioInputStream.getFrameLength() * 1000) / format
	          .getFrameRate());
	      duration = milliseconds / 1000.0;

	      try {
	        audioInputStream.reset();
	      } catch (Exception ex) {
	        ex.printStackTrace();
	        return;
	      }

	    }
	  
}
