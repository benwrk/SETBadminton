package gui_backend;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Point;
import java.awt.Toolkit;

public class PositionUtils {
	public static final FlowLayout leftFlowLayout = new FlowLayout() {
		private static final long serialVersionUID = 1L;
		{
			setAlignment(FlowLayout.LEFT);
		}
	};
	public static Point getScreenCenterPoint(Component component) {
		DebugUtils.writeln("gui_backend.PositionUtils | getScreenCenterPoint -- Locating screen center for " + component.getClass().toString().substring(6));
		Point point = new Point(
				Toolkit.getDefaultToolkit().getScreenSize().width / 2 - component.getSize().width / 2,
				Toolkit.getDefaultToolkit().getScreenSize().height / 2 - component.getSize().height / 2
				);
		DebugUtils.writeln("gui_backend.PositionUtils | getScreenCenterPoint -- Screen center for " + component.getClass().toString().substring(6) + " is " + point.getX() + "," + point.getY());
		return point;
	}
	public static Dimension getScreenCenterDimension(Component component) {
		DebugUtils.writeln("gui_backend.PositionUtils | getScreenCenterDimension -- Locating screen center for " + component.getClass().toString().substring(6));
		Dimension dim = new Dimension(
				Toolkit.getDefaultToolkit().getScreenSize().width / 2 - component.getSize().width / 2,
				Toolkit.getDefaultToolkit().getScreenSize().height / 2 - component.getSize().height / 2
				);
		DebugUtils.writeln("gui_backend.PositionUtils | getScreenCenterDimension -- Screen center for " + component.getClass().toString().substring(6) + " is " + dim.getWidth() + "," + dim.getHeight());
		return dim;
	}
}
