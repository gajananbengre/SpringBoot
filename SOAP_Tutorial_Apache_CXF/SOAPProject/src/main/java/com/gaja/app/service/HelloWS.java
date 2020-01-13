package com.gaja.app.service;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.apache.cxf.feature.Features;

import com.gaja.app.error.CustomError;

@WebService
@Features(features = "org.apache.cxf.feature.LoggingFeature")
public class HelloWS {
	
	@WebMethod
	public String hello(String message) throws CustomError {
		if(message == null || message.length() == 0) {
			throw new CustomError("message required");
		}
		return "hello "+message; 
	}

}
