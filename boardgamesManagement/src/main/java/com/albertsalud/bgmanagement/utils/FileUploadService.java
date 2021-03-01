package com.albertsalud.bgmanagement.utils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;

@Component
public class FileUploadService {
	
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
		
		try (InputStream inputStream = file.getInputStream()){
			Path uploadPath = managePath(destinationFolder);
			
		    Path filePath = uploadPath.resolve(destinationName);
		    Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
		    
		    result.ok = true;
		    
		} catch (IOException e) {
			result.errorMessage = e.getMessage();
		}
		
		return result;
	}

	private Path managePath(String destinationFolder) throws IOException {
		Path uploadPath = Paths.get(destinationFolder);
		if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }
		
		return uploadPath;
	}

}
