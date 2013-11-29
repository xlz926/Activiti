package org.activiti.sophia.workflow.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.sophia.workflow.persistence.impl.entity.TaskEntity;
import org.activiti.sophia.workflow.persistence.impl.mapper.TaskQueryMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskQueryService implements Queryservice<TaskEntity>  {

	@Autowired
	TaskQueryMap taskquery;


	@Override
	public List<TaskEntity> listPage(Map params) {
		return taskquery.listPage(params);
	}

	@Override
	public long count(Map params) {
		return   taskquery.count(params);
	}

	public TaskEntity singleResult(String taskId){
		return taskquery.singleResult(taskId);
	}

	
	
	
	
	
	
}
