package com.xworkz.simpleApplication.service;

import org.springframework.ui.Model;

import com.xworkz.simpleApplication.dto.SimpleApplicationDTO;

public interface SimpleApplicationService {
	public boolean registerSA(SimpleApplicationDTO dto);

	public boolean loginEmailAndPasswordValidate(String email,String Password);
	public boolean loginService(String email , String Password , Model model);

}
