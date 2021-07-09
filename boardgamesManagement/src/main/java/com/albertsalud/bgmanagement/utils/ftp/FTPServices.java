package com.albertsalud.bgmanagement.utils.ftp;

import java.io.IOException;
import java.io.InputStream;

public interface FTPServices {
	
	public void disconnect() throws IOException;
	
	public boolean uploadFile(String destinationDir, String destionationFileName, InputStream is);

}
