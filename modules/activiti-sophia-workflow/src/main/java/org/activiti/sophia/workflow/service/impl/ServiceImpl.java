package org.activiti.sophia.workflow.service.impl;

import org.activiti.engine.impl.interceptor.CommandExecutor;

public class ServiceImpl {

	 protected CommandExecutor commandExecutor;
	  
	  public CommandExecutor getCommandExecutor() {
	    return commandExecutor;
	  }

	  public void setCommandExecutor(CommandExecutor commandExecutor) {
	    this.commandExecutor = commandExecutor;
	  }
}
