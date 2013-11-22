package org.activiti.rest.service.api.sophia.task;

import java.util.HashMap;
import java.util.Map;

import org.activiti.engine.ActivitiIllegalArgumentException;
import org.activiti.engine.ActivitiObjectNotFoundException;
import org.activiti.engine.task.Task;
import org.activiti.rest.common.api.ActivitiUtil;
import org.activiti.rest.service.api.engine.variable.RestVariable;
import org.activiti.rest.service.api.runtime.task.TaskActionRequest;
import org.activiti.rest.service.api.runtime.task.TaskBaseResource;
import org.activiti.rest.service.api.runtime.task.TaskResponse;
import org.activiti.rest.service.application.ActivitiRestServicesApplication;
import org.restlet.data.Status;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.ResourceException;

public class TaskActionResource extends TaskBaseResource {

	
	  @Get
	  public TaskResponse getTask() {
	    if(!authenticate()) { return null; }
	    return getApplication(ActivitiRestServicesApplication.class).getRestResponseFactory()
	            .createTaskResponse(this, getTaskFromRequest());
	  }
	  
	  @Post
	  public  void executeTaskAction(TaskActionRequest actionRequest) {
		    if (!authenticate()) {
		        return;
		      }
		      if (actionRequest == null) {
		        throw new ResourceException(new Status(Status.CLIENT_ERROR_UNSUPPORTED_MEDIA_TYPE.getCode(), "A request body was expected when executing a task action.",
		                null, null));
		      }
		      Task task = getTaskFromRequest();
		      if (TaskActionRequest.ACTION_COMPLETE.equals(actionRequest.getAction())) {
		        completeTask(task, actionRequest);
		      } else if (TaskActionRequest.ACTION_CLAIM.equals(actionRequest.getAction())) {
		        claimTask(task, actionRequest);
		      } else if (TaskActionRequest.ACTION_DELEGATE.equals(actionRequest.getAction())) {
		        delegateTask(task, actionRequest);
		      } else if (TaskActionRequest.ACTION_RESOLVE.equals(actionRequest.getAction())) {
		        resolveTask(task, actionRequest);
		      } else {
		        throw new ActivitiIllegalArgumentException("Invalid action: '" + actionRequest.getAction() + "'.");
		      }
		      
	  }
	  
	  protected Task getTaskFromRequest() {
		    String taskId = getAttribute("taskId");
		    
		    if (taskId == null) {
		      throw new ActivitiIllegalArgumentException("The taskId cannot be null");
		    }
		    
		    Task task = ActivitiUtil.getTaskService().createTaskQuery().taskId(taskId).singleResult();
		    if (task == null) {
		      throw new ActivitiObjectNotFoundException("Could not find a task with id '" + taskId + "'.", Task.class);
		    }
		    return task;
	}
	   protected void completeTask(Task task, TaskActionRequest actionRequest) {
	    	
	    	if(task.getAssignee()==null){
	    		claimTask(task,actionRequest);
	    	}
	    	
	      if(actionRequest.getVariables() != null) {
	        Map<String, Object> variablesToSet = new HashMap<String, Object>(); 
	        for(RestVariable var : actionRequest.getVariables()) {
	          if(var.getName() == null) {
	            throw new ActivitiIllegalArgumentException("Variable name is required");
	          }
	          
	          Object actualVariableValue = getApplication(ActivitiRestServicesApplication.class).getRestResponseFactory()
	                  .getVariableValue(var);
	          
	          variablesToSet.put(var.getName(), actualVariableValue);
	        }
	        
	        ActivitiUtil.getTaskService().complete(task.getId(), variablesToSet);
	      } else {
	        ActivitiUtil.getTaskService().complete(task.getId());
	      }
	      
	    }

	    protected void resolveTask(Task task, TaskActionRequest actionRequest) {
	      ActivitiUtil.getTaskService().resolveTask(task.getId());
	    }

	    protected void delegateTask(Task task, TaskActionRequest actionRequest) {
	      if(actionRequest.getAssignee() == null) {
	        throw new ActivitiIllegalArgumentException("An assignee is required when delegating a task.");
	      }
	      ActivitiUtil.getTaskService().delegateTask(task.getId(), actionRequest.getAssignee());
	    }

	    protected void claimTask(Task task, TaskActionRequest actionRequest) {
	      if(actionRequest.getAssignee() == null) {
	        throw new ActivitiIllegalArgumentException("An assignee is required when claiming a task.");
	      }
	      // In case the task is already claimed, a ActivitiTaskAlreadyClaimedException is thown and converted to
	      // a CONFLICT response by the StatusService
	      ActivitiUtil.getTaskService().claim(task.getId(), actionRequest.getAssignee());
	    }
	  
}
