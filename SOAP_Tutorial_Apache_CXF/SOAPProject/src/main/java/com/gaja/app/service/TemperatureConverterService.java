package com.gaja.app.service;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.apache.cxf.feature.Features;

import com.gaja.app.dto.CelsiusToFahrenheitRequest;
import com.gaja.app.dto.CelsiusToFahrenheitResponse;
import com.gaja.app.dto.FahrenheitToCelsiusRequest;
import com.gaja.app.dto.FahrenheitToCelsiusResponse;

@WebService
@Features(features = "org.apache.cxf.feature.LoggingFeature")
public interface TemperatureConverterService {

	@WebMethod(operationName = "convertCelsiusToFahrenheit")
	public CelsiusToFahrenheitResponse convert (CelsiusToFahrenheitRequest celsiusToFahrenheitRequest);
	
	@WebMethod(operationName = "convertFahrenheitToCelsius")
	public FahrenheitToCelsiusResponse convert (FahrenheitToCelsiusRequest fahrenheitToCelsiusRequest);
}


