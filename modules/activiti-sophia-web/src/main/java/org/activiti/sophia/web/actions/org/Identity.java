package org.activiti.sophia.web.actions.org;

import javax.servlet.http.HttpServletRequest;

import org.activiti.sophia.web.utils.WebRestUtil;
import org.codehaus.jackson.JsonNode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/org/*")
public class Identity {

	
	
	@RequestMapping(value = "getUserList", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public JsonNode getUserList(HttpServletRequest request,Model model,@RequestParam("method") String method){
		return 	WebRestUtil.restGet(method);
	}
	
	@RequestMapping(value = "getGroupList", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public JsonNode getGroupList(HttpServletRequest request,Model model,@RequestParam("method") String method){
		return 	WebRestUtil.restGet(method);
	}
}
