package gui_elements;
import gui_backend.ImageUtils;

import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.JPanel;


public class SplashScreenPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Image image;
	private float alpha = 0;
	public SplashScreenPanel(float alpha) {
		this.alpha = alpha;
		image = ImageUtils.createScaledImage(this, "assets/logo.png", 400, 400);
	}
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));
		g2d.drawImage(image, 0, 0, 400, 400, null);
	}
	public void setAlpha(float alpha) {
		this.alpha = alpha;
	}
	public float getAlpha() {
		return alpha;
	}
}
