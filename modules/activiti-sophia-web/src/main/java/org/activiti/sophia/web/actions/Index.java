package org.activiti.sophia.web.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class Index {

	@RequestMapping(value = "/index", method = { RequestMethod.GET,RequestMethod.POST })
	public String getIndex(HttpServletRequest request, HttpSession session, Model model) {
		model.addAttribute("username", session.getAttribute("username"));
		return "index";
	}
	

	
}
