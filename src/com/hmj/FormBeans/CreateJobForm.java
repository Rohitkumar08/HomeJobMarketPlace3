package com.hmj.FormBeans;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class CreateJobForm extends ActionForm{
	
	 private int jobId;
	 private String jobTitle;
	private int postedBy;
	private String startDate;
	public int getJobId() {
		return jobId;
	}
	public void setJobId(int jobId) {
		this.jobId = jobId;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public int getPostedBy() {
		return postedBy;
	}
	public void setPostedBy(int postedBy) {
		this.postedBy = postedBy;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public int getPayPerHour() {
		return payPerHour;
	}
	public void setPayPerHour(int payPerHour) {
		this.payPerHour = payPerHour;
	}
	private String endDate;
	private String startTime;
	private String endTime;
	private int payPerHour;
	
	@Override
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		// TODO Auto-generated method stub
		ActionErrors ae=new ActionErrors();
		 Pattern p = Pattern.compile("[0-9]");
		 Matcher m = p.matcher(jobTitle);
			boolean b = m.find();
		 if(b){
			 ae.add("jobTitle", new ActionMessage("jobTitleError"));
	 
		 }
		 
		//-----------validation for end date------------
		 SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

		 String date1 = startDate;
		 
		 Date currentDate = new Date();
		
	        System.out.println(format.format(currentDate));
	   
		 
			String date2 = endDate;
			
			Date startDate;
			Date endDate;
			try {
				startDate = format.parse(date1);
				 endDate= format.parse(date2);
				 boolean before = startDate.before(currentDate);
				 if(before) {
					 System.out.println("start date is before today");
					 ae.add("startDate", new ActionMessage("startDateError"));
				 }
				 
			if (endDate.before(startDate)) {
			    System.out.println("earlier");
			    System.out.println("");
			    ae.add("endDate", new ActionMessage("endDateError"));
			}
			if(startDate.compareTo(endDate)==0){
				
				 String startTime1 = startTime;
				    String endTime1 = endTime;
				    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
				    Date d1;
				    Date d2;
					try {
						d1 = sdf.parse(startTime1);
						d2 = sdf.parse(endTime1);
						 long elapsed = d2.getTime() - d1.getTime(); 
						 System.out.println(elapsed);
						 if (elapsed<0) {
							    System.out.println("earlier");
							    System.out.println("");
							    ae.add("endTime", new ActionMessage("endTimeError"));
							}
				} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				    
			  
			}
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
		//-----------------------------------------------
		
			int check=payPerHour;
			if(check<10){
				ae.add("payPerHour", new ActionMessage("payPerHourError"));
			}
			
	return ae;
	}
	
}
