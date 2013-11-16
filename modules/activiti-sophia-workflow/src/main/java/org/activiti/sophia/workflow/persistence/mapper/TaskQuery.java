package org.activiti.sophia.workflow.persistence.mapper;

import java.util.List;

import org.activiti.sophia.workflow.persistence.entity.TaskEntity;

public interface TaskQuery {
  
    List<TaskEntity>	getTaskList ();
}
