package com.hmj.FormBeans;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class UpdateSeekerForm extends ActionForm {
	
	private  String firstName;
	private String phone;
	private String lastName;
	private String email;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSpouseName() {
		return spouseName;
	}
	public void setSpouseName(String spouseName) {
		this.spouseName = spouseName;
	}
	public String getNoOfChilds() {
		return noOfChilds;
	}
	public void setNoOfChilds(String noOfChilds) {
		this.noOfChilds = noOfChilds;
	}
	private  String spouseName;
	private  String noOfChilds;
	
	
	 @Override
		public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
			// TODO Auto-generated method stub
			 ActionErrors ae=new ActionErrors();
			 
			 //-----------validation for first name-------------------
			 
			 Pattern p = Pattern.compile("[a-zA-Z]{3,30}");
				Matcher m = p.matcher(firstName);
				boolean b = m.find();
			 if(!b){
				 ae.add("firstName", new ActionMessage("firstNameError"));
		 
			 }
			 //--------------
			 
			 
			 //----validation for EMAIL---------
			 
			 //---------------------
			
			 //-------------------------------validation for phone no----------
			
			 if (!(phone.matches("\\d{10}"))) {
				 System.out.println("Inside validation");
				 ae.add("phone", new ActionMessage("phoneNoError"));
			 }
			 
			 //-------------------validation for seeker additional fields--------------
			 
			
				 
				 Pattern p3 = Pattern.compile("\\d");
					Matcher m3 = p3.matcher(noOfChilds);
					boolean b2 = m3.find();
				 if(!b2){
					 ae.add("noOfChildError", new ActionMessage("noOfChildError"));
			 
				 }
				 else {
						int noOfChild=Integer.parseInt(noOfChilds);
						if(noOfChild<0)
							 ae.add("noOfChildError", new ActionMessage("noOfChildError"));
					}
					
					if(spouseName==null){
						ae.add("spouseName", new ActionMessage("spouseNameError"));
					}
					m = p.matcher(spouseName);
					b = m.find();
					if(!b){
					 ae.add("spouseName", new ActionMessage("spouseNameError"));
			 
				 }
			
			
			 
			 //--------------------
			
			return ae;
		}
		
	
}
