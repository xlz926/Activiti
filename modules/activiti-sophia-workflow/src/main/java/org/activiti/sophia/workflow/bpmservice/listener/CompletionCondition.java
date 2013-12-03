package org.activiti.sophia.workflow.bpmservice.listener;

import org.activiti.engine.runtime.Execution;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;



@Service
public class CompletionCondition {

	
	 private Logger logger = LoggerFactory.getLogger(getClass());
	 
	  public Boolean canComplete(Execution execution,String assignee,String complete) {
		  boolean result =assignee.equals(complete);
		  return result;
	  }
	
	
}
