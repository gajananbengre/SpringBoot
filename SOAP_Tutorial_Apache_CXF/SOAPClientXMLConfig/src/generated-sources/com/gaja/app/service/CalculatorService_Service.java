package com.gaja.app.service;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 3.1.9
 * 2019-11-09T19:51:38.433+03:00
 * Generated source version: 3.1.9
 * 
 */
@WebServiceClient(name = "CalculatorService", 
                  wsdlLocation = "file:/Users/gaja/Documents/Gaja/Programming%20Workspace/Demo/SOAPClientXMLConfig/src/main/resources/calculator.wsdl",
                  targetNamespace = "http://service.app.gaja.com/") 
public class CalculatorService_Service extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://service.app.gaja.com/", "CalculatorService");
    public final static QName CalculatorServicePort = new QName("http://service.app.gaja.com/", "CalculatorServicePort");
    static {
        URL url = null;
        try {
            url = new URL("file:/Users/gaja/Documents/Gaja/Programming%20Workspace/Demo/SOAPClientXMLConfig/src/main/resources/calculator.wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(CalculatorService_Service.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "file:/Users/gaja/Documents/Gaja/Programming%20Workspace/Demo/SOAPClientXMLConfig/src/main/resources/calculator.wsdl");
        }
        WSDL_LOCATION = url;
    }

    public CalculatorService_Service(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public CalculatorService_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public CalculatorService_Service() {
        super(WSDL_LOCATION, SERVICE);
    }
    
    public CalculatorService_Service(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public CalculatorService_Service(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public CalculatorService_Service(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }    




    /**
     *
     * @return
     *     returns CalculatorService
     */
    @WebEndpoint(name = "CalculatorServicePort")
    public CalculatorService getCalculatorServicePort() {
        return super.getPort(CalculatorServicePort, CalculatorService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns CalculatorService
     */
    @WebEndpoint(name = "CalculatorServicePort")
    public CalculatorService getCalculatorServicePort(WebServiceFeature... features) {
        return super.getPort(CalculatorServicePort, CalculatorService.class, features);
    }

}