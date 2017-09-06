package com.hmj.service;



import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;



import com.hmj.dao.JobsData;
import com.hmj.model.*;
import com.hmj.util.FactoryUtil;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;


public class JobServiceImp {

	Sitter sitter=(Sitter) FactoryUtil.mapClassInstance.get(FactoryUtil.SITTER);
	public int newJob(String jobTitle, String startDate, String endDate, String startTime, String endTime,int uid,  String payPerHour){
		
		JobsData jd= (JobsData) FactoryUtil.mapClassInstance.get(FactoryUtil.JOBSDATA);
		Jobs job = (Jobs)FactoryUtil.mapClassInstance.get(FactoryUtil.JOBS);
		
		String startTimeFormat=startTime.substring(0, 2)+":"+startTime.substring(2);
		String endTimeFormat=endTime.substring(0, 2)+":"+endTime.substring(2);
		
		SimpleDateFormat startDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		SimpleDateFormat endDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		
		System.out.println(startTimeFormat);
		Date d1 = null, d2 = null;
		try {
			d1 = startDateFormat.parse(startDate + " " + startTimeFormat);
			d2 = endDateFormat.parse(endDate + " " + endTimeFormat);
		} catch (ParseException | java.text.ParseException e) {
			e.printStackTrace();
		}
		
		System.out.println(d1);
		
		
		
		int payPerHours= Integer.parseInt(payPerHour);
		job.setJobTitle(jobTitle);
		job.setStartDate(d1);
		job.setEndDate(d2);
		job.setPostedBy(uid);
		job.setPayPerHour(payPerHours);
		job.setStatus("ACTIVE");
		System.out.println(job.getStartDate()+"***********");
		
		SeekerActivity seekerAct=new SeekerActivity();
		seekerAct.setUid(uid);
		seekerAct.setMessage("New job posted: "+job.getJobTitle());
		int created = jd.createJob(job, seekerAct);
			
		return created;
		
	}
	
	
	public List<Jobs> updateJob(int uid){
		
		JobsData jd= (JobsData) FactoryUtil.mapClassInstance.get(FactoryUtil.JOBSDATA);
	
		List<Jobs> jobs=jd.fetchSeekerJobs(uid);
		return jobs;
	
	}
//public boolean deleteJob(int uid, String jobTitle) {
//	JobsData jd= (JobsData) FactoryUtil.mapClassInstance.get(FactoryUtil.JOBSDATA);
//	   
//		if(jd.deleteThisJob(uid,jobTitle))
//		return true;
//		else
//			return false;
//	}
//
//public List<Jobs> updateJob(int uid){
//	JobsData jd= (JobsData) FactoryUtil.mapClassInstance.get(FactoryUtil.JOBSDATA);
//	List<Jobs> jobs=jd.fetchSeekerJobs(uid);
//		return jobs;
//	
//}
//public List<Jobs> deletejobApp(int uid){
//	JobsData jd= (JobsData) FactoryUtil.mapClassInstance.get(FactoryUtil.JOBSDATA);
//	List<Jobs> jobs=jd.getAppliedJobs(uid);
//		return jobs;
//	
//}
public Jobs getJobDetails(int JobId) {
	// TODO Auto-generated method stub
	JobsData jd= (JobsData) FactoryUtil.mapClassInstance.get(FactoryUtil.JOBSDATA);
	Jobs jb=jd.findDetailsOfJob(JobId);
	return jb;
}
//public boolean updateCurrentTitle(String newTitle, String curentJobTitle) {
//	// TODO Auto-generated method stub
////	if(email=="jobTitle"){
////		jd.updateJobTitle(email);
////	}
////	if(email=="startDate"){
////		updateStartDate(job.getJobTitle());
////	}
////	if(email=="endDate"){
////		updateEndDate(job.getJobTitle());
////	}
////	if(email=="payPerHour"){
////		updatePayPerHour(job.getJobTitle());
////	}
////
////	Jobs jb = 
////	
////	if(.updateJobTitle(newTitle)){
////		System.out.println("success");
////		return true;
////	}
//	JobsData jd= (JobsData) FactoryUtil.mapClassInstance.get(FactoryUtil.JOBSDATA);
//	if(jd.updateJobTitle(curentJobTitle, newTitle))
//		return true;
//	
//	return false;
//	
//	
//	
//}
//public boolean appliedForThisJob(String jobTitle, int uid) {
//	// TODO Auto-generated method stub
//	JobsData jd =(JobsData) FactoryUtil.mapClassInstance.get(FactoryUtil.JOBSDATA);
//	int jobId=jd.getJobId(jobTitle);
//	System.out.println(jobId +"************" + jobTitle);
//	if(jd.applyThisJobDao(jobTitle, uid, jobId))
//		return true;
//	else
//		return false;
//}
//public boolean deleteThisJobApp(String jobTitle, int uid) {
//	// TODO Auto-generated method stub
//	JobsData jd =(JobsData) FactoryUtil.mapClassInstance.get(FactoryUtil.JOBSDATA);
//	int jobId=jd.getJobId(jobTitle);
//	System.out.println(jobId +"************" + jobTitle);
//	if(jd.deleteThisAppDao(jobTitle, uid, jobId))
//		return true;
//	else
//		return false;
//}
//public boolean updateJobDetails(Jobs jb, String oldJobTitle) {
//	// TODO Auto-generated method stub
//	JobsData jd =(JobsData) FactoryUtil.mapClassInstance.get(FactoryUtil.JOBSDATA);
//	if(jd.updateTheseJobDetails(jb,oldJobTitle))
//		return true;
//	else
//		return false;
//}
//
//public List<Sitter> showApplicants(int uid, String jobTitle){
//	UserData jd =(UserData) FactoryUtil.mapClassInstance.get(FactoryUtil.USERDATA);
//	List<Sitter> sitters = jd.fetchApplicants(uid,jobTitle);
//
//	return sitters;
//	}


public boolean updateChoosenParam(int uid,int jobId, String jobTitle, String startDate,  String endDate,String payPerHour) {
	// TODO Auto-generated method stub
	JobsData jd= (JobsData) FactoryUtil.mapClassInstance.get(FactoryUtil.JOBSDATA);
	Jobs job = (Jobs)FactoryUtil.mapClassInstance.get(FactoryUtil.JOBS);
	
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	
	Date d1 = null, d2 = null;
	
		
		try {
			d1= sdf.parse(startDate);
			d2=sdf.parse(endDate);
		} catch (java.text.ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return false;
		}
		
		
	
	
	
	
	int payPerHours;
	try {
		payPerHours= Integer.parseInt(payPerHour);
	}catch(NumberFormatException e) {
		return false;
		
		
	}
	
	job.setId(jobId);
	job.setJobTitle(jobTitle);
	job.setStartDate(d1);
	job.setEndDate(d2);
	
	
	job.setPayPerHour(payPerHours);
	
	SeekerActivity seekerAct=new SeekerActivity();
	seekerAct.setUid(uid);
	seekerAct.setMessage("updated  job: "+job.getJobTitle());
	boolean check=jd.updateThisJob(jobId, job,seekerAct);
	if(check)
		return true;
	else
	return false;
}


public boolean deleteJob(int id,int uid) {
	// TODO Auto-generated method stub
	JobsData jd= (JobsData) FactoryUtil.mapClassInstance.get(FactoryUtil.JOBSDATA);
	SeekerActivity seekerAct=new SeekerActivity();
	seekerAct.setUid(uid);
	seekerAct.setMessage("deleted a job");
	boolean deleted = jd.deleteThisJob(id, seekerAct);
	if(deleted) {
		return true;
		}
	else
	return false;
}


public List<Jobs> listAllJobsForSeekers(int uid) {
	// TODO Auto-generated method stub
	JobsData jd= (JobsData) FactoryUtil.mapClassInstance.get(FactoryUtil.JOBSDATA);
	List<Jobs> lst=jd.listAllJobs(uid);
	return lst;
}
public List<Jobs> listAllJobsForSitters(int uid) {
	// TODO Auto-generated method stub
	JobsData jd= (JobsData) FactoryUtil.mapClassInstance.get(FactoryUtil.JOBSDATA);
	List<Jobs> lst=jd.listAllJobsSitters(uid);
	return lst;
}

public int applyThisJob(int jobId, int uid) {
	// TODO Auto-generated method stub
	
	JobsData jd= (JobsData) FactoryUtil.mapClassInstance.get(FactoryUtil.JOBSDATA);
	int applied = jd.applyJobDao(jobId,uid);
	
	return applied;
}


public List<Applications> fetchAllJobsSitter(int uid) {
	// TODO Auto-generated method stub
	JobsData jd= (JobsData) FactoryUtil.mapClassInstance.get(FactoryUtil.JOBSDATA);
	Applications app= new Applications();
//	app.set
	List<Applications> lst = jd.fetchSitterApps(uid);
	
	
	
	return lst;
}


public List<Applications> showApplicants(int uid, int jobId) {
	// TODO Auto-generated method stub
	JobsData jd= (JobsData) FactoryUtil.mapClassInstance.get(FactoryUtil.JOBSDATA);
	List<Applications> sitter=jd.fetchSitterDetails(uid,jobId);
	return sitter;
}


public boolean deleteApp(int jobId, int uid) {
	// TODO Auto-generated method stub
	JobsData jd= (JobsData) FactoryUtil.mapClassInstance.get(FactoryUtil.JOBSDATA);
	
	boolean deleted = jd.deleteThisAppDao(jobId,uid);
	if(deleted) {
		return true;
		}
	else
	return false;
	
}





}
