package org.activiti.sophia.workflow.service;

import java.util.List;

import org.activiti.engine.impl.AbstractQuery;
import org.activiti.engine.impl.Page;
import org.activiti.engine.impl.interceptor.CommandContext;
import org.activiti.engine.query.Query;
import org.activiti.sophia.workflow.persistence.impl.mapper.TaskQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TaskQueryService extends AbstractQuery{

	
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
		System.out.println("32222222222");
		System.out.println(taskQuery.getTaskList().size());
		 return taskQuery.getTaskList();
	}

	@Override
	public long executeCount(CommandContext commandContext) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List executeList(CommandContext commandContext, Page page) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
	
}
