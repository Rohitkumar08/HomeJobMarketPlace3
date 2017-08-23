package com.hmj.dao;

import java.awt.List;
import java.util.Iterator;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.hmj.model.Member;
import com.hmj.model.Seeker;
import com.hmj.model.Sitter;
import com.hmj.util.HibernateUtil;

public class UserData {


	String hql;

	public int getID(String email) {
		// TODO Auto-generated method stub
		
		return 0;
	}

	public int registerSeeker(Seeker seeker) {
		// TODO Auto-generated method stub
		
		Session ses= HibernateUtil.getSession().openSession();
		//Tra
	//	Session session = HibernateUtil.
		System.out.println("*inside dao***");
		Transaction transaction  = ses.beginTransaction();
		
		int id=(int) ses.save(seeker);
		
		transaction.commit();
		ses.close();
		
		System.out.println("successfully registered seeker");
		return id;
	}

	public int registerSitter(Sitter sitter) {
		// TODO Auto-generated method stub
		Session ses= HibernateUtil.getSession().openSession();
		//Tra
	//	Session session = HibernateUtil.
		System.out.println("*inside dao***");
		Transaction transaction  = ses.beginTransaction();
		int id=(int) ses.save(sitter);
		
		transaction.commit();
		ses.close();
		
		System.out.println("successfully registered sitter");
		return id;
	}


	public boolean checkEmail(String email) {
		int count=0;
		System.out.println("**"+email);
		Session ses= HibernateUtil.getSession().openSession();
		String hql = "from com.hmj.model.Member m where m.email=:e";
		Query query = ses.createQuery(hql);
		query.setParameter("e",email);
		Member mem=(Member) query.uniqueResult();
		System.out.println(mem);
		if(mem==null){
			return false;
		}
		else{
				return true;
			
		}
	}

	public Member getPassword(String email) {
		// TODO Auto-generated method stub
		Session ses= HibernateUtil.getSession().openSession();
		hql="from Member where email=:e";
		Query query = ses.createQuery(hql);
		query.setParameter("e", email);
		Member mem= (Member) query.uniqueResult();
		return mem;
	
	}

	
	
	
	
}
