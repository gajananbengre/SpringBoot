package com.gaja.app.service;

import javax.jws.WebService;

import com.gaja.app.dto.AddRequest;
import com.gaja.app.dto.AddResponse;

@WebService(name = "CalculatorService")
//@Features(features = "org.apache.cxf.feature.LoggingFeature")
public interface Calculator {

	public AddResponse add(AddRequest request);
}
