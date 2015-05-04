package gui_backend;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class StorageUtils {
	public static void loadAllData() {
		DebugUtils.writeln("gui_backend.StorageUtils | loadAllData() | Loading data from storage...");
		loadCredentialData();
	}	
	public static void saveAllData() {
		DebugUtils.writeln("gui_backend.StorageUtils | saveAllData() | Saving data to storage...");
		saveCredentialData();
	}
	public static void saveCredentialData() {
		try {
			File toWrite = new File("src/storage/credStore.dat");
			DebugUtils.writeln("gui_backend.StorageUtils | saveCredentialData() | Saving to file " + toWrite.getAbsolutePath() + "...");
			PrintWriter writer = new PrintWriter(new FileWriter(toWrite));
			ArrayList<String[]> cred = CredentialUtils.credentials;
			for (int i = 0; i < cred.size(); i++) {
				writer.printf("%s=%s=", cred.get(i)[0], cred.get(i)[1]);
				if (i < cred.size() - 1) {
					writer.println();
				}
			}
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void loadCredentialData() {
		try {
			File toRead = new File("src/storage/credStore.dat");
			DebugUtils.writeln("gui_backend.StorageUtils | loadCredentialData() | Loading from file " + toRead.getAbsolutePath() + "...");
			Scanner scan = new Scanner(toRead);
			ArrayList<String[]> cred = CredentialUtils.credentials;
			while (scan.hasNextLine()) {
				String[] reader = scan.nextLine().split("=");
				cred.add(new String[] {reader[0], reader[1]});
			}
			scan.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
