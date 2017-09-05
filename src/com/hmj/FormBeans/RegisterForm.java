package com.hmj.FormBeans;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class RegisterForm extends ActionForm {

	private  String firstName;
	private String phone;
	private String lastName;
	private String address;
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	private String email;
	private String password;
	private String status;
	private  String noOfChilds;
	private String yearsOfExperience;
	
	private String memberType;
	
	public String getYearsOfExperience() {
		return yearsOfExperience;
	}
	public void setYearsOfExperience(String yearsOfExperience) {
		this.yearsOfExperience = yearsOfExperience;
	}
	public String getMemberType() {
		return memberType;
	}
	public void setMemberType(String memberType) {
		this.memberType = memberType;
	}
	private String expectedPay;
	
	public String getExpectedPay() {
		return expectedPay;
	}
	public void setExpectedPay(String expectedPay) {
		this.expectedPay = expectedPay;
	}
	public  String getNoOfChilds() {
		return noOfChilds;
	}
	public  void setNoOfChilds(String noOfChilds) {
		this.noOfChilds = noOfChilds;
	}
	public  String getSpouseName() {
		return spouseName;
	}
	public  void setSpouseName(String spouseName) {
		this.spouseName = spouseName;
	}
	private  String spouseName;
	

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
		 
		 m=p.matcher(lastName);
		b = m.find();
		 if(!b){
			 ae.add("lastName", new ActionMessage("lastNameError"));
	 
		 }
		 
		 
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
		
		 
		 Pattern p1 = Pattern.compile("[a-zA-Z0-9@]{3,30}");
			Matcher m1 = p1.matcher(password);
			boolean b1 = m1.find();
		 if(!b1){
			 ae.add("pwdError", new ActionMessage("pwdError"));
	 
		 }
		 //-------------------------------validation for phone no----------
		
		 if (!(phone.matches("\\d{10}"))) {
			 System.out.println("Inside validation");
			 ae.add("phone", new ActionMessage("phoneNoError"));
		 }
		 
		 //-------------------validation for seeker additional fields--------------
		 
		if(getMemberType().equals("Seeker")){
			 
			 Pattern p3 = Pattern.compile("\\d");
				Matcher m3 = p3.matcher(noOfChilds);
				boolean b2 = m3.find();
			 if(!b2){
				 ae.add("noOfChildError", new ActionMessage("noOfChildError"));
		 
			 }
			 else {
				 try {
					 int noOfChild=Integer.parseInt(noOfChilds);
						if(noOfChild<0)
							 ae.add("noOfChildError", new ActionMessage("noOfChildError"));
				 }catch(NumberFormatException e) {
					 ae.add("noOfChildError", new ActionMessage("noOfChildError"));
				 }
					
				}
				
				if(spouseName==null){
					ae.add("spouseName", new ActionMessage("spouseNameError"));
				}
				m = p.matcher(spouseName);
				b = m.find();
				if(!b){
				 ae.add("spouseName", new ActionMessage("spouseNameError"));
		 
			 }
		}
		//-----------validation for sitter additional fields------------
		if(getMemberType().equals("Sitter")){
			
			
			Pattern p3 = Pattern.compile("[0-9]+");
			Matcher m3 = p3.matcher(expectedPay);
			boolean b2 = m3.find();
			if(!b2){
			 ae.add("expectedPay", new ActionMessage("expectedPayError"));
	 
			}
			else {
				try {
					int expectedPays=Integer.parseInt(expectedPay);
					if(expectedPays<=0)
						 ae.add("expectedPay", new ActionMessage("expectedPayError"));
				}
				catch(NumberFormatException e) {
					ae.add("expectedPay", new ActionMessage("expectedPayError"));
				}
				
			}
			
			
			m3 = p3.matcher(yearsOfExperience);
			boolean b3 = m3.find();
			if(!b3){
			 ae.add("yearsOfExperience", new ActionMessage("yoeError"));
	 
			}
			else {
				
				try {
					int yearsOfExperiences=Integer.parseInt(yearsOfExperience);
					if(yearsOfExperiences<0)
						 ae.add("yearsOfExperience", new ActionMessage("yoeError"));
				}catch(NumberFormatException e) {
					 ae.add("yearsOfExperience", new ActionMessage("yoeError"));
				}
				
				
			}
			
			
			
			
			
		}
		 
		 //--------------------
		
		return ae;
	}
	
}
