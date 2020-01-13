package com.gaja.app.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;

import org.apache.cxf.feature.Features;

@Features(features = "org.apache.cxf.feature.LoggingFeature")
public class FileWSImpl implements FileWS {

	@Override
	public void upload(DataHandler attachment, String filename) {

		InputStream inputStream = null;
		OutputStream outputStream = null;
		try {
			File file = new File("/Users/gaja/Documents/Gaja/Programming Workspace/Demo/Uploaded/" + filename);
			inputStream = attachment.getInputStream();
			outputStream = new FileOutputStream(file);

			byte[] b = new byte[100000];
			int bytesRead = 0;

			while ((bytesRead = inputStream.read(b)) != -1) {
				outputStream.write(b, 0, bytesRead);
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {

				inputStream.close();
				outputStream.close();

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public DataHandler download(String filename) {
		return new DataHandler(new FileDataSource(
				new File("/Users/gaja/Documents/Gaja/Programming Workspace/Demo/Uploaded/" + filename)));
	}

}
