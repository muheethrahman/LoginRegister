package com.xworkz.simpleApplication.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.hibernate.query.QueryProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.*;

import com.xworkz.simpleApplication.entity.SimpleApplicationEntity;

@Component
public class SimpleApplicationDAOImpl implements SimpleApplicationDAO {
	@Autowired
	private SessionFactory factory;
	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	public   SimpleApplicationDAOImpl() {
		System.out.println(getClass().getSimpleName() + "object is created");
	}

	public boolean saveSimpleApplicationDTO(SimpleApplicationEntity applicationEntity) {
		 LOGGER.log(Level.INFO, "Save Method started");
		
		Session session = this.factory.openSession();
		try {
			Transaction transaction = session.beginTransaction();
			session.save(applicationEntity);
			transaction.commit();
			LOGGER.log(Level.INFO,"data is saved in sql successfully");
			
			return true;
		} catch (Exception exp) {
			session.getTransaction().rollback();
			LOGGER.log(Level.INFO,"data is not saved,rolling back"+exp.getMessage());
			
		} finally {
			if (session != null) {
				LOGGER.log(Level.INFO,"Session Closed");
				
				session.close();
			} else {
				LOGGER.log(Level.INFO,"Session Not Closed");
			
			}
		}
		return false;
	}

	public SimpleApplicationEntity getEmailByEntity(String email,String password) {
		SimpleApplicationEntity enrollEntity = null;
		Object session = null;
		try {
			session = this.factory.openSession();
			Query<SimpleApplicationEntity> query = ((QueryProducer) session).createNamedQuery("GetRecordByMail");
			query.setParameter("em", email);
			query.setParameter("e", password);
			enrollEntity = (SimpleApplicationEntity) query.uniqueResult();
			return enrollEntity;
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.log(Level.INFO,"You have an exception " + e.getMessage());
			
			return null;
		} finally {
			if (session != null) {
				LOGGER.log(Level.INFO,"Session is closed");
				
			} else {
				LOGGER.log(Level.INFO,"Session is not closed");
				
			}
		}

	}

}