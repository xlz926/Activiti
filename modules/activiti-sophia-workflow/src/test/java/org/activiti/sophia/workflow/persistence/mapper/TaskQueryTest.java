package org.activiti.sophia.workflow.persistence.mapper;

import java.util.HashMap;
import java.util.Map;

import org.activiti.sophia.workflow.base.SpringTransactionalTest;
import org.activiti.sophia.workflow.service.ServiceFactoryApplication;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;



@ContextConfiguration(locations = { "/applicationContext-test.xml" })
public class TaskQueryTest  extends SpringTransactionalTest {


	
	@Test
	public void test() {
		
	     try {
	    	 
	    	//System.out.println(taskQuery.getTaskList().size());
	    	ServiceFactoryApplication test =new ServiceFactoryApplication();
	        Map 	params =new HashMap(); 
	       // params.put("firstResult", 12);
	       // params.put("maxResults", 20);
	    	System.out.println(test.createTaskQuery().listPage(params).size());
	    	//test.createTaskQuery().list();
	    	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
