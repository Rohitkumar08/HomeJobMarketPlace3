package com.hmj.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.hmj.FormBeans.UpdateSitterForm;
import com.hmj.model.Member;
import com.hmj.model.Seeker;
import com.hmj.model.Sitter;
import com.hmj.service.MemberServiceImp;
import com.hmj.util.FactoryUtil;

public class ViewProfileSitterAction extends Action {
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		Member mem= (Member) FactoryUtil.mapClassInstance.get(FactoryUtil.MEMBER);
		Sitter sitter = (Sitter) FactoryUtil.mapClassInstance.get(FactoryUtil.SITTER);
		MemberServiceImp svc = (MemberServiceImp) FactoryUtil.mapClassInstance.get(FactoryUtil.MEMBERSERVICEIMP);
		
		
		UpdateSitterForm sitterForm= (UpdateSitterForm) form;
		HttpSession session = request.getSession();
		int uid= (int) session.getAttribute("uid");
		if(sitterForm.getFirstName()==null) {
			System.out.println("first time in view profile");
			Sitter data=(Sitter) session.getAttribute("sessionData");
			request.setAttribute("sitter", data);
			
		}
		else {
			request.setAttribute("sitter", sitterForm);
			
//			boolean update= svc.updateUserSitter(uid,sitterForm.getFirstName(),sitterForm.getPhone(),sitterForm.getExpectedPay(),sitterForm.getYearsOfExperience());
//			System.out.println(update);
//			if(update)
//				return mapping.findForward("success");
//			else
//			return mapping.findForward("failure");
		}
		//int uid=(int) session.getAttribute("uid");
		//sitter  =svc.getSitterUserDetails(uid);
		
		
		
		return mapping.findForward("success");
	}
	
	
}
