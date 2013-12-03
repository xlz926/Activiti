package org.activiti.sophia.workflow.bpmservice.expression;

import org.activiti.rest.common.api.ActivitiUtil;
import org.springframework.stereotype.Service;


@Service
public class SqlExpression {
       public void exec(String sql){
    	   ActivitiUtil.getTaskService().createNativeTaskQuery().sql(sql).count();
       }
}
