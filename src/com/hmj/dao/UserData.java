package com.hmj.dao;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.hmj.enums.Status;
import com.hmj.model.Jobs;
import com.hmj.model.Member;
import com.hmj.model.Seeker;
import com.hmj.model.SeekerActivity;
import com.hmj.model.Sitter;
import com.hmj.service.MemberServiceImp;
import com.hmj.util.*;

public class UserData {


	String hql;
	

	public int getID(String email) {
		// TODO Auto-generated method stub
		
		return 0;
	}

	public int registerSeeker(Seeker seeker) {
		// TODO Auto-generated method stub
		Session  ses=null;
		try {
	
		ses= HibernateUtil.getSession().openSession();
		Transaction transaction  = ses.beginTransaction();
		int id=(int) ses.save(seeker);
		transaction.commit();
		
		SeekerActivity seekerAct =new SeekerActivity();
		seekerAct.setUid(id);
		seekerAct.setMessage("Seeker Profile Created");
		Transaction transaction2  = ses.beginTransaction();
		ses.save(seekerAct);
		transaction2.commit();
		ses.close();
		System.out.println("successfully registered seeker");
		return id;
		}catch(Exception e ) {
			e.printStackTrace();
			return 0;
		}finally {
			ses.close();
		}
		
	}

	public int registerSitter(Sitter sitter) {
		Session  ses=null;
		try {
			
		
		ses= HibernateUtil.getSession().openSession();
		System.out.println("*inside dao***");
		Transaction transaction  = ses.beginTransaction();
		int id=(int) ses.save(sitter);
		
		transaction.commit();
		ses.close();
		System.out.println("successfully registered sitter");
		return id;
		}catch(Exception e ) {
			return 0;
		}
		finally {
			
			ses.close();
		}
	}

	@SuppressWarnings({ "rawtypes" })
	public boolean checkEmail(String email) {
		System.out.println("**"+email);
		
		Session  ses=null;
		try {
			
		
		ses= HibernateUtil.getSession().openSession();
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
		}catch(Exception e) {
			return false;
			
		}finally {
			ses.close();
		}
	}
	@SuppressWarnings({ "rawtypes" })
	public Member getPassword(String email) {
		// TODO Auto-generated method stub
		Session  ses=null;
		Member mem=(Member) FactoryUtil.mapClassInstance.get(FactoryUtil.MEMBER);
		
		try {
			
		
		ses= HibernateUtil.getSession().openSession();
		hql="from Member where email=:e and status=:status";
		Query query = ses.createQuery(hql);
		query.setParameter("e", email);
		query.setParameter("status", Status.ACTIVE);
		mem= (Member) query.uniqueResult();
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}finally {
			
			ses.close();
		}
		return mem;
	}
	
