package com.xworkz.simpleApplication.service;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.xworkz.simpleApplication.dao.SimpleApplicationDAO;
import com.xworkz.simpleApplication.dto.SimpleApplicationDTO;
import com.xworkz.simpleApplication.entity.SimpleApplicationEntity;
import com.xworkz.simpleApplication.util.MailDispatcher;



@Service
public class SimpleApplicationServiceImpl implements SimpleApplicationService {

	 private static org.apache.log4j.Logger log = Logger.getLogger(SimpleApplicationServiceImpl.class);  
	@Autowired
	private SimpleApplicationDAO saDAO;

	@Autowired
	private MailDispatcher mailDispatcher;


	public SimpleApplicationServiceImpl() {
		System.out.println(getClass().getSimpleName() + "object is created");
	}

	public boolean registerSA(SimpleApplicationDTO dto) {
		log.info("invoked registerVacciner");
		SimpleApplicationEntity sEntity = new SimpleApplicationEntity();
		BeanUtils.copyProperties(dto, sEntity);
		boolean result = this.saDAO.saveSimpleApplicationDTO(sEntity);
		if (result) {
			this.mailDispatcher.SendOTP(dto.getEmail(), "Vaccination Notification",
					"Vaccine Registeration is succesfully done  ");
			return true;
		} else {
			System.out.println("Oops somethig went wrong,try again");
		}
		return false;
	}

	public boolean loginEmailAndPasswordValidate(String email, String Password) {
		if (!email.isEmpty() && email != null && Password != null && !Password.isEmpty()) {
			return true;
		} else {
			return false;
		}

	}

	public boolean loginService(String email, String Password, Model model) {
		System.out.println("Invoked Login Service Method");
		SimpleApplicationEntity entity = this.saDAO.getEmailByEntity(email, Password);
		if (entity != null && !entity.getEmail().isEmpty() && entity.getEmail() != null
				&& !entity.getPassword().isEmpty()) {
			return true;
		} else {
			return false;
		}
	}
}