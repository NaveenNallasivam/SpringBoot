package com.avitam.application.controller;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.avitam.application.dao.JpaWebDAO;
import com.avitam.application.model.Jspuser;
import com.avitam.application.model.UserData;
import com.avitam.application.service.JpaWebService;
import com.avitam.application.service.JpaWebServiceImpl;
import com.fasterxml.classmate.AnnotationConfiguration;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.json.JSONObject;

@Controller
public class WebappController {
	@Autowired
	JpaWebDAO jpawebdao;
	JpaWebService jpawebservice = new JpaWebServiceImpl();
	Jspuser jspuser = new Jspuser();

	@RequestMapping("/")
	public String displayHome() {
		return "indexPage";
	}

	@RequestMapping("/Login")
	public ModelAndView processLogin(@RequestParam("userId") int userId, @RequestParam("password") String password) {
		ModelAndView mv = new ModelAndView("indexPage");
		jspuser = jpawebdao.findById(userId).orElse(null);

		if (jspuser != null) {
			UserData userData = jpawebservice.modelDataConverter(jspuser);
			boolean loginFlag = jpawebservice.processlogin(password, jspuser.getPassword());

			if (loginFlag != false) {
				mv.addObject("passwordWarning", "Login successful");
				mv = new ModelAndView("mainPage");
				mv.addObject("userBean", userData);
			} else {

				mv.addObject("passwordWarning", "Check your credentials");
			}

		}

		else {

			mv.addObject("passwordWarning", "Check your credentials");
		}

		return mv;

	}

	@RequestMapping("/displaySignupForm")
	public String displaySignupForm() {
		return "signup";
	}

	@RequestMapping("/processSignup")
	public String processSignup(Jspuser jspuser) {
		jpawebdao.save(jspuser);
		return "indexPage";
	}

	@SuppressWarnings("deprecation")
	@RequestMapping("/viewProfile")
	public @ResponseBody String displayProfileData(@RequestParam("uid") int uid) {
		jspuser = jpawebdao.getById(uid);
		UserData userData = jpawebservice.modelDataConverter(jspuser);
		String JSONres = new Gson().toJson(userData);
		return JSONres;

	}

	@RequestMapping(value = "/editProfile", method = RequestMethod.POST)
	public @ResponseBody String editProfileData(@RequestBody String userData, HttpServletRequest req,
			HttpServletResponse res) {

		JSONObject jsonObj = new JSONObject(userData);
		int uid = jsonObj.getInt("uid");
		UserData userDataObj = new UserData();
		userDataObj = new Gson().fromJson(userData, UserData.class);
		userDataObj.setUserId(uid);
		jspuser = jpawebservice.DatamodelConverter(userDataObj);
		jpawebdao.save(jspuser);
		return null;

	}

	@RequestMapping(value = "/forgotPassword", method = RequestMethod.GET)
	public String forgotPassword() {
		return "forgotPassword";
	}

	@RequestMapping(value = "/forgotPassword", method = RequestMethod.POST)
	public ModelAndView forgotPassword(@ModelAttribute("userid") int uid,
			@ModelAttribute("newPassword") String newPassword,
			@ModelAttribute("confirmNewPassword") String confirmNewPassword) {
		ModelAndView mv = new ModelAndView("indexPage");
		if (newPassword.trim().equals(confirmNewPassword.trim())) {
			jspuser = jpawebdao.findById(uid).orElse(null);
			if (jspuser != null) {
				jspuser.setPassword(confirmNewPassword);
				jpawebdao.save(jspuser);
				mv.addObject("passwordreset", "Password has been reset successfully, Please login using new Password");
			} else {
				mv = new ModelAndView("forgotPassword");
				mv.addObject("passwordreset", "User id does not exist");
			}

		} else {
			mv = new ModelAndView("forgotPassword");
			mv.addObject("passwordreset", "Passwords did not match!");
		}
		return mv;
	}
}
