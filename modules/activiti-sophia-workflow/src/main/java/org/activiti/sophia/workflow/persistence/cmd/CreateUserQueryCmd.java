package org.activiti.sophia.workflow.persistence.cmd;

import java.io.Serializable;

import org.activiti.sophia.workflow.orgManager.UserQuery;
import org.activiti.sophia.workflow.persistence.interceptor.Command;
import org.activiti.sophia.workflow.persistence.interceptor.CommandContext;

public class CreateUserQueryCmd implements Command<UserQuery>, Serializable{

	@Override
	public UserQuery execute(CommandContext commandContext) {
		 return commandContext
			      .getUserEntityManager()
			      .createNewUserQuery();
	}

}
