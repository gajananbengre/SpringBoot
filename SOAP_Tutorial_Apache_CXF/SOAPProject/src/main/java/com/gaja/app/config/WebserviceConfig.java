package com.gaja.app.config;

import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.gaja.app.service.HelloWS;
import com.gaja.app.service.TemperatureConverterServiceImpl;

@Configuration
public class WebserviceConfig {

	@Autowired
	private Bus bus;

	@Bean
	public Endpoint helloendpoint() {
		EndpointImpl endpoint = new EndpointImpl(bus, new HelloWS());
		endpoint.publish("/hello");
		return endpoint;

	}

	@Bean
	public Endpoint tempconverterendpoint() {
		EndpointImpl endpoint = new EndpointImpl(bus, new TemperatureConverterServiceImpl());
		endpoint.publish("/tempconverter");
		return endpoint;

	}
}
