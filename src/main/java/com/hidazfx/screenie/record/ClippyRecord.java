package com.hidazfx.screenie.record;

import java.awt.AWTException;

import com.hidazfx.screenie.record.ScreenRecorder.Quality;

public class ClippyRecord {
	static ScreenRecorder recorder = null;
	static Thread thread;
	public static boolean isFinished = false;
	public static void StartRecordingClippy() throws AWTException, InterruptedException{
	    Thread thread = new Thread(){
	    double frameRate = 30; //FPS
		int howManySecondsToRun = 11; //How many seconds to run
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
		    recorder.stopCapture();
		    isFinished = true;
	    }
	    };
	    thread.start();

	      
	}
	public static void StopRecordingClippy(){
		recorder.stopCapture();
		thread.interrupt();
	}
}
