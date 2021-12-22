package com.xworkz.simpleApplication.controller;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xworkz.simpleApplication.dto.SimpleApplicationDTO;
import com.xworkz.simpleApplication.service.SimpleApplicationService;

@Controller
public class SimpleApplicationController {
	
	
	

		@Autowired
		private SimpleApplicationService aService;
		private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

		public SimpleApplicationController() {
			LOGGER.log(Level.INFO,getClass().getSimpleName() + "object is created");
			//System.out.println(getClass().getSimpleName() + "object is created");
		}
		
		@RequestMapping(value = "/clickregister.do")
		public String onClickRegister() {
			return "optpage";
			
		}
//		

		@RequestMapping(value = "/register.do")
		public String onRegister(@ModelAttribute SimpleApplicationDTO dto, Model model)
		{
			LOGGER.log(Level.INFO,"Invoked onRegister Method");
			
			LOGGER.log(Level.INFO,"dto");
		
			boolean outcome = this.aService.registerSA(dto);
			if (outcome) {
				model.addAttribute("vaccinemessage", "vaccine Application Successfull done");
				return "success";
			} else {
				model.addAttribute("vaccinemessage", " Application Failed try again later");
				return "fail";

			}

		}

	}


