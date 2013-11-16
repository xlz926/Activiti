package org.activiti.sophia.workflow.persistence.mapper;

import org.activiti.sophia.workflow.base.SpringTransactionalTest;
import org.activiti.sophia.workflow.service.TestBean;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;



@ContextConfiguration(locations = { "/applicationContext-test.xml" })
public class TaskQueryTest  extends SpringTransactionalTest {

	
    @Autowired
    TaskQuery taskQuery;
    

	
	@Test
	public void test() {
		
	     try {
	    	 
	    	System.out.println(taskQuery.getTaskList().size());
	    	TestBean test =new TestBean();
	    	System.out.println(test.getService());
	    	//test.createTaskQuery().list();
	    	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
