package org.activiti.rest.service.api.sophia.task;

import java.util.List;

import org.activiti.rest.service.api.RestActionRequest;
import org.activiti.rest.service.api.engine.variable.RestVariable;
import org.codehaus.jackson.annotate.JsonTypeInfo;
import org.codehaus.jackson.annotate.JsonTypeInfo.Id;

public class TaskActionRequest  extends RestActionRequest{

	
	 public static final String ACTION_COMPLETE = "complete";
	  public static final String ACTION_CLAIM = "claim";
	  public static final String ACTION_DELEGATE = "delegate";
	  public static final String ACTION_RESOLVE = "resolve";
	  
	  private String assignee;
	  private List<RestVariable> variables;
	  
	  public void setAssignee(String assignee) {
	    this.assignee = assignee;
	  }
	  public String getAssignee() {
	    return assignee;
	  }
	  public void setVariables(List<RestVariable> variables) {
	    this.variables = variables;
	  }
	  @JsonTypeInfo(use=Id.CLASS, defaultImpl=RestVariable.class)
	  public List<RestVariable> getVariables() {
	    return variables;
	  }
	
	
}
