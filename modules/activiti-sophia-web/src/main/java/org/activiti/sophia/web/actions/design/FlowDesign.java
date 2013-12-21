package org.activiti.sophia.web.actions.design;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.activiti.sophia.web.utils.HttpMultipartRepresentation;
import org.activiti.sophia.web.utils.WebRestUtil;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.node.ObjectNode;
import org.restlet.representation.Representation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class FlowDesign {

	@RequestMapping(value = "/design", method = { RequestMethod.GET,RequestMethod.POST })
	public String test(HttpServletRequest request, HttpSession session, Model model,HttpServletResponse  response) {
		return "design";
	}
	
}
