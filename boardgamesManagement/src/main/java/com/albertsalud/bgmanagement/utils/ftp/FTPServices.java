package com.albertsalud.bgmanagement.utils.ftp;

import java.io.File;
import java.io.IOException;

public interface FTPServices {
	
	public void disconnect() throws IOException;
	
	public boolean uploadFile(String destinationDir, String destionationFileName, File file);

}
