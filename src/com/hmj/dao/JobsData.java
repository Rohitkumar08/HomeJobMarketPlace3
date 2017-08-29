package com.hmj.dao;
import java.text.ParseException;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.hmj.FormBeans.*;
import com.hmj.model.Applications;
import com.hmj.model.Jobs;
import com.hmj.model.SeekerActivity;
import com.hmj.model.Sitter;
import com.hmj.service.*;
import com.hmj.util.ActivityUtil;
import com.hmj.util.FactoryUtil;
import com.hmj.util.HibernateUtil;

public class JobsData {
	
	
	
	public int createJob(Jobs job, SeekerActivity seekerAct) {
		int id=0;
		try{
			
			Session ses= HibernateUtil.getSession().openSession();
			//Tra
		//	Session session = HibernateUtil.
			System.out.println("*inside dao***");
			Transaction transaction  = ses.beginTransaction();
			
			id=(int) ses.save(job);
			ses.save(seekerAct);
			transaction.commit();
			
			System.out.println("successfully Job created");
			
			ActivityUtil.add(job.getJobTitle()+" job created");
			
			return id;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		return 0;
	}

//	public void updateJob(String job_title, String updateParameter) {
		// TODO Auto-generated method stub
//		sql = "update "
		
		
		
		
//	}
	
//	public List<Jobs> listAllJobs(int uid) {
//		// TODO Auto-generated method stub
//		
//		String sql = "select * from Jobs where posted_by=? and status='ACTIVE'";
//		List<Jobs>  jobs= new ArrayList<>();
//		
//		try {
//			ps= connect.prepareStatement(sql);
//			ps.setInt(1,uid);
//			ResultSet rs = ps.executeQuery();
//			
//			while(rs.next()){
//				//Jobs jb= (Jobs) FactoryUtil.mapClassInstance.get(FactoryUtil.JOBS);
//				Jobs jb=new Jobs();
//				jb.setJobTitle(rs.getString("job_title"));
//				jb.setStartDate(rs.getString("start_date"));
//				jb.setEndDate(rs.getString("end_date"));
//				jb.setStartTime(rs.getString("start_time"));
//				jb.setEndTime(rs.getString("end_time"));
//				jb.setPayPerHour(rs.getInt("pay_per_hour"));
//				jobs.add(jb);
//				System.out.println("inside dao"+jb.getJobTitle());
//				
//			}
//			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return jobs;
//		
//	}
//	public List<Jobs> listAllJobsForSeekers() {
//		// TODO Auto-generated method stub
//		
//		String sql = "select * from Jobs where status='ACTIVE' ";
//		List<Jobs>  jobs= new ArrayList<>();
//		
//		try {
//			ps= connect.prepareStatement(sql);
//			ResultSet rs = ps.executeQuery();
//			
//			while(rs.next()){
//				//Jobs jb= (Jobs) FactoryUtil.mapClassInstance.get(FactoryUtil.JOBS);
//				Jobs jb=new Jobs();
//				jb.setJobTitle(rs.getString("job_title"));
//				jb.setStartDate(rs.getString("start_date"));
//				jb.setEndDate(rs.getString("end_date"));
//				jb.setStartTime(rs.getString("start_time"));
//				jb.setEndTime(rs.getString("end_time"));
//				jb.setPayPerHour(rs.getInt("pay_per_hour"));
//				jobs.add(jb);
//				System.out.println("inside dao"+jb.getJobTitle());
//				
//			}
//			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return jobs;
//		
//	}
//
//	public boolean deleteJob(String job_title, int uid) {
//		
//		// TODO Auto-generated method stub
//		int posted_By=0;
//		sql = "select posted_by from Jobs where job_title= ?";
//		try {
//			ps = connect.prepareStatement(sql);
//			ps.setString(1, job_title);
//			ResultSet rs = ps.executeQuery();
//			while(rs.next()){
//				posted_By = rs.getInt("posted_by");
//				System.out.println("Posted by:    "+posted_By);
//			}
//			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		if(posted_By == uid){
//			
//			sql = "delete from Jobs where job_title= ?";
//			try {
//				ps = connect.prepareStatement(sql);
//				ps.setString(1, job_title);
//				ps.executeUpdate();
//				
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		
//		}
//		else
//			return false;
//		
//		return true;
//		
//	
//	}
//
//	public boolean updateJobTitle(String currentJobTitle, String newJobTitle) {
//		// TODO Auto-generated method stub
//		sql = "update Jobs set job_title =? where job_title = ?";
//		try {
//			ps = connect.prepareStatement(sql);
//			ps.setString(1, newJobTitle);
//			ps.setString(2, currentJobTitle);
//			ps.executeUpdate();
//			return true;
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return false;
//		
//	}
//
//	public boolean updateJobStart(String job_title, String newStartDate) {
//		// TODO Auto-generated method stub
//		sql = "update Jobs set start_date = ? where job_title = ?";
//		try {
//			ps = connect.prepareStatement(sql);
//			ps.setString(1, newStartDate);
//			ps.setString(2, job_title);
//			ps.executeUpdate();
//			return true;
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return false;
//	}
//
//	public boolean updateJobEnds(String job_title, String newEndDate) {
//		// TODO Auto-generated method stub
//		sql = "update Jobs set end_date = ? where job_title = ?";
//		try {
//			ps = connect.prepareStatement(sql);
//			ps.setString(1, newEndDate);
//			ps.setString(2, job_title);
//			ps.executeUpdate();
//			return true;
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return false;
//	}
//
//	public boolean deleteThisJob(int uid, String jobTitle) {
//		// TODO Auto-generated method stub
//		int posted_By=0;
//		sql = "select posted_by from Jobs where job_title= ?";
//		try {
//			ps = connect.prepareStatement(sql);
//			ps.setString(1, jobTitle);
//			ResultSet rs = ps.executeQuery();
//			while(rs.next()){
//				posted_By = rs.getInt("posted_by");
//				System.out.println("Posted by:    "+posted_By);
//			}
//			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		if(posted_By == uid){
//			
//			sql = "update Jobs set status='INACTIVE' where job_title=?";
//			try {
//				ps = connect.prepareStatement(sql);
//				ps.setString(1, jobTitle);
//				ps.executeUpdate();
//				
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		
//		}
//		else
//			return false;
//		
//		
//		return true;
//	}
//
	public List<Jobs> fetchSeekerJobs(int uid) {
		// TODO Auto-generated method stub
		
		List<Jobs> lst=null;
		try {
			Session ses= HibernateUtil.getSession().openSession();
			//Tra
		//	Session session = HibernateUtil.
			System.out.println("*inside dao***");
			Query query=ses.createQuery("from Jobs where postedBy=:id and status=:status");
			query.setParameter("id", uid);
			query.setParameter("status", "ACTIVE");
			lst = query.list();
			
			
			ses.close();
			
			System.out.println("successfully Job created");
			System.out.println(lst.size());
			return lst;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
		return lst;
	}
//	public List<Jobs> getAppliedJobs(int uid) {
//		// TODO Auto-generated method stub
//		String sql = "select * from Jobs where job_id IN (select jobId from Application where member_id=?) and status='ACTIVE'";
//         List<Jobs>  jobApplied= new ArrayList<>();
//		
//		try {
//			ps= connect.prepareStatement(sql);
//			ps.setInt(1, uid);
//			ResultSet rs = ps.executeQuery();
//			
//			while(rs.next()){
//				Jobs jb=new Jobs();
//				jb.setJobTitle(rs.getString("job_title"));
//				jb.setStartDate(rs.getString("start_date"));
//				System.out.println("*************"+jb.getStartDate());
//				jb.setEndDate(rs.getString("end_date"));
//				jb.setStartTime(rs.getString("start_time"));
//				jb.setEndTime(rs.getString("end_time"));
//				jb.setPayPerHour(rs.getInt("pay_per_hour"));
//				
//				jobApplied.add(jb);
//			
//			}
//			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return jobApplied;
//	
//	}
//
	public Jobs findDetailsOfJob(int jobId) {
		// TODO Auto-generated method stub
		
		
		try {
			Session ses= HibernateUtil.getSession().openSession();
			//Tra
		//	Session session = HibernateUtil.
			System.out.println("*inside dao***");
			Query query=ses.createQuery("from Jobs where id=:id");
			query.setParameter("id", jobId);
			List<Jobs> job=query.list();
		
				
				Jobs jb=job.get(0);
				
				//jobs.add(jb);
				ActivityUtil.add(jb.getJobTitle()+" details displayed");	
				System.out.println("inside dao"+jb.getJobTitle());
				return jb;
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
//
//	public boolean updateJobTitle(String newJobTitle) {
//		// TODO Auto-generated method stub
//		Jobs job = new Jobs();
//		sql = "update Jobs set job_title =? where job_title = ?";
//		try {
//			ps = connect.prepareStatement(sql);
//			ps.setString(1, newJobTitle);
//			System.out.println("****************"+ job.getJobTitle());
//			ps.setString(2, job.getJobTitle());
//			
//			ps.executeUpdate();
//			return true;
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return false;
//		
//		
//		
//	}
//	public int getExpectedPay(int user_id){
//		String sql = "select expected_pay from sitter where sitter_id = ?";
//		int expected_pay = 0;
//		try {
//			ps= connect.prepareStatement(sql);
//			ps.setInt(1, user_id);
//			ResultSet rs = ps.executeQuery();
//			
//			while(rs.next()){
//				expected_pay = rs.getInt("expected_pay");
//			}
//			return expected_pay;
//		  } catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return expected_pay;
//	}
//	
//	
//	public int getJobId(String jobTitle){
//		String sql = "select job_id from jobs where job_title = ?";
//		int jobId = 0;
//		try {
//			ps= connect.prepareStatement(sql);
//			ps.setString(1, jobTitle);
//			ResultSet rs = ps.executeQuery();
//			
//			while(rs.next()){
//				jobId = rs.getInt("job_id");
//			}
//			
//			return jobId;
//		  } catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		
//		return 1;
//	}
//
//	public boolean applyThisJobDao(String jobTitle, int uid, int jobId) {
//		// TODO Auto-generated method stub
//		int expected_pay=getExpectedPay(uid);
//		String sql = "insert into Application(jobId, Expected_pay, member_id) values(?, ? , ?)";
//		
//		try {
//			ps= connect.prepareStatement(sql);
//			ps.setInt(1, jobId);
//			ps.setInt(2, expected_pay);
//			ps.setInt(3, uid);
//			ps.executeUpdate();
//		
//			return true;
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			return false;
//		}
//		
//	}
//
//	public boolean deleteThisAppDao(String jobTitle, int uid, int jobId) {
//		// TODO Auto-generated method stub
//		String sql = "delete from Application where jobId =(select job_id from Jobs where job_title=?) AND member_id=?";
//		try {
//			ps= connect.prepareStatement(sql);
//			ps.setString(1, jobTitle);
//			ps.setInt(2, uid);
//			ps.executeUpdate();
//			return true;
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			
//			e.printStackTrace();
//			return false;			
//		}
//		
//		
//		
//	}
//
//	public boolean updateTheseJobDetails(Jobs job, String oldJobTitle) {
//		// TODO Auto-generated method stub
//		
//		sql = "update Jobs set job_title =?, start_date=?, end_date=?, pay_per_hour=? where job_title = ?";
//		try {
//			ps = connect.prepareStatement(sql);
//			ps.setString(1, job.getJobTitle());
//			ps.setString(2, job.getStartDate());
//			ps.setString(3, job.getEndDate());
//			ps.setInt(4, job.getPayPerHour());
////			ps.setString(5, job.getStatus());
//			System.out.println("****************"+ job.getJobTitle());
//			ps.setString(6, oldJobTitle);
//			
//			ps.executeUpdate();
//			return true;
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		
//		
//		return false;
//	}

	public boolean updateThisJob(int jobId, Jobs job, SeekerActivity seekerAct) {
		// TODO Auto-generated method stub
		
		try {
			Session ses= HibernateUtil.getSession().openSession();
			//Tra
		//	Session session = HibernateUtil.
			Transaction tx= ses.beginTransaction();
			System.out.println("*inside dao***");
			Query query=ses.createQuery("update Jobs set jobTitle=:jobTitle, startDate=:startDate, endDate=:endDate, startTime=:startTime, endTime=:endTime, payPerHour=:payPerHour where id=:jobId");
			query.setParameter("jobId", jobId);
			query.setParameter("jobTitle", job.getJobTitle());
			query.setParameter("startDate", job.getStartDate());
			query.setParameter("endDate", job.getEndDate());
			query.setParameter("startTime", job.getStartTime());
			query.setParameter("endTime", job.getEndTime());
			query.setParameter("payPerHour", job.getPayPerHour());
			System.out.println("befire execute update statement");
			int res=query.executeUpdate();
			System.out.println("inside update dao     "+res);
			ses.save(seekerAct);
			tx.commit();
			
			ActivityUtil.add(job.getJobTitle()+" Job profile updated");
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
			//Tra
		//	Session session = HibernateUtil.
			Transaction tx= ses.beginTransaction();
			System.out.println("*inside dao***");
			System.out.println(id);
			System.out.println();
			Query query=ses.createQuery("update Jobs set status=:new where id=:id ");
			
			query.setParameter("new", "INACTIVE");
			query.setParameter("id", id);
			int res=query.executeUpdate();
			
			query=ses.createQuery("update Applications set status=:new where jobs.id=:id ");
			
			query.setParameter("new", "INACTIVE");
			query.setParameter("id", id);
			query.executeUpdate();
			System.out.println("inside update dao     "+res);
			ses.save(seekerAct);
			tx.commit();
			ActivityUtil.add("selected job was deleted");
				return true;
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
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
			Transaction tx= ses.beginTransaction();
			System.out.println("*inside dao***");
			Query query=ses.createQuery("from Applications where sitter.id=:uid");
			query.setParameter("uid", uid);
			lst = query.list();
//			System.out.println("list of sitters "+lst.get(0).getJobs().getId());
			
			for(Applications app:lst) 
				jobsList.add(app.getJobs().getId());
			
			query=ses.createQuery("from Jobs where id not in(:jobsList)");
			query.setParameter("jobsList", jobsList);
			result=query.list();
			
			
			
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
			Transaction tx= ses.beginTransaction();
			System.out.println("*inside dao***");
			Query query=ses.createQuery("from Jobs where status=:status");
			query.setParameter("status", "ACTIVE");
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
			int res= (int) ses.save(app);
			System.out.println(res);
			tx.commit();
			ActivityUtil.add("applied to a new job"+job.getJobTitle());
			return res;
			
//			int expectedPay=sitter.getExpectedPay();
//			System.out.println(expectedPay);
//			Transaction tx= ses.beginTransaction();
//			System.out.println("*inside dao***");
//			Query query=ses.createSQLQuery("insert into Application(jobId, expectedPay, uid) values(:jobId, :expectedPay, :uid)");
//			query.setParameter("jobId", jobId);
//			query.setParameter("uid", uid);
//			query.setParameter("expectedPay", expectedPay);
//			int res= query.executeUpdate();
//			tx.commit();
//			return res;
				
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
			q.setParameter("status", "ACTIVE");
			List<Applications> lst = q.list();
			
//			for(Applications app: lst) {
//				int jobId= app.getJobId();
//				System.out.println("****************"+jobId+"*******");
//				q= ses.createQuery("from Jobs where id=:jobId");
//				q.setParameter("jobId", jobId);
//				List<Jobs> tmpJob= q.list();
//				Jobs job= tmpJob.get(0);
//				lstJob.add(job);
//			}
//			
			ActivityUtil.add("sitter applications fetched");
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
		List<Sitter> allSitters=null;
		List<Integer> sitters=null;
		try {
			Session ses= HibernateUtil.getSession().openSession();
			Transaction tx= ses.beginTransaction();
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
			q.setParameter("status",	"INACTIVE");
			q.setParameter("jobId",	jobId);
			q.setParameter("sid",uid);
			q.executeUpdate();
			
			tx.commit();
			ActivityUtil.add("Job Application was deleted");
			return true;
			
	}catch(Exception e) {
		
		return false;
	}
		

	}
}
