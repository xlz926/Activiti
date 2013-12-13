package org.activiti.sophia.web.actions.design;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class FlowDesign {

	@RequestMapping(value = "/design", method = { RequestMethod.GET,RequestMethod.POST })
	public String test(HttpServletRequest request, HttpSession session, Model model,HttpServletResponse  response) {
		return "design";
	}
}