	@SuppressWarnings("rawtypes")
	public Member getMemberDetailsDao(int uid) {
		// TODO Auto-generated method stub
		Session  ses=null;
		Member seeker=(Member) FactoryUtil.mapClassInstance.get(FactoryUtil.MEMBER);
		try {
			
		
		ses= HibernateUtil.getSession().openSession();
		Query query = ses.createQuery("from Member where id=:e");
		query.setParameter("e", uid);
		seeker= (Member) query.uniqueResult();
		
		}catch(Exception e) {
			e.printStackTrace();
			
		}finally {
			ses.close();
		}
		return seeker;
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void deleteMember(Member mem) {
		// TODO Auto-generated method stub
		List<Integer> jobIds=new ArrayList<>();
		Session ses=null;
		try {
			ses= HibernateUtil.getSession().openSession();
			//Tra
		//	Session session = HibernateUtil.
			Transaction tx1= ses.beginTransaction();
			ses.saveOrUpdate(mem);
			System.out.println("inside member update");
			tx1.commit();
			
			Query q= ses.createQuery("from Jobs where postedBy=:uid");
			q.setParameter("uid", mem.getId());
			List<Jobs> jobs=q.list();
			System.out.println(jobs);
			jobIds.clear();
			if(jobs!=null) {
				
				for(Jobs job:jobs) {
					System.out.println(job.getId()+"*****");
					jobIds.add(job.getId());
					
				}
				
			}
				Transaction tx2 =ses.beginTransaction();
				 Query q2= ses.createQuery("update Jobs set status=:status where postedBy=:uid");
				q2.setParameter("status", "INACTIVE");
				q2.setParameter("uid", mem.getId());
				q2.executeUpdate();
				tx2.commit();
				
		
				Transaction tx3 =ses.beginTransaction();
				Query q3= ses.createQuery("update Applications set jobStatus=:status where jobs.id in (:jobIds)");
				q3.setParameter("status", "DELETED");
				q3.setParameter("jobIds", jobIds);
				q3.executeUpdate();
				tx3.commit();
				
	
			
			SeekerActivity seekerAct = new SeekerActivity();
			seekerAct.setUid(mem.getId());
			seekerAct.setMessage(mem.getFirstName()+" deleted his profile");
			ses.save(seekerAct);
	
		}catch(Exception e) {
			
		}
		finally {
			ses.close();
		}
	}

	@SuppressWarnings("rawtypes")
	public Seeker getUserDetailsDao(int uid) {
		// TODO Auto-generated method stub
		Session ses=null;
		 Seeker seeker =(Seeker) FactoryUtil.mapClassInstance.get(FactoryUtil.SEEKER); 
		try {
			ses= HibernateUtil.getSession().openSession();
		Query query = ses.createQuery("from Seeker where id=:e");
		query.setParameter("e", uid);
		seeker= (Seeker) query.uniqueResult();
		
		
		}catch(Exception e) {
			e.printStackTrace();
			
		}finally {
			ses.close();
		}
		return seeker;
	}

	public boolean updateSeekerDetails(Member mem,Seeker seeker, int uid) {
		// TODO Auto-generated method stub
		Session  ses=null;
		try {
		ses= HibernateUtil.getSession().openSession();
		
			Transaction tx= ses.beginTransaction();
			ses.merge(mem);
			tx.commit();
			
			Transaction tx1= ses.beginTransaction();
			
			ses.merge(seeker);
			tx1.commit();

			SeekerActivity seekerAct =new SeekerActivity();
			seekerAct.setUid(uid);
			seekerAct.setMessage("Seeker Profile Updated");

			Transaction transaction2  = ses.beginTransaction();
			
			ses.save(seekerAct);
			transaction2.commit();
			
			return true;
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return false;
		}
		finally {
			ses.close();
		}
	
	}


	@SuppressWarnings("rawtypes")
	public Sitter getSitterUserDetailsDao(int uid) {
		// TODO Auto-generated method stub
		Session  ses= null;
		 Sitter sitter = (Sitter) FactoryUtil.mapClassInstance.get(FactoryUtil.SITTER);
		try {
			ses= HibernateUtil.getSession().openSession();

		Query query = ses.createQuery("from Sitter where id=:e");
		query.setParameter("e", uid);
		sitter= (Sitter) query.uniqueResult();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
			ses.close();
			
		}
		return sitter;
	
	}

	public boolean updateSitterDetails(Member mem, Sitter sitter, int uid) {
		// TODO Auto-generated method stub
		Session  ses= null;
		try {
			ses= HibernateUtil.getSession().openSession();

			Transaction tx1= ses.beginTransaction();
			System.out.println("*inside sitter dao***");
			ses.merge(mem);
			tx1.commit();
			
			Transaction tx= ses.beginTransaction();
			ses.merge(sitter);
			tx.commit();
	
		return true;

		} catch (Exception e) {
			// TODO Auto-generated catch block
		return false;
		}
		finally {
			ses.close();
		}
	
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<Member> getSearchedEmails(String keyWord) {
		// TODsO Auto-generated method stub
		List<Member> mem =null;
		Session  ses= null;
		try {
			ses= HibernateUtil.getSession().openSession();

		System.out.println(keyWord);
		
		Query query = ses.createQuery("from Member where email LIKE :keyword and memberType=:utype and status=:status");
		query.setParameter("keyword", "%"+keyWord+"%");
		query.setParameter("utype", "Seeker");
		query.setParameter("status", Status.ACTIVE);
		mem= query.list();
		return mem;
		}
		catch(Exception e) {
		
			return null;
		}
		finally {
			ses.close();
		}
		
	}

	@SuppressWarnings("rawtypes")
	public int deleteSitter(int uid, String email) {
		// TODO Auto-generated method stub
		Session ses=null;
		try {
			ses= HibernateUtil.getSession().openSession();
	
			Transaction tx1= ses.beginTransaction();
			System.out.println("*inside sitter dao***");
			String pipedEmail=email.concat(""+uid);
			System.out.println(pipedEmail+"***"+uid);
			Query query1=ses.createQuery("update Member set status=:ustatus, email=:uemail where id=:uid");
			query1.setParameter("uid", uid);
			query1.setParameter("ustatus", Status.INACTIVE);
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
			return res1;
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			ses.close();
		}
		return 0;
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SeekerActivity> getUserActivity(int uid) {
		// TODO Auto-generated method stub
		Session ses= null;
		try {
			ses= HibernateUtil.getSession().openSession();
			Query query = ses.createQuery("from SeekerActivity where uid=:e");
			query.setParameter("e", uid);
		
			List<SeekerActivity> result=query.list();
			
			return result;
		
		}
		catch(Exception e) {
			return null;
		}finally {
			ses.close();
		}

	}

	@SuppressWarnings({ "rawtypes", "unchecked", "deprecation" })
	public List<Member> getAllUsers() {
		// TODO Auto-generated method stub
		Session ses= null;
		try {
			ses= HibernateUtil.getSession().openSession();
			Query query = ses.createQuery("from Member");
		
			List<Member> result=query.list();
			System.out.println("inside dao api");
			System.out.println(result.get(0).getFirstName());
			return result;
		
		}
		catch(Exception e) {
			return null;
		}finally {
			ses.close();
		}
		
	}

	public Member getUserDetailsDaoAPI(int uid) {
		// TODO Auto-generated method stub
		Session ses=null;
		 Member mem= (Member) FactoryUtil.mapClassInstance.get(FactoryUtil.MEMBER);

		try {
			ses= HibernateUtil.getSession().openSession();
		Query query = ses.createQuery("from Member where id=:e");
		query.setParameter("e", uid);
		mem= (Member) query.uniqueResult();
		
		
		}catch(Exception e) {
			e.printStackTrace();
			
		}finally {
			ses.close();
		}
		return mem;
		
	}
}
