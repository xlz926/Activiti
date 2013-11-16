package org.activiti.sophia.web.actions;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class Login {

	@RequestMapping(value = "/login", method = { RequestMethod.GET })
	public String getLogin(HttpServletRequest request, HttpSession session, Model model) {
		
		return "login";
	}
	
	@RequestMapping(value = "/login", method = { RequestMethod.POST })
	public String Login(HttpServletRequest request, HttpSession session, Model model) {
		session.setAttribute("username",request.getAttribute("username"));
		session.setAttribute("password",request.getAttribute("password"));
		return "index";
	}
}
