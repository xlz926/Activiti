package org.activiti.rest.service.api.sophia;

import java.util.List;
import java.util.Map;

import org.activiti.engine.ActivitiIllegalArgumentException;
import org.activiti.engine.impl.AbstractQuery;
import org.activiti.engine.query.QueryProperty;
import org.activiti.rest.common.api.AbstractPaginateList;
import org.activiti.rest.common.api.DataResponse;
import org.activiti.rest.common.api.RequestUtil;
import org.activiti.sophia.workflow.persistence.impl.db.Pagination;
import org.activiti.sophia.workflow.service.Queryservice;
import org.restlet.data.Form;

public class SophiaPaginateList {
	
	  @SuppressWarnings({ "rawtypes", "unchecked" })
	  public DataResponse paginateList( Queryservice query,Map params,Form form) {
		   DataResponse response = new DataResponse();
		   response.setTotal(query.count(params)); 
		  int start =RequestUtil.getInteger(form, "start", 0);
		  int size = RequestUtil.getInteger(form, "size", 10);
		  params.putAll(Pagination.toListPage(start, size));
	      List list = query.listPage( params);
	    
	     response.setSize(size); 
	     response.setStart(start);
	   
	     response.setData(list);
	      return response;
	  }
	

}
