package gui_elements;

import gui_backend.DebugUtils;
import gui_backend.ImageUtils;
import gui_backend.PositionUtils;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class LoginPageBgFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPageBgFrame frame = new LoginPageBgFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginPageBgFrame() {
		DebugUtils.writeln(this.getClass().toString().substring(6) + " | Building LoginPageBgFrame...");
		setIconImage(ImageUtils.createImage(this, "assets/loginIcon.png"));
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel bgLabel = new JLabel("");
		bgLabel.setBounds(0, 0, 800, 450);

		DebugUtils.writeln(this.getClass().toString().substring(6) + " | Loading animated image resource \"assets/animatedBg.gif\" and building ImageIcon...");
		bgLabel.setIcon(new ImageIcon(this.getClass().getClassLoader().getResource("assets/animatedBg.gif")));
		contentPane.add(bgLabel);
		
		setLocation(PositionUtils.getScreenCenterPoint(this));
		DebugUtils.writeln(this.getClass().toString().substring(6) + " | Building finished.");
	}
}
