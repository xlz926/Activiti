package org.activiti.sophia.workflow.service;

import java.util.List;

import org.activiti.engine.query.Query;
import org.activiti.sophia.workflow.persistence.mapper.TaskQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("taskQueryService")
public class TaskQueryService implements Query{

	
	 @Autowired
	TaskQuery taskQuery;
	

	@Override
	public Query asc() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Query desc() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object singleResult() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List list() {
	  return taskQuery.getTaskList();
	}

	@Override
	public List listPage(int firstResult, int maxResults) {
		 return taskQuery.getTaskList();
	}
	
	
	
	
	
}
