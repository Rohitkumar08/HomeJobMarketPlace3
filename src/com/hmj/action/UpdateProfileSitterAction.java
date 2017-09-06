package com.hmj.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.hmj.FormBeans.UpdateSitterForm;
import com.hmj.service.MemberServiceImp;
import com.hmj.util.FactoryUtil;

public class UpdateProfileSitterAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		MemberServiceImp svc = (MemberServiceImp) FactoryUtil.mapClassInstance.get(FactoryUtil.MEMBERSERVICEIMP);

		HttpSession session= request.getSession();
		int uid=(int) session.getAttribute("uid");
		UpdateSitterForm regForm= (UpdateSitterForm) form;
		
		boolean update= svc.updateUserSitter(uid,regForm.getFirstName(),regForm.getLastName(),regForm.getPhone(),regForm.getExpectedPay(),regForm.getYearsOfExperience());
		System.out.println(update);
		if(update)
			return mapping.findForward("success");
		else
		return mapping.findForward("failure");
	}
	
	
	
}
