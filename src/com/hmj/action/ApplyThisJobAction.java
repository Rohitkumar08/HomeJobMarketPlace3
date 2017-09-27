package com.hmj.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.hmj.service.JobServiceImp;
import com.hmj.util.FactoryUtil;

public class ApplyThisJobAction extends Action{
	
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		JobServiceImp jbs = (JobServiceImp) FactoryUtil.mapClassInstance.get(FactoryUtil.JOBSERVICEIMP);

		HttpSession session= request.getSession();
//		
//		String selected[]= request.getParameterValues("inputed");
//		int selectedJobId=Integer.parseInt(selected[0].substring(6));  //job title choosen for edit purpose
//			System.out.println(selected[0].substring(6));
//			int jobId=selectedJobId;
		
		
		int jobId= Integer.parseInt(request.getParameter("id"));	
		System.out.println(jobId);
		int uid= (int) session.getAttribute("uid");
		 int applied= jbs.applyThisJob(jobId,uid);
		 System.out.println(applied);
		 
			 return mapping.findForward("success");
		 
	}

}
