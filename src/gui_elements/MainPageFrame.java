package gui_elements;

import gui_backend.DebugUtils;
import gui_backend.ImageUtils;
import gui_backend.PageUtils;
import gui_backend.PositionUtils;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class MainPageFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static String username = "invalid";
	public static MainPageFrame frame;
	public static void main(String[] args) {
		frame = new MainPageFrame(username);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
				if (username.equals("invalid")) {
					PageUtils.quitApp(-2);
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainPageFrame(String username) {
		setFont(new Font("Segoe UI Semilight", Font.PLAIN, 12));
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainPageFrame.class.getResource("/assets/windowIcon.png")));
		setResizable(false);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel menuPanel = new JPanel();
		menuPanel.setBackground(UIManager.getColor("windowBorder"));
		menuPanel.setBounds(750, 0, 50, 450);
		contentPane.add(menuPanel);
		menuPanel.setLayout(null);
		
		JPanel menuItemPanel_1 = new JPanel();
		menuItemPanel_1.setToolTipText("Home");
		menuItemPanel_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		menuItemPanel_1.setBackground(new Color(0, 191, 255));
		menuItemPanel_1.setBounds(0, 0, 50, 88);
		menuPanel.add(menuItemPanel_1);
		menuItemPanel_1.setLayout(null);
		
		JLabel homeIconLabel = new JLabel("");
		homeIconLabel.setBounds(10, 29, 30, 30);
		homeIconLabel.setHorizontalAlignment(SwingConstants.CENTER);
		homeIconLabel.setIcon(ImageUtils.createScaledImageIcon(this, "assets/homeIcon.png", 30, 30));
		menuItemPanel_1.add(homeIconLabel);
		
		JPanel menuItemPanel_2 = new JPanel();
		menuItemPanel_2.setToolTipText("Search");
		menuItemPanel_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		menuItemPanel_2.setBackground(Color.DARK_GRAY);
		menuItemPanel_2.setBounds(0, 90, 50, 88);
		menuPanel.add(menuItemPanel_2);
		menuItemPanel_2.setLayout(null);
		
		JLabel searchTimeIconLabel = new JLabel("");
		searchTimeIconLabel.setBounds(10, 29, 30, 30);
		searchTimeIconLabel.setHorizontalAlignment(SwingConstants.CENTER);
		searchTimeIconLabel.setIcon(ImageUtils.createScaledImageIcon(this, "assets/searchTimeIcon.png", 30, 30));
		menuItemPanel_2.add(searchTimeIconLabel);
		
		JPanel menuItemPanel_3 = new JPanel();
		menuItemPanel_3.setToolTipText("Reserve and Payment");
		menuItemPanel_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		menuItemPanel_3.setBackground(Color.DARK_GRAY);
		menuItemPanel_3.setBounds(0, 180, 50, 88);
		menuPanel.add(menuItemPanel_3);
		menuItemPanel_3.setLayout(null);
		
		JLabel reserveIconLabel = new JLabel("");
		reserveIconLabel.setBounds(10, 29, 30, 30);
		menuItemPanel_3.add(reserveIconLabel);
		reserveIconLabel.setHorizontalAlignment(SwingConstants.CENTER);
		reserveIconLabel.setIcon(ImageUtils.createScaledImageIcon(this, "assets/reserveIcon.png", 30, 30));
		
		JPanel menuItemPanel_4 = new JPanel();
		menuItemPanel_4.setToolTipText("Information");
		menuItemPanel_4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		menuItemPanel_4.setBackground(Color.DARK_GRAY);
		menuItemPanel_4.setBounds(0, 270, 50, 88);
		menuPanel.add(menuItemPanel_4);
		menuItemPanel_4.setLayout(null);
		
		JLabel informationIconLabel = new JLabel("");
		informationIconLabel.setBounds(10, 29, 30, 30);
		menuItemPanel_4.add(informationIconLabel);
		informationIconLabel.setHorizontalAlignment(SwingConstants.CENTER);
		informationIconLabel.setIcon(ImageUtils.createScaledImageIcon(this, "assets/informationIcon.png", 30, 30));
		
		JPanel menuItemPanel_5 = new JPanel();
		menuItemPanel_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				DebugUtils.writeln(MainPageFrame.frame.getClass().toString().substring(6) + " | Logging out...");
				PageUtils.openLoginPage();
				MainPageFrame.frame.dispose();
			}
		});
		menuItemPanel_5.setToolTipText("Logout");
		menuItemPanel_5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		menuItemPanel_5.setBackground(Color.DARK_GRAY);
		menuItemPanel_5.setBounds(0, 360, 50, 90);
		menuPanel.add(menuItemPanel_5);
		menuItemPanel_5.setLayout(null);
		
		JLabel exitIconLabel = new JLabel("");
		exitIconLabel.setBounds(10, 29, 30, 30);
		menuItemPanel_5.add(exitIconLabel);
		exitIconLabel.setHorizontalAlignment(SwingConstants.CENTER);
		exitIconLabel.setIcon(ImageUtils.createScaledImageIcon(this, "assets/exitIcon.png", 30, 30));
		
		JPanel mainPagePanel = new JPanel();
		mainPagePanel.setBackground(SystemColor.control);
		mainPagePanel.setBounds(0, 0, 750, 450);
		contentPane.add(mainPagePanel);
		mainPagePanel.setLayout(null);
		
		JLabel titleLabel = new JLabel("Courts Status");
		titleLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		titleLabel.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 42));
		titleLabel.setForeground(new Color(105, 105, 105));
		titleLabel.setBounds(120, 18, 283, 66);
		mainPagePanel.add(titleLabel);
		
		JLabel logoLabel = new JLabel("");
		logoLabel.setBounds(21, 11, 88, 66);
		logoLabel.setIcon(ImageUtils.createScaledImageIcon(this, "assets/logo.png", 88, 88));
		mainPagePanel.add(logoLabel);
		
		JPanel topBarPanel = new JPanel();
		topBarPanel.setBackground(Color.DARK_GRAY);
		topBarPanel.setBounds(0, 0, 750, 30);
		mainPagePanel.add(topBarPanel);
		topBarPanel.setLayout(null);
		
		JLabel usernameLabel = new JLabel(username);
		usernameLabel.setForeground(new Color(252, 252, 252));
		usernameLabel.setBounds(635, 0, 115, 29);
		topBarPanel.add(usernameLabel);
		usernameLabel.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 14));
		
		JLabel userIconLabel = new JLabel("");
		userIconLabel.setBounds(599, 0, 30, 30);
		topBarPanel.add(userIconLabel);
		userIconLabel.setIcon(ImageUtils.createScaledImageIcon(this, "assets/userIcon.png", 30, 30));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scrollPane.setBorder(null);
		scrollPane.setBounds(20, 88, 730, 362);
		scrollPane.getHorizontalScrollBar().setUnitIncrement(10);
		mainPagePanel.add(scrollPane);
		
		JPanel courtStatusPanel = new JPanel();
		scrollPane.setViewportView(courtStatusPanel);
		courtStatusPanel.setLayout(null);
		courtStatusPanel.setSize(1690, 345);
		courtStatusPanel.setMinimumSize(new Dimension(1690, 345));
		courtStatusPanel.setPreferredSize(new Dimension(1690, 345));
		
		JPanel courtPanel_1 = new JPanel();
		courtPanel_1.setBackground(Color.BLUE);
		courtPanel_1.setBounds(0, 0, 200, 345);
		courtStatusPanel.add(courtPanel_1);
		courtPanel_1.setLayout(null);
		
		JPanel courtPanel_2 = new JPanel();
		courtPanel_2.setBackground(Color.BLUE);
		courtPanel_2.setLayout(null);
		courtPanel_2.setBounds(210, 0, 200, 345);
		courtStatusPanel.add(courtPanel_2);
		
		JPanel courtPanel_3 = new JPanel();
		courtPanel_3.setBackground(Color.BLUE);
		courtPanel_3.setLayout(null);
		courtPanel_3.setBounds(420, 0, 200, 345);
		courtStatusPanel.add(courtPanel_3);
		
		JPanel courtPanel_4 = new JPanel();
		courtPanel_4.setBackground(Color.BLUE);
		courtPanel_4.setLayout(null);
		courtPanel_4.setBounds(630, 0, 200, 345);
		courtStatusPanel.add(courtPanel_4);
		
		JPanel courtPanel_5 = new JPanel();
		courtPanel_5.setLayout(null);
		courtPanel_5.setBackground(Color.BLUE);
		courtPanel_5.setBounds(840, 0, 200, 345);
		courtStatusPanel.add(courtPanel_5);
		
		JPanel courtPanel_6 = new JPanel();
		courtPanel_6.setLayout(null);
		courtPanel_6.setBackground(Color.BLUE);
		courtPanel_6.setBounds(1050, 0, 200, 345);
		courtStatusPanel.add(courtPanel_6);
		
		JPanel courtPanel_7 = new JPanel();
		courtPanel_7.setLayout(null);
		courtPanel_7.setBackground(Color.BLUE);
		courtPanel_7.setBounds(1260, 0, 200, 345);
		courtStatusPanel.add(courtPanel_7);
		
		JPanel courtPanel_8 = new JPanel();
		courtPanel_8.setLayout(null);
		courtPanel_8.setBackground(Color.BLUE);
		courtPanel_8.setBounds(1470, 0, 200, 345);
		courtStatusPanel.add(courtPanel_8);
		
		setLocation(PositionUtils.getScreenCenterPoint(this));
	}
}
