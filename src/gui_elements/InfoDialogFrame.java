package gui_elements;

import gui_backend.ImageUtils;
import gui_backend.PositionUtils;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class InfoDialogFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	public static final int
	DIALOG_NORMAL = 0,
	DIALOG_ERROR = 1,
	DIALOG_REGISTERCONFIRM = 10;
	private JPanel contentPane;
	private JTextField messageField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InfoDialogFrame frame = new InfoDialogFrame(DIALOG_NORMAL, "Default dialog box");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public static void main(int dialogType, String message) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InfoDialogFrame frame = new InfoDialogFrame(dialogType, message);
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
	public InfoDialogFrame(int dialogType, String message) {
		setIconImage(ImageUtils.createImage(this, "assets/blueInfoIcon.png"));
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 400, 140);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel topBarPanel = new JPanel();
		topBarPanel.setLayout(null);
		topBarPanel.setBackground(Color.DARK_GRAY);
		topBarPanel.setBounds(0, 0, 400, 30);
		contentPane.add(topBarPanel);
		
		JLabel closeIconLabel = new JLabel("");
		closeIconLabel.setToolTipText("Exit");
		closeIconLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		closeIconLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				dispose();
			}
		});
		closeIconLabel.setIcon(ImageUtils.createScaledImageIcon(this, "assets/closeIcon.png", 30, 30));
		closeIconLabel.setBounds(340, 0, 30, 30);
		topBarPanel.add(closeIconLabel);
		
		JLabel titleIconLabel = new JLabel("");
		titleIconLabel.setBounds(370, 0, 30, 30);
		topBarPanel.add(titleIconLabel);
		
		JLabel titleLabel = new JLabel("");
		titleLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		titleLabel.setForeground(new Color(252, 252, 252));
		titleLabel.setBounds(215, 0, 115, 30);
		topBarPanel.add(titleLabel);
		titleLabel.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 14));
		
		messageField = new JTextField(message);
		messageField.setHorizontalAlignment(SwingConstants.CENTER);
		messageField.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		messageField.setBorder(null);
		messageField.setBackground(new Color(0, 0, 0, 0));
		messageField.setEditable(false);
		messageField.setBounds(20, 45, 360, 80);
		contentPane.add(messageField);
		messageField.setColumns(10);
		
		String iconFile = "";
		
		switch (dialogType) {
		case 0 :
			//NORMAL
			titleLabel.setText("information");
			iconFile = "assets/blueInfoIcon.png";
			break;
		case 1 :
			//ERROR
			titleLabel.setText("error");
			iconFile = "assets/blueErrorIcon.png";
			break;
		case 10 :
			//REGISTRATION SUCCESSFUL
			titleLabel.setText("registration");
			iconFile = "assets/blueRegisterIcon.png";
		}
		titleIconLabel.setIcon(ImageUtils.createScaledImageIcon(this, iconFile, 30, 30));
		
		setLocation(PositionUtils.getScreenCenterPoint(this));
		setAlwaysOnTop(true);
	}
}
