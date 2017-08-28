package com.hmj.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hmj.dao.JobsData;
import com.hmj.model.*;
import com.hmj.util.FactoryUtil;


public class JobServiceImp {

	Sitter sitter=(Sitter) FactoryUtil.mapClassInstance.get(FactoryUtil.SITTER);
	public int newJob(String jobTitle, String startDate, String endDate, String startTime, String endTime,int uid,  int payPerHour){
		
		JobsData jd= (JobsData) FactoryUtil.mapClassInstance.get(FactoryUtil.JOBSDATA);
		Jobs job = (Jobs)FactoryUtil.mapClassInstance.get(FactoryUtil.JOBS);
		
		job.setJobTitle(jobTitle);
		job.setStartDate(startDate);
		job.setEndDate(endDate);
		job.setStartTime(startTime);
		job.setEndTime(endTime);
		job.setPostedBy(uid);
		job.setPayPerHour(payPerHour);
		System.out.println(job.getStartDate()+"***********");
		
		SeekerActivity seekerAct=new SeekerActivity();
		seekerAct.setUid(uid);
		seekerAct.setMessage("New job posted");
		int created = jd.createJob(job, seekerAct);
			
		return created;
		
	}
	
	
	public List<Jobs> updateJob(int uid){
		Jobs job = (Jobs)FactoryUtil.mapClassInstance.get(FactoryUtil.JOBS);
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


public boolean updateChoosenParam(int jobId, String jobTitle, String startDate,  String endDate, String startTime, String endTime,int payPerHour) {
	// TODO Auto-generated method stub
	JobsData jd= (JobsData) FactoryUtil.mapClassInstance.get(FactoryUtil.JOBSDATA);
	Jobs job = (Jobs)FactoryUtil.mapClassInstance.get(FactoryUtil.JOBS);
	job.setId(jobId);
	job.setJobTitle(jobTitle);
	job.setStartDate(startDate);
	job.setEndDate(endDate);
	job.setEndDate(endDate);
	job.setStartTime(startTime);
	job.setEndTime(endTime);
	job.setPayPerHour(payPerHour);
	
	SeekerActivity seekerAct=new SeekerActivity();
	seekerAct.setUid(job.getPostedBy());
	seekerAct.setMessage("updated  job"+job.getJobTitle());
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


public List<Jobs> listAllJobsForSeekers() {
	// TODO Auto-generated method stub
	JobsData jd= (JobsData) FactoryUtil.mapClassInstance.get(FactoryUtil.JOBSDATA);
	List<Jobs> lst=jd.listAllJobs();
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
