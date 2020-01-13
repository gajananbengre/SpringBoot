package com.gaja.app.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "CelsiusToFahrenheitResponse")
public class CelsiusToFahrenheitResponse {

	private int fahrenheit;

	public int getFahrenheit() {
		return fahrenheit;
	}

	public void setFahrenheit(int fahrenheit) {
		this.fahrenheit = fahrenheit;
	}
	
	
}
