package org.activiti.sophia.workflow.service;

import org.springframework.beans.factory.annotation.Autowired;

public class TestBean {
	@Autowired
	ServiceFactoryApplation Service;

	public ServiceFactoryApplation getService() {
		return Service;
	}
	
}
