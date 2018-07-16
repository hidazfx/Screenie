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
import java.awt.SystemColor;

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
					frame.hide();
				}
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 314, 221);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblTypeADescription = new JLabel("Choose one...");
		lblTypeADescription.setForeground(Color.DARK_GRAY);
		lblTypeADescription.setBackground(Color.DARK_GRAY);
		lblTypeADescription.setFont(new Font("Segoe UI Light", Font.BOLD, 20));
		lblTypeADescription.setBounds(10, 5, 198, 19);
		contentPane.add(lblTypeADescription);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(0, 73, 314, 43);
		contentPane.add(panel_1);
		
		JLabel lblSendClippie_1 = new JLabel("Record Clippy");
		lblSendClippie_1.setBounds(10, 6, 262, 30);
		panel_1.add(lblSendClippie_1);
		lblSendClippie_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					ClippyRecord.StartRecordingClippy();
				} catch (AWTException | InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblSendClippie_1.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblSendClippie_1.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
			}
		});
		lblSendClippie_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblSendClippie_1.setForeground(Color.DARK_GRAY);
		lblSendClippie_1.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		lblSendClippie_1.setBackground(Color.BLACK);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBounds(0, 30, 314, 43);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblSendClippie = new JLabel("Send Described Screenie");
		lblSendClippie.setBounds(10, 0, 294, 43);
		panel.add(lblSendClippie);
		lblSendClippie.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				shutdown();
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
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblSendClippie.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblSendClippie.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
			}
		});
		lblSendClippie.setHorizontalAlignment(SwingConstants.LEFT);
		lblSendClippie.setForeground(Color.LIGHT_GRAY);
		lblSendClippie.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		lblSendClippie.setBackground(Color.LIGHT_GRAY);
		
		JPanel panel_2 = new JPanel();
		panel_2.setForeground(Color.DARK_GRAY);
		panel_2.setLayout(null);
		panel_2.setBackground(Color.DARK_GRAY);
		panel_2.setBounds(0, 114, 314, 43);
		contentPane.add(panel_2);
		
		JLabel lblConfiguration = new JLabel("Configuration");
		lblConfiguration.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblConfiguration.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblConfiguration.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
			}
		});
		lblConfiguration.setHorizontalAlignment(SwingConstants.LEFT);
		lblConfiguration.setForeground(Color.LIGHT_GRAY);
		lblConfiguration.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		lblConfiguration.setBackground(Color.LIGHT_GRAY);
		lblConfiguration.setBounds(10, 6, 294, 30);
		panel_2.add(lblConfiguration);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(SystemColor.controlShadow);
		panel_3.setBounds(0, 156, 314, 143);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel = new JLabel(Connect.SERVER_NAME);
		lblNewLabel.setFont(new Font("Segoe UI Light", Font.BOLD, 15));
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setBounds(10, 11, 294, 21);
		panel_3.add(lblNewLabel);
		lblNewLabel.setText(Connect.SERVER_NAME);
		
		JLabel lblChannelnameaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa = new JLabel(Connect.CHANNEL_NAME);
		lblChannelnameaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa.setVerticalAlignment(SwingConstants.TOP);
		lblChannelnameaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa.setHorizontalAlignment(SwingConstants.LEFT);
		lblChannelnameaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa.setFont(new Font("Segoe UI Light", Font.PLAIN, 13));
		lblChannelnameaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa.setBounds(9, 35, 294, 21);
		
		panel_3.add(lblChannelnameaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa);
		
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
