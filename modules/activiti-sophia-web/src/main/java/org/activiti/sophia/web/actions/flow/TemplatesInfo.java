package org.activiti.sophia.web.actions.flow;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.activiti.sophia.web.utils.HttpMultipartRepresentation;
import org.activiti.sophia.web.utils.WebRestUtil;
import org.codehaus.jackson.JsonNode;
import org.restlet.representation.Representation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;


@Controller
@RequestMapping("/flow/templatesInfo/*")
public class TemplatesInfo {

	
	@RequestMapping(value = "getTemplateList", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public JsonNode getUserList(HttpServletRequest request,Model model,@RequestParam("method") String method){
		return 	WebRestUtil.restGet(method);
	}
	
	
	@RequestMapping(value = "deployment", method = { RequestMethod.POST })
	@ResponseBody
	public JsonNode deployment(HttpServletRequest request,Model model) throws IOException{
		if (request instanceof MultipartHttpServletRequest) {
			MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
			for(MultipartFile multipartFile :multipartRequest.getFiles("templateFile")){
				if(!multipartFile.isEmpty()){
				      Representation uploadRepresentation = new HttpMultipartRepresentation(multipartFile.getOriginalFilename(),
				    		  multipartFile.getInputStream());
				      WebRestUtil.restPost("repository/deployments", uploadRepresentation);
				}
			}
		}
		return null;
	}
	
}
