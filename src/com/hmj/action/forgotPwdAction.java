package com.hmj.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.hmj.mailer.Mailer;

public class forgotPwdAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		int random = (int )(Math.random() * 1000 + 1);
		String str=Integer.toString(random);
		String email=request.getParameter("email");
		
		
		
		
		
		String[] temp=email.split("@");
		String tempPwd=temp[0]+str;
		
		System.out.println(tempPwd);
		Mailer.send("rohitbits1994@gmail.com","9334093133",email,"hi user","your new password: "+tempPwd); 
		
		return mapping.findForward("success");
	}
	
}
