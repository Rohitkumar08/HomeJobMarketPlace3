package com.hmj.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.hmj.model.Member;
import com.hmj.util.HibernateUtil;

public class UserData {


	String hql;

	public boolean putUserData(Member mem){
		Session ses= HibernateUtil.getSession().openSession();
		//Tra
	//	Session session = HibernateUtil.
		System.out.println("*inside dao***");
		Transaction transaction  = ses.beginTransaction();
		ses.save(mem);
		transaction.commit();
		ses.close();
		
		System.out.println("successfully registered");
		return true;
	}
	
	
	
}
