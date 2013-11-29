package org.activiti.sophia.workflow.Listener;

import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;
import org.activiti.rest.common.api.ActivitiUtil;

public class DraftListener implements TaskListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void notify(DelegateTask delegateTask) {
		
		//设置草稿自动跳过
	   Object isDraft =  delegateTask.getVariable("isDraft");
      if(isDraft==null ||  "true".equals(isDraft.toString())){
    	  ActivitiUtil.getTaskService().complete(delegateTask.getId());
    	  delegateTask.setVariable("isDraft", false);
      }
		
       //设置申请人
      Object applyUserId =  delegateTask.getVariable("applyUserId");
      if(applyUserId!=null){
    	  delegateTask.setOwner(applyUserId.toString());
      }
	}

}
