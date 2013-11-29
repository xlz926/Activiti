package org.activiti.rest.service.api.sophia.delegate;

import org.activiti.rest.common.api.SecuredResource;
import org.activiti.sophia.workflow.persistence.impl.entity.DelegateEntity;
import org.activiti.sophia.workflow.service.ServiceFactoryApplication;
import org.apache.ibatis.annotations.Delete;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.Put;

public class DelegateResource  extends SecuredResource{
	  @Get
	  public  DelegateEntity getDelegate(){
		  if(!authenticate()) { return null; }
		    String delegateId = getAttribute("delegateId");
		  return  ServiceFactoryApplication.createDelegateService().singleResult(delegateId);
	  }
	  
	  @Post
	  public  DelegateEntity createDelegate(DelegateEntity delegateEntity){
		  if(!authenticate()) { return null; }
		  return  ServiceFactoryApplication.createDelegateService().createDelegate(delegateEntity);
	  }
	  
	  @Put
	  public  DelegateEntity saveDelegate(DelegateEntity delegateEntity){
		  if(!authenticate()) { return null; }
		  return  ServiceFactoryApplication.createDelegateService().saveDelegate(delegateEntity);
	  }
	  
	  public  DelegateEntity deleteDelegate(String Id){
		  if(!authenticate()) { return null; }
		  return  ServiceFactoryApplication.createDelegateService().singleResult(Id);
	  }
	  
}
