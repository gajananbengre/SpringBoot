package com.gaja.app.service;

import com.gaja.app.dto.CelsiusToFahrenheitRequest;
import com.gaja.app.dto.CelsiusToFahrenheitResponse;
import com.gaja.app.dto.FahrenheitToCelsiusRequest;
import com.gaja.app.dto.FahrenheitToCelsiusResponse;

public class TemperatureConverterServiceImpl implements TemperatureConverterService {

	@Override
	
	public CelsiusToFahrenheitResponse convert(CelsiusToFahrenheitRequest celsiusToFahrenheitRequest) {

		CelsiusToFahrenheitResponse response = new CelsiusToFahrenheitResponse();
		response.setFahrenheit(((9 * celsiusToFahrenheitRequest.getCelsius()) / 5) + 32);
		return response;
	}

	@Override
	
	public FahrenheitToCelsiusResponse convert(FahrenheitToCelsiusRequest fahrenheitToCelsiusRequest) {
		FahrenheitToCelsiusResponse response = new FahrenheitToCelsiusResponse();
		response.setCelsius(((fahrenheitToCelsiusRequest.getFahrenheit() - 32) * 5) / 9);
		return response;
	}

}
