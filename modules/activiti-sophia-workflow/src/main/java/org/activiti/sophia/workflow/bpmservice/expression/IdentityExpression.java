package org.activiti.sophia.workflow.bpmservice.expression;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;


@Service
public class IdentityExpression {

	public List<String> assigneeUsersForTask(String... users){
		return Arrays.asList(users);
	}
	
	
	
}
