package com.albertsalud.bgmanagement.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

public class FTPConnection implements FTPServices{

//	private String server;
	private int port = 21;	// FTP standard port
//	private String username;
//	private String password;
	
	private FTPClient ftpClient;
	
	public FTPConnection(String server, String username, String password) throws IOException {
		ftpClient = new FTPClient();
		System.out.print("Connecting to " + server+ ":" + port + "... ");
		ftpClient.connect(server, port);
		System.out.println("Connected!");
		
		ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
		ftpClient.enterLocalPassiveMode();
		
		System.out.print("Login with username " + username + "... ");
		System.out.println(ftpClient.login(username, password));
	}
	
	public boolean uploadFile(String destinationDir, String destionationFileName, File file) {
		System.out.println("Uploading " + destionationFileName + " to " + destinationDir + "... ");
		try (InputStream is = new FileInputStream(file)){
			manageWorkingDirectory(destinationDir);
			return ftpClient.storeFile(destionationFileName, is);
			
		} catch (IOException e) {
			e.printStackTrace();
			return false;
			
		}
		
	}
	
	private void manageWorkingDirectory(String destinationDir) throws IOException {
		if(!ftpClient.changeWorkingDirectory(destinationDir) &&
				!ftpClient.makeDirectory(destinationDir)) {
			throw new IOException("Unable to create destination directory!");
		}		
	}

	public void disconnect() throws IOException {
		System.out.print("Disconnecting FTP client... ");
		ftpClient.disconnect();
		System.out.println("Disconected!");
	}
	
	public static void main(String args[]) {
		try {
			File testFile = new File("C:\\tlc.jpg");
			
			if(testFile.exists()) {
				FTPServices ftp = new FTPConnection("46.183.119.135", "daudecinc-ftp", "dd5ftpuser");
				System.out.println("File loaded successfully..." + ftp.uploadFile("/uploaded/images", testFile.getName(), testFile));
				ftp.disconnect();
			
			} else {
				System.out.println("Specified file doesn't exist!");
			}
			
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("ERROR: " + e.getMessage());
		}
	}
}
