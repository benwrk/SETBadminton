package gui_backend;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Calendar;

public class DebugUtils {
	public static PrintWriter logger;
	public static void writeln(String string) {
		System.out.println(string);
		if (logger != null)
			logger.println(String.format("%02d/%02d/%02d %02d:%02d:%02d: ", Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DATE), Calendar.getInstance().get(Calendar.HOUR_OF_DAY), Calendar.getInstance().get(Calendar.MINUTE), Calendar.getInstance().get(Calendar.SECOND)) + string);
	}
	public static void writeln() {
		System.out.println();
		if (logger != null)
			logger.println(String.format("%02d/%02d/%02d %02d:%02d:%02d: ", Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DATE), Calendar.getInstance().get(Calendar.HOUR_OF_DAY), Calendar.getInstance().get(Calendar.MINUTE), Calendar.getInstance().get(Calendar.SECOND)));
	}
	public static void startSession() {
		try {
			logger = new PrintWriter(new FileWriter(new File("src/storage/log.dat")));
		} catch (Exception e) {
			e.printStackTrace();
		}
		writeln("Logging started.");
		writeln();
	}
}
