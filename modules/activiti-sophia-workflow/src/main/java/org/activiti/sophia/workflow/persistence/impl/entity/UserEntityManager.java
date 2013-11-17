package org.activiti.sophia.workflow.persistence.impl.entity;


import org.activiti.sophia.workflow.orgManager.UserQueryImpl;
import org.activiti.sophia.workflow.persistence.AbstractManager;
import org.activiti.sophia.workflow.persistence.context.Context;


public class UserEntityManager  extends AbstractManager{

	
	  public UserEntity findUserById(String userId) {
		    return (UserEntity) getDbSqlSession().selectOne("selectUserById", userId);
		  }
	
	  
	  public UserQuery createNewUserQuery() {
		  Context.getWorkflowConfiguration();
		    return new UserQueryImpl();
		}
}
