package org.activiti.sophia.workflow.persistence.impl.mapper;

import java.util.List;
import java.util.Map;

public interface   QueryMap<T> {

		public   long count(Map params);

		public   T singleResult(String id) ;

		public List<T> listPage(Map params);
		
		public int insertEntity(T entity);
		
		public int deleteEntity(String Id);
		
		public int updateEntity(T entity);
		

}
