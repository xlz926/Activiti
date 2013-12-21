package org.activiti.sophia.web.utils;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.restlet.data.ChallengeScheme;
import org.restlet.representation.Representation;
import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class WebRestUtil {

	
	 private static Logger logger = LoggerFactory.getLogger(WebRestUtil.class);
	
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
		     String  username="admin";
		     String  password="000000";
		     if(RequestContextHolder.getRequestAttributes()!=null){
		    	  HttpSession session = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getSession();
				  username =session.getAttribute("username")==null?"admin":session.getAttribute("username").toString();
				   password =session.getAttribute("password")==null?"000000":session.getAttribute("password").toString();
		     }
		   
		    client.setChallengeResponse(ChallengeScheme.HTTP_BASIC,username, password);
		    return client;
     }
	 
	 
	public static JsonNode restGet(String method){
		 ClientResource client = getAuthenticatedClient(method);
		 JsonNode responseNode = objectMapper.createObjectNode() ;
		  try {
			  responseNode =objectMapper.readTree( client.get().getStream());
			  logger.debug(method);
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
		 logger.debug(method,params);
		return getAuthenticatedClient(method).post(params);
	}
	
	
	public static Representation restPut(String method,Object params){
		 logger.debug(method,params);
		return getAuthenticatedClient(method).put(params);
	}
	
	
	public static Representation restDelete(String method){
		 logger.debug(method);
		return getAuthenticatedClient(method).delete();
	}
	
	
	
}
