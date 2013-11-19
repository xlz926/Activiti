package org.activiti.sophia.web.actions.flow;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.activiti.sophia.web.utils.WebRestUtil;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.node.ObjectNode;
import org.restlet.representation.Representation;
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
	public JsonNode getRestService(HttpServletRequest request,Model model,@RequestParam("method") String method){
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
	
	
}
