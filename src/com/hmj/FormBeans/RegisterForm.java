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
	private static int noOfChilds;
	private int yearsOfExperience;
	private int expectedPay;
	
	public int getExpectedPay() {
		return expectedPay;
	}
	public void setExpectedPay(int expectedPay) {
		this.expectedPay = expectedPay;
	}
	public static int getNoOfChilds() {
		return noOfChilds;
	}
	public static void setNoOfChilds(int noOfChilds) {
		RegisterForm.noOfChilds = noOfChilds;
	}
	public static String getSpouseName() {
		return spouseName;
	}
	public static void setSpouseName(String spouseName) {
		RegisterForm.spouseName = spouseName;
	}
	private static String spouseName;
	
	 @Override
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		// TODO Auto-generated method stub
		 ActionErrors ae=new ActionErrors();
		 
		 //-----------validation for first name-------------------
		 
		 Pattern p = Pattern.compile("[0-9]");
		 System.out.println("**************"+firstName);
		 System.out.println("**************"+phone);
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
			 
		 
		 //--------------------
		
		return ae;
	}
	
}
