package com.gaja.app.service;

import javax.activation.DataHandler;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public interface FileWS {

	public void upload (@WebParam(name = "file") DataHandler attachment, String filename);
	
	public DataHandler download(String filename);
}
