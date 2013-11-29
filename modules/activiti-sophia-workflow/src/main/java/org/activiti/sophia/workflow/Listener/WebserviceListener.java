package org.activiti.sophia.workflow.Listener;

import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;
import org.activiti.rest.common.api.ActivitiUtil;
import org.restlet.resource.ClientResource;

public class WebserviceListener implements TaskListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void notify(DelegateTask delegateTask) {
		
	   Object urlRoot =	delegateTask.getVariable("urlRoot");
	   if(urlRoot!=null){
		  String bussnesKey =    ActivitiUtil.getHistoryService().createHistoricProcessInstanceQuery().processInstanceId(delegateTask.getProcessInstanceId()).singleResult().getBusinessKey();
	      ClientResource resource = new ClientResource(urlRoot.toString()+bussnesKey+"/FINISH");
	      resource.get();
	   }
	}

}
