package org.activiti.sophia.workflow.persistence.mapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.sophia.workflow.base.SpringTransactionalTest;
import org.activiti.sophia.workflow.persistence.impl.db.Pagination;
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
	        params.put("assignee", "kermit");
	        params.putAll(Pagination.toListPage(0, 30));
	        
	        List<String> group = new ArrayList<String>();
	        group.add("deptLeader");
	        params.put("candidateGroups", group);
	    	System.out.println(test.createTaskQuery().singleResult("1121"));
	    	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
