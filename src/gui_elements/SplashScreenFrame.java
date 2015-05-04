package gui_elements;
import gui_backend.DebugUtils;
import gui_backend.PositionUtils;

import java.awt.Color;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class SplashScreenFrame extends JFrame implements Runnable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public SplashScreenFrame() {
		super();
		setIconImage(Toolkit.getDefaultToolkit().getImage(SplashScreenFrame.class.getResource("/assets/windowIcon.png")));
		setAlwaysOnTop(true);
		setResizable(false);
		setUndecorated(true);
		pack();
		setVisible(true);
		setBackground(new Color(0, 0, 0, 0));
		getContentPane().setLayout(null);
		setSize(400, 400);
		setLocation(PositionUtils.getScreenCenterPoint(this));
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		SplashScreenPanel transparencyPanel = new SplashScreenPanel(0f);
		transparencyPanel.setBounds(0, 0, 400, 400);
		transparencyPanel.setLayout(null);
		transparencyPanel.setBackground(new Color(0, 0, 0, 0));
		getContentPane().add(transparencyPanel);
		for (float i = 0, j = 0; j < 255; i += 0.00393700787401574803149606299213f, j++) {
			setBackground(new Color(255, 255, 255, (int) j));
			transparencyPanel.setAlpha(i);
			DebugUtils.writeln(this.getClass().toString().substring(6) + " | Setting opacity (UP) | frame -- " + j + " | img -- " + i);
			try {Thread.sleep(1);} catch (InterruptedException e) {e.printStackTrace();}
		}
		DebugUtils.writeln(this.getClass().toString().substring(6) + " | Thread.sleep(3000)");
		try {Thread.sleep(3000);} catch (InterruptedException e) {e.printStackTrace();}
		for (float i = transparencyPanel.getAlpha(), j = 254; j >= 0; i -= 0.00393700787401574803149606299213f * 6, j -= 6) {
			setBackground(new Color(255, 255, 255, (int) j));
			transparencyPanel.setAlpha(i);
			DebugUtils.writeln(this.getClass().toString().substring(6) + " | Setting opacity (DOWN) | frame -- " + j + " | img -- " + i);
			try {Thread.sleep(1);} catch (InterruptedException e) {e.printStackTrace();}
		}
		transparencyPanel.setAlpha(1.0f);
		setVisible(false);
		dispose();		
	}
	public void run() {}
}
