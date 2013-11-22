package org.activiti.rest.service.api.sophia.historic;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.activiti.rest.common.api.DataResponse;
import org.activiti.rest.common.api.SecuredResource;
import org.activiti.rest.service.api.sophia.SophiaPaginateList;
import org.activiti.sophia.workflow.service.HistoricTaskQueryService;
import org.activiti.sophia.workflow.service.ServiceFactoryApplication;
import org.restlet.data.Form;
import org.restlet.resource.Get;

public class HisTasksResource extends SecuredResource {

	
	   @Get
	   public   DataResponse getTasks() {
	    if(!authenticate()) { return null; }
	    HistoricTaskQueryService  taskQuery = ServiceFactoryApplication.createHitoricTaskQuery();
	    Map<String,Object> params = new HashMap<String,Object>();
	    Form query = getQuery();
	    Set<String> names = query.getNames();
	     if(names.contains("name")) {
		      params.put("name", getQueryParameter("name", query));
		    }
	     if(names.contains("processInstanceId")) {
	    	params.put("processInstanceId", getQueryParameter("processInstanceId", query));
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
	    
	     return   new SophiaPaginateList().paginateList(taskQuery,params,query);
	  }
}
