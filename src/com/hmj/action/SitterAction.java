package com.hmj.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class SitterAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		HttpSession session= request.getSession();
		
		
		if(session.getAttribute("uname").equals(null)) {
			
			return mapping.findForward("loginFirst");
		}
		if(!(session.getAttribute("utype").equals("Sitter"))) {
			
			return mapping.findForward("notSitter");
		}
		System.out.println("inside session"+session.getAttribute("uname"));
		return mapping.findForward("success");
	}
	
}
