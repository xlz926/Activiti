package org.activiti.sophia.workflow.service;

import java.util.List;
import java.util.Map;

import org.activiti.sophia.workflow.persistence.impl.entity.DelegateEntity;
import org.activiti.sophia.workflow.persistence.impl.entity.TaskEntity;
import org.activiti.sophia.workflow.persistence.impl.mapper.DelegateQueryMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DelegateService  implements Queryservice<DelegateEntity>{

	@Autowired
	DelegateQueryMap delegateQueryMap;
	
	@Override
	public List<DelegateEntity> listPage(Map params) {
		return delegateQueryMap.listPage(params);
	}

	@Override
	public long count(Map params) {
		return delegateQueryMap.count(params);
	}
	
	public DelegateEntity  createDelegate(DelegateEntity delegateEntity){
		 delegateQueryMap.insertEntity(delegateEntity);
		 return delegateEntity;
	}
	
	public DelegateEntity  saveDelegate(DelegateEntity delegateEntity){
		if(delegateEntity.getId()==null){
			return null;
		}
		 delegateQueryMap.updateEntity(delegateEntity);
		return delegateEntity;
	}
	public DelegateEntity singleResult(String delegateId){
	  return delegateQueryMap.singleResult(delegateId);
	}
	
	public int deleteDelegate(String Id){
		return  delegateQueryMap.deleteEntity(Id);
	}
	
	

}
