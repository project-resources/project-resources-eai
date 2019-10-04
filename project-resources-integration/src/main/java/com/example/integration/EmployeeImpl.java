package com.example.integration;

import com.northgatearinso.resourcelinkservice.webservice.EmployeeNotifications;
import com.northgatearinso.resourcelinkservice.webservice.notifications.employee.Employee;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EmployeeImpl implements Employee {
    
    private static final transient Logger LOG = LoggerFactory.getLogger(EmployeeImpl.class);
    
    @Override
    public void ensure(EmployeeNotifications part) {
        LOG.debug(part.toString());
        part.getEmployeeNotifications().size();
    }

    @Override
    public void close(EmployeeNotifications part) {
        LOG.debug(part.toString());
        part.getEmployeeNotifications().size();
    }
    
}