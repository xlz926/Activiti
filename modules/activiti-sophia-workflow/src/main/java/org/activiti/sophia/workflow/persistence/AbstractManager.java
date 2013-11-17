/**
 * 
 */
package org.activiti.sophia.workflow.persistence;

import org.activiti.sophia.workflow.persistence.context.Context;
import org.activiti.sophia.workflow.persistence.db.DbSqlSession;
import org.activiti.sophia.workflow.persistence.interceptor.Session;


/**
 * @author stell
 *
 */
public abstract  class AbstractManager  implements Session{

	
	 protected <T> T getSession(Class<T> sessionClass) {
		    return Context.getCommandContext().getSession(sessionClass);
    }

	 protected DbSqlSession getDbSqlSession() {
		    return getSession(DbSqlSession.class);
     }
	 
	 public void close() {
	  }

	  public void flush() {
	  }
}
