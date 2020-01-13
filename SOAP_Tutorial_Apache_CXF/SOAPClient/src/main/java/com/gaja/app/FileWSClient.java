package com.gaja.app;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.gaja.app.service.FileWS;
import com.gaja.app.service.FileWSImplService;

public class FileWSClient {

	public static void main(String[] args) throws IOException {

		FileWSImplService fileService = new FileWSImplService(new URL("http://localhost:8080/mtomws/fileWS?wsdl"));
		FileWS fileWSImplPort = fileService.getFileWSImplPort();

		//File Upload start
		byte[] fileContent;
		File file = new File("/Users/gaja/Desktop/download.jpeg");
		fileContent = Files.readAllBytes(file.toPath());
		fileWSImplPort.upload(fileContent, "Test1.jpeg");
		//File Upload end

		//File Download start
		byte[] download = fileWSImplPort.download("Test1.jpeg");
		Path path = Paths.get("/Users/gaja/Desktop/test1dowloaded.jpeg");
		Files.write(path, download);
		//File Download end

	}
}
