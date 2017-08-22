package com.hmj.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static Session ses=null;
	private static SessionFactory factory;
	
	static{
		
			factory=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	}
	public static SessionFactory getSession(){
		return factory;
//		Session ses=factory.openSession();
//		return ses;
	
	}
	
	
	public static void closeSession(){
		
		ses.close();
	}
	
	public static void closeSessionFactory(){
		factory.close();
	}

}
