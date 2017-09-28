package com.hmj.FormBeans;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.hmj.Validations.Validator;

public class ForgotPwdForm extends ActionForm {
	private String email;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	@Override
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		// TODO Auto-generated method stub
		
		ActionErrors ae = new ActionErrors();
		 Validator validate= new Validator();
		 if(!validate.validateEmail(email)){
		    	ae.add("emailError", new ActionMessage("emailError"));
		    }

		
		return ae;
	}
}
