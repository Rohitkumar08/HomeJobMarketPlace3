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
	public String getPayPerHour() {
		return payPerHour;
	}
	public void setPayPerHour(String payPerHour) {
		this.payPerHour = payPerHour;
	}
	private String endDate;
	private String startTime;
	private String endTime;
	private String payPerHour;
	
	@Override
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		// TODO Auto-generated method stub
		ActionErrors ae=new ActionErrors();
		 Pattern p = Pattern.compile("[a-zA-Z]{3,30}");
		 Matcher m = p.matcher(jobTitle);
			boolean b = m.find();
		 if(!b){
			 ae.add("jobTitle", new ActionMessage("jobTitleError"));
	 
		 }
		 
		 //--validation for dates inputs--------
		 
		if(!isThisDateValid(startDate)) {
			ae.add("startDateFormat", new ActionMessage("startDateFormatError"));
			
		}
		if(!isThisDateValid(endDate)) {
			ae.add("endDateFormat", new ActionMessage("endDateFormatError"));
			
		}
		 
		
		 
		 
		 
		 
		 //----start & end time validation----------
		 
		 
		
		 if(!startTime.matches("\\d{4}")){
			 ae.add("startTimeFormat", new ActionMessage("startTimeFormatError"));
	 
		 }
		 
		 else {
			 int arr[]= new int[4];
			 for (int i = 0; i < 4; i++){
			        arr[i] = startTime.charAt(i) - '0';
			    }
			 if(arr[0]==2 && arr[1]>=4) {
				 ae.add("startTimeFormat", new ActionMessage("startTimeFormatError"));
			 }
			 
			 
			 if(arr[0]>=3 || arr[2]>=6)
			 {
				 ae.add("startTimeFormat", new ActionMessage("startTimeFormatError"));
			 }
			
			 
		 }
		 if(!endTime.matches("\\d{4}")){
			 ae.add("endTimeFormat", new ActionMessage("endTimeFormatError"));
	 
		 }
		 else {
			 int arr[]= new int[4];
			 for (int i = 0; i < 4; i++){
			        arr[i] = endTime.charAt(i) - '0';
			    }
			 if(arr[0]==2 && arr[1]>=4) {
				 ae.add("endTimeFormat", new ActionMessage("endTimeFormatError"));
			 }
			 
			 if(arr[0]>=3 || arr[2]>=6)
			 {
				 ae.add("endTimeFormat", new ActionMessage("endTimeFormatError"));
			 }
			
			 
		 }
		 
		 
		 
		 //------------------
		 
		//-----------validation for end date------------
		 SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

		 String date1 = startDate;
		 
		 Date currentDate = new Date();
		String today=format.format(currentDate);
		
		if(startDate.compareTo(today)<0) {
			 ae.add("startDate", new ActionMessage("startDateError"));
		}
			
	        System.out.println(format.format(currentDate));
	   
		 
			String date2 = endDate;
			System.out.println(date1+"************"+date2);
			Date startDate;
			Date endDate;
			try {
				startDate = format.parse(date1);
				 endDate= format.parse(date2);
				 
				 
			if (endDate.before(startDate)) {
			    System.out.println("earlier");
			    System.out.println("");
			    ae.add("endDate", new ActionMessage("endDateError"));
			}
			if(startDate.compareTo(endDate)==0){
				
				String startTime1 = startTime.replaceAll("([01][0-9]|[2][0-3]):?([0-5]+)", "$1:$2");
				String endTime1  = endTime.replaceAll("([01][0-9]|[2][0-3]):?([0-5]+)", "$1:$2");
				System.out.println(startTime1);
				System.out.println(endTime1);
				    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
				    Date d1;
				    Date d2;
					try {
						d1 = sdf.parse(startTime1);
						d2 = sdf.parse(endTime1);
						 long elapsed = d2.getTime() - d1.getTime(); 
						 System.out.println(elapsed);
						 if (elapsed<=0) {
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

			Pattern p3 = Pattern.compile("[0-9]+");
			Matcher m3 = p3.matcher(payPerHour);
			boolean b3 = m3.find();
			if(!b3){
			 ae.add("payPerHour", new ActionMessage("payPerHourError"));
	 
			}
			else {
				int payPerHours=Integer.parseInt(payPerHour);
				if(payPerHours<=10)
					 ae.add("payPerHour", new ActionMessage("payPerHourError"));
			}
			
	return ae;
	}
	public static boolean isThisDateValid(String dateToValidate) {
		String dateFromat = "yyyy-mm-dd";
		if (dateToValidate == null) {
			return false;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(dateFromat);
		sdf.setLenient(false);
		try {
			Date date = sdf.parse(dateToValidate);
			System.out.println(date);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
}
