package com.hidazfx.screenie.record;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;

import com.hidazfx.screenie.Screenie.configuration.LoadConfig;

public class ffmpeg {
	public static void recordScreen() throws IOException, InterruptedException{
		Thread thread = new Thread(new Runnable()
		{
		   public void run()
		   {
		       // this will be run in a separate thread

			   Runtime run = Runtime.getRuntime();
				Process proc = null;
				try {
					run.exec("SendSignal ffmpeg.exe");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				File outputFile = new File("output.mp4");
		    	if(outputFile.exists()){
		    		try {
						FileUtils.forceDelete(outputFile);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		    	}
				try {
					proc = run.exec("ffmpeg -f gdigrab -framerate 30 -i desktop output.mp4");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					TimeUnit.SECONDS.sleep(Long.parseLong(LoadConfig.clippyDuration()));
				} catch (NumberFormatException | InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					run.exec("SendSignal ffmpeg.exe");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					TimeUnit.SECONDS.sleep(3);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				run();
				
		   }
		});
		// start the thread

		thread.start(); 
		
		
	}
	
	public static void stopRecording() throws IOException{
		Runtime run = Runtime.getRuntime();
		run.exec("SendSignal ffmpeg.exe");
		
	}
}
