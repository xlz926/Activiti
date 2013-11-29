package org.activiti.sophia.workflow.Listener;

import java.util.Iterator;
import java.util.Set;

import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;
import org.activiti.engine.task.IdentityLink;
import org.activiti.engine.task.Task;
import org.activiti.rest.common.api.ActivitiUtil;

public class MultiUserListener implements TaskListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void notify(DelegateTask delegateTask) {
		Set<IdentityLink> users =	delegateTask.getCandidates();
		Iterator<IdentityLink>  it =	users.iterator();
		
	    while(it.hasNext()){
	    	IdentityLink user =	(IdentityLink) it.next();
	    	if(user.getUserId()!=null){
	    	   	Task childTask = ActivitiUtil.getTaskService().newTask();
		    	  ActivitiUtil.getTaskService().saveTask(childTask);
		    	  childTask.setAssignee(user.getUserId());
		    	  childTask.setName(delegateTask.getName());
		    	  childTask.setDescription(delegateTask.getName()+"--协办");
		    	  childTask.setParentTaskId(delegateTask.getId());
	    	}
	    }
		
/*		//设置第一个人为主办
	    if(it.hasNext()){
	    	IdentityLink user =	(IdentityLink) it.next();
	    	if(delegateTask.getAssignee()==null){
	    		delegateTask.setAssignee(user.getUserId());
	    	}else{
	    		if(user.getUserId()!=null){
	    			  Task childTask = ActivitiUtil.getTaskService().newTask();
	    	    	  ActivitiUtil.getTaskService().saveTask(childTask);
	    	    	  childTask.setAssignee(user.getUserId());
	    	    	  childTask.setName(delegateTask.getName());
	    	    	  childTask.setParentTaskId(delegateTask.getId());
	    	    	  childTask.setDescription(delegateTask.getName()+"--协办");
	    		}
	    	
	    	}
	    }
*/	     //设置协办人员
	
		
	}

}
