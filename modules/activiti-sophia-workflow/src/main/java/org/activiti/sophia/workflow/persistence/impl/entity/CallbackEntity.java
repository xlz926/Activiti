package org.activiti.sophia.workflow.persistence.impl.entity;

public class CallbackEntity {

	
	private String bussnesKey;
	private String status;
	private String tableName;
	
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public String getBussnesKey() {
		return bussnesKey;
	}
	public void setBussnesKey(String bussnesKey) {
		this.bussnesKey = bussnesKey;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
