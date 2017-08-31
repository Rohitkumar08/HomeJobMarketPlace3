package com.hmj.FormBeans;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class UpdateSitterForm extends ActionForm{
	
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

	public String getYearsOfExperience() {
		return yearsOfExperience;
	}
	public void setYearsOfExperience(String yearsOfExperience) {
		this.yearsOfExperience = yearsOfExperience;
	}

	public String getExpectedPay() {
		return expectedPay;
	}
	public void setExpectedPay(String expectedPay) {
		this.expectedPay = expectedPay;
	}


	private String yearsOfExperience;
	
	private String expectedPay;
	
	
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
		 
		 final String EMAIL_REGEX="^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})";
		    //static Pattern object, since pattern is fixed
		    Pattern pattern;
		    //non-static Matcher object because it's created from the input String
		    Matcher matcher;
		    pattern = Pattern.compile(EMAIL_REGEX, Pattern.CASE_INSENSITIVE);
		    matcher = pattern.matcher(email);
		    if(matcher.matches()){
		    	
		    }
		    else{
		    		ae.add("emailError", new ActionMessage("emailError"));
		    
		    }
		 
		 
		 //---------------------
		
		 
		
		 //-------------------------------validation for phone no----------
		
		 if (!(phone.matches("\\d{10}"))) {
			 System.out.println("Inside validation");
			 ae.add("phone", new ActionMessage("phoneNoError"));
		 }
		 
		 //-------------------validation for seeker additional fields--------------
		 

		//-----------validation for sitter additional fields------------
	
			
			
			Pattern p3 = Pattern.compile("[0-9]+");
			Matcher m3 = p3.matcher(expectedPay);
			boolean b2 = m3.find();
			if(!b2){
			 ae.add("expectedPay", new ActionMessage("expectedPayError"));
	 
			}
			else {
				int expectedPays=Integer.parseInt(expectedPay);
				if(expectedPays<=0)
					 ae.add("expectedPay", new ActionMessage("expectedPayError"));
			}
			
			
			m3 = p3.matcher(yearsOfExperience);
			boolean b3 = m3.find();
			if(!b3){
			 ae.add("yearsOfExperience", new ActionMessage("yoeError"));
	 
			}
			else {
				int yearsOfExperiences=Integer.parseInt(yearsOfExperience);
				if(yearsOfExperiences<0)
					 ae.add("yearsOfExperience", new ActionMessage("yoeError"));
			}
			
		 
		 //--------------------
		
		return ae;
	}

}
