package appengine_classes;

import gui_backend.DebugUtils;
import gui_backend.PageUtils;
import gui_backend.StorageUtils;
import gui_elements.LoginPageFrame;


public class MainClass {
	public static void main(String[] args) {
		//Console ID
		DebugUtils.startSession();
		DebugUtils.writeln("appengine_classes.MainClass | Firing up SET Badminton Court App");
		DebugUtils.writeln();
		DebugUtils.writeln("SET Badminton Court APP (Java SWING)");
		DebugUtils.writeln("Version 1.0.0.0 Build date: 20141201");
		DebugUtils.writeln("Copyright(C) 2014 - Sorawit Sakulkalanuwat, Benjapol Worakan, Prinn Angkunanuwat");
		DebugUtils.writeln("As a part of Object-Oriented Programming I");
		DebugUtils.writeln();

		//Load data from storage
		StorageUtils.loadAllData();
		
		//Set exit status to be 0 will cause the program to save data when exiting
		LoginPageFrame.staticExitStatus = 0;

		//Splash Screen Launch
		PageUtils.startSplash();

		//LoginPage Launch
		PageUtils.openLoginPage();

		//End of MainClass driven codes
		DebugUtils.writeln("appengine_classes.MainClass | End of MainClass.");
		
		//After this are event driven codes
	}
}
