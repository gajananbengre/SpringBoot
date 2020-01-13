package com.gaja.app.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "FahrenheitToCelsiusResponse")
public class FahrenheitToCelsiusResponse {

	private int celsius;

	public int getCelsius() {
		return celsius;
	}

	public void setCelsius(int celsius) {
		this.celsius = celsius;
	}
	
	
}
