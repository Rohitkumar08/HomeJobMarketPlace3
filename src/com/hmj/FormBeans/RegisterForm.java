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
	private  int noOfChilds;
	private int yearsOfExperience;
	
	private String memberType;
	
	public int getYearsOfExperience() {
		return yearsOfExperience;
	}
	public void setYearsOfExperience(int yearsOfExperience) {
		this.yearsOfExperience = yearsOfExperience;
	}
	public String getMemberType() {
		return memberType;
	}
	public void setMemberType(String memberType) {
		this.memberType = memberType;
	}
	private int expectedPay;
	
	public int getExpectedPay() {
		return expectedPay;
	}
	public void setExpectedPay(int expectedPay) {
		this.expectedPay = expectedPay;
	}
	public  int getNoOfChilds() {
		return noOfChilds;
	}
	public  void setNoOfChilds(int noOfChilds) {
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
		 
		 Pattern p = Pattern.compile("[0-9]");
		 System.out.println("**************"+firstName);
		 System.out.println("**************"+phone);
		 System.out.println(spouseName);
		 System.out.println(noOfChilds);
			Matcher m = p.matcher(firstName);
			boolean b = m.find();
		 if(b){
			 ae.add("firstName", new ActionMessage("firstNameError"));
	 
		 }
		
		 //-------------------------------validation for phone no----------
		
		 if (!(phone.matches("\\d{10}"))) {
			 System.out.println("Inside validation");
			 ae.add("phone", new ActionMessage("phoneNoError"));
		 }
		 
		 //-------------------validation for seeker additional fields--------------
		 
		if(getMemberType().equals("Seeker")){
				if(getNoOfChilds()<0)
					ae.add("noOfChild", new ActionMessage("noOfChildError"));
				if(spouseName==null){
					ae.add("spouseName", new ActionMessage("spouseNameError"));
				}
				m = p.matcher(spouseName);
				b = m.find();
				if(b){
				 ae.add("spouseName", new ActionMessage("spouseNameError"));
		 
			 }
		}
		//-----------validation for sitter additional fields------------
		if(getMemberType().equals("Sitter")){
			
			if(getExpectedPay()<0){
				ae.add("expectedPay", new ActionMessage("expectedPayError"));
			}
			if(getYearsOfExperience()<0){
				ae.add("yearsOfExperience", new ActionMessage("yoeError"));
			}
			
			
			
			
			
		}
		 
		 //--------------------
		
		return ae;
	}
	
}
