package org.activiti.sophia.workflow.service;

import java.util.List;
import java.util.Map;

public interface   Queryservice<T> {
	
	String limitBefore ="select * from ( select a.*, ROWNUM rnum from (";
	
   public   List<T>	listPage(Map params);
   
    long  count(Map params);
}
