package com.hidazfx.screenie.record;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.hidazfx.screenie.Screenie.Connect;
import com.hidazfx.screenie.Screenie.Main;
import com.hidazfx.screenie.Screenie.configuration.LoadConfig;
import com.hidazfx.screenie.resize.Resize;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.concurrent.Executors;

import javax.swing.JTextArea;

import java.awt.AWTException;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.event.KeyAdapter;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Notification extends JFrame {

	private JPanel contentPane;
	public static Notification frame = null;

	/**
	 * Launch the application.
	 */
	public static void launch() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Notification();
					frame.setVisible(true);
					frame.toFront();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	 
	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public Notification() throws IOException {
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				shutdown();
				try {
					ClippyRecord.StartRecordingClippy();
				} catch (AWTException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		setUndecorated(true);
		setAlwaysOnTop(true);
		setResizable(false);
		setType(Type.UTILITY);
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
					dispose();
				}
			}
		});
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 183, 59);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Stopped recording");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(0, 0, 183, 37);
		contentPane.add(lblNewLabel);
		
		JLabel lblclickToStart = new JLabel("(Click to Dismiss)");
		lblclickToStart.setHorizontalAlignment(SwingConstants.CENTER);
		lblclickToStart.setForeground(Color.BLACK);
		lblclickToStart.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblclickToStart.setBounds(10, 25, 163, 29);
		contentPane.add(lblclickToStart);
		
		Resize.resize();
	}
	public static void shutdown(){
		frame.setVisible(false);
	}
	
	public final void requestFocus(final JComponent component)
	{
	    Runnable r = new Runnable() {
	        @Override
	        public void run() {
	            while (!component.isFocusOwner()) {
	                component.requestFocusInWindow();
	                try {
	                    Thread.sleep(1);
	                } catch (InterruptedException ex) {
	                    //Logger.getLogger(TestFrame.class.getName()).log(Level.SEVERE, null, ex);
	                }
	            }
	        }
	    };
	    if(component!=null&&component.isFocusable())
	    {
	        Executors.newCachedThreadPool().execute(r);
	    }
	}
}
