package com.gaja.app;

import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.gaja.app.service.CalculatorServiceImpl;

@Configuration
public class WebserviceConfig {

	@Autowired
	private Bus bus;
	
	@Bean
	public Endpoint endpoint() {
		EndpointImpl endpoint = new EndpointImpl(bus, new CalculatorServiceImpl());
		endpoint.publish("/calculator");
		return endpoint;
		
	}
}
