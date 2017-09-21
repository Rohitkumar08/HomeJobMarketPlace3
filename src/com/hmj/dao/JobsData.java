package com.hmj.dao;



import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.hmj.enums.JobStatus;
import com.hmj.enums.Status;
import com.hmj.model.Applications;
import com.hmj.model.Jobs;
import com.hmj.model.SeekerActivity;
import com.hmj.model.Sitter;

import com.hmj.util.ActivityUtil;

import com.hmj.util.HibernateUtil;


public class JobsData {
	
	
	
	public int createJob(Jobs job, SeekerActivity seekerAct) {
		int id=0;
		try{
			
			Session ses= HibernateUtil.getSession().openSession();
			
			System.out.println("*inside dao***");
			Transaction transaction  = ses.beginTransaction();
			
			id=(int) ses.save(job);
			ses.save(seekerAct);
			transaction.commit();
			
			System.out.println("successfully Job created");
			
			ActivityUtil.add(job.getJobTitle()+" job created");
			
			return id;
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		return 0;
	}


	public List<Jobs> fetchSeekerJobs(int uid) {
		// TODO Auto-generated method stub
		System.out.println("ajay");
		List<Jobs> lst= new ArrayList<Jobs>();
		try {
			Session ses= HibernateUtil.getSession().openSession();
			
			System.out.println("*inside dao***");
			Query<Jobs> query=ses.createQuery("from Jobs where postedBy=:id and status=:status");
			query.setParameter("id", uid);
			query.setParameter("status", Status.ACTIVE);
			lst = query.list();
			
			System.out.println("wdfwwrfrwfwf");
			ses.close();
			
	return lst;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
		return lst;
	}

	public Jobs findDetailsOfJob(int jobId) {
		// TODO Auto-generated method stub
		
		ActivityUtil activityUtil=new ActivityUtil();
		try {
			Session ses= HibernateUtil.getSession().openSession();
		
			System.out.println("*inside dao***");
			Query query=ses.createQuery("from Jobs where id=:id");
			query.setParameter("id", jobId);
			List<Jobs> job=query.list();
		
				
				Jobs jb=job.get(0);
				
				
				ActivityUtil.add(jb.getJobTitle()+" details displayed");	
				System.out.println("inside dao"+jb.getJobTitle());
				return jb;
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}

	public boolean updateThisJob(int jobId, Jobs job, SeekerActivity seekerAct) {
		// TODO Auto-generated method stub
		
		try {
			Session ses= HibernateUtil.getSession().openSession();
		
			Transaction tx= ses.beginTransaction();
			System.out.println("*inside dao***");
			ses.merge(job);
			tx.commit();

			Transaction tx2= ses.beginTransaction();
			ses.save(seekerAct);
			tx2.commit();
			
			return true;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	public boolean deleteThisJob(int id, SeekerActivity seekerAct) {
		// TODO Auto-generated method stub
		
		try {
			Session ses= HibernateUtil.getSession().openSession();
			
			Transaction tx= ses.beginTransaction();
			System.out.println("*inside dao***");
			System.out.println(id);
			System.out.println();
			Query query=ses.createQuery("update Jobs set status=:new where id=:id ");
			
			query.setParameter("new", Status.INACTIVE);
			query.setParameter("id", id);
			int res=query.executeUpdate();
			
			query=ses.createQuery("update Applications set jobStatus=:new where jobs.id=:id ");
			
			query.setParameter("new", Status.DELETED);
			query.setParameter("id", id);
			query.executeUpdate();
			System.out.println("inside update dao     "+res);
			ses.save(seekerAct);
			tx.commit();
			ActivityUtil.add("selected job was deleted");
				return true;
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return false;
	}

	public List<Jobs> listAllJobsSitters(int uid) {
		// TODO Auto-generated method stub
		List<Applications> lst=null;
		List<Integer> jobsList=new ArrayList<>();
		List<Jobs> result=null;
		try {
			Session ses= HibernateUtil.getSession().openSession();
			System.out.println("*inside dao***");
			Query query=ses.createQuery("from Applications where sitter.id=:uid");
			query.setParameter("uid", uid);
			lst = query.list();

			
			for(Applications app:lst) 
				jobsList.add(app.getJobs().getId());
			if(jobsList.size()==0) {
				jobsList.add(0);
			}
			query=ses.createQuery("from Jobs where id not in (:jobsList) and status=:status");
			query.setParameter("jobsList", jobsList);
			query.setParameter("status", Status.ACTIVE);
			result=query.list();
			System.out.println(result.get(0).getJobTitle());
			
			
			return result;
				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	public List<Jobs> listAllJobs(int uid) {
		// TODO Auto-generated method stub
		
		List<Jobs> result=null;
		try {
			Session ses= HibernateUtil.getSession().openSession();
			System.out.println("*inside dao***");
			Query query=ses.createQuery("from Jobs where status=:status");
			query.setParameter("status", Status.ACTIVE);
			result=query.list();
			
			
			
			return result;
				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

	public int applyJobDao(int jobId, int uid) {
		// TODO Auto-generated method stub
	
		try {
			Session ses= HibernateUtil.getSession().openSession();
			Transaction tx= ses.beginTransaction();
			Query q= ses.createQuery("from Sitter where id=:uid");
			q.setParameter("uid", uid);
			List<Sitter> lst = q.list();
			
			Sitter sitter = lst.get(0);
			
			q= ses.createQuery("from Jobs where id=:jobId");
			q.setParameter("jobId", jobId);
			List<Jobs> lst1 = q.list();
			Jobs job = lst1.get(0);
			
			
			Applications app= new Applications();
			app.setExpectedPay(sitter.getExpectedPay());
			app.setJobs(job);
			app.setSitter(sitter);
			app.setStatus(Status.ACTIVE);
			app.setJobStatus(Status.ACTIVE);
			int res= (int) ses.save(app);
			
			System.out.println("applied successfully...."+res);
			tx.commit();

			return res;
			

				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}

	public List<Applications> fetchSitterApps(int uid) {
		// TODO Auto-generated method stub
		
		try {
			Session ses= HibernateUtil.getSession().openSession();
			Transaction tx= ses.beginTransaction();
			Query q= ses.createQuery("from Applications where sitter.id=:uid and status=:status");
			q.setParameter("uid", uid);
			q.setParameter("status", Status.ACTIVE);
			List<Applications> lst = q.list();
			

			return lst;
				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return null;
	}
//------------method for view all applicants-----
	public List<Applications> fetchSitterDetails(int uid, int jobId) {
		// TODO Auto-generated method stub
		
		try {
			Session ses= HibernateUtil.getSession().openSession();
			
			Query q= ses.createQuery("from Applications where jobs.id=:jobId");
			q.setParameter("jobId",	jobId);
			List<Applications> lst = q.list();
			System.out.println("&&&&&&&"+lst.size());
			return lst;

				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return null;
	}

	public boolean deleteThisAppDao(int jobId, int uid) {
		// TODO Auto-generated method stub
		try {
			Session ses= HibernateUtil.getSession().openSession();
			Transaction tx= ses.beginTransaction();
			Query q= ses.createQuery("update Applications set status=:status where jobs.id=:jobId and sitter.id=:sid");
			q.setParameter("status",	Status.INACTIVE);
			q.setParameter("jobId",	jobId);
			q.setParameter("sid",uid);
			q.executeUpdate();
			
			tx.commit();
		
			return true;
			
	}catch(Exception e) {
		
		return false;
	}
		

	}
}
