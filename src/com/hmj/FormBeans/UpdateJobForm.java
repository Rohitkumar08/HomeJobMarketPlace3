package com.hmj.FormBeans;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class UpdateJobForm extends ActionForm {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	private String jobTitle;
	
	private String startDate;
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
	private String endDate;
	
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	
	public String getPayPerHour() {
		return payPerHour;
	}
	public void setPayPerHour(String payPerHour) {
		this.payPerHour = payPerHour;
	}

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

		 if(!isThisDateValid(endDate)) {
			 ae.add("endDateFormat", new ActionMessage("endDateFormatError")); 
		 }
		//-----------validation for end date------------
		 SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");

		 String date1 = startDate;
		 
//		 Date currentDate = new Date();
//		String today=format.format(currentDate);
//		
//		if(startDate.compareTo(today)<0) {
//			 ae.add("startDate", new ActionMessage("startDateError"));
//		}
			
//	        System.out.println(format.format(currentDate));
	   
		 
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
//			if(startDate.compareTo(endDate)==0){
//				
//				String startTime1 = startTime.replaceAll("([01][0-9]|[2][0-3]):?([0-5]+)", "$1:$2");
//				String endTime1  = endTime.replaceAll("([01][0-9]|[2][0-3]):?([0-5]+)", "$1:$2");
//				System.out.println(startTime1);
//				System.out.println(endTime1);
//				    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
//				    Date d1;
//				    Date d2;
//					try {
//						d1 = sdf.parse(startTime1);
//						d2 = sdf.parse(endTime1);
//						 long elapsed = d2.getTime() - d1.getTime(); 
//						 System.out.println(elapsed);
//						 if (elapsed<=0) {
//							    System.out.println("earlier");
//							    System.out.println("");
//							    ae.add("endTime", new ActionMessage("endTimeError"));
//							}
//				} catch (ParseException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//				    
//			  
//			}
//			} catch (ParseException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();//			}
	
		//-----------------------------------------------

			Pattern p3 = Pattern.compile("[0-9]+");
			Matcher m3 = p3.matcher(payPerHour);
			boolean b3 = m3.find();
			if(!b3){
			 ae.add("payPerHour", new ActionMessage("payPerHourError"));
	 
			}
			else {
				try{
					int payPerHours=Integer.parseInt(payPerHour);
					if(payPerHours<10)
						 ae.add("payPerHour", new ActionMessage("payPerHourError"));
				}catch(NumberFormatException e) {
					ae.add("payPerHour", new ActionMessage("payPerHourError"));
				}
				
				}
			}catch(Exception e) {
				
			}
			return ae;
	}
	
	public static boolean isThisDateValid(String dateToValidate) {
	
		try {
		    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		    Date date = formatter.parse(dateToValidate);
		    System.out.println(date+"<<<<<<<<");
		    System.out.println(formatter.format(date) );
		  return true;
		} catch(ParseException e) {
		    // It does not match your input
			return false;
		}
		
	}
	
}
