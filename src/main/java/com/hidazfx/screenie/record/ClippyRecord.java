package com.hidazfx.screenie.record;

import java.awt.AWTException;

import com.hidazfx.screenie.Screenie.Connect;
import com.hidazfx.screenie.Screenie.configuration.LoadConfig;
import com.hidazfx.screenie.record.ScreenRecorder.Quality;

public class ClippyRecord {
	static ScreenRecorder recorder = null;
	static Thread thread;
	public static void StartRecordingClippy() throws AWTException, InterruptedException{
	    Thread thread = new Thread(){
	    double frameRate = 30; //FPS
		int howManySecondsToRun = Integer.parseInt(LoadConfig.clippyDuration()) + 1; //How many seconds to run
		String outputFilename = "clippy/CLIPPY_" + System.currentTimeMillis() + ".mp4"; //File output
		//Being multithreading, separate from main thread for better performance and to allow the main thread to handle things like global key-input
	    public void run(){
	    	ScreenRecorder recorder = null;
			try {
				recorder = new ScreenRecorder(outputFilename, frameRate, Quality.MEDIUM);
			} catch (AWTException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			recorder.startCapture();
			try {
				Thread.sleep(howManySecondsToRun * 1000);	
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.print("Stopped Recording");
			recorder.stopCapture();
			Connect.sendClippy(LoadConfig.email(), LoadConfig.password());
		    }
	    };
	    thread.start();

	      
	}
}
