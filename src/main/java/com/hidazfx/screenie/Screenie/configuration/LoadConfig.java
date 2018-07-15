package com.hidazfx.screenie.Screenie.configuration;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class LoadConfig {
	static String host;
	public static String email(){
		File configFile = new File("config.properties");
		try {
		    FileReader reader = new FileReader(configFile);
		    Properties props = new Properties();
		    props.load(reader);
		 
		    host = props.getProperty("email");
		 
		    System.out.print("Host name is: " + host);
		    reader.close();
		} catch (FileNotFoundException ex1) {
		    // file does not exist
		} catch (IOException ex) {
		    // I/O error
		}
		return host;
	}
	public static String password(){
		File configFile = new File("config.properties");
		try {
		    FileReader reader = new FileReader(configFile);
		    Properties props = new Properties();
		    props.load(reader);
		 
		    host = props.getProperty("password");
		 
		    System.out.print("Host name is: " + host);
		    reader.close();
		} catch (FileNotFoundException ex1) {
		    // file does not exist
		} catch (IOException ex) {
		    // I/O error
		}
		return host;
	}
	public static String fileformat(){
		File configFile = new File("config.properties");
		try {
		    FileReader reader = new FileReader(configFile);
		    Properties props = new Properties();
		    props.load(reader);
		 
		    host = props.getProperty("fileformat");
		 
		    System.out.print("Host name is: " + host);
		    reader.close();
		} catch (FileNotFoundException ex1) {
		    // file does not exist
		} catch (IOException ex) {
		    // I/O error
		}
		return host;
	}
	public static String serverid(){
		File configFile = new File("config.properties");
		try {
		    FileReader reader = new FileReader(configFile);
		    Properties props = new Properties();
		    props.load(reader);
		 
		    host = props.getProperty("serverid");
		 
		    System.out.print("Host name is: " + host);
		    reader.close();
		} catch (FileNotFoundException ex1) {
		    // file does not exist
		} catch (IOException ex) {
		    // I/O error
		}
		return host;
	}
	public static String channelid(){
		File configFile = new File("config.properties");
		try {
		    FileReader reader = new FileReader(configFile);
		    Properties props = new Properties();
		    props.load(reader);
		 
		    host = props.getProperty("channelid");
		 
		    System.out.print("Host name is: " + host);
		    reader.close();
		} catch (FileNotFoundException ex1) {
		    // file does not exist
		} catch (IOException ex) {
		    // I/O error
		}
		return host;
	}
	public static String shutdownButton(){
		File configFile = new File("config.properties");
		try {
		    FileReader reader = new FileReader(configFile);
		    Properties props = new Properties();
		    props.load(reader);
		 
		    host = props.getProperty("shutdownbutton");
		 
		    System.out.print("Host name is: " + host);
		    reader.close();
		} catch (FileNotFoundException ex1) {
		    // file does not exist
		} catch (IOException ex) {
		    // I/O error
		}
		return host;
	}
	public static String captureButton(){
		File configFile = new File("config.properties");
		try {
		    FileReader reader = new FileReader(configFile);
		    Properties props = new Properties();
		    props.load(reader);
		 
		    host = props.getProperty("capturebutton");
		 
		    System.out.print("Host name is: " + host);
		    reader.close();
		} catch (FileNotFoundException ex1) {
		    // file does not exist
		} catch (IOException ex) {
		    // I/O error
		}
		return host;
	}
	public static String describeCaptureButton(){
		File configFile = new File("config.properties");
		try {
		    FileReader reader = new FileReader(configFile);
		    Properties props = new Properties();
		    props.load(reader);
		 
		    host = props.getProperty("describecapturebutton");
		 
		    System.out.print("Host name is: " + host);
		    reader.close();
		} catch (FileNotFoundException ex1) {
		    // file does not exist
		} catch (IOException ex) {
		    // I/O error
		}
		return host;
	}
	public static String clippyDuration(){
		File configFile = new File("config.properties");
		try {
		    FileReader reader = new FileReader(configFile);
		    Properties props = new Properties();
		    props.load(reader);
		 
		    host = props.getProperty("clippyduration");
		 
		    System.out.print("Host name is: " + host);
		    reader.close();
		} catch (FileNotFoundException ex1) {
		    // file does not exist
		} catch (IOException ex) {
		    // I/O error
		}
		return host;
	}
}
