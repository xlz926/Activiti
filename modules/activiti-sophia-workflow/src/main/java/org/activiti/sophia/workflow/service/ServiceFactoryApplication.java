package org.activiti.sophia.workflow.service;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class ServiceFactoryApplication implements ApplicationContextAware{

	private  static ApplicationContext applicationContext;
	
	@SuppressWarnings("static-access")
	public  void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.applicationContext = applicationContext;
	}
}
	
	
