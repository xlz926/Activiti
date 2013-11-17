package org.activiti.sophia.workflow.persistence.impl;

public class Pagination {

	protected int firstResult;
	  protected int maxResults;
	  
	  public Pagination(int firstResult, int maxResults) {
	    this.firstResult = firstResult;
	    this.maxResults = maxResults;
	  }
	  
	  public int getFirstResult() {
	    return firstResult;
	  }

	  public int getMaxResults() {
	    return maxResults;
	  }
	
}
