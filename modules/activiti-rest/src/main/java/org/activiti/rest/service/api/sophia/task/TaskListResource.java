package org.activiti.rest.service.api.sophia.task;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.activiti.engine.ActivitiIllegalArgumentException;
import org.activiti.engine.ActivitiObjectNotFoundException;
import org.activiti.engine.task.Task;
import org.activiti.rest.common.api.ActivitiUtil;
import org.activiti.rest.common.api.DataResponse;
import org.activiti.rest.service.api.engine.variable.RestVariable;
import org.activiti.rest.service.api.runtime.task.TaskActionRequest;
import org.activiti.rest.service.api.runtime.task.TaskQueryRequest;
import org.activiti.rest.service.application.ActivitiRestServicesApplication;
import org.restlet.data.Form;
import org.restlet.data.Status;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.ResourceException;

public class TaskListResource extends TaskBaseResource {
	   @Get
	   public   DataResponse getTasks() {
	    if(!authenticate()) { return null; }
	    
	    // Create a Task query request
	    TaskQueryRequest request = new TaskQueryRequest();
	     return   getTasksFromQueryRequest(request);
	  }
	  
	
}
