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
		setBounds(0, 0, 536, 423);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblTypeADescription = new JLabel("What'd you capture?");
		lblTypeADescription.setForeground(Color.LIGHT_GRAY);
		lblTypeADescription.setBackground(Color.LIGHT_GRAY);
		lblTypeADescription.setFont(new Font("Segoe UI Light", Font.BOLD, 18));
		lblTypeADescription.setBounds(10, 11, 198, 19);
		contentPane.add(lblTypeADescription);
		
		Resize.resize();
		textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		textArea.setForeground(Color.LIGHT_GRAY);
		textArea.setBackground(Color.GRAY);
		textArea.setBounds(10, 228, 516, 141);
		contentPane.add(textArea);
		requestFocus(textArea);
		
		JLabel lblPressEnterTo = new JLabel("Press enter to submit, escape to cancel");
		lblPressEnterTo.setHorizontalAlignment(SwingConstants.CENTER);
		lblPressEnterTo.setForeground(Color.BLACK);
		lblPressEnterTo.setFont(new Font("Segoe UI Light", Font.ITALIC, 14));
		lblPressEnterTo.setBackground(Color.BLACK);
		lblPressEnterTo.setBounds(10, 380, 411, 32);
		contentPane.add(lblPressEnterTo);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("resize_screenie." + Main.fileformat));
		lblNewLabel.setBounds(10, 37, 516, 180);
		contentPane.add(lblNewLabel);
		
		JLabel lblScreenieV = new JLabel("Screenie v0.3");
		lblScreenieV.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.hide();
			}
		});
		lblScreenieV.setHorizontalAlignment(SwingConstants.RIGHT);
		lblScreenieV.setForeground(Color.BLACK);
		lblScreenieV.setFont(new Font("Segoe UI Light", Font.BOLD, 14));
		lblScreenieV.setBackground(Color.LIGHT_GRAY);
		lblScreenieV.setBounds(413, 13, 113, 19);
		contentPane.add(lblScreenieV);
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
