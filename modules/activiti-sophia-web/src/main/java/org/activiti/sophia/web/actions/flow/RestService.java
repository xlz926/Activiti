package org.activiti.sophia.web.actions.flow;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.activiti.sophia.web.utils.WebRestUtil;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.restlet.representation.Representation;
import org.restlet.resource.ResourceException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
@RequestMapping("/flow/restService/*")
public class RestService {

	  protected ObjectMapper objectMapper = new ObjectMapper();

	@RequestMapping(value = "RestService", method = { RequestMethod.GET })
	@ResponseBody
	public JsonNode getRestService(HttpServletRequest request,Model model,
			 HttpSession session,@RequestParam("method") String method){
		String params =request.getParameter("params");
		if(params !=null)method=method+"?"+params;
		return 	WebRestUtil.restGet(method);
	}
	
	@RequestMapping(value = "RestService", method = {  RequestMethod.POST })
	@ResponseBody
	public JsonNode postRestService(HttpServletRequest request,Model model,@RequestParam("method") String method){
		  JsonNode	requestNode =objectMapper.createObjectNode();
		  JsonNode result =objectMapper.createObjectNode();
		try {
			Object params =request.getParameter("params");
			 if(params !=null)requestNode = objectMapper.readTree(params.toString());
			
			 result =objectMapper.readTree(WebRestUtil.restPost(method, requestNode).getStream());
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 	 result;
	}
	
	
	@RequestMapping(value = "putRestService", method = {  RequestMethod.POST })
	@ResponseBody
	public JsonNode putRestService(HttpServletRequest request,Model model,@RequestParam("method") String method){
		  JsonNode	requestNode =objectMapper.createObjectNode();
		  JsonNode result =objectMapper.createObjectNode();
		try {
			Object params =request.getParameter("params");
			 if(params !=null)requestNode = objectMapper.readTree(params.toString());
			
			 result =objectMapper.readTree(WebRestUtil.restPut(method, requestNode).getStream());
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 	 result;
	}
	
	@RequestMapping(value = "getResource", method = {  RequestMethod.GET })
	public void getResource(HttpServletRequest request,HttpServletResponse response,
			@RequestParam("deploymentId") String deploymentId,@RequestParam("diagramResourceName") String diagramResourceName){
		try {
			
			InputStream  resourceAsStream = WebRestUtil.getAuthenticatedClient("repository/deployments/"+deploymentId+"/resourcedata/"+diagramResourceName).get().getStream();
			
			 byte[] b = new byte[1024];
			    int len = -1;
			    while ((len = resourceAsStream.read(b, 0, 1024)) != -1) {
			      response.getOutputStream().write(b, 0, len);
			    }
			
		} catch (ResourceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "getinstancesImg", method = {  RequestMethod.GET })
	public void getinstancesImg(HttpServletRequest request,HttpServletResponse response,@RequestParam("processInstanceId") String processInstanceId){
		try {
			InputStream  resourceAsStream = WebRestUtil.getAuthenticatedClient("process-instance/"+processInstanceId+"/diagram").get().getStream();
			 byte[] b = new byte[1024];
			    int len = -1;
			    while ((len = resourceAsStream.read(b, 0, 1024)) != -1) {
			      response.getOutputStream().write(b, 0, len);
			    }
			
		} catch (ResourceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	@RequestMapping(value = "deleteRestService", method = {  RequestMethod.POST })
	@ResponseBody
	public JsonNode deleteRestService(HttpServletRequest request,Model model,@RequestParam("method") String method){
		  JsonNode result =objectMapper.createObjectNode();
		try {
			result =  objectMapper.readTree(WebRestUtil.restDelete(method).getStream());
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	
	
	
}
