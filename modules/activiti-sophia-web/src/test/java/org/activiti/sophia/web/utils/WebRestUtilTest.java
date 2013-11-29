package org.activiti.sophia.web.utils;

import java.io.IOException;
import java.lang.reflect.Field;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.node.ArrayNode;
import org.codehaus.jackson.node.ObjectNode;
import org.junit.Test;
import org.restlet.data.ChallengeScheme;
import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

public class WebRestUtilTest {

	  protected ObjectMapper objectMapper = new ObjectMapper();
	 protected ObjectNode requestNode;
	// protected String baseUrl ="http://localhost:8081/activiti-rest/service/";
	 protected String baseUrl ="http://172.16.8.89:7080/activiti-rest/service/";
	@Test
	public void completeTask() throws IOException {
	

		ClientResource resource = new ClientResource("http://localhost:8081/activiti-rest/service/sophia/task/418");
		//ClientResource resource = new ClientResource("http://localhost:8081/activiti-rest/service/runtime/tasks/1306");  
		resource.setChallengeResponse(ChallengeScheme.HTTP_BASIC, "admin", "000000");
		try {
		
			  requestNode = objectMapper.createObjectNode();
		      ArrayNode variablesNode = objectMapper.createArrayNode();
		      
		      requestNode.put("action", "complete");
		  	   requestNode.put("assignee", "admin");
		      
		      requestNode.put("variables", variablesNode);
		      
		      ObjectNode var1 = objectMapper.createObjectNode();
		      variablesNode.add(var1);
		      var1.put("name", "zhuban");
		      var1.put("value", "主办协办测试");
		      var1.put("type", "string");
		      requestNode.put("variables", variablesNode);
		      resource.post(requestNode);
	
		} catch (ResourceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	
	
	//获取待办列表
	@Test
	public void getTaskList() throws JsonProcessingException, IOException {
		
		ClientResource resource = new ClientResource("http://localhost:8081/activiti-rest/service/sophia/task/117");
		//ClientResource resource = new ClientResource("http://localhost:8081/activiti-rest/service/runtime/tasks/1306");  
		resource.setChallengeResponse(ChallengeScheme.HTTP_BASIC, "kermit", "kermit");
	     requestNode = objectMapper.createObjectNode();
	      ArrayNode variablesNode = objectMapper.createArrayNode();
	      requestNode.put("action", "complete");
	      requestNode.put("assignee", "kermit");
	      requestNode.put("variables", variablesNode);
	      
	      ObjectNode var1 = objectMapper.createObjectNode();
	      variablesNode.add(var1);
	      var1.put("name", "auditPass");
	      var1.put("value", true);
		
		 // requestNode = objectMapper.readTree("{\"action\":\"complete\",\"assignee\":\"kermit\",\"variables\":[{\"auditPass\":true}]}");
		
		  System.out.println(requestNode.get("variables"));
		  
	    //  resource.post(requestNode);
	}

	
	
	@Test
	public void start(){
		ClientResource resource = new ClientResource("http://172.16.8.89:7080/activiti-rest/service/runtime/process-instances");
		//ClientResource resource = new ClientResource("http://localhost:8081/activiti-rest/service/runtime/tasks/1306");  
		resource.setChallengeResponse(ChallengeScheme.HTTP_BASIC, "kermit", "kermit");
	     requestNode = objectMapper.createObjectNode();
	      requestNode.put("processDefinitionKey", "oa_leave");
	      requestNode.put("businessKey", "4444444444444");
	      try {
	
	    	  System.out.println(  objectMapper.readTree(resource.post(requestNode).getStream()) );
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ResourceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void complate2(){
		ClientResource resource = new ClientResource(
				"http://172.16.8.89:7080/activiti-rest/service/sophia/task/960");
		resource.setChallengeResponse(ChallengeScheme.HTTP_BASIC, "kermit", "kermit");

		ObjectNode requestNode = new ObjectMapper().createObjectNode();

		ArrayNode variablesNode = new ObjectMapper().createArrayNode();

		requestNode.put("action", "complete");
		requestNode.put("assignee", "kermit");
		// 额外参数
		ObjectNode var1 = new ObjectMapper().createObjectNode();
		variablesNode.add(var1);
		var1.put("name", "auditPass");
		var1.put("value", true);
		var1.put("type", "boolean");
		requestNode.put("variables", variablesNode);

		resource.post(requestNode);
	}
}
