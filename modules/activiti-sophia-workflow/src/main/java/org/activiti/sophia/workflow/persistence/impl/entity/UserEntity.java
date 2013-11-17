package org.activiti.sophia.workflow.persistence.impl.entity;

import java.io.Serializable;

import org.activiti.sophia.workflow.persistence.context.Context;
import org.activiti.sophia.workflow.persistence.db.PersistentObject;




public class UserEntity implements Serializable, PersistentObject {

	
	  private static final long serialVersionUID = 1L;

	  protected String id;
	  protected int revision;
	  protected String firstName;
	  protected String lastName;
	  protected String email;
	  protected String password;
	
	
	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setId(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object getPersistentState() {
		// TODO Auto-generated method stub
		return null;
	}
	
	  public void delete() {
		    Context.getCommandContext()
		      .getDbSqlSession()
		      .delete(this);

		  }

}
