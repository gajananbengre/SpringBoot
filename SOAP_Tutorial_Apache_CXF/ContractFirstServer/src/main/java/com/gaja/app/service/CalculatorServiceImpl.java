package com.gaja.app.service;

import org.apache.cxf.feature.Features;
import org.tempuri.CalculatorSoap;

@Features(features = "org.apache.cxf.feature.LoggingFeature")
public class CalculatorServiceImpl implements CalculatorSoap {

	@Override
	public int subtract(int intA, int intB) {
		return (intA - intB);
	}

	@Override
	public int divide(int intA, int intB) {
		return (intA / intB);
	}

	@Override
	public int add(int intA, int intB) {
		return (intA + intB);
	}

	@Override
	public int multiply(int intA, int intB) {
		return (intA * intB);
	}

}
