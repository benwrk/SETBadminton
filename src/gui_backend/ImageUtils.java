package gui_backend;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class ImageUtils {
	public static Image createImage(Object cls, String srcFile) {
		Image image = null;
		try {
			URL url = cls.getClass().getClassLoader().getResource(srcFile);
			image = ImageIO.read(url);
			DebugUtils.writeln("gui_backend.ImageUtils | createImage -- \"" + srcFile + "\" loaded for " + cls.getClass().toString().substring(6));
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return image;
	}
	public static Image createScaledImage(Object cls, String srcFile, int width, int height) {
		Image image = null;
		try {
			URL url = cls.getClass().getClassLoader().getResource(srcFile);
			image = ImageIO.read(url).getScaledInstance(width, height, Image.SCALE_SMOOTH);
			DebugUtils.writeln("gui_backend.ImageUtils | createScaledImage -- \"" + srcFile + "\" loaded for " + cls.getClass().toString().substring(6) + " with size " + width + "x" + height);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return image;
	}
	public static BufferedImage createBufferedImage(Object cls, String srcFile) {
		BufferedImage image = null;
		try {
			URL url = cls.getClass().getClassLoader().getResource(srcFile);
			image = ImageIO.read(url);
			DebugUtils.writeln("gui_backend.ImageUtils | createBufferedImage -- \"" + srcFile + "\" loaded for " + cls.getClass().toString().substring(6));
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return image;
	}
	public static ImageIcon createImageIcon(Object cls, String srcFile) {
		ImageIcon icon = null;
		try {
			URL url = cls.getClass().getClassLoader().getResource(srcFile);
			icon = new ImageIcon(ImageIO.read(url));
			DebugUtils.writeln("gui_backend.ImageUtils | createImageIcon -- \"" + srcFile + "\" loaded for " + cls.getClass().toString().substring(6));
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return icon;
	}
	public static ImageIcon createScaledImageIcon(Object cls, String srcFile, int width, int height) {
		ImageIcon icon = null;
		try {
			URL url = cls.getClass().getClassLoader().getResource(srcFile);
			icon = new ImageIcon(ImageIO.read(url).getScaledInstance(width, height, Image.SCALE_SMOOTH));
			DebugUtils.writeln("gui_backend.ImageUtils | createScaledImageIcon -- \"" + srcFile + "\" loaded for " + cls.getClass().toString().substring(6) + " with size " + width + "x" + height);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return icon;
	}
}
