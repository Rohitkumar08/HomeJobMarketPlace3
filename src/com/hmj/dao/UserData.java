package com.hmj.dao;


import java.util.Iterator;

import java.util.ArrayList;
import java.util.List;


import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.hmj.model.Jobs;
import com.hmj.model.Member;
import com.hmj.model.Seeker;
import com.hmj.model.Sitter;
import com.hmj.util.*;

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
		
		ActivityUtil.add("Seeker profile created");
		
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
		ActivityUtil.add("Seeker profile created");
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
	public Member getMemberDetailsDao(int uid) {
		// TODO Auto-generated method stub
		Session ses= HibernateUtil.getSession().openSession();
		
		Query query = ses.createQuery("from Member where id=:e");
		query.setParameter("e", uid);
		Member seeker= (Member) query.uniqueResult();
		return seeker;
	
	}
	public void deleteMember(Member mem) {
		// TODO Auto-generated method stub
		try {
			Session ses= HibernateUtil.getSession().openSession();
			//Tra
		//	Session session = HibernateUtil.
			Transaction tx1= ses.beginTransaction();
			ses.saveOrUpdate(mem);
			System.out.println("inside member update");
			tx1.commit();
			
			Transaction tx2 =ses.beginTransaction();
			Query q= ses.createQuery("update Jobs set status=:status where postedBy=:uid");
			q.setParameter("status", "INACTIVE");
			q.setParameter("uid", mem.getId());
			q.executeUpdate();
			tx2.commit();
	
		}catch(Exception e) {
			
		}
	}

	public Seeker getUserDetailsDao(int uid) {
		// TODO Auto-generated method stub
		Session ses= HibernateUtil.getSession().openSession();
		
		Query query = ses.createQuery("from Seeker where id=:e");
		query.setParameter("e", uid);
		Seeker seeker= (Seeker) query.uniqueResult();
		
		return seeker;
	
	}

	public int updateSeekerDetails(Seeker seeker, int uid) {
		// TODO Auto-generated method stub
		try {
			Session ses= HibernateUtil.getSession().openSession();
			//Tra
		//	Session session = HibernateUtil.
			Transaction tx1= ses.beginTransaction();
			System.out.println("*inside seeker dao***");
			System.out.println(seeker.getFirstName()+"*************"+seeker.getPhone());
			
			Query query1=ses.createQuery("update Member set firstName=:name, phone=:phone where id=:uid");
			query1.setParameter("name", seeker.getFirstName());
			query1.setParameter("phone", seeker.getPhone());
			query1.setParameter("uid", uid);
			int res1=query1.executeUpdate();
			tx1.commit();
			
			System.out.println(seeker.getSpouseName()+"****************"+seeker.getNoOfChilds());
			Transaction tx= ses.beginTransaction();
			Query query=ses.createQuery("update Seeker set noOfChilds=:noOfChilds,spouseName=:spouseName where id=:uid");
			query.setParameter("noOfChilds", seeker.getNoOfChilds());
			query.setParameter("spouseName", seeker.getSpouseName());
			query.setParameter("uid", uid);
			
			System.out.println("befire execute update statement");
			int res=query.executeUpdate();
			System.out.println("inside update dao     "+res);
			tx.commit();
			
			ActivityUtil.add("Seeker profile updated");
				return res;
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return 0;
	}

	public int deleteSeeker(int uid, String email) {
		// TODO Auto-generated method stub
		try {
			Session ses= HibernateUtil.getSession().openSession();
			//Tra
		//	Session session = HibernateUtil.
			Transaction tx1= ses.beginTransaction();
			System.out.println("*inside seeker dao***");
			String pipedEmail=email.concat("|");
			System.out.println(pipedEmail+"***"+uid);
			Query query1=ses.createQuery("update Member set status=:ustatus, email=:uemail where id=:uid");
			query1.setParameter("ustatus", "INACTIVE");
			query1.setParameter("uid", uid);
			query1.setParameter("uemail", pipedEmail);
			int res1=query1.executeUpdate();
			System.out.println("inside member update");
			tx1.commit();
			
			Transaction tx= ses.beginTransaction();
			Query query=ses.createQuery("update Jobs set status=:status where postedBy=:uid");
			query.setParameter("status", "INACTIVE");
			query.setParameter("uid", uid);
			System.out.println("befire execute update statement");
			int res=query.executeUpdate();
			System.out.println("inside update dao"+res);
			tx.commit();
			System.out.println("outside job update");	
			return res;
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public Sitter getSitterUserDetailsDao(int uid) {
		// TODO Auto-generated method stub
		Session ses= HibernateUtil.getSession().openSession();
		
		Query query = ses.createQuery("from Sitter where id=:e");
		query.setParameter("e", uid);
		Sitter sitter= (Sitter) query.uniqueResult();
		return sitter;
	
	}

	public int updateSitterDetails(Sitter sitter, int uid) {
		// TODO Auto-generated method stub
		try {
			Session ses= HibernateUtil.getSession().openSession();
			//Tra
		//	Session session = HibernateUtil.
			Transaction tx1= ses.beginTransaction();
			System.out.println("*inside sitter dao***");
			System.out.println(sitter.getFirstName()+"*************"+sitter.getPhone());
			
			Query query1=ses.createQuery("update Member set firstName=:name, phone=:phone where id=:uid");
			query1.setParameter("name", sitter.getFirstName());
			query1.setParameter("phone", sitter.getPhone());
			query1.setParameter("uid", uid);
			int res1=query1.executeUpdate();
			tx1.commit();
			
			Transaction tx= ses.beginTransaction();
			Query query=ses.createQuery("update Sitter set expectedPay=:expectedPay,yearsOfExperience=:yoe where id=:uid");
			query.setParameter("expectedPay", sitter.getExpectedPay());
			query.setParameter("yoe", sitter.getYearsOfExperience());
			query.setParameter("uid", uid);
			
			System.out.println("befire execute update statement");
			int res=query.executeUpdate();
			System.out.println("inside update dao     "+res);
			tx.commit();
				return res;
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return 0;
	}

	public List<Member> getSearchedEmails(String keyWord) {
		// TODsO Auto-generated method stub
		List<Member> mem =null;
		Session ses= HibernateUtil.getSession().openSession();
		System.out.println(keyWord);
		
		Query query = ses.createQuery("from Member where email LIKE :keyword and memberType=:utype and status=:status");
		query.setParameter("keyword", "%"+keyWord+"%");
		query.setParameter("utype", "Seeker");
		query.setParameter("status", "ACTIVE");
		mem= query.list();
		System.out.println("$$$$$$$$$$$$$$"+mem.get(0).getEmail());
		ActivityUtil.add("Seeker email searched");
		return mem;

		
	}

	public int deleteSitter(int uid, String email) {
		// TODO Auto-generated method stub
		
		try {
			Session ses= HibernateUtil.getSession().openSession();
			//Tra
		//	Session session = HibernateUtil.
			Transaction tx1= ses.beginTransaction();
			System.out.println("*inside sitter dao***");
			String pipedEmail=email.concat("|");
			System.out.println(pipedEmail+"***"+uid);
			Query query1=ses.createQuery("update Member set status=:ustatus, email=:uemail where id=:uid");
			query1.setParameter("uid", uid);
			query1.setParameter("ustatus", "INACTIVE");
			query1.setParameter("uemail", pipedEmail);
			int res1=query1.executeUpdate();
			System.out.println("inside member update");
			tx1.commit();
			
			Transaction tx= ses.beginTransaction();
			query1=ses.createQuery("update Applications set status=:ustatus where sitter.id=:uid");
			query1.setParameter("uid", uid);
			query1.setParameter("ustatus", "INACTIVE");
			query1.executeUpdate();
			System.out.println("inside application update");
			tx.commit();
//			Transaction tx= ses.beginTransaction();
//			Query query=ses.createQuery("update Jobs set status=:status where postedBy=:uid");
//			query.setParameter("status", "INACTIVE");
//			query.setParameter("uid", uid);
//			System.out.println("befire execute update statement");
//			int res=query.executeUpdate();
//			System.out.println("inside update dao"+res);
//			tx.commit();
//			System.out.println("outside job update");	
//			return res;
			
			return res1;
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	
	
	
	
}
