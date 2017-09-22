package com.hmj.FormBeans;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

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
		
		
		
		
		
		return super.validate(mapping, request);
	}
	
	
}
