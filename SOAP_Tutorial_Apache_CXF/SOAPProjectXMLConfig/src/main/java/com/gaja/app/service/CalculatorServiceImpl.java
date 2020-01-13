package com.gaja.app.service;

import com.gaja.app.dto.AddRequest;
import com.gaja.app.dto.AddResponse;

public class CalculatorServiceImpl implements Calculator {

	@Override
	public AddResponse add(AddRequest request) {
		AddResponse response = new AddResponse();
		response.setResult(request.getNum1() + request.getNum2());
		return response;
	}

}
