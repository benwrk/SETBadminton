package gui_backend;

import gui_elements.InfoDialogFrame;
import gui_elements.LoginPageFrame;
import gui_elements.MainPageFrame;
import gui_elements.RegisterPageFrame;
import gui_elements.SplashScreenFrame;

public class PageUtils {
	public static void startSplash() {
		DebugUtils.writeln("gui_backend.PageUtils | startSplash() | Starting Splash...");
		new SplashScreenFrame().run();
		DebugUtils.writeln("gui_backend.PageUtils | startSplash() | Splash done.");
	}
	public static void openMainPage(String username) {
		DebugUtils.writeln("gui_backend.PageUtils | openMainPage() | Opening MainPage with username = \"" + username + "\"...");
		MainPageFrame.username = username;
		MainPageFrame.main(new String[0]);
	}
	public static void openLoginPage() {
		DebugUtils.writeln("gui_backend.PageUtils | openLoginPage() | Opening LoginPage...");
		LoginPageFrame.main(new String[0]);
	}
	public static void quitApp(int status) {
		if (status == -2) {
			DebugUtils.writeln("gui_backend.PageUtils | quitApp() | exiting due to security breach (-2)");
		}
		if (status == 1) {
			DebugUtils.writeln("gui_backend.PageUtils | quitApp() | exiting without saving data (1)");
		}
		if (status == 0) {
			DebugUtils.writeln("gui_backend.PageUtils | quitApp() | normal exit, saving data...");
			StorageUtils.saveAllData();
		}
		DebugUtils.writeln("gui_backend.PageUtils | quitApp() | EXITING... with status = \"" + status + "\" (System.exit(" + status + "))");
		if (DebugUtils.logger != null) {
			DebugUtils.logger.close();
		}
		System.exit(status);
	}
	public static void openRegisterPage() {
		DebugUtils.writeln("gui_backend.PageUtils | openRegisterPage() | Opening RegisterPage...");
		RegisterPageFrame.main(new String[0]);
	}
	public static void showInfoDialog(int dialogType, String message) {
		DebugUtils.writeln("gui_backend.PageUtils | showInfoDialog() | Creating dialog box with dialogType = " + dialogType + " and message = \"" + message + "\"");
		InfoDialogFrame.main(dialogType, message);
	}
}
