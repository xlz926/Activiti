package org.activiti.sophia.web.actions;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class Login {

	private static Logger logger = LoggerFactory.getLogger(Login.class);
	
	@RequestMapping(value = "/login", method = { RequestMethod.GET })
	public String getLogin(HttpServletRequest request, HttpSession session, Model model) {
		return "login";
	}
	
	@RequestMapping(value = "/login", method = { RequestMethod.POST })
	public String Login(HttpServletRequest request, HttpSession session, Model model) {
		session.setAttribute("username",request.getParameter("username"));
		session.setAttribute("password",request.getParameter("password"));
		logger.debug("用户:"+request.getParameter("username")+"登陆成功");
		return "redirect:/index";
	}
	
	@RequestMapping(value = "/logout", method = { RequestMethod.GET })
	public String logout(HttpServletRequest request, HttpSession session, Model model) {
		logger.debug("用户:"+session.getAttribute("username")+"退出系统");
		session.removeAttribute("username");
		session.removeAttribute("password");
		return "redirect:/login";
	}
}
