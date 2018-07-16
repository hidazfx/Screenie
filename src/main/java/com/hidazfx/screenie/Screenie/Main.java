package com.hidazfx.screenie.Screenie;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

import com.hidazfx.screenie.Screenie.configuration.LoadConfig;
import com.hidazfx.screenie.record.ClippyRecord;


public class Main {
    private static volatile boolean wPressed = false;
    public static String email = null;
    public static String keyText;
    public static boolean isAddDescription;
    public static String fileformat = LoadConfig.fileformat();
    public static boolean isWPressed() {
        synchronized (Main.class) {
            return wPressed;
        }
    }


    
    public static void main(String[] args) throws InterruptedException, IOException, AWTException {
    	email = LoadConfig.email();
    	Connect.downloadData(LoadConfig.email(), LoadConfig.password());
    	try
    	{
    	    GlobalScreen.registerNativeHook();
    	    GlobalScreen.addNativeKeyListener(new NativeKeyListener()
    	    {

    	        @Override
    	        public void nativeKeyTyped(NativeKeyEvent nativeEvent)
    	        {
    	        }

    	        @Override
    	        public void nativeKeyReleased(NativeKeyEvent nativeEvent)
    	        {
    	            String keyText=NativeKeyEvent.getKeyText(nativeEvent.getKeyCode());
    	            System.out.println("User typed: "+ keyText);
    	            if(keyText == "F10"){

    	            	try {
							Thread.sleep(500);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
    	            	System.exit(0);
    	            	
    	            }
    	            if(keyText == "F11"){
    	            	System.out.print("F11_Pressed");
                        wPressed = false;
                        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
                        Rectangle screenRectangle = new Rectangle(screenSize);
                        Robot robot = null;
						try {
							robot = new Robot();
						} catch (AWTException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
                        BufferedImage image = robot.createScreenCapture(screenRectangle);
                        try {
							ImageIO.write(image, Main.fileformat, new File("screenie." + Main.fileformat));
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
                        Connect.send(LoadConfig.email(), LoadConfig.password()); // Add shit here
    	            }
    	            if(keyText == "F12"){
    	            	
    	            	System.out.print("F12_Pressed");
                        wPressed = false;
                        F12Menu.launch();
    	            }
    	            if(keyText == "Enter" && isAddDescription == true){
    	            	AddDescription.submit();
    	            	isAddDescription=false;
    	            }
    	            if(keyText == "Escape" && isAddDescription == true){
    	            	AddDescription.shutdown();
    	            	F12Menu.shutdown();
    	            	isAddDescription=false;
    	            }
    	        }

    	        @Override
    	        public void nativeKeyPressed(NativeKeyEvent nativeEvent)
    	        {   
    	        }
    	     });
    	}
    	catch (NativeHookException e)
    	{
    	    e.printStackTrace();
    	}
    }
}