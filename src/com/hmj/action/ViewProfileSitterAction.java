package com.hmj.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.hmj.model.Sitter;
import com.hmj.service.MemberServiceImp;
import com.hmj.util.FactoryUtil;

public class ViewProfileSitterAction extends Action {
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		MemberServiceImp svc = (MemberServiceImp) FactoryUtil.mapClassInstance.get(FactoryUtil.MEMBERSERVICEIMP);
		//Sitter sitter = (Sitter)session.getAttribute("sessionData");
		int uid= (int) session.getAttribute("uid");
		Sitter sitter = svc.getSitterUserDetails(uid);
		
		request.setAttribute("updateSitterForm", sitter);
		return mapping.findForward("success");
		
//		UpdateSitterForm sitterForm= (UpdateSitterForm) form;
//		HttpSession session = request.getSession();
//		int uid= (int) session.getAttribute("uid");
//		if(sitterForm.getFirstName()==null) {
//			System.out.println("first time in view profile");
//			Sitter data=(Sitter) session.getAttribute("sessionData");
//			request.setAttribute("sitter", data);
//			
//		}
//		else {
//			request.setAttribute("sitter", sitterForm);
//
//		}
//	
//		
//		
//		return mapping.findForward("success");
	}
	
	
}
