package org.activiti.sophia.workflow.bpmservice.listener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;
import org.activiti.engine.task.IdentityLink;
import org.springframework.stereotype.Service;



public class MultiUserListener implements TaskListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void notify(DelegateTask delegateTask) {
		
		 List<String> list = new ArrayList<String>();
		 Iterator<IdentityLink>  identityLink =delegateTask.getCandidates().iterator();
		 
		 while(identityLink.hasNext()){
			 IdentityLink user =  identityLink.next();
			 list.add(user.getUserId());
		 }
		
		 delegateTask.setVariable("assigneeList", list);
		
	}


}
