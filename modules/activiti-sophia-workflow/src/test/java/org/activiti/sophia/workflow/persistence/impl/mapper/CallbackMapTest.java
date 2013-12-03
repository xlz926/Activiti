package org.activiti.sophia.workflow.persistence.impl.mapper;

import org.activiti.sophia.workflow.base.SpringTransactionalTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;



@ContextConfiguration(locations = { "/applicationContext-test.xml" })
public class CallbackMapTest extends SpringTransactionalTest{

	
	@Autowired
	CallbackMap callbackMap;
	
	
	@Test
	@Rollback(value=false)
	public void test() {
	/*	CallbackEntity callbackEntity =new CallbackEntity();
		callbackEntity.setStatus("1");
		callbackEntity.setBussnesKey("dd");
		callbackEntity.setTableName("bpm_form_leave");
		callbackMap.updateEntity(callbackEntity);*/
		callbackMap.updateUserStatus("zhangsan");
		
	}

}
