package com.xworkz.simpleApplication.controller;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.xworkz.simpleApplication.service.SimpleApplicationService;

@Controller
public class LoginController {

	@Autowired
	private SimpleApplicationService saService;
	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

	public LoginController() {
		LOGGER.log(Level.INFO,getClass().getSimpleName() + "object is created");
		
	}

	@RequestMapping(value = "/login.do")
	public String onLogin(@RequestParam String email, @RequestParam String password, Model model) {
		
		LOGGER.log(Level.INFO,"invoked on login method");
		
	
			boolean loginSuccessResult = this.saService.loginService(email, password, model);
			if (loginSuccessResult) {
				model.addAttribute("loginmessage", "your account login succesfullly done");
				return "success";
			} else {
				model.addAttribute("loginmessage", " Login Failed your user & password wrong try again later");
				return "fail";
			}

		
	}

}