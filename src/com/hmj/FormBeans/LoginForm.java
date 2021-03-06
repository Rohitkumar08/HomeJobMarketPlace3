package com.hmj.FormBeans;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.hmj.Validations.Validator;

public class LoginForm extends ActionForm{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String email;
	private String password;
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
	@Override
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		// TODO Auto-generated method stub
		
		 ActionErrors ae = new ActionErrors();
		 //----validation for EMAIL---------
		 
		 Validator validate= new Validator();

		    if(!validate.validateEmail(email)){
		    	ae.add("emailError", new ActionMessage("emailError"));
		    }
		 //---------------------
		
		 
		 Pattern p1 = Pattern.compile("[a-zA-Z0-9@]{3,30}");
			Matcher m1 = p1.matcher(password);
			boolean b1 = m1.find();
		 if(!b1){
			 ae.add("pwdError", new ActionMessage("pwdError"));
	 
		 }

		return ae;
	}
	
	
}
