package org.activiti.sophia.workflow.persistence.impl.entity;

import org.junit.Test;

public class UserEntityManagerTest {

	@Test
	public void test() {
		try {
			UserEntityManager user = new UserEntityManager();
			
			user.findUserById("kermit");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
