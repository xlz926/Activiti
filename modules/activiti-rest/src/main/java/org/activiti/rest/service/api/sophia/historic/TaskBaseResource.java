package org.activiti.rest.service.api.sophia.historic;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.activiti.engine.impl.TaskQueryProperty;
import org.activiti.engine.query.QueryProperty;
import org.activiti.rest.common.api.DataResponse;
import org.activiti.rest.common.api.SecuredResource;
import org.activiti.rest.service.api.runtime.task.TaskQueryRequest;
import org.activiti.rest.service.api.sophia.SophiaPaginateList;
import org.activiti.sophia.workflow.service.ServiceFactoryApplication;
import org.activiti.sophia.workflow.service.TaskQueryService;
import org.restlet.data.Form;

public class TaskBaseResource  extends SecuredResource {

	
	 private static HashMap<String, QueryProperty> properties = new HashMap<String, QueryProperty>();
	  
	  static {
	    properties.put("id", TaskQueryProperty.TASK_ID);
	    properties.put("name", TaskQueryProperty.NAME);
	    properties.put("description", TaskQueryProperty.DESCRIPTION);
	    properties.put("dueDate", TaskQueryProperty.DUE_DATE);
	    properties.put("createTime", TaskQueryProperty.CREATE_TIME);
	    properties.put("priority", TaskQueryProperty.PRIORITY);
	    properties.put("executionId", TaskQueryProperty.EXECUTION_ID);
	    properties.put("processInstanceId", TaskQueryProperty.PROCESS_INSTANCE_ID);
	  }
	
	
	
	  protected DataResponse getTasksFromQueryRequest(TaskQueryRequest request) {
		  
		  TaskQueryService  taskQuery = ServiceFactoryApplication.createTaskQuery();
		  Map params = new HashMap<String,Object>();
		    Form query = getQuery();
		    Set<String> names = query.getNames();
		    if(names.contains("name")) {
		      params.put("name", getQueryParameter("name", query));
		    }
		    
		    if(names.contains("nameLike")) {
		    	params.put("nameLike", getQueryParameter("nameLike", query));
		    }
		    
		    if(names.contains("assignee")) {
		    	params.put("assignee", getQueryParameter("assignee", query));
		    }
		    
		    if(names.contains("descriptionLike")) {
		    	params.put("descriptionLike", getQueryParameter("descriptionLike", query));
		    }
		    
		    if(names.contains("description")) {
		    	params.put("description", getQueryParameter("description", query));
		    }
		    
		    if(names.contains("owner")) {
		    	params.put("owner", getQueryParameter("owner", query));
		    }
		    
		  return new SophiaPaginateList().paginateList(taskQuery,params,query);
	  }
}
