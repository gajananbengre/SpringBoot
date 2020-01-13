package com.gaja.app;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.endpoint.Endpoint;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.ws.security.wss4j.WSS4JOutInterceptor;
import org.apache.wss4j.dom.WSConstants;
import org.apache.wss4j.dom.handler.WSHandlerConstants;

import com.gaja.app.config.handler.PasswordCallbackHandler;
import com.gaja.app.service.CalculatorService;
import com.gaja.app.service.CalculatorService_Service;
import com.gaja.app.service.Request;
import com.gaja.app.service.Response;

public class CalculatorClient {
	
	public static void main(String[] args) throws MalformedURLException {
		
		CalculatorService_Service service = new CalculatorService_Service(new URL("http://localhost:8080/SOAPProjectXMLConfig/services/addService?wsdl"));
		CalculatorService calculator = service.getCalculatorServicePort();
		
		Client client = ClientProxy.getClient(calculator);
		Endpoint endpoint = client.getEndpoint();
		
		HashMap<String, Object> props = new HashMap<String, Object>();
		
		props.put(WSHandlerConstants.ACTION, WSConstants.USERNAME_TOKEN_LN);
		props.put(WSHandlerConstants.USER, "gaja");
		props.put(WSHandlerConstants.PASSWORD_TYPE, WSConstants.PW_TEXT);
		props.put(WSHandlerConstants.PW_CALLBACK_CLASS, PasswordCallbackHandler.class.getName());
		
		
		WSS4JOutInterceptor wssOut = new WSS4JOutInterceptor(props);
		endpoint.getOutInterceptors().add(wssOut);
		
		Request request = new Request();
		request.setNum1(5);
		request.setNum2(2);
		Response result = calculator.add(request);
		
		System.out.println("Result : " +result.getResult());
	}

}
