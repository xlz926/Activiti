package org.activiti.sophia.workflow.persistence.cfg;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class WorkflowConfigImplTest {

	@Test
	public void test() {
		try {
			SqlSession session =	new WorkflowConfigImpl().sqlSessionFactory.openSession();
			System.out.println(session.selectList("TaskQuery.getTaskList")); ;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
