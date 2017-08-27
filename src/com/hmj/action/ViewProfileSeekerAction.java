package com.hmj.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.hmj.model.Member;
import com.hmj.model.Seeker;
import com.hmj.service.MemberServiceImp;
import com.hmj.util.FactoryUtil;

public class ViewProfileSeekerAction extends Action {
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		Member mem= (Member) FactoryUtil.mapClassInstance.get(FactoryUtil.MEMBER);
		Seeker seeker = (Seeker) FactoryUtil.mapClassInstance.get(FactoryUtil.SEEKER);
		MemberServiceImp svc = (MemberServiceImp) FactoryUtil.mapClassInstance.get(FactoryUtil.MEMBERSERVICEIMP);
		HttpSession session = request.getSession();
		
		int uid=(int) session.getAttribute("uid");
		seeker  =svc.getUserDetails(uid);
		
		request.setAttribute("seeker", seeker);
		
		
		return mapping.findForward("success");
	}
	

}