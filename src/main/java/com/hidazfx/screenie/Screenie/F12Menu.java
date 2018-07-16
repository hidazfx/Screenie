package com.hidazfx.screenie.Screenie;

import java.awt.AWTException;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.hidazfx.screenie.Screenie.configuration.LoadConfig;
import com.hidazfx.screenie.record.ClippyRecord;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.Executors;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.SwingConstants;
import java.awt.event.KeyAdapter;

import javax.imageio.ImageIO;
import javax.swing.JComponent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class F12Menu extends JFrame {

	private JPanel contentPane;
	public static F12Menu frame = null;
	private JLabel lblSendClippie;

	/**
	 * Launch the application.
	 */
	public static void launch() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new F12Menu();
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
	 */
	public F12Menu() {
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
		setBounds(0, 0, 231, 80);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblTypeADescription = new JLabel("Choose one...");
		lblTypeADescription.setForeground(Color.LIGHT_GRAY);
		lblTypeADescription.setBackground(Color.LIGHT_GRAY);
		lblTypeADescription.setFont(new Font("Segoe UI Light", Font.BOLD, 18));
		lblTypeADescription.setBounds(10, 11, 198, 19);
		contentPane.add(lblTypeADescription);
		
		lblSendClippie = new JLabel("Send Screenie");
		lblSendClippie.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
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
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
                Main.isAddDescription=true;
				AddDescription.launch();
				shutdown();
			}
		});
		lblSendClippie.setHorizontalAlignment(SwingConstants.CENTER);
		lblSendClippie.setForeground(Color.LIGHT_GRAY);
		lblSendClippie.setFont(new Font("Segoe UI Light", Font.BOLD, 14));
		lblSendClippie.setBackground(Color.LIGHT_GRAY);
		lblSendClippie.setBounds(10, 41, 108, 19);
		contentPane.add(lblSendClippie);
		
		JLabel lblSendClippie_1 = new JLabel("Send Clippy");
		lblSendClippie_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				shutdown();
				ClippyRecord.StopRecordingClippy();
				Connect.sendClippy(LoadConfig.email(), LoadConfig.password());
			}
		});
		lblSendClippie_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblSendClippie_1.setForeground(Color.LIGHT_GRAY);
		lblSendClippie_1.setFont(new Font("Segoe UI Light", Font.BOLD, 14));
		lblSendClippie_1.setBackground(Color.LIGHT_GRAY);
		lblSendClippie_1.setBounds(128, 41, 99, 19);
		contentPane.add(lblSendClippie_1);
	}
	public static void submit(){
		frame.setVisible(false);
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
