package com.albertsalud.bgmanagement.utils;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.albertsalud.bgmanagement.utils.ftp.FTPConnection;
import com.albertsalud.bgmanagement.utils.ftp.FTPServices;

import lombok.Getter;

@Component
public class FileUploadService {
	
	@Value("${dd5.ftp.host}")
	private String hostname;
	
	@Value("${dd5.ftp.username}")
	private String username;
	
	@Value("${dd5.ftp.password}")
	private String password;
	
	
	@Getter
	public class FileUploadServiceResult {
		private FileUploadServiceResult(String destinationFolder, String destinationName, 
				MultipartFile file) {
			
			this.destinationFolder = destinationFolder;
			this.destinationName = destinationName;
			this.file = file;
		}
		
		private String destinationFolder;
		private String destinationName;
		private String errorMessage;
		private MultipartFile file;
		private boolean ok;
	}
	
	public FileUploadServiceResult saveFile(String destinationFolder, String destinationName, 
			MultipartFile file) {
		
		FileUploadServiceResult result = new FileUploadServiceResult(destinationFolder, destinationName,
				file);
		
		try {
			FTPServices ftp = new FTPConnection(hostname, username, password);
			result.ok = ftp.uploadFile(destinationFolder, destinationName, file.getInputStream());
			
			ftp.disconnect();
		
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
			result.ok = false;
			result.errorMessage = e.getMessage();
		}
		
		return result;
	}

}
