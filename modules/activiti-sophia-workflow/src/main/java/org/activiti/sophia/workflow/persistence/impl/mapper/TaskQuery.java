package org.activiti.sophia.workflow.persistence.impl.mapper;

import java.util.List;

import org.activiti.sophia.workflow.persistence.impl.entity.TaskEntity;

public interface TaskQuery {
  
    List<TaskEntity>	getTaskList ();
}
