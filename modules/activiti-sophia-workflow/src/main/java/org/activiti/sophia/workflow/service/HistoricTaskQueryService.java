package org.activiti.sophia.workflow.service;

import java.util.List;
import java.util.Map;

import org.activiti.sophia.workflow.persistence.impl.entity.HistoricTaskEntity;
import org.activiti.sophia.workflow.persistence.impl.mapper.HistoricTaskQueryMap;
import org.activiti.sophia.workflow.persistence.impl.mapper.TaskQueryMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class HistoricTaskQueryService implements Queryservice<HistoricTaskEntity> {

	@Autowired
	HistoricTaskQueryMap historicTaskQueryMap;

	
	@Override
	public List<HistoricTaskEntity> listPage(Map params) {
		return historicTaskQueryMap.listPage(params);
	}

	@Override
	public long count(Map params) {
		return  historicTaskQueryMap.count(params);
	}

}
