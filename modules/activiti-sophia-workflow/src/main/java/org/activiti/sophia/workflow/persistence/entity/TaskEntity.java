package org.activiti.sophia.workflow.persistence.entity;

import java.util.Date;

import org.activiti.engine.task.DelegationState;

public class TaskEntity {
	   private String id;
	   private String owner;
	   private String assignee;
	   private String suspensionState;
	  private String name;
	   private String description;
	   private Date createTime; 
	   private Date dueDate;
	   private String processInstanceId;
	   private String businessKey;
	   private String auditUser;
	   private String procdefName;

	   public String getProcdefName() {
		return procdefName;
	}

	public void setProcdefName(String procdefName) {
		this.procdefName = procdefName;
	}

	public String getSuspensionState() {
			return suspensionState;
		}

		public void setSuspensionState(String suspensionState) {
			this.suspensionState = suspensionState;
		}
	  
	  public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public String getProcessInstanceId() {
		return processInstanceId;
	}

	public void setProcessInstanceId(String processInstanceId) {
		this.processInstanceId = processInstanceId;
	}

	public String getBusinessKey() {
		return businessKey;
	}

	public void setBusinessKey(String businessKey) {
		this.businessKey = businessKey;
	}

	public String getAuditUser() {
		return auditUser;
	}

	public void setAuditUser(String auditUser) {
		this.auditUser = auditUser;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	protected String parentTaskId;

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getAssignee() {
		return assignee;
	}

	public void setAssignee(String assignee) {
		this.assignee = assignee;
	}


	public String getParentTaskId() {
		return parentTaskId;
	}

	public void setParentTaskId(String parentTaskId) {
		this.parentTaskId = parentTaskId;
	}
}
