package com.xworkz.simpleApplication.dao;

import com.xworkz.simpleApplication.entity.SimpleApplicationEntity;

public interface SimpleApplicationDAO {
	public boolean saveSimpleApplicationDTO(SimpleApplicationEntity applicationEntity);
	SimpleApplicationEntity getEmailByEntity(String email,String password);
}
