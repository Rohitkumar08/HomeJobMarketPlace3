package com.hmj.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.hmj.model.Seeker;

import com.hmj.service.MemberServiceImp;
import com.hmj.util.FactoryUtil;

public class ViewProfileSeekerAction extends Action {
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		MemberServiceImp svc = (MemberServiceImp) FactoryUtil.mapClassInstance.get(FactoryUtil.MEMBERSERVICEIMP);

		
		HttpSession session = request.getSession();
		int uid= (int) session.getAttribute("uid");
		Seeker seeker = svc.getUserDetails(uid);
		
		request.setAttribute("updateSeekerForm", seeker);
		return mapping.findForward("success");
		
		
//		UpdateSeekerForm seekerForm= (UpdateSeekerForm) form;
//		if(seekerForm.getFirstName()==null) {
//			System.out.println("first time in view profile");
//			Seeker data=(Seeker) session.getAttribute("sessionData");
//			request.setAttribute("seeker", data);
//			
//		}
//		else {
//			request.setAttribute("seeker", seekerForm);
//		}
//
//		return mapping.findForward("success");
//		
	}
	

}
