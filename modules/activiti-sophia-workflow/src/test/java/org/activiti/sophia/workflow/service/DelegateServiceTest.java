package org.activiti.sophia.workflow.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.activiti.sophia.workflow.base.SpringTransactionalTest;
import org.activiti.sophia.workflow.persistence.impl.entity.DelegateEntity;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
@ContextConfiguration(locations = { "/applicationContext-test.xml" })
public class DelegateServiceTest extends SpringTransactionalTest {

	
	@Test
	@Rollback(false)
	public void createDelegate() {
		ServiceFactoryApplication test =new ServiceFactoryApplication();
		DelegateEntity delegateEntity =new DelegateEntity();
		
		delegateEntity.setId("dddddd44");
		delegateEntity.setEndTime(new Date());
		delegateEntity.setStartTime(new Date());
		delegateEntity.setUesrId("kermit");
		try {
			test.createDelegateService().createDelegate(delegateEntity);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@Test
	@Rollback(false)
	public void saveDelegate() {
		ServiceFactoryApplication test =new ServiceFactoryApplication();
		DelegateEntity delegateEntity =new DelegateEntity();
		delegateEntity.setId("dddddd");
		delegateEntity.setEndTime(new Date());
		delegateEntity.setStartTime(new Date());
		delegateEntity.setUesrId("kermit");
		delegateEntity.setProcDefId("dfddfdf");
		try {
			test.createDelegateService().saveDelegate(delegateEntity);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	@Rollback(false)
	public void queryDelegate() {
		ServiceFactoryApplication test =new ServiceFactoryApplication();
	    Map params =new HashMap();
		try {
			System.out.println( test.createDelegateService().count(params));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
}
