package com.gaja.app;

import java.net.MalformedURLException;
import java.net.URL;

import org.tempuri.CalculatorSoap;

import com.gaja.app.service.CalculatorServiceImplService;

public class CalculatorClient {

	public static void main(String[] args) throws MalformedURLException {
		CalculatorServiceImplService calculator = new CalculatorServiceImplService(new URL("http://localhost:8080/wsdlfirst/calculator?wsdl"));
		CalculatorSoap calculatorServiceImplPort = calculator.getCalculatorServiceImplPort();
		//add
		int result = calculatorServiceImplPort.add(5, 2);
		System.out.println("Addition Result : "+result);
		
		//Subtract
		result = calculatorServiceImplPort.subtract(5, 2);
		System.out.println("Subtract Result : "+result);
		
		//Multiply
		result = calculatorServiceImplPort.multiply(5, 2);
		System.out.println("Multiply Result : "+result);
	}
	
}