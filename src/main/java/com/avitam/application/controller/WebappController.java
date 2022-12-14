package com.avitam.application.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.avitam.application.dao.JpaWebDAO;
import com.avitam.application.model.Jspuser;
import com.avitam.application.service.JpaWebService;
import com.avitam.application.service.JpaWebServiceImpl;

@Controller
public class WebappController {
	@Autowired
	JpaWebDAO jpawebdao;
	JpaWebService jpawebservice = new JpaWebServiceImpl();
	Jspuser jspuser=new Jspuser();
	@RequestMapping("/")
	public String displayHome() {
		return "indexPage.jsp";
	}

	@RequestMapping("/Login")
	public ModelAndView processLogin(@RequestParam("userId") int userId, @RequestParam("password") String password) {
		ModelAndView mv = new ModelAndView("indexPage.jsp");
		jspuser=jpawebdao.findByUserIdAndPassword(userId, password);
		if(jspuser != null) {
			//System.out.println("login successful");
			mv.addObject("passwordWarning", "Login successful");
		}
		
		else {
			//System.out.println("check creds");
			mv.addObject("passwordWarning", "Check your credentials");
		}
		
		return mv;
		
	}

	@RequestMapping("/displaySignupForm")
	public String displaySignupForm() {
		return "signup.jsp";
	}

	@RequestMapping("/processSignup")
	public String processSignup(Jspuser jspuser) {
		jpawebdao.save(jspuser);
		return "indexPage.jsp";
	}
}
