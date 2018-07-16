package com.hidazfx.screenie.Screenie;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.hidazfx.screenie.Screenie.configuration.LoadConfig;
import com.hidazfx.screenie.resize.Resize;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.concurrent.Executors;

import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.event.KeyAdapter;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.SystemColor;

public class AddDescription extends JFrame {

	private JPanel contentPane;
	static JTextArea textArea;
	public static AddDescription frame = null;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void launch() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new AddDescription();
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
	public AddDescription() throws IOException {
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
		setBounds(0, 0, 515, 388);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(0, 357, 516, 32);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblPressEnterTo = new JLabel("Press enter to submit, escape to cancel");
		lblPressEnterTo.setBounds(0, 0, 516, 32);
		panel.add(lblPressEnterTo);
		lblPressEnterTo.setHorizontalAlignment(SwingConstants.CENTER);
		lblPressEnterTo.setForeground(Color.BLACK);
		lblPressEnterTo.setFont(new Font("Segoe UI Light", Font.ITALIC, 14));
		lblPressEnterTo.setBackground(Color.BLACK);
		
		Resize.resize();
		textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		textArea.setForeground(Color.LIGHT_GRAY);
		textArea.setBackground(Color.GRAY);
		textArea.setBounds(0, 219, 516, 141);
		contentPane.add(textArea);
		requestFocus(textArea);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("resize_screenie." + Main.fileformat));
		lblNewLabel.setBounds(0, 41, 516, 180);
		contentPane.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.BLACK);
		panel_1.setBounds(0, 0, 515, 32);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		
		JLabel lblTypeADescription = new JLabel("What'd you capture?");
		lblTypeADescription.setBounds(10, 5, 228, 21);
		panel_1.add(lblTypeADescription);
		lblTypeADescription.setForeground(Color.DARK_GRAY);
		lblTypeADescription.setBackground(Color.DARK_GRAY);
		lblTypeADescription.setFont(new Font("Segoe UI Light", Font.BOLD, 20));
	}
	public static void submit(){
		Connect.sendDescription(LoadConfig.email(), LoadConfig.password(), textArea.getText());
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
