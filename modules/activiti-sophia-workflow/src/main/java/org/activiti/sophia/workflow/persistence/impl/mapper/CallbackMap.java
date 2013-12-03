package org.activiti.sophia.workflow.persistence.impl.mapper;

import org.activiti.sophia.workflow.persistence.impl.entity.CallbackEntity;

public interface CallbackMap {
	
   int	updateEntity(CallbackEntity callbackEntity) ;
    int updateUserStatus(String userId);

}
