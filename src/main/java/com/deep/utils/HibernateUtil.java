package com.deep.utils;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static SessionFactory sessionFactory;

	static {

		try {
			Configuration cfg = new Configuration();
			cfg.configure("hibernate.cfg.xml");
			sessionFactory = cfg.buildSessionFactory();
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public static Session getSession() {
		Session ses=null;
		if(sessionFactory!=null) {
			ses=sessionFactory.openSession();
		}
		return ses;
	}
	
	public static void closeSessionFactory() {
		
		if(sessionFactory!=null) {
			sessionFactory.close();
		}
	}
	
	public static void closeSession(Session ses) {
		if(ses!=null) {
			ses.close();
		}
	}
}
