package org.activiti.sophia.workflow.bpmservice.expression;

import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.runtime.Execution;
import org.activiti.rest.common.api.ActivitiUtil;
import org.activiti.sophia.workflow.persistence.impl.entity.CallbackEntity;
import org.activiti.sophia.workflow.service.CallbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CallBackExpression {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired 
	CallbackService callbackService;
	
	public void updateStatus(Execution execution,String tableName,String status){
	   HistoricProcessInstance instance =		ActivitiUtil.getHistoryService().createHistoricProcessInstanceQuery().processInstanceId(execution.getProcessInstanceId()).singleResult();
		CallbackEntity callbackEntity =new CallbackEntity();
		callbackEntity.setBussnesKey(instance.getBusinessKey());
		 callbackEntity.setStatus(status);
		 callbackEntity.setTableName(tableName);
		 callbackService.saveCallback(callbackEntity);
		 if(tableName.equals("BPM_FORM_EXPLANE")){
			 callbackService.updateUserStatus(instance.getStartUserId());
		 }
	}

}
