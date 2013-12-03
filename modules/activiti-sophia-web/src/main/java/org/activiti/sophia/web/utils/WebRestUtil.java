package org.activiti.sophia.web.utils;

import java.io.IOException;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.restlet.data.ChallengeScheme;
import org.restlet.representation.Representation;
import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

public class WebRestUtil {

	
	 private static String  preUrl;
	
	static {
		PropertiesLoader proper =new PropertiesLoader("classpath:jdbc.properties");
		preUrl = proper.getProperty("activiti.rest.service.url");
	}
	
	//private static String  preUrl ="http://172.16.8.89:7080/activiti-rest/service/";

	 
	 
	 
	 
	 
	 protected static ObjectMapper objectMapper = new ObjectMapper();
	// PropertyFileUtil.get("activiti.rest.service.url")
	 public static ClientResource getAuthenticatedClient(String method) {
		     ClientResource client = new ClientResource(preUrl+method);
		    client.setChallengeResponse(ChallengeScheme.HTTP_BASIC, "admin", "000000");
		    return client;
     }
	 
	 
	public static JsonNode restGet(String method){
		 ClientResource client = getAuthenticatedClient(method);
		 JsonNode responseNode = objectMapper.createObjectNode() ;
		  try {
			  responseNode =objectMapper.readTree( client.get().getStream());
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (ResourceException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return  responseNode ;
	}

	public static Representation restPost(String method,Object params){
		 
		return getAuthenticatedClient(method).post(params);
	}
	
	
	public static Representation restPut(String method,Object params){
		return getAuthenticatedClient(method).put(params);
	}
	
	
	public static Representation restDelete(String method){
		return getAuthenticatedClient(method).delete();
	}
	
	
	
}
