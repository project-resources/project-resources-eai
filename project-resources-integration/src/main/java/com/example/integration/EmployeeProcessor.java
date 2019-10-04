package com.example.integration;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;
import org.apache.camel.component.cxf.common.message.CxfConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;

public class EmployeeProcessor implements Processor {
    private static final transient Logger LOG = LoggerFactory.getLogger(EmployeeProcessor.class);

    
    @Override
    public void process(Exchange exchange) throws Exception {
        Message inMessage = exchange.getIn();
        String operationName = inMessage.getHeader(CxfConstants.OPERATION_NAME, String.class);

        if ("ensure".equals(operationName.toLowerCase())) {
            LOG.info("ensure called with: " + inMessage.getBody().toString());
        }
        else if("close".equals(operationName.toLowerCase())) {
            LOG.info("close called with: " + inMessage.getBody().toString());
        }
        else {
            LOG.info(operationName);
        }
        exchange.getMessage().setHeader(Exchange.HTTP_RESPONSE_CODE, HttpStatus.ACCEPTED.value());
        
    }
    
}