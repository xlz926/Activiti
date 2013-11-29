package org.activiti.sophia.workflow.service;

import java.util.HashMap;
import java.util.Map;

import org.activiti.sophia.workflow.base.SpringTransactionalTest;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;


@ContextConfiguration(locations = { "/applicationContext-test.xml" })
public class HistoricTaskQueryServiceTest extends SpringTransactionalTest {

	@Test
	public void test() {
		ServiceFactoryApplication test =new ServiceFactoryApplication();
		Map map =new HashMap();
		map.put("processInstanceId", "105");
		System.out.println(test.createHitoricTaskQuery().listPage(map).size());
	}

}
