package org.activiti.sophia.workflow.service;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;


@Component
public class ServiceFactoryApplation implements ApplicationContextAware{

	private ApplicationContext applicationContext;
	
	public ApplicationContext getApplicationContext() {
		return applicationContext;
	}
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.applicationContext = applicationContext;
		applicationContext.getBean(TaskQueryService.class);
		System.out.println(applicationContext.getBean(TaskQueryService.class));
	}
	public  TaskQueryService createTaskQuery() {
		return applicationContext.getBean("taskQueryService",TaskQueryService.class);
	}
}
	
	
