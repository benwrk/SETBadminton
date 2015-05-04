package gui_backend;

import java.util.ArrayList;

public class CredentialUtils {
	protected static ArrayList<String[]> credentials = new ArrayList<String[]>();
	public static int login(String username, String password) {
		DebugUtils.writeln("gui_backend.CredentialUtils | trying login with username = \"" + username + "\" and entered password.");
		int usernameIndex = -1;
		for (int i = 0; i < credentials.size(); i++) {
			if (credentials.get(i)[0].equalsIgnoreCase(username)) {
				usernameIndex = i;
			}
		}
		if (usernameIndex == -1) {
			DebugUtils.writeln("gui_backend.CredentialUtils | \"" + username + "\" username not found.");
			return -1;
		}
		else {
			if (credentials.get(usernameIndex)[1].equals(password)) {
				DebugUtils.writeln("gui_backend.CredentialUtils | \"" + username + "\" username found, password matched.");
				return 0;
			}
			else {
				DebugUtils.writeln("gui_backend.CredentialUtils | \"" + username + "\" password does not match.");
				return -2;
			}
		}
	}
	
	public static int register(String username, String password) {
		DebugUtils.writeln("gui_backend.CredentialUtils | registering with username = \"" + username + "\" and entered password.");		
		if (username.contains("=") || password.contains("=")) {
			//IF USERNAME/PASSWORD CONTAINS "=", THERE WILL BE AN ERROR OCCURED WHEN PARSING CREDSTORE.DAT
			DebugUtils.writeln("gui_backend.CredentialUtils | Cannot register \"" + username + "\", Username and password cannot contains \"=\"");
			return -2;
		}
		else if (username.equalsIgnoreCase("") || password.equalsIgnoreCase("") || username.equalsIgnoreCase(password)) {
			DebugUtils.writeln("gui_backend.CredentialUtils | Cannot register \"" + username + "\", Illegal username and/or password");
			return -1;
		}
		else {
			int usernameIndex = -1;
			for (int i = 0; i < credentials.size(); i++) {
				if (credentials.get(i)[0].equalsIgnoreCase(username)) {
					usernameIndex = i;
				}
			}
			if (usernameIndex != -1) {
				DebugUtils.writeln("gui_backend.CredentialUtils | Cannot register \"" + username + "\", Username already exists.");
				return -3;
			}
			else {
				DebugUtils.writeln("gui_backend.CredentialUtils | Successfully registered \"" + username + "\" and entered password.");
				credentials.add(new String[] {username, password});
				return 0;
			}
		}
	}
}
