package com.xworkz.simpleApplication.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

@Entity
@Table(name = "simple")
@NamedQueries({
	@NamedQuery(name = "GetRecordByMail", query = "select name from SimpleApplicationEntity name where name.email=:em and name.password=:e ")})
public class SimpleApplicationEntity {

	
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		@Column(name = "SA_ID")
		private int simpleApplicationId;

		 
		@Column(name = "SA_NAME")
		private String name;
		 
		@Column(name = "SA_EMAIL")
		private String email;
		
	
		@Column(name = "SA_PASSWORD")
		private String password;
		
		  
		@Column(name = "SA_OPT")
		private int otp;


		


		public int getSimpleApplicationId() {
			return simpleApplicationId;
		}


		public void setSimpleApplicationId(int simpleApplicationId) {
			this.simpleApplicationId = simpleApplicationId;
		}


		public String getName() {
			return name;
		}


		public void setName(String name) {
			this.name = name;
		}


		public String getEmail() {
			return email;
		}


		public void setEmail(String email) {
			this.email = email;
		}


		public String getPassword() {
			return password;
		}


		public void setPassword(String password) {
			this.password = password;
		}


		public int getOtp() {
			return otp;
		}


		public void setOtp(int otp) {
			this.otp = otp;
		}


		public SimpleApplicationEntity() {
			super();
			// TODO Auto-generated constructor stub
		}
		
		
}

	

