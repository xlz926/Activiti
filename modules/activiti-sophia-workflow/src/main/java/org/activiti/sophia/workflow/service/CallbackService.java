package org.activiti.sophia.workflow.service;

import org.activiti.sophia.workflow.persistence.impl.entity.CallbackEntity;
import org.activiti.sophia.workflow.persistence.impl.mapper.CallbackMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CallbackService {
	
	@Autowired
	CallbackMap callbackMap;
	
	
	public int saveCallback(CallbackEntity callbackEntity){
		return callbackMap.updateEntity(callbackEntity);
	}

	
	public int updateUserStatus(String userId){
		return callbackMap.updateUserStatus(userId);
		
	}
	
}
