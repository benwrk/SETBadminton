package gui_elements;

import gui_backend.CredentialUtils;
import gui_backend.ImageUtils;
import gui_backend.PageUtils;
import gui_backend.PositionUtils;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

public class LoginPageFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static LoginPageFrame frame;
	private JTextField usernameField;
	private JPasswordField passwordField;
	private JLabel statusLabel = new JLabel("");
	public static int staticExitStatus = 1;	
	private LoginPageBgFrame bg;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		frame = new LoginPageFrame(staticExitStatus);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
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
	public LoginPageFrame(int exitStatus) {
		setIconImage(ImageUtils.createImage(this, "assets/loginIcon.png"));
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBackground(new Color(0, 0, 0, 0));
		setBounds(100, 100, 800, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(222, 222, 222, 60));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel loginPanel = new JPanel();
		loginPanel.setLayout(null);
		loginPanel.setBackground(new Color(0, 0, 0, 0));
		loginPanel.setBounds(0, 0, 800, 450);
		contentPane.add(loginPanel);

		JLabel logoLabel = new JLabel("");
		logoLabel.setBounds(21, 11, 88, 66);
		logoLabel.setIcon(ImageUtils.createScaledImageIcon(this, "assets/logo.png", 88, 88));
		loginPanel.add(logoLabel);

		JPanel topBarPanel = new JPanel();
		topBarPanel.setLayout(null);
		topBarPanel.setBackground(Color.DARK_GRAY);
		topBarPanel.setBounds(0, 0, 800, 30);
		loginPanel.add(topBarPanel);

		JLabel loginIconLabel = new JLabel("");
		loginIconLabel.setBounds(770, 0, 30, 30);
		topBarPanel.add(loginIconLabel);
		loginIconLabel.setIcon(ImageUtils.createScaledImageIcon(this, "assets/loginIcon.png", 30, 30));

		JLabel closeIconLabel = new JLabel("");
		closeIconLabel.setToolTipText("Exit");
		closeIconLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		closeIconLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PageUtils.quitApp(exitStatus);
			}
		});
		closeIconLabel.setBounds(740, 0, 30, 30);
		topBarPanel.add(closeIconLabel);
		closeIconLabel.setIcon(ImageUtils.createScaledImageIcon(this, "assets/closeIcon.png", 30, 30));

		JLabel titleLabel = new JLabel("Sign in");
		titleLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		titleLabel.setForeground(Color.DARK_GRAY);
		titleLabel.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 42));
		titleLabel.setBounds(120, 18, 283, 66);
		loginPanel.add(titleLabel);

		JLabel usernameLabel = new JLabel("username");
		usernameLabel.setForeground(Color.DARK_GRAY);
		usernameLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		usernameLabel.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		usernameLabel.setBounds(120, 97, 88, 22);
		loginPanel.add(usernameLabel);

		usernameField = new JTextField();
		usernameField.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent arg0) {
				repaint();
			}
		});
		usernameField.setSelectionColor(Color.LIGHT_GRAY);
		usernameField.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		usernameField.setBackground(new Color(0, 0, 0, 0));
		usernameField.setForeground(Color.DARK_GRAY);
		usernameField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		usernameField.setBounds(120, 120, 160, 25);
		loginPanel.add(usernameField);
		usernameField.setColumns(10);

		JLabel passwordLabel = new JLabel("password");
		passwordLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		passwordLabel.setForeground(Color.DARK_GRAY);
		passwordLabel.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		passwordLabel.setBounds(120, 152, 88, 22);
		loginPanel.add(passwordLabel);

		JButton loginButton = new JButton("");
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				@SuppressWarnings("deprecation")
				int loginRes = CredentialUtils.login(usernameField.getText(), passwordField.getText());
				switch (loginRes) {
				case 0 :
					PageUtils.openMainPage(usernameField.getText());
					statusLabel.setText("logged in");
					LoginPageFrame.frame.setVisible(false);
					LoginPageFrame.frame.dispose();
					bg.dispose();
					break;
				case -1 :
					PageUtils.showInfoDialog(InfoDialogFrame.DIALOG_ERROR, "Username not found. Click register button to register. (-1)");
					break;
				case -2 :
					PageUtils.showInfoDialog(InfoDialogFrame.DIALOG_ERROR, "Password does not match. Try again. (-2)");
					break;
				}
				repaint();
			}
		});
		loginButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		loginButton.setToolTipText("Sign in");
		loginButton.setIcon(ImageUtils.createScaledImageIcon(this, "assets/submitIcon.png", 40, 40));
		loginButton.setForeground(Color.DARK_GRAY);
		loginButton.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		loginButton.setBorder(null);
		loginButton.setBackground(new Color(0, 0, 0, 0));
		loginButton.setBounds(253, 243, 40, 40);
		loginPanel.add(loginButton);

		JButton registerButton = new JButton("");
		registerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PageUtils.openRegisterPage();
				setVisible(false);
				dispose();
				bg.setVisible(false);
				bg.dispose();
			}
		});
		registerButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		registerButton.setToolTipText("Register");
		registerButton.setIcon(ImageUtils.createScaledImageIcon(this, "assets/registerIcon.png", 40, 40));
		registerButton.setForeground(Color.DARK_GRAY);
		registerButton.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		registerButton.setBorder(null);
		registerButton.setBackground(new Color(0, 0, 0, 0));
		registerButton.setBounds(210, 243, 40, 40);
		loginPanel.add(registerButton);

		passwordField = new JPasswordField();
		passwordField.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) {
				repaint();
			}
		});
		passwordField.setBackground(new Color(0, 0, 0, 0));
		passwordField.setSelectionColor(Color.LIGHT_GRAY);
		passwordField.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		passwordField.setBounds(120, 174, 160, 25);
		loginPanel.add(passwordField);
		
		statusLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		statusLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		statusLabel.setForeground(new Color(255, 60, 60));
		statusLabel.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		statusLabel.setBounds(43, 261, 160, 22);
		loginPanel.add(statusLabel);

		JPanel transparencyPanel = new JPanel();
		transparencyPanel.setBackground(new Color(222, 222, 222, 150));
		transparencyPanel.setBounds(10, 11, 300, 290);
		contentPane.add(transparencyPanel);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(222, 222, 222, 30));
		panel.setBounds(0, 0, 800, 450);
		contentPane.add(panel);
		
		bg = new LoginPageBgFrame();
		setLocation(PositionUtils.getScreenCenterPoint(this));
		bg.setAlwaysOnTop(true);
		bg.setVisible(true);		
		
		setAlwaysOnTop(true);
		toFront();
	}
}
