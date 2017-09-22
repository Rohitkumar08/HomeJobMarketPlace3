package com.hmj.action;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.hmj.model.SeekerActivity;
import com.hmj.service.MemberServiceImp;
import com.hmj.util.FactoryUtil;

public class SeekerAction extends Action{
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		MemberServiceImp svc=(MemberServiceImp) FactoryUtil.mapClassInstance.get(FactoryUtil.MEMBERSERVICEIMP);
		
		HttpSession session= request.getSession();
		System.out.println("inside seeker action");

		//List<String> activities=ActivityUtil.getActivity();
		int uid=(int) session.getAttribute("uid");
		List<SeekerActivity> activities=svc.getActivity(uid);
		if(activities==null) {
			return mapping.findForward("failure");
		}
		List<SeekerActivity> finalList=new ArrayList<SeekerActivity>();
		
		if(activities.size()<10)
			finalList= activities;
		else
			 finalList= activities.subList(activities.size()-10, activities.size());

		session.setAttribute("activity", finalList);
		
		System.out.println("inside session"+session.getAttribute("uname"));
		return mapping.findForward("success");
	}

}
