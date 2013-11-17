package org.activiti.sophia.workflow.service.impl;

import org.activiti.engine.identity.UserQuery;
import org.activiti.engine.impl.cmd.CreateUserQueryCmd;
import org.activiti.sophia.workflow.service.OrgManagerService;


public class OrgManagerServiceImpl  extends ServiceImpl implements OrgManagerService{

	  public UserQuery createUserQuery() {
		    return commandExecutor.execute(new CreateUserQueryCmd());
		  }

}
