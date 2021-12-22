package com.xworkz.simpleApplication.controller;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.validator.constraints.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.xworkz.simpleApplication.util.OtpGenerator;

@Controller
public class OtpController {

	private static Integer otppNumber;
	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	@Autowired
	private com.xworkz.simpleApplication.util.MailDispatcher mailDispatcher;

	public OtpController() {
		LOGGER.log(Level.INFO,getClass().getSimpleName() + "object is created");
	
	}

	@RequestMapping(value = "/startotp.do")
	public String getOtp(@RequestParam String email, Model model,HttpServletRequest req) 
	{
		LOGGER.log(Level.INFO,"invoked getOTP");
		
		otppNumber = OtpGenerator.randomNumberGenerator(1000, 9999);
		boolean outcome=this.mailDispatcher.SendOTP(email, "OTP_Message", "Hi Your OTP for Vaccination is  " + otppNumber);
		model.addAttribute("OtpSuccessMessage", "Your Otp sent to mail id");
		LOGGER.log(Level.INFO,"OTP is generated");
		
		if(outcome) {
			HttpSession session=req.getSession(true);
			 session.setAttribute("email",email);
			return "home";
		}else {
			model.addAttribute("OtpSuccessMessage", "invalid email");
		}
		return "startotp.do";
	}


}