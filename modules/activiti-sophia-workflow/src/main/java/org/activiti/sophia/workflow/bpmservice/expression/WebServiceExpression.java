package org.activiti.sophia.workflow.bpmservice.expression;

import java.io.IOException;

import org.activiti.engine.runtime.Execution;
import org.activiti.rest.common.api.ActivitiUtil;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.GetMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


@Service
public class WebServiceExpression  {

	private static Logger logger = LoggerFactory.getLogger(WebServiceExpression.class);
	
	
	public void updateStatus(Execution execution,String urlRoot,String status) {
	  if(urlRoot!=null){
		   String bussnesKey =    ActivitiUtil.getHistoryService().createHistoricProcessInstanceQuery().processInstanceId(execution.getProcessInstanceId()).singleResult().getBusinessKey();
		   String url =urlRoot.toString()+bussnesKey+"/"+status;
		  //构造HttpClient的实例
		  HttpClient httpClient = new HttpClient();
		  //创建GET方法的实例
		  GetMethod getMethod = new GetMethod(url);
	     try {
	    	 httpClient.executeMethod(getMethod);
			//resource.get();
		} catch (HttpException e) {
			logger.error("远程调用地址："+url+"失败\n"+e.getMessage());
		} catch (IOException e) {
			logger.error("远程调用地址："+url+"失败\n"+e.getMessage());
		}
	   }else{
		   logger.debug("远程调用地址为空");
	   }
	}

}
