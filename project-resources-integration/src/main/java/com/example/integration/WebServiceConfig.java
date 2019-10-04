package com.example.integration;

import com.northgatearinso.resourcelinkservice.webservice.notifications.employee.Employee;

import org.apache.camel.component.cxf.CxfEndpoint;
import org.apache.cxf.Bus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebServiceConfig {

    @Autowired
    private Bus bus;
    
    
    //NOTE THE VALUE OF cxf.path in application.properties this leads to 
    //the URL of the soap service being of the form /service/CustomerServicePort
    
    @Bean(name="EmployeeProcessor")
    public EmployeeProcessor getProcessor(){
    	return new EmployeeProcessor();
    }

    @Bean
    public CxfEndpoint employeeEndpoint() {
    	
    	CxfEndpoint cxfEndpoint = new CxfEndpoint();
    	cxfEndpoint.setAddress("/EmployeePort");
    	//cxfEndpoint.setServiceName("RLServiceInstance");
    	cxfEndpoint.setServiceClass(Employee.class);
    	cxfEndpoint.setBus(bus);
        return cxfEndpoint;
    }
    
    @Bean
    public Employee employeeService()
    {
    	return new EmployeeImpl();
    }
}