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

public class RegisterPageFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private LoginPageBgFrame bg;
	private JTextField usernameField;
	private JPasswordField passwordField;
	public static RegisterPageFrame frame;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		frame = new RegisterPageFrame();
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
	public RegisterPageFrame() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBackground(new Color(0, 0, 0, 0));
		setBounds(100, 100, 800, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(222, 222, 222, 60));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel registerPanel = new JPanel();
		registerPanel.setLayout(null);
		registerPanel.setBackground(new Color(220, 220, 220, 0));
		registerPanel.setBounds(0, 0, 800, 450);
		contentPane.add(registerPanel);

		JLabel logoLabel = new JLabel("");
		logoLabel.setBounds(21, 11, 88, 66);
		logoLabel.setIcon(ImageUtils.createScaledImageIcon(this, "assets/logo.png", 88, 88));
		registerPanel.add(logoLabel);

		JPanel topBarPanel = new JPanel();
		topBarPanel.setLayout(null);
		topBarPanel.setBackground(Color.DARK_GRAY);
		topBarPanel.setBounds(0, 0, 800, 30);
		registerPanel.add(topBarPanel);

		JLabel loginIconLabel = new JLabel("");
		loginIconLabel.setBounds(770, 0, 30, 30);
		topBarPanel.add(loginIconLabel);
		loginIconLabel.setIcon(ImageUtils.createScaledImageIcon(this, "assets/blueRegisterIcon.png", 30, 30));
		
		JLabel usernameLabel = new JLabel("username");
		usernameLabel.setForeground(Color.DARK_GRAY);
		usernameLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		usernameLabel.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		usernameLabel.setBounds(120, 97, 88, 22);
		registerPanel.add(usernameLabel);
		
		JLabel passwordLabel = new JLabel("password");
		passwordLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		passwordLabel.setForeground(Color.DARK_GRAY);
		passwordLabel.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		passwordLabel.setBounds(120, 152, 88, 22);
		registerPanel.add(passwordLabel);
		
		JButton registerButton = new JButton("");
		registerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				@SuppressWarnings("deprecation")
				int registerRes = CredentialUtils.register(usernameField.getText(), passwordField.getText());
				switch (registerRes) {
				case 0 : //SUCCESSFUL
					PageUtils.openLoginPage();
					PageUtils.showInfoDialog(InfoDialogFrame.DIALOG_REGISTERCONFIRM, "Registration completed. You can now login.");
					setVisible(false);
					dispose();
					bg.setVisible(false);
					bg.dispose();
					break;
				case -1 : //FAILED
					PageUtils.showInfoDialog(InfoDialogFrame.DIALOG_ERROR, "Illegal user name and/or password, please try again. (-1)");
					break;
				case -2 : //CONTAINS "="
					PageUtils.showInfoDialog(InfoDialogFrame.DIALOG_ERROR, "Username and password cannot contains \"=\" (-2)");
					break;
				case -3 : //ALREADY EXISTS
					PageUtils.showInfoDialog(InfoDialogFrame.DIALOG_ERROR, "Username already exists, please try another username (-3)");
					break;
				}
				repaint();
			}
		});
		registerButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		registerButton.setToolTipText("Submit");
		registerButton.setIcon(ImageUtils.createScaledImageIcon(this, "assets/submitIcon.png", 40, 40));
		registerButton.setForeground(Color.DARK_GRAY);
		registerButton.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		registerButton.setBorder(null);
		registerButton.setBackground(new Color(0, 0, 0, 0));
		registerButton.setBounds(253, 243, 40, 40);
		registerPanel.add(registerButton);
		
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
		registerPanel.add(usernameField);
		usernameField.setColumns(10);
		
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
		registerPanel.add(passwordField);

		JLabel backIconLabel = new JLabel("");
		backIconLabel.setToolTipText("Back");
		backIconLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		backIconLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PageUtils.openLoginPage();
				setVisible(false);
				dispose();
				bg.setVisible(false);
				bg.dispose();
			}
		});
		backIconLabel.setBounds(740, 0, 30, 30);
		topBarPanel.add(backIconLabel);
		backIconLabel.setIcon(ImageUtils.createScaledImageIcon(this, "assets/redBackIcon.png", 30, 30));

		JLabel titleLabel = new JLabel("Register");
		titleLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		titleLabel.setForeground(Color.DARK_GRAY);
		titleLabel.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 42));
		titleLabel.setBounds(120, 18, 283, 66);
		registerPanel.add(titleLabel);
		
		JPanel transparencyPanel = new JPanel();
		transparencyPanel.setBackground(new Color(222, 222, 222, 150));
		transparencyPanel.setBounds(10, 11, 300, 290);
		contentPane.add(transparencyPanel);
		
		bg = new LoginPageBgFrame();
		bg.setAlwaysOnTop(true);
		bg.setVisible(true);
		
		setLocation(PositionUtils.getScreenCenterPoint(this));
		
		setAlwaysOnTop(true);
		toFront();
		
	}
}
